// Exercise11_10.java: Compute sales commissions
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise11_10 extends JFrame implements ActionListener {
  private JTextField jtfSalesAmount = new JTextField(15);
  private JTextField jtfCommissions = new JTextField(15);

  // Main method
  public static void main(String[] args) {
    Exercise11_10 frame = new Exercise11_10();
    frame.setSize(300, 200);
    frame.setTitle("Exercise 11.10: Compute Sales Commissions");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public Exercise11_10() {
    // Panel p1 to hold text fields
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(2, 2));
    p1.add(new JLabel("Sales Amount"));
    p1.add(jtfSalesAmount);
    p1.add(new JLabel("Commissions"));
    p1.add(jtfCommissions);

    // Set border title
    p1.setBorder(new TitledBorder("Sales Amount and Commissions"));

    // Panel p2 to hold commission rates
    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(4, 2));
    p2.add(new JLabel("Sales Amount"));
    p2.add(new JLabel("Commission Rate"));
    p2.add(new JLabel("$1 to $5,000"));
    p2.add(new JLabel("8 Percent"));
    p2.add(new JLabel("$5,001 to $10,000"));
    p2.add(new JLabel("10 Percent"));
    p2.add(new JLabel("Above $10,000"));
    p2.add(new JLabel("12 Percent"));

    // Set border title
    p2.setBorder(new TitledBorder("Commission Rates"));

    getContentPane().add(p1, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);

    // Register listener for the scroll bars
    jtfSalesAmount.addActionListener(this);
    jtfCommissions.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jtfSalesAmount) {
      double salesAmount =
        new Double(jtfSalesAmount.getText().trim()).doubleValue();

      double commission = 0;
      if (salesAmount <= 5000)
        commission = salesAmount*0.08;
      else if (salesAmount <= 10000)
        commission = (salesAmount-5000)*0.1 + 5000*0.08;
      else
        commission = (salesAmount-10000)*0.12 +
          5000*0.1 +5000*0.08;

      // Display commission on the text field
      jtfCommissions.setText(new Double(commission).toString());
    }
    else if (e.getSource() == jtfCommissions) {
      double COMMISSIONSOUGHT =
        new Double(jtfCommissions.getText().trim()).doubleValue();

      double commission = 0;
      double salesAmount = 1;
      while (commission < COMMISSIONSOUGHT) {
        // Compute commission
        if (salesAmount >= 10001)
          commission = 5000*0.08 + 5000*0.1 + (salesAmount-10000)*0.12;
        else if (salesAmount >= 5001)
          commission = 5000*0.08 + (salesAmount-5000)*0.10;
        else
          commission = salesAmount*0.08;

        salesAmount++;
      }

      // Display sales amount on the text field
      jtfSalesAmount.setText(new Double(salesAmount).toString());
    }
  }
}