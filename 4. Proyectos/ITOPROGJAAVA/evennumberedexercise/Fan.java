import javax.swing.*;
import java.awt.*;

public class Fan extends JPanel implements Runnable {
  private Thread control = null;
  private int xCenter, yCenter;
  private int fanRadius, bladeLength;
  private int angle = 100;
  private int direction = 1;
  private int speed = 10;

  private boolean suspended = false;

  public Fan() {
    control = new Thread(this);
    control.start();
  }

  public synchronized void resume() {
    if (suspended) {
      suspended = false;
      notify();
    }
  }

  public synchronized void suspend() {
    suspended = true;
  }

  public void reverse() {
    direction = -direction;
  }

  public void setSpeed(int ms) {
    speed = ms;
  }

  public void run() {
    while (true) {
      repaint();
      try {
        Thread.sleep(speed);
        waitForNotificationToResume();
      }
      catch (InterruptedException ex) {
      }
    }
  }

  // Wait for notification to resume
  private synchronized void waitForNotificationToResume()
    throws InterruptedException {
    while (suspended)
      wait();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Set clock radius, and center
    fanRadius = (int)(Math.min(getSize().width, getSize().height)*0.9*0.5);
    xCenter = (getSize().width)/2;
    yCenter = (getSize().height)/2;
    bladeLength = (int)(fanRadius*0.9);
    angle = (angle+direction)%360;

    //draw circle
    g.setColor(Color.black);
    g.drawOval(xCenter - fanRadius,yCenter - fanRadius,
      2*fanRadius, 2*fanRadius);

    //draw four blades
    drawBlade(g, angle);
    drawBlade(g, angle+90);
    drawBlade(g, angle+180);
    drawBlade(g, angle+270);
  }

  private void drawBlade(Graphics g, int angle) {
    g.setColor(Color.red);
    g.fillArc(xCenter-bladeLength, yCenter-bladeLength,
      2*bladeLength, 2*bladeLength, angle, 30);
  }
}