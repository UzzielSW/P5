// Cylinder1.java: Class definition for describing Cylinder
public class Cylinder1 extends CircleWithAccessors {
  private double length;

  /** Default constructor */
  public Cylinder1() {
    super(); // Invoke the default superclass constructor
    length = 1.0;
  }

  /** Construct a cylinder with specified radius and length */
  public Cylinder1(double radius, double length) {
    super(radius); // Invoke superclass constructor Circle(r)
    this.length = length;
  }

  /** Return length */
  public double getLength() {
    return length;
  }

  /** Return the volume of this cylinder */
  public double findVolume() {
    return findArea() * length;
  }
}