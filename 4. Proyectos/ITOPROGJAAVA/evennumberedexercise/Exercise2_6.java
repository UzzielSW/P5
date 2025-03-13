// Exercise2_6.java: Check if a double number is between 1 and 1000
import javax.swing.JOptionPane;

public class Exercise2_6 {
  /**Main method*/
  public static void main(String[] args) {
    // Enter a number 
    String numberString = JOptionPane.showInputDialog(null,
      "Enter an integer between 0 and 1000",
      "Exercise2_6 Input", JOptionPane.QUESTION_MESSAGE);
    
    // Convert string to double
    double number = Double.parseDouble(numberString);

    // Display results
    System.out.println("The number " + number + " is between 1 and 1000 is "
      + ((1 < number) && (number < 1000)) );

    System.exit(0);
  }
}