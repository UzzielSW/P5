// Exercise5_6.java: Write a method to sum all integers in
// a matrix of integers.
public class Exercise5_6 {
  // Main method
  public static void main(String[] args) {
    int[][] m = { 
      {1, 2, 4, 5},  
      {6, 7, 8, 9},  
      {10, 11, 12, 13},  
      {14, 15, 16, 17}};

    int sum = 0;

    for (int i = 0; i < m.length; i++)
      for (int j = 0; j < m[0].length; j++)
        sum += m[i][j];

    System.out.print("Sum of the matrix is " + sum);
  }
}