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

  for (int dTheta = 0; dTheta <= 180; dTheta += 10) {
    float theta = radians(dTheta);
    float z = radius * cos(theta);
    float r = radius * sin(theta);
    drawCircle(z, r);
  }
}

public void drawCircle(float z, float r) {
  for (int dPhi = 0; dPhi < 360; dPhi += 10) {
    float phi = radians(dPhi);
    float x = r * cos(phi);
    float y = r * sin(phi);

    stroke(0);
    strokeWeight(4);
    point(x, y, z);
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
