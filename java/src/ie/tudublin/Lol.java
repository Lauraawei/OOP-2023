package ie.tudublin;

import processing.core.PApplet;

public void settings()
{
    full screen(SPAN);
}

int mode = 0;

    public void draw()
    {
        background(0);
        fill(255);
        noStroke();

switch (mode) {
    case 0:
        int numCircles = (int) max(1, mousex / 50.0f);
        float d = width / (float)numCircles;
        for(in j = 0; j < numCircles; j++){
        for (int i = 0; i < numcircles; i++)
        {
        float y = (d * 0.5f) + (d *i);
        float x = (d * 0.5f) + (d *i);
        float c = ((i + j) / ((numcircles - 1) * 2.0f)) * 255.0f;
        fill(c + off) % 255,255);
        circle(x, y, d);
        }

        off += mouseY/ 50.0f
    

    default:
        break;
}

}

}
