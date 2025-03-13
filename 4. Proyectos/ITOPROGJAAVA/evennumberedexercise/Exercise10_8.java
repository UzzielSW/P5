// Exercise10_8.java: Draw a diagram for function f(x) = x*x
import java.awt.*;
import javax.swing.*;

public class Exercise10_8 extends JFrame {
  public Exercise10_8() {
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(new DrawXSquare(), BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    Exercise10_8 frame = new Exercise10_8();
    frame.setSize(400, 400);
    frame.setTitle("Exercise 10.8");
    frame.setVisible(true);
  }

  // Inner class
  class DrawXSquare extends JPanel {
    double f(double x) {
      return x*x;
    }

    // Draw the function
    public void drawFunction() {
      repaint();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.drawLine(10, 200, 390, 200);
      g.drawLine(200, 30, 200, 390);

      // Draw arrows
      g.drawLine(390, 200, 370, 190);
      g.drawLine(390, 200, 370, 210);
      g.drawLine(200, 30, 190, 50);
      g.drawLine(200, 30, 210, 50);

      // Draw x, y axises
      g.drawString("X", 390, 170);
      g.drawString("Y", 220, 40);

      // Draw function
      Polygon p = new Polygon();

      double scaleFactor = 0.01;

      for (int x=-100; x <= 100; x++) {
        p.addPoint(x+200, 200-(int)(scaleFactor*f(x)));
      }

      g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
  }
}