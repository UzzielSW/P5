package guiprogramming;
import java.awt.*;
import javax.swing.*;

public class PhotoOpDrawingPanel extends JPanel {
  private Image bimage;
  private double angle = 0.0; // rotate image by this angle
  private float scaleValue = 1.0f; // resize image by this amount
  
  // fields representing horizontal and vertical shear
  private float horizontalShear = 0.0f;
  private float verticalShear = 0.0f;
		
  public PhotoOpDrawingPanel() {
    bimage =  new javax.swing.ImageIcon("image/squirrelMonkey.jpg").getImage();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D 	g2 = (Graphics2D) g;

    // rotate image
    g2.rotate(angle, 250, 250);	

    // scale image
    g2.scale(scaleValue, scaleValue);

    // shear image
    g2.shear(horizontalShear, verticalShear);

    g2.drawImage(bimage, 0, 0, null);
  }

  public void rotateImage(double a) {
    angle += a;
    repaint();
  }

  public void scaleImage(float s) {
    scaleValue *= s;
    repaint();
  }

  // method to shear an image by the given amounts
  public void shearImage(float hshear, float vshear) {
    horizontalShear = hshear;
    verticalShear = vshear;
    repaint(); // calls the paintComponent method of this class
  }	

  public void loadImage(Image i) {
    bimage = i;
    repaint();
  }

}
