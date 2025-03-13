// TestMultipleListener.java: Test multiple listeners
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestMultipleListener extends JFrame
  implements ActionListener {
  // Create two buttons
  private JButton jbtOk = new JButton("OK");
  private JButton jbtCancel = new JButton("Cancel");

  /** Default constructor */
  public TestMultipleListener() {
    // Set the window title
    setTitle("TestMultipleListener");

    // Set FlowLayout manager to arrange the components
    // inside the frame
    getContentPane().setLayout(new FlowLayout());

    // Add buttons to the frame
    getContentPane().add(jbtOk);
    getContentPane().add(jbtCancel);

    // Register the frame as listeners
    jbtOk.addActionListener(this);
    jbtCancel.addActionListener(this);

    // Register a second listener for buttons
    SecondListener secondListener = new SecondListener();
    jbtOk.addActionListener(secondListener);
    jbtCancel.addActionListener(secondListener);
  }

  /** Main method */
  public static void main(String[] args) {
    TestMultipleListener frame = new TestMultipleListener();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 80);
    frame.setVisible(true);
  }

  /** This method will be invoked when a button is clicked */
  public void actionPerformed(ActionEvent e) {
    System.out.print("First listener: ");

    if (e.getSource() == jbtOk) {
      System.out.println("The OK button is clicked");
    }
    else if (e.getSource() == jbtCancel) {
      System.out.println("The Cancel button is clicked");
    }
  }
}

/** The class for the second listener */
class SecondListener implements ActionListener {
  /** Handle ActionEvent */
  public void actionPerformed(ActionEvent e) {
    System.out.print("Second listener: ");

    // A button has an actionCommand property, which is same as the
    // text of the button by default.
    if (e.getActionCommand().equals("OK")) {
      System.out.println("The OK button is clicked");
    }
    else if (e.getActionCommand().equals("Cancel")) {
      System.out.println("The Cancel button is clicked");
    }
  }
}