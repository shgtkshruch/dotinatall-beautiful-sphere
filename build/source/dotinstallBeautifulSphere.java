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

int num = 500;
Point[] points = new Point[num];

public void setup() {
  
  

  for (int i = 0; i < num; i++) {
    points[i] = new Point();
  }
}

public void draw() {
  background(255);
  translate(width/2, height/2, 0);
  rotateY(frameCount * 0.01f);

  for (int i = 0; i < num; i++) {
    points[i].update();
    points[i].display();
  }

  for (int i = 0; i < num; i++) {
    for (int j = i + 1; j < num; j++) {
      float d = dist(
        points[i].x,
        points[i].y,
        points[i].z,
        points[j].x,
        points[j].y,
        points[j].z
        );
      if (d < 40) {
        stroke((int) map(d, 0, 40, 0, 255));
        strokeWeight(1);
        line(
          points[i].x,
          points[i].y,
          points[i].z,
          points[j].x,
          points[j].y,
          points[j].z
          );
      }
    }
  }
}
class Point {
  float x;
  float y;
  float z;
  float targetX;
  float targetY;
  float targetZ;
  float radius;

  Point() {
    setTarget();
    x = targetX;
    y = targetY;
    z = targetZ;
  }

  public void setTarget() {
    if (random(2) < 1) {
      radius = 150;
    } else {
      radius = 75;
    }
    float phi = random(TWO_PI);
    float unitZ = random(-1, 1);
    targetX = radius * sqrt(1 - unitZ * unitZ) * cos(phi);
    targetY = radius * sqrt(1 - unitZ * unitZ) * sin(phi);
    targetZ = radius * unitZ;
  }

  public void update() {
    if (frameCount % 120 == 0) {
      setTarget();
    }
    x += (targetX - x) * 0.05f;
    y += (targetY - y) * 0.05f;
    z += (targetZ - z) * 0.05f;
  }

  public void display() {
    stroke(0);
    strokeWeight(3);
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
