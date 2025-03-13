// Exercise15_8.java: Display three running fans in a group
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise15_8 extends JApplet
  implements ActionListener {
  private FanControlPanel fanControlPanel1 = new FanControlPanel();
  private FanControlPanel fanControlPanel2 = new FanControlPanel();
  private FanControlPanel fanControlPanel3 = new FanControlPanel();
  private JButton jbtStartAll = new JButton("Start All");
  private JButton jbtStopAll = new JButton("Stop All");

  public void init() {
    // Create a panel to group three fan control panels
    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(1, 3));
    panel1.add(fanControlPanel1);
    panel1.add(fanControlPanel2);
    panel1.add(fanControlPanel3);

    // Create a panel to group two buttons
    JPanel panel2 = new JPanel();
    panel2.setLayout(new FlowLayout());
    panel2.add(jbtStartAll);
    panel2.add(jbtStopAll);

    // Add the panels into the applet
    getContentPane().add(panel1, BorderLayout.CENTER);
    getContentPane().add(panel2, BorderLayout.SOUTH);

    // Register listeners
    jbtStartAll.addActionListener(this);
    jbtStopAll.addActionListener(this);

    // Set line border for the fan control panels
    Border border = BorderFactory.createLineBorder(Color.black);
    fanControlPanel1.setBorder(border);
    fanControlPanel2.setBorder(border);
    fanControlPanel3.setBorder(border);
  }

  // Handle the action event
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtStartAll) {
      fanControlPanel1.start();
      fanControlPanel2.start();
      fanControlPanel3.start();
    }
    else if (e.getSource() == jbtStopAll) {
      fanControlPanel1.stop();
      fanControlPanel2.stop();
      fanControlPanel3.stop();
    }
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
      "Exercise 15.8: Controlling a Group of Fans");

    // Create an instance of the applet
    Exercise15_8 applet = new Exercise15_8();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.pack();
    frame.setVisible(true);
  }
}
