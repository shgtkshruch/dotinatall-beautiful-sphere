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
int num = 3000;
float[] x = new float[num];
float[] y = new float[num];
float[] z = new float[num];

public void setup() {
  
  

  for (int i = 0; i < num; i++) {
    float phi = random(TWO_PI);
    float unitZ = random(-1, 1);

    x[i] = radius * sqrt(1 - unitZ * unitZ) * cos(phi);
    y[i] = radius * sqrt(1 - unitZ * unitZ) * sin(phi);
    z[i] = radius * unitZ;


  }
}

public void draw() {
  background(255);
  translate(width/2, height/2, 0);
  rotateY(frameCount * 0.01f);

  for (int i = 0; i < num; i++) {
    stroke(0);
    strokeWeight(3);
    point(x[i], y[i], z[i]);
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
