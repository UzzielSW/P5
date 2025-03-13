// Exercise3_2.java: Sort three numbers
// The solution can be simplified after you how sort a list
import javax.swing.JOptionPane;

public class Exercise3_2 {
  public static void main(String[] args) {
    // Enter the first number
    String numberString = JOptionPane.showInputDialog(null, 
      "Enter the first integer:",
      "Exercise3_2 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int num1 = Integer.parseInt(numberString);    
    
    // Enter the second number
    numberString = JOptionPane.showInputDialog(null, 
      "Enter the second integer:",
      "Exercise3_2 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int num2 = Integer.parseInt(numberString);    
    
    // Enter the third number
    numberString = JOptionPane.showInputDialog(null, 
      "Enter the third integer:",
      "Exercise3_2 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int num3 = Integer.parseInt(numberString);    
		
    if (num1 > num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
    }

    if (num2 > num3) {
      int temp = num2;
      num2 = num3;
      num3 = temp;
    }

    if (num1 > num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
    }

    System.out.println("The sorted numbers are "
      + num1 + " " + num2 + " " + num3);
    
    System.exit(0);
  }
}