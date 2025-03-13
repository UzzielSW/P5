// Exercise2_4.java: Break down an amount into smaller units
import javax.swing.JOptionPane;

public class Exercise2_4 {
  // Main method
  public static void main(String[] args) {
    int amount; // Amount entered from the keyboard

    // Receive the amount entered from the keyboard
    String amountString = JOptionPane.showInputDialog(null,
      "Enter an amount in integer, for example 1156 \nfor 11 dollars and 56 cents",
      "Exercise 2_4 Input", JOptionPane.QUESTION_MESSAGE);
    
    // Convert string to double
    amount = Integer.parseInt(amountString);
 
    int remainingAmount = amount;

    // Find the number of one dollars
    int numOfOneDollars = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;

    // Find the number of quaters in the remaining amount
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
    System.out.println("Your amount " + amount + " consists of ");
    System.out.println(numOfOneDollars + "\t dollars");
    System.out.println(numOfQuarters + "\t quarters");
    System.out.println(numOfDimes + "\t dimes");
    System.out.println(numOfNickels + "\t nickels");
    System.out.println(numOfPennies + "\t pennies");

    System.exit(0);
  }
}