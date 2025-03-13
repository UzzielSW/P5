// TestArray.java: Count the occurrences of the largest number
import javax.swing.JOptionPane;

public class TestArray {
  /** Main method */
  public static void main(String[] args) {
    int[] numbers = new int[6];

    // Read all numbers
    for (int i = 0; i < numbers.length; i++) {
      String numString = JOptionPane.showInputDialog(null, 
        "Enter a number:",
        "Example 5.1 Input", JOptionPane.QUESTION_MESSAGE);

      // Convert string into integer
      numbers[i] = Integer.parseInt(numString);
    }

    // Find the largest 
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (max < numbers[i])
        max = numbers[i];
    }

    // Find the occurrence of the largest number
    int count = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == max) count++;
    }

    // Prepare the result
    String output = "The array is ";
    for (int i = 0; i < numbers.length; i++) {
      output += numbers[i] + " ";
    }

    output += "\nThe largest number is " + max;
    output += "\nThe occurrence count of the largest number "
      + "is " + count;

    // Display the result
    JOptionPane.showMessageDialog(null, output, 
      "Example 5.1 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }
}