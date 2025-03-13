// TestOverrideMethod.java: Test the Cylinder class that overrides
// its superclass's methods. The source code of 
public class TestOverrideMethod {
  public static void main(String[] args) {
    Cylinder2 myCylinder = new Cylinder2(5.0, 2.0);
    System.out.println("The length is " + myCylinder.getLength());
    System.out.println("The radius is " + myCylinder.getRadius());
    System.out.println("The surface area of the cylinder is "+
      myCylinder.findArea());
    System.out.println("The volume of the cylinder is "+
      myCylinder.findVolume());
  }
}