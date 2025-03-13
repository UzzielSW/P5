// TestIfElse.java: Test if-else statements
import javax.swing.JOptionPane;

public class TestIfElse {
  /** Main method */
  public static void main(String[] args) {
    double annualInterestRate = 0;
    int numOfYears;
    double loanAmount;
    
    // Prompt the user to enter number of years
    String numOfYearsString = JOptionPane.showInputDialog(null, 
      "Enter number of years (7, 15 and 30 only):",
      "Example 3.1 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into int
    numOfYears = Integer.parseInt(numOfYearsString);
    
    // Find interest rate based on year
    if (numOfYears == 7)
      annualInterestRate = 7.25;
    else if (numOfYears == 15)
      annualInterestRate = 8.50;
    else if (numOfYears == 30)
      annualInterestRate = 9.0;
    else {
      JOptionPane.showMessageDialog(null, 
        "Wrong number of years", 
        "Example 3.1 Output", JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
    
    // Obtain monthly interest rate
    double monthlyInterestRate = annualInterestRate / 1200;
    
    // Prompt the user to enter loan amount
    String loanAmountString = JOptionPane.showInputDialog(null, 
      "Enter loan amount, for example 120000.95:",
      "Example 3.1 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into double
    loanAmount = Double.parseDouble(loanAmountString);
    
    // Compute mortgage
    double monthlyPayment = loanAmount*monthlyInterestRate / ( 1 -
      (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
    double totalPayment = monthlyPayment * numOfYears * 12;
    
    // Format to keep two digits after the decimal point
    monthlyPayment = (int)(monthlyPayment * 100) / 100.0;
    totalPayment = (int)(totalPayment * 100) / 100.0;
    
    // Display results
    String output = "The monthly payment is " + monthlyPayment + 
      "\nThe total payment is " + totalPayment;
    JOptionPane.showMessageDialog(null, output, 
      "Example 3.1 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}