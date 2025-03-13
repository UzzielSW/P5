// Exercise12_8: Calculator
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise12_8 extends JApplet implements ActionListener {
  private JTextField jtf = new JTextField(10);
  private boolean newNumber = true;
  private int result = 0;
  private String op = "=";

  public void init() {
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());

    JPanel westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(5, 0));
    westPanel.add(new JButton("   "));
    westPanel.add(new JButton("MC"));
    westPanel.add(new JButton("MR"));
    westPanel.add(new JButton("MS"));
    westPanel.add(new JButton("M+"));

    Panel centerPanel = new Panel();
    centerPanel.setLayout(new BorderLayout());
    Panel p1 = new Panel();
    Panel p2 = new Panel();

    p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
    p1.add(new JButton("Back"));
    p1.add(new JButton("CE"));
    p1.add(new JButton("C"));

    p2.setLayout(new GridLayout(4, 5));
    JButton bt;
    p2.add(bt = new JButton("7"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("8"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("9"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("/"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("sqrt"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("4"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("5"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("6"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("*"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("%"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("1"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("2"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("3"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("-"));
    bt.addActionListener(this);
    p2.add(new JButton("1/x"));
    p2.add(new JButton("0"));
    p2.add(new JButton("+/-"));
    p2.add(new JButton("."));
    p2.add(bt = new JButton("+"));
    bt.addActionListener(this);
    p2.add(bt = new JButton("="));
    bt.addActionListener(this);

    centerPanel.add(p2, BorderLayout.CENTER);
    centerPanel.add(p1, BorderLayout.NORTH);
    p.add(centerPanel, BorderLayout.CENTER);
    p.add(westPanel, BorderLayout.WEST);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(jtf, BorderLayout.NORTH);
  }

  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    if ('0' <= actionCommand.charAt(0) &&
      actionCommand.charAt(0) <= '9') {
      if (newNumber) {
        jtf.setText(actionCommand);
        newNumber = false;
      }
      else {
        jtf.setText(jtf.getText() + actionCommand);
      }
    }
    else
      if (newNumber) {
        if (actionCommand.equals("-")) {
          jtf.setText("-");
          newNumber = false;
        }
        else
          op = actionCommand;
      }
      else {
        execute();
        op = actionCommand;
      }
    }

  void execute() {
    int number = new Integer(jtf.getText()).intValue();
    System.out.println("number "+op);
    switch (op.charAt(0)) {
      case '+': result += number; break;
      case '-': result -= number; break;
      case '*': result *= number; break;
      case '/': result /= number; break;
      case '%': result %= number; break;
      case '=': result = number;
    }
    System.out.println("result "+result);
    jtf.setText(new Integer(result).toString());
    newNumber = true;
  }
}