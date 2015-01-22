import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

public int moveLen = 40;
public void setup()
{
	size(400, 400);
}
public void draw()
{	
	noCursor();
	background(255);
	sierpinski(mouseX, mouseY, moveLen);
}
public void mousePressed()//optional
{
	if (moveLen < 400)
	{
		moveLen += 40;
	} else {
		moveLen -= 360;
	}
}
public void mouseDragged()
{
	rotate(PI/3.0f);
}
public void sierpinski(int x, int y, int len) 
{
	if(len <= 20)
	{
		triangle(x, y, x + len, y, x + len/2, y + len);
	}
	else 
	{
		triangle(x, y, x + len/2, y, x + len/4, y + len/2);
		sierpinski(x, y, len/2);
		sierpinski(x + len/2, y, len/2);
		sierpinski(x + len/4, y + len/2, len/2);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
