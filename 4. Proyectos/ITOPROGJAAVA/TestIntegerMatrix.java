// TestIntegerMatrix.java: Test matrix operations involving
// integer values
public class TestIntegerMatrix {
  public static void main(String[] args) {
    // Create Integer arrays m1, m2
    Object[][] m1 = new Integer[5][5];
    Object[][] m2 = new Integer[5][5];

    // Initialize Integer arrays m1 and m2
    for (int i = 0; i < m1.length; i++)
      for (int j = 0; j < m1[0].length; j++) {
        m1[i][j] = new Integer(i);
      }

    for (int i = 0; i < m2.length; i++)
      for (int j = 0; j < m2[0].length; j++) {
        m2[i][j] = new Integer(i + j);
      }

    // Create instances of IntegerMatrix
    IntegerMatrix im1 = new IntegerMatrix(m1);
    IntegerMatrix im2 = new IntegerMatrix(m2);

    // Perform integer matrix addition, and multiplication
    IntegerMatrix im3 = (IntegerMatrix)im1.addMatrix(im2);
    IntegerMatrix im4 = (IntegerMatrix)im1.multiplyMatrix(im2);

    // Display im1, im2, im3, im4
    System.out.println("m1 + m2 is ...");
    GenericMatrix.printResult(im1, im2, im3, '+');

    System.out.println("\nm1 * m2 is ...");
    GenericMatrix.printResult(im1, im2, im4, '*');
  }
}