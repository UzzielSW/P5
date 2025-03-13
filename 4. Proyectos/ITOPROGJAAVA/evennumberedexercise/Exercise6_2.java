// Exercise6_2.java: Create a Fan class
// To avoid naming conflict with another Fan class later,
// this class name is Fan1
public class Exercise6_2 {
  public static void main(String[] args) {
    Fan1 fan = new Fan1();
    fan.setSpeed(Fan1.MEDIUM);
    fan.setRadius(5.5);
    fan.setOn(true);
    fan.setColor("red");

    System.out.println(fan.toString());
  }
}

class Fan1 {
  public static int SLOW = 1;
  public static int MEDIUM = 2;
  public static int FAST = 3;

  private int speed = SLOW;
  private boolean on = false;
  private double radius = 5;
  private String color = "white";

  public Fan1() {
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public boolean isOn() {
    return on;
  }

  public void setOn(boolean trueOrFalse) {
    this.on = on;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String toString() {
    return "speed " + speed + "\n"
      + "on " + on + "\n"
      + "radius " + radius + "\n"
      + "color " + color + "\n";
  }
}