// TestPolymorphism.java: Demonstrate polymorphism
public class TestPolymorphism {
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize two geometric objects
    GeometricObject geoObject1 = new Circle(5);
    GeometricObject geoObject2 = new Rectangle(5, 3);

    System.out.println("The two objects have the same area? " +
      equalArea(geoObject1, geoObject2));

    // Display circle
    displayGeometricObject(geoObject1);

    // Display rectangle
    displayGeometricObject(geoObject2);
  }

  /** A method for comparing the areas of two geometric objects */
  static boolean equalArea(GeometricObject object1,
    GeometricObject object2) {
    return object1.findArea() == object2.findArea();
  }

  /** A method for displaying a geometric object */
  static void displayGeometricObject(GeometricObject object) {
    System.out.println();
    System.out.println(object.toString());
    System.out.println("The area is " + object.findArea());
    System.out.println("The perimeter is " + object.findPerimeter());
  }
}