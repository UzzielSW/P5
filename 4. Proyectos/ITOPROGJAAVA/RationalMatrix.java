/** RationalMatrix.java:
   Declare RationalMatrix derived from GenericMatrix */
public class RationalMatrix extends GenericMatrix {
  /** Construct a RationalMatrix for a given Rational array */
  public RationalMatrix(Object[][] m1) {
    super(m1);
  }

  /** Implement the createGenericMatrix method */
  public GenericMatrix createGenericMatrix(Object[][] matrix) {
    return new RationalMatrix(matrix);
  }

  /** Implement the add method for adding two rational elements */
  protected Object add(Object o1, Object o2) {
    Rational r1 = (Rational)o1;
    Rational r2 = (Rational)o2;
    return r1.add(r2);
  }

  /** Implement the multiply method for multiplying
     two rational elements */
  protected Object multiply(Object o1, Object o2) {
    Rational r1 = (Rational)o1;
    Rational r2 = (Rational)o2;
    return r1.multiply(r2);
  }

  /** Implement the zero method to specify zero for Rational */
  protected Object zero() {
    return new Rational(0,1);
  }
}