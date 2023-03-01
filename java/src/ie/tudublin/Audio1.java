package ie.tudublin;

import ddf.minim.AudioBuffer; //handles audio input
import ddf.minim.AudioInput; //MP3 file
import ddf.minim.AudioPlayer; //audio input from microphone
import ddf.minim.Minim; // stores audio data from the audioplayer
import processing.core.PApplet; // base class for all processing  sketches.

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {  //a method that is called whenever a key is pressed
		if (key >= '0' && key <= '9') {  // this method will be called when a key is pressed
			mode = key - '0';
		}
		if (keyCode == ' ') { // check if the key that was pressed is the spacebar
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings() //states the size of the window to 1024x1000 with the P3D renderer
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup() //called at beginning of the sketch to perform initialisation tasks.
    {
        minim = new Minim(this); // new instance of minimum class
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 

        // And comment the next two lines out
        ap = minim.loadFile("heroplanet.mp3", 1024);// buffer size set to 1024
        ap.play();
        ab = ap.mix; // used to get an audiobuffer object, which is stored in ab variable
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;      // variables are initialised 
    }

    float off = 0;

    float lerpedBuffer[] = new float[1024]; // the class uses lerping to create a smooth animation effect

    public void draw() // called repeatedly and is responsible for rendering the visualizer
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;


        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.8f);
        
        float cx = width / 2;
        float cy = height / 2;

// determine the mode of operation.
//mode can be changed by pressing keys from 0 to 9.
        switch (mode) { 
			case 0:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, halfH - f, i);                    
                }
                break;
        case 1:
            background(0);
            for(int i = 0 ; i < ab.size() ; i ++)
            {
                //float c = map(ab.get(i), -1, 1, 0, 255);
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 4.0f;
                line(i, halfH + f, halfH - f, i);                    
            }
            break;      
        case 2:
            background(0);
            for(int i = 0 ; i < ab.size() ; i ++)
            {
                float c = map(i, 0, ab.size(), mouseX /2, mouseY/ 2);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 4.0f;
                line(0, i, f, i);              
                line(width, i, width - f, i);              
                line(i, 0, i, f);          
                line(i, height, i, height - f);              
            }
            break;          
        }


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
