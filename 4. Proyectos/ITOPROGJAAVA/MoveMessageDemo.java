// MoveMessageDemo.java: Move a message in a panel
// by dragging the mouse
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveMessageDemo extends JApplet {
  /** Initialize the applet */
  public void init() {
    // Create a MoveMessagePanel instance for drawing a message
    MoveMessagePanel p = new MoveMessagePanel("Welcome to Java");

    // Place the message panel in the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p);
  }

  /** This main method enables the applet to run as an application */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Move Message Using Mouse");

    // Create an instance of the applet
    MoveMessageDemo applet = new MoveMessageDemo();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

// MoveMessagePanel draws a message
class MoveMessagePanel extends MessagePanel
  implements MouseMotionListener {
  /** Construct a panel to draw string s */
  public MoveMessagePanel(String s) {
    super(s);
    this.addMouseMotionListener(this);
  }

  /** Tell the panel how to draw things */
  public void paintComponent(Graphics g) {
    // Invoke the paintComponent method in the MessagePanel class
    super.paintComponent(g);
  }

  /** Handle mouse moved event */
  public void mouseMoved(MouseEvent e) {
  }

  /** Handle mouse dragged event */
  public void mouseDragged(MouseEvent e) {
    // Get the new location and repaint the screen
    setXCoordinate(e.getX());
    setYCoordinate(e.getY());
    repaint();
  }
}