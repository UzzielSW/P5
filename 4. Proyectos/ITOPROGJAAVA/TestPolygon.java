// TestPolygon.java: Demonstrate drawing polygons
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Polygon;

public class TestPolygon extends JFrame {
  /** Default constructor */
  public TestPolygon() {
    setTitle("Show Polygon");
    getContentPane().add(new PolygonsPanel());
  }

  /** Main method */
  public static void main(String[] args) {
    TestPolygon frame = new TestPolygon();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 250);
    frame.setVisible(true);
  }
}

// Draw a polygon in the panel
class PolygonsPanel extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    int radius =
      (int)(Math.min(getWidth(), getHeight()) * 0.4);

    // Create a Polygon object
    Polygon polygon = new Polygon();

    // Add points to the polygon
    polygon.addPoint(xCenter + radius, yCenter);
    polygon.addPoint((int)(xCenter + radius * 
      Math.cos(2 * Math.PI / 6)), (int)(yCenter - radius * 
      Math.sin(2 * Math.PI / 6)));
    polygon.addPoint((int)(xCenter + radius *
      Math.cos(2 * 2 * Math.PI / 6)), (int)(yCenter - radius *
      Math.sin(2 * 2 * Math.PI / 6)));
    polygon.addPoint((int)(xCenter + radius *
      Math.cos(3 * 2 * Math.PI / 6)), (int)(yCenter - radius *
      Math.sin(3 * 2 * Math.PI / 6)));
    polygon.addPoint((int)(xCenter + radius *
      Math.cos(4 * 2 * Math.PI / 6)), (int)(yCenter - radius *
      Math.sin(4 * 2 * Math.PI / 6)));
    polygon.addPoint((int)(xCenter + radius * 
      Math.cos(5 * 2 * Math.PI / 6)), (int)(yCenter - radius *
      Math.sin(5 * 2 * Math.PI / 6)));

    // Draw the polygon
    g.drawPolygon(polygon);
  }
}