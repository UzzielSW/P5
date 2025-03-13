// Exercise8_4.java: Create a new GeometricObject class, a new Circle
// class and a new Cylinder class
public class Exercise8_4 {
  // Main method
  public static void main(String[] args) {
    // Create two comarable circles
    Circle1 circle1 = new Circle1(5);
    Circle1 circle2 = new Circle1(4);

    // Display the max circle
    Circle1 circle = (Circle1)Max.max(circle1, circle2);
    System.out.println("The max circle's radius is " +
      circle.getRadius());
    System.out.println(circle);

    // Create two comarable cylinders
    Cylinder1 cylinder1 = new Cylinder1(5, 2);
    Cylinder1 cylinder2 = new Cylinder1(4, 5);

    // Display the max cylinder
    Cylinder1 cylinder = (Cylinder1)Max.max(cylinder1, cylinder2);
    System.out.println();
    System.out.println("cylinder1's volume is " +
      cylinder1.findVolume());
    System.out.println("cylinder2's volume is " +
      cylinder2.findVolume());
    System.out.println("The max cylinder's \tradius is " +
      ((Cylinder1)cylinder).getRadius() + "\n\t\t\tlength is " +
      ((Cylinder1)cylinder).getLength() + "\n\t\t\tvolume is " +
      ((Cylinder1)cylinder).findVolume());
    System.out.println(cylinder);
  }
}


abstract class GeometricObject1 implements Comparable {
  protected String color;
  protected double weight;

  // Default construct
  protected GeometricObject1() {
    color = "white";
    weight = 1.0;
  }

  // Construct a geometric object
  protected GeometricObject1(String color, double weight) {
    this.color = color;
    this.weight = weight;
  }

  // Getter method for color
  public String getColor() {
    return color;
  }

  // Setter method for color
  public void setColor(String color) {
    this.color = color;
  }

  // Getter method for weight
  public double getWeight() {
    return weight;
  }

  // Setter method for weight
  public void setWeight(double weight) {
    this.weight = weight;
  }

  // Abstract method
  public abstract double findArea();

  // Abstract method
  public abstract double findPerimeter();
}

// Circle.java: The circle class that extends GeometricObject
class Circle1 extends GeometricObject1 {
  protected double radius;

  // Default constructor
  public Circle1() {
    this(1.0, "white", 1.0);
  }

  // Construct circle with specified radius
  public Circle1(double radius) {
    super("white", 1.0);
    this.radius = radius;
  }

  // Construct a circle with specified radius, weight, and color
  public Circle1(double radius, String color, double weight) {
    super(color, weight);
    this.radius = radius;
  }

  // Getter method for radius
  public double getRadius() {
    return radius;
  }

  // Setter method for radius
  public void setRadius(double radius) {
    this.radius = radius;
  }

  // Implement the findArea method defined in GeometricObject
  public double findArea() {
    return radius*radius*Math.PI;
  }

  // Implement the findPerimeter method defined in GeometricObject
  public double findPerimeter() {
    return 2*radius*Math.PI;
  }

  // Override the equals() method defined in the Object class
  public boolean equals(Circle1 circle) {
    return this.radius == circle.getRadius();
  }

  // Override the toString() method defined in the Object class
  public String toString() {
    return "[Circle] radius = " + radius;
  }

  // Implement the compareTo method defined in Comparable
  public int compareTo(Object o) {
    if (getRadius() > ((Circle1)o).getRadius())
      return 1;
    else if (getRadius() < ((Circle1)o).getRadius())
      return -1;
    else
      return 0;
  }
}

class Cylinder1 extends Circle1 {
  private double length;

  // Default constructor
  public Cylinder1() {
    super();
    length = 1.0;
  }

  // Construct a cylinder with specified radius, and length
  public Cylinder1(double radius, double length) {
    this(radius, "white", 1.0, length);
  }

  // Construct a cylinder with specified radius, weight, color, and
  // length
  public Cylinder1(double radius,
    String color, double weight, double length) {
    super(radius, color, weight);
    this.length = length;
  }

  // Getter method for length
  public double getLength() {
    return length;
  }

  // Setter method for length
  public void setLength(double length) {
    this.length = length;
  }

  // Find cylinder surface area
  public double findArea() {
    return 2*super.findArea()+(2*getRadius()*Math.PI)*length;
  }

  // Find cylinder volume
  public double findVolume() {
    return super.findArea()*length;
  }

  // Override the equals() method defined in the Object class
  public boolean equals(Cylinder1 cylinder) {
    return (this.radius == cylinder.getRadius()) &&
      (this.length == cylinder.getLength());
  }

  // Override the toString() method defined in the Object class
  public String toString() {
    return "[Cylinder1] radius = " + radius + " and length "
      + length;
  }

  // Implement the compareTo method defined in Comparable interface
  public int compareTo(Object o) {
    if (findVolume() > ((Cylinder1)o).findVolume())
      return 1;
    else if (findVolume() < ((Cylinder1)o).findVolume())
      return -1;
    else
      return 0;
  }
}

// Max.java: Find a maximum object
class Max {
  // Return the maximum between two objects
  public static Comparable max(Comparable o1, Comparable o2) {
    if (o1.compareTo(o2) > 0)
      return o1;
    else
      return o2;
  }
}