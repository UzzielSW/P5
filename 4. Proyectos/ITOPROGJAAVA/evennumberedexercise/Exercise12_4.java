// Exercise12_4.java: The Maze problem
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise12_4 extends JApplet {
  public void init() {
    getContentPane().add(new DisplayCoordinatePanel());
  }

  /**Main method*/
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise 12.4");

    // Create an instance of MortgageApplet
    Exercise12_4 applet = new Exercise12_4();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}

class DisplayCoordinatePanel extends JPanel implements MouseListener {
  // Point is a Java object for representing points in a plane.
  // p.x and p.y are the x and y coordinates.
  private Point p = new Point(0, 0);

  public DisplayCoordinatePanel() {
    addMouseListener(this);
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  // When mouse is clicked, the mouse pointer location is
  // captured in the point p.
  public void mouseClicked(MouseEvent e) {
    p.x = e.getX();
    p.y = e.getY();
    repaint();
  }

  // Draw a small solid square around the point
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawString("("+p.x+", "+p.y+")", p.x, p.y);
  }
}