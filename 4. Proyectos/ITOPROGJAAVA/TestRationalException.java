// TestRationalException.java: Catch and handle exceptions
public class TestRationalException {
  /** Main method */
  public static void main(String[] args) {
    // Create three rational numbers
    Rational r1 = new Rational(4, 2);
    Rational r2 = new Rational(2, 3);
    Rational r3 = new Rational(0, 1);

    try { 
      System.out.println(r1+" + "+ r2 +" = " + r1.add(r2));
      System.out.println(r1+" - "+ r2 +" = " + r1.subtract(r2));
      System.out.println(r1+" * "+ r2 +" = " + r1.multiply(r2));
      System.out.println(r1+" / "+ r2 +" = " + r1.divide(r2));
      System.out.println(r1+" / "+ r3 +" = " + r1.divide(r3));
      System.out.println(r1+" + "+ r2 +" = " + r1.add(r2));
    }
    catch (Exception ex) { 
      System.out.println(ex);
    }

    // Display the result
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
  }
}