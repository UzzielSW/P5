// Exercise11_4.java: Convert Celsius to Fahrenheit and vice versa
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise11_4 extends JFrame
  implements ActionListener {
  private JTextField jtfCelsius = new JTextField(10);
  private JTextField jtfFahrenheit = new JTextField(10);

  // Main method
  public static void main(String[] args) {
    Exercise11_4 frame = new Exercise11_4();
    frame.pack();
    frame.setTitle("Exercise 11.4");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public Exercise11_4() {
    // Panel p1 to hold labels and text fields
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(2, 2));
    p.add(new JLabel("Celsius"));
    p.add(jtfCelsius);
    p.add(new JLabel("Fahrenheit"));
    p.add(jtfFahrenheit);

    // Add p to the frame
    getContentPane().add(p);

    // Register listener
    jtfCelsius.addActionListener(this);
    jtfFahrenheit.addActionListener(this);
  }

  // Handle ActionEvent
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jtfCelsius) {
      double celsius = new Double(jtfCelsius.getText().trim()).doubleValue();
      double fahrenheit = (9.0/5.0)*celsius + 32;
      jtfFahrenheit.setText(new Double(fahrenheit).toString());
    }
    else {
      double fahrenheit = new Double(jtfFahrenheit.getText().trim()).doubleValue();
      double celsius = (5.0/9.0)*(fahrenheit - 32);
      jtfCelsius.setText(new Double(celsius).toString());
    }
  }
}