// ComputeChange.java: Break down an amount into smaller units
import javax.swing.JOptionPane;

public class ComputeChange {
  /** Main method */
  public static void main(String[] args) {
    double amount; // Amount entered from the keyboard
    
    // Receive the amount entered from the keyboard
    String amountString = JOptionPane.showInputDialog(null,
      "Enter an amount in double, for example 11.56",
      "Example 2.4 Input", JOptionPane.QUESTION_MESSAGE);
    
    // Convert string to double
    amount = Double.parseDouble(amountString);
    
    int remainingAmount = (int)(amount * 100);
    
    // Find the number of one dollars
    int numOfOneDollars = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;
    
    // Find the number of quarters in the remaining amount
    int numOfQuarters = remainingAmount / 25;
    remainingAmount = remainingAmount % 25;
    
    // Find the number of dimes in the remaining amount
    int numOfDimes = remainingAmount / 10;
    remainingAmount = remainingAmount % 10;
    
    // Find the number of nickels in the remaining amount
    int numOfNickels = remainingAmount / 5;
    remainingAmount = remainingAmount % 5;
    
    // Find the number of pennies in the remaining amount
    int numOfPennies = remainingAmount;
    
    // Display results
    String output = "Your amount " + amount + " consists of \n" + 
      numOfOneDollars + " dollars\n" + 
      numOfQuarters + " quarters\n" +
      numOfDimes + " dimes\n" + 
      numOfNickels + " nickel\n" +
      numOfPennies + " pennies";
    JOptionPane.showMessageDialog(null, output, 
      "Example 2.4 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}