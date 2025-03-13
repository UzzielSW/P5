// Exercise13_2.java: Handle 0 divisor
// MenuDemo.java: Use menus to move message in a panel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise13_2 extends JFrame
  implements ActionListener {
  // Text fields for Number 1, Number 2, and Result
  private JTextField jtfNum1, jtfNum2, jtfResult;

  // Buttons "Add", "Subtract", "Multiply" and "Divide"
  private JButton jbtAdd, jbtSub, jbtMul, jbtDiv;

  // Menu items "Add", "Subtract", "Multiply","Divide" and "Close"
  private JMenuItem jmiAdd, jmiSub, jmiMul, jmiDiv, jmiClose;

  // Main Method
  public static void main(String[] args) {
    Exercise13_2 frame = new Exercise13_2();
    frame.pack();
    frame.setVisible(true);
  }

  // Default Constructor
  public Exercise13_2() {
    setTitle("Menu Demo");

    // Create menu bar
    JMenuBar jmb = new JMenuBar();

    // Set menu bar to the frame
    setJMenuBar(jmb);

    // Add menu "Operation" to menu bar
    JMenu operationMenu = new JMenu("Operation");
    operationMenu.setMnemonic('O');
    jmb.add(operationMenu);

    // Add menu "Exit" in menu bar
    JMenu exitMenu = new JMenu("Exit");
    exitMenu.setMnemonic('E');
    jmb.add(exitMenu);

    // Add menu items with mnemonics to menu "Operation"
    operationMenu.add(jmiAdd= new JMenuItem("Add", 'A'));
    operationMenu.add(jmiSub = new JMenuItem("Subtract", 'S'));
    operationMenu.add(jmiMul = new JMenuItem("Multiply", 'M'));
    operationMenu.add(jmiDiv = new JMenuItem("Divide", 'D'));
    exitMenu.add(jmiClose = new JMenuItem("Close", 'C'));

    // Set keyboard accelerators
    jmiAdd.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    jmiSub.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    jmiMul.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
    jmiDiv.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

    // Panel p1 to hold text fields and labels
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new JLabel("Number 1"));
    p1.add(jtfNum1 = new JTextField(3));
    p1.add(new JLabel("Number 2"));
    p1.add(jtfNum2 = new JTextField(3));
    p1.add(new JLabel("Result"));
    p1.add(jtfResult = new JTextField(4));
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
    jmiAdd.addActionListener(this);
    jmiSub.addActionListener(this);
    jmiMul.addActionListener(this);
    jmiDiv.addActionListener(this);
    jmiClose.addActionListener(this);
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
    else if (e.getSource() instanceof JMenuItem) {
      // Handling menu item events
      if ("Add".equals(actionCommand))
        calculate('+');
      else if ("Subtract".equals(actionCommand))
        calculate('-');
      else if ("Multiply".equals(actionCommand))
        calculate('*');
      else if ("Divide".equals(actionCommand))
        calculate('/');
      else if ("Close".equals(actionCommand))
        System.exit(0);
    }
  }

  // Calculate and show the result in jtfResult
  private void calculate(char operator) {
    try {
    // Obtain Number 1 and Number 2
    int num1 = (Integer.parseInt(jtfNum1.getText().trim()));
    int num2 = (Integer.parseInt(jtfNum2.getText().trim()));
    int result = 0;

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
    catch (ArithmeticException ex) {
      JOptionPane.showMessageDialog(this, "Arithmetic errors",
			  "Warning", JOptionPane.WARNING_MESSAGE);
    }
    catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(this, "Number format errors",
			  "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }
}