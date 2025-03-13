// TestRationalMatrix.java: Test matrix operations involving
// Rational values
public class TestRationalMatrix {
  public static void main(String[] args) {
    // Declare Rational arrays m1, m2
    Object[][] m1 = new Rational[4][4];
    Object[][] m2 = new Rational[4][4];

    // Initialize Rational arrays m1 and m2
    for (int i = 0; i < m1.length; i++)
      for (int j = 0; j < m1[0].length; j++) {
        m1[i][j] = new Rational(i + 1, i + 3);
        m2[i][j] = new Rational(i + 1, i + 3);
      }

    // Create RationalMatrix instances
    RationalMatrix rm1 = new RationalMatrix(m1);
    RationalMatrix rm2 = new RationalMatrix(m2);

    // Perform Rational matrix addition, and multiplication
    RationalMatrix rm3 = (RationalMatrix)rm1.addMatrix(rm2);
    RationalMatrix rm4 = (RationalMatrix)rm1.multiplyMatrix(rm2);

    // Display rm1, rm2, rm3, rm4
    System.out.println("m1 + m2 is ...");
    GenericMatrix.printResult(rm1, rm2, rm3, '+');

    System.out.println("\nm1 * m2 is ...");
    GenericMatrix.printResult(rm1, rm2, rm4, '*');
  }
}