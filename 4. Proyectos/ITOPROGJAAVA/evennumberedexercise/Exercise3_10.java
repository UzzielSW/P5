// Exercise3_10: Find smallest factors of an integer
import javax.swing.JOptionPane;

public class Exercise3_10 {
  // Main method
  public static void main(String args[]) {
    // Prompt the user to enter an integer
    String intString = JOptionPane.showInputDialog(null, 
      "Enter an integer:",
      "Exercise3_10 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int number = Integer.parseInt(intString);

    // Find all the smallest factors of the integer
    System.out.println("The factors for " + number + " is");
    int factor = 2;
    while (factor <= number) {
      if (number % factor == 0) {
        number = number / factor;
        System.out.println(factor);
      }
      else {
        factor++;
      }
    }
    
    System.exit(0);
  }
}
