// TestMortgageClass.java: Demonstrate using the Mortgage class
import javax.swing.JOptionPane;

public class TestMortgageClass {
  /** Main method */
  public static void main(String[] args) {
    // Enter yearly interest rate
    String annualInterestRateString = JOptionPane.showInputDialog(
      null, "Enter yearly interest rate, for example 8.25:",
      "Example 6.8 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    double annualInterestRate = 
      Double.parseDouble(annualInterestRateString);
       
    // Enter number of years
    String numOfYearsString = JOptionPane.showInputDialog(null, 
      "Enter number of years as an integer, \nfor example 5:",
      "Example 6.8 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int numOfYears = Integer.parseInt(numOfYearsString);
    
    // Enter loan amount
    String loanString = JOptionPane.showInputDialog(null, 
      "Enter loan amount, for example 120000.95:",
      "Example 6.8 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    double loanAmount =  Double.parseDouble(loanString);

    // Create Mortgage object
    Mortgage mortgage = 
      new Mortgage(annualInterestRate, numOfYears, loanAmount);

    // Format to keep two digits after the decimal point
    double monthlyPayment = 
      (int)(mortgage.monthlyPayment() * 100) / 100.0;
    double totalPayment = 
      (int)(mortgage.totalPayment() * 100) / 100.0;
    
    // Display results
    String output = "The monthly payment is " + monthlyPayment + 
      "\nThe total payment is " + totalPayment;
    JOptionPane.showMessageDialog(null, output, 
      "Example 6.8 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }
}