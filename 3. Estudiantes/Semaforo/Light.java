import java.awt.*;
import javax.swing.*;
class Light extends JPanel {
  private boolean red;
  private boolean yellow;
  private boolean green;

  public Light() {
  }

  public void turnOnRed() {
    red = true;
    yellow = false;
    green = false;
    repaint();
  }

  public void turnOnYellow() {
    red = false;
    yellow = true;
    green = false;
    repaint();
  }

  public void turnOnGreen() {
    red = false;
    yellow = false;
    green = true;
    repaint();
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (red) {
      g.setColor(Color.red);
      g.fillOval(10, 10, 20, 20);
      g.setColor(Color.black);
      g.drawOval(10, 35, 20, 20);
      g.drawOval(10, 60, 20, 20);
      g.drawRect(5, 5, 30, 80);
    }
    else if (yellow) {
      g.setColor(Color.yellow);
      g.fillOval(10, 35, 20, 20);
      g.setColor(Color.black);
      g.drawRect(5, 5, 30, 80);
      g.drawOval(10, 10, 20, 20);
      g.drawOval(10, 60, 20, 20);
    }
    else if (green) {
      g.setColor(Color.green);
      g.fillOval(10, 60, 20, 20);
      g.setColor(Color.black);
      g.drawRect(5, 5, 30, 80);
      g.drawOval(10, 10, 20, 20);
      g.drawOval(10, 35, 20, 20);
    }
    else {
      g.setColor(Color.black);
      g.drawRect(5, 5, 30, 80);
      g.drawOval(10, 10, 20, 20);
      g.drawOval(10, 35, 20, 20);
      g.drawOval(10, 60, 20, 20);
    }
  }
  public Dimension getPreferredSize() {
    return new Dimension(40, 90);
  }
}