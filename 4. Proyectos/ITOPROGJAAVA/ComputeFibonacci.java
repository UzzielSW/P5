// ComputeFibonacci.java: Find a Fibonacci number for a given index
import javax.swing.JOptionPane;

public class ComputeFibonacci {
  /** Main method */
  public static void main(String args[]) {
    // Read the index
    String intString = JOptionPane.showInputDialog(null, 
      "Enter an index for the Fibonacci number:",
      "Example 4.8 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into integer
    int n = Integer.parseInt(intString);

    // Find and display the Fibonacci number
    JOptionPane.showMessageDialog(null, 
      "Fibonacci number at index " + n + " is " + fib(n),
      "Example 4.8 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }

  /** The method for finding the Fibonacci number */
  public static long fib(long n) {
    if ((n == 0) || (n == 1))  // Stopping condition
      return n;
    else  // Reduction and recursive calls
      return fib(n - 1) + fib(n - 2);
  }
}