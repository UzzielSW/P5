// TextFieldDemo.java: Convert Celsius to Fahrenheit and vice versa
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldDemo extends JFrame
  implements ActionListener {
  private JTextField jtfCelsius = new JTextField(10);
  private JTextField jtfFahrenheit = new JTextField(10);

  /** Main method */
  public static void main(String[] args) {
    TextFieldDemo frame = new TextFieldDemo();
    frame.pack();
    frame.setTitle("TextFieldDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public TextFieldDemo() {
    // Panel p1 to hold labels 
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(2, 1));
    p1.add(new JLabel("Celsius"));
    p1.add(new JLabel("Fahrenheit"));
    
    // Panel p2 to hold text fields
    JPanel p2 = new JPanel();
    p2.setLayout(new GridLayout(2, 1));
    p2.add(jtfCelsius);
    p2.add(jtfFahrenheit);

    // Add p1 and p3 to the frame
    getContentPane().add(p1, BorderLayout.WEST);
    getContentPane().add(p2, BorderLayout.CENTER);
    
    // Set horizontal alignment to RIGHT for text fields
    jtfCelsius.setHorizontalAlignment(JTextField.RIGHT);
    jtfFahrenheit.setHorizontalAlignment(JTextField.RIGHT);
    
    // Register listener
    jtfCelsius.addActionListener(this);
    jtfFahrenheit.addActionListener(this);
  }

  /** Handle ActionEvent */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jtfCelsius) {
      double celsius = 
        Double.parseDouble(jtfCelsius.getText().trim());
      double fahrenheit = (9.0 / 5.0) * celsius + 32;
      jtfFahrenheit.setText(new Double(fahrenheit).toString());
    }
    else {
      double fahrenheit = 
        Double.parseDouble(jtfFahrenheit.getText().trim());
      double celsius = (5.0 / 9.0) * (fahrenheit - 32);
      jtfCelsius.setText(new Double(celsius).toString());
    }
  }
}