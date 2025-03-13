// AccountApplet.java: Use custom exception classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AccountApplet extends JApplet 
  implements ActionListener {
  // Declare text fields
  private JTextField jtfID, jtfBalance, jtfDeposit, jtfWithdraw;

  // Declare Deposit and Withdraw buttons
  private JButton jbtDeposit, jbtWithdraw;

  // Create an account with initial balance $1000
  private Account account = new Account(1, 1000);

  // Create a label for showing status
  private JLabel jlblStatus = new JLabel();

  /** Initialize the applet */
  public void init() {
    // Panel p1 to group ID and Balance labels and text fields
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(2, 2));
    p1.add(new JLabel("Account ID"));
    p1.add(jtfID = new JTextField(4));
    p1.add(new JLabel("Account Balance"));
    p1.add(jtfBalance = new JTextField(4));
    jtfID.setEditable(false);
    jtfBalance.setEditable(false);
    p1.setBorder(new TitledBorder("Display Account Information"));

    // Panel p2 to group deposit amount and Deposit button and
    // withdraw amount and Withdraw button
    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(2, 3));
    p2.add(new JLabel("Deposit"));
    p2.add(jtfDeposit = new JTextField(4));
    p2.add(jbtDeposit = new JButton("Deposit"));
    p2.add(new JLabel("Withdraw"));
    p2.add(jtfWithdraw = new JTextField(4));
    p2.add(jbtWithdraw = new JButton("Withdraw"));
    p2.setBorder(new TitledBorder("Deposit or withdraw funds"));

    // Place panels p1, p2, and label in the applet
    this.getContentPane().add(p1, BorderLayout.WEST);
    this.getContentPane().add(p2, BorderLayout.CENTER);
    this.getContentPane().add(jlblStatus, BorderLayout.SOUTH);

    // Refresh ID and Balance fields
    refreshFields();

    // Register listener
    jbtDeposit.addActionListener(this);
    jbtWithdraw.addActionListener(this);
  }

  /** Handle ActionEvent */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtDeposit) {
      try {
        double depositValue = (Double.valueOf(
          jtfDeposit.getText().trim())).doubleValue();
        account.deposit(depositValue);
        refreshFields();
        jlblStatus.setText("Transaction Processed");
      }
      catch (NegativeAmountException ex) {
        jlblStatus.setText("Negative Amount");
      }
    }
    else if (e.getSource() == jbtWithdraw) {
      try {
        double withdrawValue = (Double.valueOf(
          jtfWithdraw.getText().trim())).doubleValue();
        account.withdraw(withdrawValue);
        refreshFields();
        jlblStatus.setText("Transaction Processed");
      }
      catch (NegativeAmountException ex) {
        jlblStatus.setText("Negative Amount");
      }
      catch (InsufficientFundException ex) {
        jlblStatus.setText("Insufficient Funds");
      }
    }
  }

  /** Update the display for account balance */
  public void refreshFields() {
    jtfID.setText(String.valueOf(account.getId()));
    jtfBalance.setText(String.valueOf(account.getBalance()));
  }
}