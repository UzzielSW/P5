// ComputeMortgage.java: Compute mortgage payments
import javax.swing.JOptionPane;

public class ComputeMortgage {
  /** Main method */
  public static void main(String[] args) {
    double annualInterestRate;
    int numOfYears;
    double loanAmount;
    
    // Enter yearly interest rate
    String annualInterestRateString = JOptionPane.showInputDialog(
      null, "Enter yearly interest rate, for example 8.25:",
      "Example 2.3 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    annualInterestRate = 
      Double.parseDouble(annualInterestRateString);
    
    // Obtain monthly interest rate
    double monthlyInterestRate = annualInterestRate/1200;
    
    // Enter number of years
    String numOfYearsString = JOptionPane.showInputDialog(null, 
      "Enter number of years as an integer, \nfor example 5:",
      "Example 2.3 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    numOfYears = Integer.parseInt(numOfYearsString);
    
    // Enter loan amount
    String loanString = JOptionPane.showInputDialog(null, 
      "Enter loan amount, for example 120000.95:",
      "Example 2.3 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    loanAmount =  Double.parseDouble(loanString);

    // Calculate payment
    double monthlyPayment = loanAmount * monthlyInterestRate /
      (1 - 1 / Math.pow(1 + monthlyInterestRate, numOfYears * 12));
    double totalPayment = monthlyPayment * numOfYears * 12;
    
    // Format to keep two digits after the decimal point
    monthlyPayment = (int)(monthlyPayment * 100) / 100.0;
    totalPayment = (int)(totalPayment * 100) / 100.0;
    
    // Display results
    String output = "The monthly payment is " + monthlyPayment + 
      "\nThe total payment is " + totalPayment;
    JOptionPane.showMessageDialog(null, output, 
      "Example 2.3 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}