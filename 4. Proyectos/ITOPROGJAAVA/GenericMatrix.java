// GenericMatrix.java: Define a matrix and its associated
// operations such as add and multiply
public abstract class GenericMatrix {
  // Representation of a matrix using a two-dimensional array
  private Object[][] matrix;

  /** Construct a matrix */
  protected GenericMatrix(Object[][] matrix) {
    this.matrix = matrix;
  }

  /** Return matrix */
  public Object[][] getMatrix() {
    return matrix;
  }

  /** Set a new matrix */
  public void setMatrix(Object[][] matrix) {
    this.matrix = matrix;
  }

  public abstract GenericMatrix 
    createGenericMatrix(Object[][] matrix);

  /** Add two matrices */
  public GenericMatrix addMatrix(
    GenericMatrix secondGenericMatrix) {
    // Create a result matrix
    Object[][] result =
      new Object[matrix.length][matrix[0].length];

    // Obtain the second matrix
    Object[][] secondMatrix =  secondGenericMatrix.getMatrix();

    // Check bounds of the two matrices
    if ((matrix.length != secondMatrix.length) ||
        (matrix[0].length != secondMatrix.length)) {
      System.out.println(
        "The matrices do not have the same size");
      System.exit(0);
    }

    // Perform addition
    for (int i = 0; i < result.length; i++)
      for (int j = 0; j < result[i].length; j++)
        result[i][j] = add(matrix[i][j], secondMatrix[i][j]);

    return createGenericMatrix(result);
  }

  /** Multiply two matrices */
  public GenericMatrix multiplyMatrix(
    GenericMatrix secondGenericMatrix) {
    // Obtain the second matrix
    Object[][] secondMatrix =  secondGenericMatrix.getMatrix();

    // Create result matrix
    Object[][] result =
      new Object[matrix.length][secondMatrix[0].length];

    // Check bounds
    if (matrix[0].length != secondMatrix.length) {
      System.out.println("Bounds error");
      System.exit(0);
    }

    // Perform multiplication of two matrices
    for (int i = 0; i < result.length; i++)
      for (int j = 0; j < result[0].length; j++) {
      result[i][j] = zero();

      for (int k = 0; k < matrix[0].length; k++) {
        result[i][j] = add(result[i][j],
          multiply(this.matrix[i][k], secondMatrix[k][j]));
      }
    }
    
    return createGenericMatrix(result);
  }

  /** Print matrices, the operator, and their operation result */
  public static void printResult(
    GenericMatrix m1, GenericMatrix m2, GenericMatrix m3, char op) {
    for (int i = 0; i < (m1.getMatrix()).length; i++) {
      for (int j = 0; j < (m1.getMatrix())[0].length; j++)
        System.out.print(" " + (m1.getMatrix())[i][j]);

      if (i == (m1.getMatrix()).length / 2)
        System.out.print( "  " + op + "  " );
      else
        System.out.print( "     " );

      for (int j = 0; j < (m2.getMatrix()).length; j++)
        System.out.print(" " + (m2.getMatrix())[i][j]);

      if (i == (m1.getMatrix()).length / 2)
        System.out.print( "  =  " );
      else
        System.out.print( "     " );

      for (int j = 0; j < (m3.getMatrix()).length; j++)
        System.out.print(" " + (m3.getMatrix())[i][j]);

      System.out.println();
    }
  }

  /** Abstract method for adding two elements of the matrices */
  protected abstract Object add(Object o1, Object o2);

  /** Abstract method for multiplying two elements of the matrices */
  protected abstract Object multiply(Object o1, Object o2);

  /** Abstract method for defining zero for the matrix element */
  protected abstract Object zero();
}