// Exercise10_10.java: Draw generic functions
import java.awt.*;
import javax.swing.*;

public class Exercise10_10 extends JFrame {
  public Exercise10_10() {
    getContentPane().setLayout(new GridLayout(1, 2, 5, 5));
    getContentPane().add(new DrawSine());
    getContentPane().add(new DrawCosine());
  }
  
  public static void main(String[] args) {
    Exercise10_10 frame = new Exercise10_10();
    frame.setSize(400, 400);
    frame.setTitle("Exercise 10.10");
    frame.setVisible(true);
  }
}

class DrawXSquare extends AbstractDrawFunction {
  /**Implement the fuction*/
  public double f(double x) {
    // scaleFactor for adjusting y coordinates
    double scaleFactor = 0.01;
    
    return scaleFactor*x*x;
  }
}

class DrawSine extends AbstractDrawFunction {
  public double f(double x) {
    return 50*Math.sin((x/100.0)*2*Math.PI);
  }
}

class DrawCosine extends AbstractDrawFunction {
  public double f(double x) {
    return 50*Math.cos((x/100.0)*2*Math.PI);
  }
}

abstract class AbstractDrawFunction extends JPanel {
  /**Polygon to hold the points*/
  private Polygon p = new Polygon();
  
  /**Default constructor*/
  protected AbstractDrawFunction() {
    drawFunction();
    setBackground(Color.white);
  }
  
  /**Draw the function*/
  public abstract double f(double x);
  
  /**Obtain points for x coordinates 100, 101, ..., 300*/
  public void drawFunction() {
    for (int x = -100; x <= 100; x++) {
      p.addPoint(x+200, 200-(int)f(x));
    }
  }
  
  /**Paint the function diagram*/
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    // Draw x axis
    g.drawLine(10, 200, 390, 200);
    
    // Draw y axis
    g.drawLine(200,30, 200, 390);
    
    // Draw arrows on x axis
    g.drawLine(390, 200, 370, 190);
    g.drawLine(390, 200, 370, 210);
    
    // Draw arrows on y axis
    g.drawLine(200, 30, 190, 50);
    g.drawLine(200, 30, 210, 50);
    
    // Draw x, y
    g.drawString("X", 370, 170);
    g.drawString("Y", 220, 40);
    
    // Draw a polygon line by connecting the points in the polygon
    g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
  }
}