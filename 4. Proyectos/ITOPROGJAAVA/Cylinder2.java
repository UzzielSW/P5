// Cylinder2.java: New cylinder class that overrides the findArea()
// method defined in the circle class. The source code of 
public class Cylinder2 extends CircleWithAccessors {
  /** length of this cylinder */
  private double length;

  /** Default constructor */
  public Cylinder2() {
    super(); // Can be omitted
    length = 1.0;
  }

  /** Construct a cylinder with specified radius and length */
  public Cylinder2(double radius, double length) {
    super(radius);
    this.length = length;
  }

  /** Return length */
  public double getLength() {
    return length;
  }

  /** Return the surface area of this cylinder. The formula is 
   * 2*circle area + cylinder body area
    */
  public double findArea() {
    return 2 * super.findArea() + 2 * getRadius() * Math.PI * length;
  }

  /** Return the volume of this cylinder */
  public double findVolume() {
    return super.findArea() * length;
  }
}