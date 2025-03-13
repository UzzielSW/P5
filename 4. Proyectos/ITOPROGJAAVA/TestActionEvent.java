// TestActionEvent.java: Test ActionEvent
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestActionEvent extends JFrame {
  // Create two buttons
  private JButton jbtOk = new JButton("OK");
  private JButton jbtCancel = new JButton("Cancel");

  /** Default constructor */
  public TestActionEvent() {
    // Set the window title
    setTitle("TestActionEvent");

    // Set FlowLayout manager to arrange the components
    // inside the frame
    getContentPane().setLayout(new FlowLayout());

    // Add buttons to the frame
    getContentPane().add(jbtOk);
    getContentPane().add(jbtCancel);

    // Create a listener object
    ButtonListener btListener = new ButtonListener();
    
    // Register listeners
    jbtOk.addActionListener(btListener);
    jbtCancel.addActionListener(btListener);
  }

  /** Main method */
  public static void main(String[] args) {
    TestActionEvent frame = new TestActionEvent();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 80);
    frame.setVisible(true);
  }
}

class ButtonListener implements ActionListener {
  /** This method will be invoked when a button is clicked */
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("OK")) {
      System.out.println("The OK button is clicked");
    }
    else if (e.getActionCommand().equals("Cancel")) {
      System.out.println("The Cancel button is clicked");
    }
  }
}