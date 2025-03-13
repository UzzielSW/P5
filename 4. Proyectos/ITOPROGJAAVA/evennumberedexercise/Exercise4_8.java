// Exercise4_8.java: Compute factorial using iterations
import javax.swing.JOptionPane;

public class Exercise4_8 {
  public static void main(String[] args) {
    // Enter an integer
    String s1 = JOptionPane.showInputDialog(null, 
      "Please enter a nonnegative integer:",
      "Exercise4_8 Input", JOptionPane.QUESTION_MESSAGE);
    
    // Convert string to int
    int n = Integer.parseInt(s1);

    System.out.println("Factorial of " + n + " is " + factorial(n));
    
    System.exit(0);
  }

  // Iterative method for computing factorial of n
  static long factorial(int n) {
    long result = 1;

    for (int i = 1; i <= n; i++)
      result *= i;

    return result;
  }
}