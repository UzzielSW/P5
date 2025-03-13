// Exercise11_8.java: Create multiple windows
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise11_8 extends JFrame implements ActionListener {
  // Declare and create a frame: an instance of MenuDemo
  MenuDemo calcFrame = new MenuDemo();

  // Declare and create a frame: an instance of RadioButtonDemo
  RadioButtonDemo lightsFrame = new RadioButtonDemo();

  // Declare two buttons for displaying frames
  private JButton jbtCalc;
  private JButton jbtLights;

  public static void main(String[] args) {
    Exercise11_8 frame = new Exercise11_8();
    frame.pack();
    frame.setTitle("Exercise 11.8: Multiple Windows Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public Exercise11_8() {
    // Add buttons to the main frame
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(jbtCalc = new JButton("Simple Calculator"));
    getContentPane().add(jbtLights = new JButton("Traffic Lights"));

    // Register the main frame as listener for the buttons
    jbtCalc.addActionListener(this);
    jbtLights.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String arg = e.getActionCommand();
    if (e.getSource() instanceof JButton)
      if ("Simple Calculator".equals(arg)) {
        //show the MenuDemo frame
        jbtCalc.setText("Hide Simple Calculator");
        calcFrame.pack();
        calcFrame.setVisible(true);
      }
      else if ("Hide Simple Calculator".equals(arg)) {
        calcFrame.setVisible(false);
        jbtCalc.setText("Simple Calculator");
      }
      else if ("Traffic Lights".equals(arg)) {
        //show the CheckboxGroup frame
        lightsFrame.pack();
        jbtLights.setText("Hide Traffic Lights");
        lightsFrame.setVisible(true);
      }
      else if ("Hide Traffic Lights".equals(arg)) {
        lightsFrame.setVisible(false);
      }
  }
}

class MenuDemo extends JFrame implements ActionListener {
  // Text fields for Number 1, Number 2, and Result
  private JTextField jtfNum1, jtfNum2, jtfResult;

  // Buttons "Add", "Subtract", "Multiply" and "Divide"
  private JButton jbtAdd, jbtSub, jbtMul, jbtDiv;

  // Menu items "Add", "Subtract", "Multiply","Divide" and "Close"
  private JMenuItem jmiAdd, jmiSub, jmiMul, jmiDiv, jmiClose;

  // Main Method
  public static void main(String[] args) {
    MenuDemo frame = new MenuDemo();
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  // Default Constructor
  public MenuDemo() {
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
      // Handle menu item events
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
}

class RadioButtonDemo extends JFrame implements ItemListener {
  // Declare radio buttons
  private JRadioButton jrbRed, jrbYellow, jrbGreen;

  // Declare a radio button group
  private ButtonGroup btg = new ButtonGroup();

  // Declare a traffic light display panel
  private Light light;

  // Main method
  public static void main(String[] args) {
    RadioButtonDemo frame = new RadioButtonDemo();
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250, 170);
    frame.setVisible(true);
  }

  // Constructor
  public RadioButtonDemo() {
    setTitle("RadioButton Demo");

    // Add traffic light panel to panel p1
    JPanel p1 = new JPanel();
    p1.setSize(200, 200);
    p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    light = new Light();
    light.setSize(40, 90);
    p1.add(light);

    // Put the radio button in Panel p2
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(jrbRed = new JRadioButton("Red", false));
    p2.add(jrbYellow = new JRadioButton("Yellow", false));
    p2.add(jrbGreen = new JRadioButton("Green", false));

    // Set keyboard mnemonics
    jrbRed.setMnemonic('R');
    jrbYellow.setMnemonic('Y');
    jrbGreen.setMnemonic('G');

    // Group radio buttons
    btg.add(jrbRed);
    btg.add(jrbYellow);
    btg.add(jrbGreen);

    // Place p1 and p2 in the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);

    // Register listeners for check boxes
    jrbRed.addItemListener(this);
    jrbYellow.addItemListener(this);
    jrbGreen.addItemListener(this);
  }

  // Handle checkbox events
  public void itemStateChanged(ItemEvent e) {
    if (jrbRed.isSelected())
      light.red(); // Set red light
    if (jrbYellow.isSelected())
      light.yellow(); // Set yellow light
    if (jrbGreen.isSelected())
      light.green(); // Set green light
  }
}

// Three traffic lights shown in a panel
class Light extends JPanel {
  private boolean red;
  private boolean yellow;
  private boolean green;

  public Light() {
    red = false;
    yellow = false;
    green = false;
  }

  // Set red light on
  public void red() {
    red = true;
    yellow = false;
    green = false;
    repaint();
  }

  // Set yellow light on
  public void yellow() {
    red = false;
    yellow = true;
    green = false;
    repaint();
  }

  // Set green light on
  public void green() {
    red = false;
    yellow = false;
    green = true;
    repaint();
  }

  // Display lights
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (red) {
      g.setColor(Color.red);
      g.fillOval(10, 10, 20, 20);
      g.setColor(Color.black);
      g.drawOval(10, 35, 20, 20);
      g.drawOval(10, 60, 20, 20);
      g.drawRect(5, 5, 30, 80);
    }
    else if (yellow) {
      g.setColor(Color.yellow);
      g.fillOval(10, 35, 20, 20);
      g.setColor(Color.black);
      g.drawRect(5, 5, 30, 80);
      g.drawOval(10, 10, 20, 20);
      g.drawOval(10, 60, 20, 20);
    }
    else if (green) {
      g.setColor(Color.green);
      g.fillOval(10, 60, 20, 20);
      g.setColor(Color.black);
      g.drawRect(5, 5, 30, 80);
      g.drawOval(10, 10, 20, 20);
      g.drawOval(10, 35, 20, 20);
    }
    else {
      g.setColor(Color.black);
      g.drawRect(5, 5, 30, 80);
      g.drawOval(10, 10, 20, 20);
      g.drawOval(10, 35, 20, 20);
      g.drawOval(10, 60, 20, 20);
    }
  }

  // Set preferred size
  public Dimension getPreferredSize() {
    return new Dimension(40, 90);
  }
}