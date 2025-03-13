// ButtonDemo.java: Use buttons to move message in a panel
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ButtonDemo extends JFrame implements ActionListener {
  // Declare a panel for displaying message
  private MessagePanel messagePanel;

  // Declare two buttons to move the message left and right
  private JButton jbtLeft, jbtRight;

  /** Main method */
  public static void main(String[] args) {
    ButtonDemo frame = new ButtonDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }

  /** Default constructor */
  public ButtonDemo() {
    setTitle("Button Demo");

    // Create a MessagePanel instance and set colors
    messagePanel = new MessagePanel("Welcome to Java");
    messagePanel.setBackground(Color.yellow);

    // Create Panel jpButtons to hold two Buttons "<=" and "right =>"
    JPanel jpButtons = new JPanel();
    jpButtons.setLayout(new FlowLayout());
    jpButtons.add(jbtLeft = new JButton());
    jpButtons.add(jbtRight = new JButton());

    // Set button text
    jbtLeft.setText("<=");
    jbtRight.setText("=>");

    // Set keyboard mnemonics
    jbtLeft.setMnemonic('L');
    jbtRight.setMnemonic('R');

    // Set icons
    //jbtLeft.setIcon(new ImageIcon("image/left.gif"));
    //jbtRight.setIcon(new ImageIcon("image/right.gif"));

    // Set toolTipText on the "<=" and "=>" buttons
    jbtLeft.setToolTipText("Move message to left");
    jbtRight.setToolTipText("Move message to right");

    // Place panels in the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(messagePanel, BorderLayout.CENTER);
    getContentPane().add(jpButtons, BorderLayout.SOUTH);

    // Register listeners with the buttons
    jbtLeft.addActionListener(this);
    jbtRight.addActionListener(this);
  }

  /** Handle button events */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtLeft) {
      left();
    }
    else if (e.getSource() == jbtRight) {
      right();
    }
  }

  /** Move the message in the panel left */
  private void left() {
    int x = messagePanel.getXCoordinate();
    if (x > 10) {
      // Shift the message to the left
      messagePanel.setXCoordinate(x - 10);
      messagePanel.repaint();
    }
  }

  /** Move the message in the panel right */
  private void right() {
    int x = messagePanel.getXCoordinate();
    if (x < getSize().width - 20) {
      // Shift the message to the right
      messagePanel.setXCoordinate(x + 10);
      messagePanel.repaint();
    }
  }
}