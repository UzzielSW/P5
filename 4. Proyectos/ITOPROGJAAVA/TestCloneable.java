// TestCloneable.java: Use the TestCloneable interface
// to enable cloning
public class TestCloneable {
  /** Main method */
  public static void main(String[] args) {
    // Declare and create an instance of CloneableCircle
    CloneableCircle c1 = new CloneableCircle(5);
    CloneableCircle c2 = (CloneableCircle)c1.clone();

    System.out.println("After copying c1 to c2");

    // Check if two variables point to the same object
    if (c1 == c2)
      System.out.println("c1 and c2 reference to the same object");
    else
      System.out.println("c1 and c2 don't point to the same object");

    // Check if two objects are of identical contents
    if (c1.equals(c2))
      System.out.println("c1 and c2 have the same contents");
    else
      System.out.println("c1 and c2 don't have the same contents");

    // Modify c1's radius, name
    c1.setRadius(10);
    c1.getCreator().setFirstName("Michael");
    c1.getCreator().setMi('Z');

    // Display c1 and c2
    System.out.println("\nAfter modifying c1");
    System.out.println("c1 " + c1);
    System.out.println("c2 " + c2);

    System.out.println();
    if (c1 instanceof Cloneable) {
      System.out.println("A CloneableCircle object is cloneable");
    }
    else {
      System.out.println(c1 + "is not cloneable");
    }

    // Check if a Circle object is cloneable
    Circle c = new Circle();
    if (c instanceof Cloneable) {
      System.out.println("A Circle object is cloneable");
    }
    else {
      System.out.println("A Circle object is not cloneable");
    }
  }
}

// CloneableCircle is a subclass of Circle, which implements the
// Cloneable interface
class CloneableCircle extends Circle implements Cloneable {
  // Store the creator of the object
  private Name creator = new Name("Yong", 'D', "Liang");

  /** Construct a CloneableCircle with a specified radius */
  public CloneableCircle(double radius) {
    super(radius);
  }

  /** Return creator */
  public Name getCreator() {
    return creator;
  }

  /** Set a new creator */
  public void setCreator(Name name) {
    creator = name;
  }

  /** Override the protected clone method defined in the Object
     class, and strengthen its accessibility */
  public Object clone() {
    try {
      return super.clone();
    }
    catch (CloneNotSupportedException ex) {
      return null;
    }
  }

  /** Override the toString method defined in the Object class */
  public String toString() {
    return super.toString() + " " + creator.getFullName();
  }
}