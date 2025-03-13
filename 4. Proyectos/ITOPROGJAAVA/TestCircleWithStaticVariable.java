// TestCircleWithStaticVariable.java: Demonstrate using instance and
// static variables
public class TestCircleWithStaticVariable {
  /** Main method */
  public static void main(String[] args) {
    // Create circle1
    CircleWithStaticVariable circle1 = 
      new CircleWithStaticVariable();

    // Display circle1 BEFORE circle2 is created
    System.out.println("Before creating circle2");
    System.out.print("circle1 is : ");
    printCircle(circle1);

    // Create circle2
    CircleWithStaticVariable circle2 = 
      new CircleWithStaticVariable(5);

    // Change the radius in circle1
    circle1.setRadius(9);

    // Display circle1 and circle2 AFTER circle2 was created
    System.out.println("\nAfter creating circle2 and modifying " +
      "circle1's radius to 9");
    System.out.print("circle1 is : ");
    printCircle(circle1);
    System.out.print("circle2 is : ");
    printCircle(circle2);
  }

  /** Print circle information */
  public static void printCircle(CircleWithStaticVariable c) {
    System.out.println("radius (" + c.getRadius() +
      ") and number of Circle objects (" +
      c.getNumOfObjects() + ")");
  }
}

class CircleWithStaticVariable {
  /** The radius of the circle */
  private double radius;

  /** The number of the objects created */
  private static int numOfObjects = 0;  

  /** Default constructor */
  public CircleWithStaticVariable() {
    radius = 1.0;
    numOfObjects++;
  }

  /** Construct a circle with a specified radius */
  public CircleWithStaticVariable(double r) {
    radius = r;
    numOfObjects++;
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double newRadius) {
    radius = newRadius;
  }

  /** Return numOfObjects */
  public static int getNumOfObjects() {
    return numOfObjects;
  }

  /** Return the area of this circle */
  public double findArea() {
    return radius * radius * Math.PI;
  }
}