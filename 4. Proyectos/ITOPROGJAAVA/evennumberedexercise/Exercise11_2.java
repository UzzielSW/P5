// Exercise11_2.java: Perform add, subtract, multiply, and divide on
// double values
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise11_2 extends JFrame
  implements ActionListener {
  // Text fields for Number 1, Number 2, and Result
  private JTextField jtfNum1, jtfNum2, jtfResult;

  // Buttons "Add", "Subtract", "Multiply" and "Divide"
  private JButton jbtAdd, jbtSub, jbtMul, jbtDiv;

  // Main Method
  public static void main(String[] args) {
    Exercise11_2 frame = new Exercise11_2();
    frame.pack();
    frame.setTitle("Exercise 11.2");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  // Default Constructor
  public Exercise11_2() {
    // Panel p1 to hold text fields and labels
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new JLabel("Number 1"));
    p1.add(jtfNum1 = new JTextField(3));
    p1.add(new JLabel("Number 2"));
    p1.add(jtfNum2 = new JTextField(3));
    p1.add(new JLabel("Result"));
    p1.add(jtfResult = new JTextField(14));
    jtfResult.setEditable(false);

    // Panel p2 to hold buttons
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(jbtAdd = new JButton("Add"));
    p2.add(jbtSub = new JButton("Subtract"));
    p2.add(jbtMul = new JButton("Multiply"));
    p2.add(jbtDiv = new JButton("Divide"));

    // Add panels to the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);

    // Register listeners
    jbtAdd.addActionListener(this);
    jbtSub.addActionListener(this);
    jbtMul.addActionListener(this);
    jbtDiv.addActionListener(this);
  }

  // Handle ActionEvent from buttons and menu items
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();

    // Handle button events
    if (e.getSource() instanceof JButton) {
      if ("Add".equals(actionCommand))
        calculate('+');
      else if ("Subtract".equals(actionCommand))
        calculate('-');
      else if ("Multiply".equals(actionCommand))
        calculate('*');
      else if ("Divide".equals(actionCommand))
        calculate('/');
    }
  }

  // Calculate and show the result in jtfResult
  private void calculate(char operator) {
    // Obtain Number 1 and Number 2
    double num1 = new Double(jtfNum1.getText().trim()).doubleValue();
    double num2 = new Double(jtfNum2.getText().trim()).doubleValue();
    double result = 0;

    // Perform selected operation
    switch (operator) {
      case '+': result = num1 + num2;
                break;
      case '-': result = num1 - num2;
                break;
      case '*': result = num1 * num2;
                break;
      case '/': result = num1 / num2;
    }

    // Set result in jtfResult
    jtfResult.setText(String.valueOf(result));
  }
}