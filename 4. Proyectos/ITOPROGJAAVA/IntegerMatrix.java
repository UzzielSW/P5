// IntegerMatrix.java:
// Declare IntegerMatrix derived from GenericMatrix
public class IntegerMatrix extends GenericMatrix {
  /** Construct an IntegerMatrix */
  public IntegerMatrix(Object[][] m) {
    super(m);
  }

  /** Implement the createGenericMatrix method */
  public GenericMatrix createGenericMatrix(Object[][] matrix) {
    return new IntegerMatrix(matrix);
  }

  /** Implement the add method for adding two matrix elements */
  protected Object add(Object o1, Object o2) {
    Integer i1 = (Integer)o1;
    Integer i2 = (Integer)o2;
    return new Integer(i1.intValue() + i2.intValue());
  }

  /** Implement the multiply method for multiplying two
     matrix elements */
  protected Object multiply(Object o1, Object o2) {
    Integer i1 = (Integer)o1;
    Integer i2 = (Integer)o2;
    return new Integer(i1.intValue() * i2.intValue());
  }

  /** Implement the zero method to specify zero for Integer */
  protected Object zero() {
    return new Integer(0);
  }
}