float radius = 150;
int num = 3000;
float[] x = new float[num];
float[] y = new float[num];
float[] z = new float[num];

void setup() {
  size(640, 360, P3D);
  pixelDensity(displayDensity());

  for (int i = 0; i < num; i++) {
    float theta = random(PI);
    float phi = random(TWO_PI);

    x[i] = radius * sin(theta) * cos(phi);
    y[i] = radius * sin(theta) * sin(phi);
    z[i] = radius * cos(theta);

  }
}

void draw() {
  background(255);
  translate(width/2, height/2, 0);
  rotateY(frameCount * 0.01);

  for (int i = 0; i < num; i++) {
    stroke(0);
    strokeWeight(3);
    point(x[i], y[i], z[i]);
  }
}
