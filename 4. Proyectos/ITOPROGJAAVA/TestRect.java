// TestRect.java: Demonstrate drawing rectangles
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class TestRect extends JFrame {
  /** Default constructor */
  public TestRect() {
    setTitle("Show Rectangles");
    getContentPane().add(new RectPanel());
  }

  /** Main method */
  public static void main(String[] args) {
    TestRect frame = new TestRect();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 250);
    frame.setVisible(true);
  }
}

class RectPanel extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Set new color
    g.setColor(Color.red);

    // Draw a rectangle
    g.drawRect(5, 5, getWidth() / 2 - 10, getHeight() / 2 - 10);

    // Draw a rounded rectangle
    g.drawRoundRect(getWidth() / 2 + 5, 5,
      getWidth() / 2 - 10, getHeight() / 2 - 10, 60, 30);

    // Change the color to cyan
    g.setColor(Color.cyan);

    // Draw a 3D rectangle
    g.fill3DRect(5, getHeight() / 2 + 5, getWidth() / 2 - 10,
      getHeight() / 2 - 10, true);

    // Draw a raised 3D rectangle
    g.fill3DRect(getWidth() / 2 + 5, getHeight() / 2 + 5, 
      getWidth() / 2 - 10, getHeight() / 2 - 10, false);
  }
}