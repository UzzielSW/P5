// TestCircleWithConstructors.java: Demonstrate constructors
public class TestCircleWithConstructors {
  /** Main method */
  public static void main(String[] args) {
    // Create a Circle with radius 5.0
    CircleWithConstructors myCircle = 
      new CircleWithConstructors(5.0);
    System.out.println("The area of the circle of radius "
      + myCircle.radius + " is " + myCircle.findArea());

    // Create a Circle with default radius
    CircleWithConstructors yourCircle = new CircleWithConstructors();
    System.out.println("The area of the circle of radius "
      + yourCircle.radius + " is " + yourCircle.findArea());

    // Modify circle radius
    yourCircle.radius = 100;
    System.out.println("The area of the circle of radius "
      + yourCircle.radius + " is " + yourCircle.findArea());
  }
}

// Define the Circle class with two constructors
class CircleWithConstructors {
  double radius;

  /** Default constructor */
  CircleWithConstructors() {
    radius = 1.0;
  }

  /** Construct a circle with a specified radius */
  CircleWithConstructors(double r) {
    radius = r;
  }

  /** Return the area of this circle */
  double findArea() {
    return radius * radius * 3.14159;
  }
}