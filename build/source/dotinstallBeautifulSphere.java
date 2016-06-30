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

public class dotinstallBeautifulSphere extends PApplet {

float radius = 150;

public void setup() {
  
  
}

public void draw() {
  background(255);
  translate(width/2, height/2, 0);
  rotateY(frameCount * 0.02f);

  float lastX = 0;
  float lastY = 0;
  float lastZ = 0;

  for (int dTheta = 0, dPhi = 0; dTheta <= 180; dTheta ++, dPhi += 10) {
    float theta = radians(dTheta);
    float phi = radians(dPhi);

    float x = radius * sin(theta) * cos(phi);
    float y = radius * sin(theta) * sin(phi);
    float z = radius * cos(theta);

    stroke(0);

    if (lastX != 0) {
      strokeWeight(1);
      line(lastX, lastY, lastZ, x, y, z);
    }

    strokeWeight(4);
    point(x, y, z);

    lastX = x;
    lastY = y;
    lastZ = z;
  }
}
  public void settings() {  size(640, 360, P3D);  pixelDensity(displayDensity()); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "dotinstallBeautifulSphere" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
