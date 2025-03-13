// TestInterface.java: Use the Comparable interface
// and the generic max method to find max objects
public class TestInterface {
  /** Main method */
  public static void main(String[] args) {
    // Create two comparable circles
    ComparableCircle circle1 = new ComparableCircle(5);
    ComparableCircle circle2 = new ComparableCircle(4);

    // Display the max circle
    Comparable circle = Max.max(circle1, circle2);
    System.out.println("The max circle's radius is " +
      ((Circle)circle).getRadius());
    System.out.println(circle);

    // Create two comparable cylinders
    ComparableCylinder cylinder1 = new ComparableCylinder(5, 2);
    ComparableCylinder cylinder2 = new ComparableCylinder(4, 5);

    // Display the max cylinder
    Comparable cylinder = Max.max(cylinder1, cylinder2);
    System.out.println();
    System.out.println("cylinder1's volume is " +
      cylinder1.findVolume());
    System.out.println("cylinder2's volume is " +
      cylinder2.findVolume());
    System.out.println("The max cylinder's \tradius is " +
      ((Cylinder)cylinder).getRadius() + "\n\t\t\tlength is " +
      ((Cylinder)cylinder).getLength() + "\n\t\t\tvolume is " +
      ((Cylinder)cylinder).findVolume());
    System.out.println(cylinder);
  }
}

// ComparableCircle is a subclass of Circle, which implements the
// Comparable interface
class ComparableCircle extends Circle implements Comparable {
  /** Construct a CompareCircle with a specified radius */
  public ComparableCircle(double r) {
    super(r);
  }

  /** Implement the compareTo method defined in Comparable */
  public int compareTo(Object o) {
    if (getRadius() > ((Circle)o).getRadius())
      return 1;
    else if (getRadius() < ((Circle)o).getRadius())
      return -1;
    else
      return 0;
  }
}

// ComparableCylinder is a subclass of Cylinder, which implements the
// CompareObject interface
class ComparableCylinder extends Cylinder implements Comparable {
  /** Construct a CompareCylinder with radius and length */
  ComparableCylinder(double radius, double length) {
    super(radius, length);
  }

  /** Implement the compareTo method defined in Comparable interface */
  public int compareTo(Object o) {
    if (findVolume() > ((Cylinder)o).findVolume())
      return 1;
    else if (findVolume() < ((Cylinder)o).findVolume())
      return -1;
    else
      return 0;
  }
}