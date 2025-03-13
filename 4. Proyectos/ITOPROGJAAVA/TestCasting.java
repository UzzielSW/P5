// TestCasting.java: Demonstrate casting objects
public class TestCasting {
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize two geometric objects
    GeometricObject geoObject1 = new Circle(5);
    GeometricObject geoObject2 = new Cylinder(5, 3);

    // Display circle
    displayGeometricObject(geoObject1);

    // Display cylinder
    displayGeometricObject(geoObject2);
  }

  /** A method for displaying a geometric object */
  static void displayGeometricObject(GeometricObject object) {
    System.out.println();
    System.out.println(object.toString());

    if (object instanceof Cylinder) {
      System.out.println("The area is " +
        ((Cylinder)object).findArea());
      System.out.println("The volume is " +
        ((Cylinder)object).findVolume());
    }
    else if (object instanceof Circle) {
      System.out.println("The area is " + object.findArea());
      System.out.println("The perimeter is " +
        object.findPerimeter());
    }
  }
}