/**
 Circle in the text is renamed to SimpleCircle here to avoid naming
 conflict with the Circle class defined in Chapter 8. If the 
 name is not changed, you would get an error if you run the program
 from JBuilder or Forte.
*/
// TestCircle.java: Demonstrate creating and using an object
public class TestCircle {
  /** Main method */
  public static void main(String[] args) {
    SimpleCircle myCircle = new SimpleCircle();  // Create a Circle object
    System.out.println("The area of the circle of radius "
      + myCircle.radius + " is " + myCircle.findArea());
  }
}

// Define the Circle class
class SimpleCircle {
  double radius = 1.0;

  /** Return the area of this circle */
  double findArea() {
    return radius * radius * 3.14159;
  }
}