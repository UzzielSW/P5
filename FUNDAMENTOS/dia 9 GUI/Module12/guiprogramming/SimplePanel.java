// SimplePanel – version 2
package guiprogramming;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SimplePanel extends JPanel {	
  int shape = 0; // shape = 1 for rectangle, 2 for circle
	
  // draws a rectangle or circle depending on the value of shape
public void paintComponent(Graphics g) {
  super.paintComponent(g);
  Graphics2D myGraphics = (Graphics2D) g;
  Shape obj;
  if (shape == 1) {
    obj = new Rectangle2D.Float(125, 125, 200, 100);
    myGraphics.draw(obj);
  } else if (shape == 2) {
    obj = new Ellipse2D.Float(175, 125, 100, 100);
    myGraphics.draw(obj);
  }	
}	

  // sets shape to the argument, and calls paintComponent	
  public void changeShape(int value) {
    shape = value;
    repaint();
  }
}




