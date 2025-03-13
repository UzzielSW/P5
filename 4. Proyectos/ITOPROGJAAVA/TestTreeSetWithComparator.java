import java.util.*;

public class TestTreeSetWithComparator {
  public static void main(String[] args) {
    // Create a tree set for geometric objects using a comparator
    Set geometricObjectSet =
      new TreeSet(new GeometricObjectComparator());
    geometricObjectSet.add(new Rectangle(4, 5));
    geometricObjectSet.add(new Circle(40));
    geometricObjectSet.add(new Circle(40));
    geometricObjectSet.add(new Cylinder(4, 1));

    // Obtain an iterator for the tree set of geometric objects
    Iterator iterator = geometricObjectSet.iterator();

    // Display geometric objects in the tree set
    System.out.println("A sorted set of geometric objects");
    while (iterator.hasNext()) {
      GeometricObject object = (GeometricObject)iterator.next();
      System.out.println(object + ", area= " + object.findArea());
    }
  }
}