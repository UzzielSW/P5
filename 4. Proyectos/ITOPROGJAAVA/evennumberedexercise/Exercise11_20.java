import javax.swing.*;

public class Exercise11_20 {
  /** Main method */
  public static void main(String[] args) {
    // Receive the amount entered from the keyboard
    String amountString = JOptionPane.showInputDialog(
      null, "Enter an amount in double, \nfor example 11.56",
      "Exercise 11.20: Input", JOptionPane.QUESTION_MESSAGE);
    // Amount entered from the keyboard
    double amount = Double.parseDouble(amountString);
    
    int remainingAmount = (int)(amount*100);

    // Find the number of one dollars
    int numOfOneDollars = remainingAmount/100;
    remainingAmount = remainingAmount%100;

    // Find the number of quarters in the remaining amount
    int numOfQuarters = remainingAmount/25;
    remainingAmount = remainingAmount%25;

    // Find the number of dimes in the remaining amount
    int numOfDimes = remainingAmount/10;
    remainingAmount = remainingAmount%10;

    // Find the number of nickels in the remaining amount
    int numOfNickels = remainingAmount/5;
    remainingAmount = remainingAmount%5;

    // Find the number of pennies in the remaining amount
    int numOfPennies = remainingAmount;

    // Display results
    JOptionPane.showMessageDialog(null, 
      "Your amount " + amount + " consists of \n" +
      numOfOneDollars + " dollars\n" +
      numOfQuarters + " quarters\n" +
      numOfDimes + " dimes\n" +
      numOfNickels + " nickels\n" +
      numOfPennies + " pennies", 
      "Exercise 11.20: Result", JOptionPane.INFORMATION_MESSAGE);
  }
}
