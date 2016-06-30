class Point {
  float x;
  float y;
  float z;
  float radius;

  Point() {
    radius = 150;
    float phi = random(TWO_PI);
    float unitZ = random(-1, 1);
    x = radius * sqrt(1 - unitZ * unitZ) * cos(phi);
    y = radius * sqrt(1 - unitZ * unitZ) * sin(phi);
    z = radius * unitZ;
  }

  void display() {
    stroke(0);
    strokeWeight(3);
    point(x, y, z);
  }
}
