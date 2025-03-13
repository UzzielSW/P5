// Exercise12_14.java: Use a standard adpater for Example 10.7
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise12_14 extends JFrame
  implements ActionListener {
  // Create two buttons
  private JButton jbtOk = new JButton("OK");
  private JButton jbtCancel = new JButton("Cancel");

  /**Default constructor*/
  public Exercise12_14() {
    // Set the window title
    setTitle("Exercise12.14");

    // Set FlowLayout manager to arrange the components
    // inside the frame
    getContentPane().setLayout(new FlowLayout());

    // Add buttons to the frame
    getContentPane().add(jbtOk);
    getContentPane().add(jbtCancel);

    // Register listeners
    jbtOk.addActionListener(new ActionListenerAdapter(this));
    jbtCancel.addActionListener(new ActionListenerAdapter(this));
  }

  /**Main method*/
  public static void main(String[] args) {
    Exercise12_14 frame = new Exercise12_14();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 80);
    frame.setVisible(true);
  }

  /**This method will be invoked when a button is clicked*/
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtOk) {
      System.out.println("The OK button is clicked");
    }
    else if (e.getSource() == jbtCancel) {
      System.out.println("The Cancel button is clicked");
    }
  }
}

/**Standard adapter for action performed*/
class ActionListenerAdapter implements ActionListener {
  Exercise12_14 adaptee;

  ActionListenerAdapter(Exercise12_14 adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.actionPerformed(e);
  }
}