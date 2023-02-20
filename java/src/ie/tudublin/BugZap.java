package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	float playerx,playery,playerwidth;
	float bugx, bugy, bugwidth;

	float halfplayer, halfbug;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();

		playerx = width * 0.5f;
		playery = height - 100;
		playerwidth = 50;
		halfplayer = playerwidth * 0.5f;
		
		resetbug();
	}

	void resetbug()
	{
		bugy= 50;
		bugwidth = 50;
		halfbug = bugwidth * 0.5f;
		bugx = random(halfbug, width - halfbug);
	}

	
	public void drawplayer(float x,float y, float w )
	{	
		noFill();
		stroke(255);
		rectMode(CENTER);
		rect(x, y, w, w);
		line(x, y - halfplayer, x, y - halfplayer * 2);
	
}

public void keyPressed()
{
	if(keyCode == LEFT)
	{
		playerx --;
	}

	if(keyCode == RIGHT)
	{
		playerx ++;
	}

	if(key == ' ')
	{
		
		System.out.println( "SPACE KEY pressed");
		line(playerx, playery - halfplayer, playerx, 0);
	}
}

public void draw()
{
	background(0);
	drawplayer(playerx, playery, playerwidth);
}

}