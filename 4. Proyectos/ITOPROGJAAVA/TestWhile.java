// TestWhile.java: Test the while loop
import javax.swing.JOptionPane;

public class TestWhile {
  /** Main method */
  public static void main(String[] args) {
    int data;
    int sum = 0;

    // Read an initial data
    String dataString = JOptionPane.showInputDialog(null, 
      "Enter an int value, \nthe program exits if the input is 0",
      "Example 3.2 Input", JOptionPane.QUESTION_MESSAGE);

    data = Integer.parseInt(dataString);

    // Keep reading data until the input is 0
    while (data != 0) {
      sum += data;

      // Read the next data
      dataString = JOptionPane.showInputDialog(null, 
        "Enter an int value, \nthe program exits if the input is 0",
        "Example 3.2 Input", JOptionPane.QUESTION_MESSAGE);

      data = Integer.parseInt(dataString);
    }

    JOptionPane.showMessageDialog(null, "The sum is " + sum, 
      "Example 3.2 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}