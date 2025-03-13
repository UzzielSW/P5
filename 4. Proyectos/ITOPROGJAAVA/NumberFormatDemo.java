// NumberFormatDemo.java: Demonstrate formatting numbers
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;

public class NumberFormatDemo extends JApplet
  implements ItemListener, ActionListener {
  // Combo box for selecting available locales
  JComboBox jcboLocale = new JComboBox();

  // Text fields for interest rate, year, loan amount,
  JTextField jtfInterestRate = new JTextField(10);
  JTextField jtfNumOfYears = new JTextField(10);
  JTextField jtfLoanAmount = new JTextField(10);
  JTextField jtfFormattedInterestRate = new JTextField(10);
  JTextField jtfFormattedNumOfYears = new JTextField(10);
  JTextField jtfFormattedLoanAmount = new JTextField(10);

  // Text fields for monthly payment and total payment
  JTextField jtfTotalPayment = new JTextField();
  JTextField jtfMonthlyPayment = new JTextField();

  // Compute Mortgage button
  JButton jbtCompute = new JButton("Compute");

  // Current locale
  Locale locale = Locale.getDefault();

  // Declare locales to store available locales
  Locale locales[] = Calendar.getAvailableLocales();

  /** Initialize the combo box */
  public void initializeComboBox() {
    // Add locale names to the combo box
    for (int i = 0; i < locales.length; i++)
      jcboLocale.addItem(locales[i].getDisplayName());
  }

  /** Initialize the applet */
  public void init() {
    // Panel p1 to hold the combo box for selecting locales
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(jcboLocale);
    initializeComboBox();
    p1.setBorder(new TitledBorder("Choose a Locale"));

    // Panel p2 to hold the input
    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(3, 3));
    p2.add(new JLabel("Interest Rate"));
    p2.add(jtfInterestRate);
    p2.add(jtfFormattedInterestRate);
    p2.add(new JLabel("Number of Years"));
    p2.add(jtfNumOfYears);
    p2.add(jtfFormattedNumOfYears);
    p2.add(new JLabel("Loan Amount"));
    p2.add(jtfLoanAmount);
    p2.add(jtfFormattedLoanAmount);
    p2.setBorder(new TitledBorder("Enter Annual Interest Rate, " +
       "Number of Years, and Loan Amount"));

    // Panel p3 to hold the result
    JPanel p3 = new JPanel();
    p3.setLayout(new GridLayout(2, 2));
    p3.setBorder(new TitledBorder("Payment"));
    p3.add(new JLabel("Monthly Payment"));
    p3.add(jtfMonthlyPayment);
    p3.add(new JLabel("Total Payment"));
    p3.add(jtfTotalPayment);

    // Set text field alignment
    jtfFormattedInterestRate.setHorizontalAlignment(JTextField.RIGHT);
    jtfFormattedNumOfYears.setHorizontalAlignment(JTextField.RIGHT);
    jtfFormattedLoanAmount.setHorizontalAlignment(JTextField.RIGHT);
    jtfTotalPayment.setHorizontalAlignment(JTextField.RIGHT);
    jtfMonthlyPayment.setHorizontalAlignment(JTextField.RIGHT);

    // Set editable false
    jtfFormattedInterestRate.setEditable(false);
    jtfFormattedNumOfYears.setEditable(false);
    jtfFormattedLoanAmount.setEditable(false);
    jtfTotalPayment.setEditable(false);
    jtfMonthlyPayment.setEditable(false);

    // Panel p4 to hold result payments and a button
    JPanel p4 = new JPanel();
    p4.setLayout(new BorderLayout());
    p4.add(p3, BorderLayout.CENTER);
    p4.add(jbtCompute, BorderLayout.SOUTH);

    // Place panels to the applet
    getContentPane().add(p1, BorderLayout.NORTH);
    getContentPane().add(p2, BorderLayout.CENTER);
    getContentPane().add(p4, BorderLayout.SOUTH);

    // Register listeners
    jcboLocale.addItemListener(this);
    jbtCompute.addActionListener(this);
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Number Formatting Demo");

    // Create an instance of the applet
    NumberFormatDemo applet = new NumberFormatDemo();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /** Handle locale selection */
  public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == jcboLocale) {
      locale = locales[jcboLocale.getSelectedIndex()];
      computeMortgage();
    }
  }

  /** Handle button action */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtCompute)
      computeMortgage();
  }

  /** Compute payments and display results locale-sensitive format */
  private void computeMortgage() {
    // Retrieve input from user
    double loan = new Double(jtfLoanAmount.getText()).doubleValue();
    double interestRate =
      new Double(jtfInterestRate.getText()).doubleValue() / 1200;
    int numOfYears = new Integer(jtfNumOfYears.getText()).intValue();

    // Calculate payments
    double monthlyPayment =
    	 loan*interestRate/
     (1 - (Math.pow(1 / (1 + interestRate), numOfYears * 12)));
    double totalPayment = monthlyPayment*numOfYears*12;

    // Get formatters
    NumberFormat percentFormatter = 
      NumberFormat.getPercentInstance(locale);
    NumberFormat currencyForm =
      NumberFormat.getCurrencyInstance(locale);
    NumberFormat numberForm = NumberFormat.getNumberInstance(locale);
    percentFormatter.setMinimumFractionDigits(2);

    // Display formatted input
    jtfFormattedInterestRate.setText(
      percentFormatter.format(interestRate*12));
    jtfFormattedNumOfYears.setText(numberForm.format(numOfYears));
    jtfFormattedLoanAmount.setText(currencyForm.format(loan));

    // Display results in currency format
    jtfMonthlyPayment.setText(currencyForm.format(monthlyPayment));
    jtfTotalPayment.setText(currencyForm.format(totalPayment));
  }
}