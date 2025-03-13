// TestSum.java: Compute sum = 0.01 + 0.02 + … + 1;
import javax.swing.JOptionPane;

public class TestSum {
  /** Main method */
  public static void main(String[] args) {
    // Initialize sum
    float sum = 0;

    // Keep adding 0.01 to sum
    for (float i = 0.01f; i <= 1.0f; i = i + 0.01f)
      sum += i;

    // Display result
    JOptionPane.showMessageDialog(null, "The summation is " + sum, 
      "Example 3.3 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0); 
  }
}  