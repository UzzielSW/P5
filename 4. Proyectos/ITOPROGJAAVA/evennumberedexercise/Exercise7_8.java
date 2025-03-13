import java.util.*;

import javax.swing.JOptionPane;

public class Exercise7_8 {
  /**Main method*/
  public static void main(String[] args) {
    // Receive the amount entered from the dialog box
    String amountString = JOptionPane.showInputDialog(null, 
      "Enter an amount in double, for example 11.56:",
      "Exercise7_8 Input", JOptionPane.QUESTION_MESSAGE);

    StringTokenizer st = new StringTokenizer(amountString, ".\n\r\t");
    int dollars = Integer.parseInt(st.nextToken());

    int remainingAmount = 0;
    int cents = 0;

    if (st.hasMoreTokens())
      remainingAmount = cents = Integer.parseInt(st.nextToken());

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
    System.out.println("Your amount " + amountString + " consists of ");
    System.out.println(dollars + "\t dollars");
    System.out.println(numOfQuarters + "\t quarters");
    System.out.println(numOfDimes + "\t dimes");
    System.out.println(numOfNickels + "\t nickels");
    System.out.println(numOfPennies + "\t pennies");
    
    System.exit(0);
  }
}