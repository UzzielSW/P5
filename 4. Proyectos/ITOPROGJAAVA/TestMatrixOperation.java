// TestMatrixOperation.java: Add and multiply two matrices
public class TestMatrixOperation {
  /** Main method */
  public static void main(String[] args) {
    // Create two matrices as two dimensional arrays
    int[][] matrix1 = new int[5][5];
    int[][] matrix2 = new int[5][5];

    // Assign random values to matrix1 and matrix2
    for (int i = 0; i < matrix1.length; i++)
      for (int j = 0; j < matrix1[i].length; j++) {
        matrix1[i][j] = (int)(Math.random() * 10);
        matrix2[i][j] = (int)(Math.random() * 10);
      }

    // Add two matrices and print the result
    int[][] resultMatrix = addMatrix(matrix1, matrix2);
    System.out.println("The addition of the matrices is ");
    printResult(matrix1, matrix2, resultMatrix, '+');

    // Multiply two matrices and print the result
    resultMatrix = multiplyMatrix(matrix1, matrix2);
    System.out.println("\nThe multiplication of the matrices is ");
    printResult(matrix1, matrix2, resultMatrix, '*');
  }

  /** The method for adding two matrices */
  public static int[][] addMatrix(int[][] m1, int[][] m2) {
    int[][] result = new int[m1.length][m1[0].length];
    for (int i = 0; i < result.length; i++)
      for (int j = 0; j < result[0].length; j++)
        result[i][j] = m1[i][j] + m2[i][j];

    return result;
  }

  /** The method for multiplying two matrices */
  public static int[][] multiplyMatrix(int[][] m1, int[][] m2) {
    int[][] result = new int[m1.length][m2[0].length];
    for (int i = 0; i < m1.length; i++)
      for (int j = 0; j < result.length; j++)
        for (int k = 0; k < result[0].length; k++)
           result[i][j] += m1[i][k] * m2[k][j];

    return result;
  }

  /** Print result */
  public static void printResult(
    int[][] m1, int[][] m2, int[][] m3, char op) {
    for (int i = 0; i < m1.length; i++) {
      for (int j = 0; j < m1[0].length; j++)
        System.out.print(" " + m1[i][j]);

      if (i == m1.length / 2)
        System.out.print( "  " + op + "  " );
      else
        System.out.print( "     " );

      for (int j = 0; j < m2[0].length; j++)
        System.out.print(" " + m2[i][j]);

      if (i == m1.length / 2)
        System.out.print( "  =  " );
      else
        System.out.print( "     " );

      for (int j = 0; j < m3[0].length; j++)
        System.out.print(" " + m3[i][j]);

      System.out.println();
    }
  }
}