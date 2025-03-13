// DrawClock.java: Display a clock in JPanel
import java.awt.*;
import javax.swing.*;

public class DrawClock extends JPanel {
  private int hour;
  private int minute;
  private int second;
  protected int xCenter, yCenter;
  protected int clockRadius;

  /** Construct a clock panel */
  public DrawClock(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  /** Draw the clock */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Initialize clock parameters
    clockRadius =
      (int)(Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
    xCenter = (getWidth()) / 2;
    yCenter = (getHeight()) / 2;

    // Draw circle
    g.setColor(Color.black);
    g.drawOval(xCenter - clockRadius,yCenter - clockRadius,
      2 * clockRadius, 2 * clockRadius);
    g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
    g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
    g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
    g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

    // Draw second hand
    int sLength = (int)(clockRadius * 0.8);
    int xSecond = (int)(xCenter + sLength *
      Math.sin(second * (2 * Math.PI / 60)));
    int ySecond = (int)(yCenter - sLength * 
      Math.cos(second * (2 * Math.PI / 60)));
    g.setColor(Color.red);
    g.drawLine(xCenter, yCenter, xSecond, ySecond);

    // Draw minute hand
    int mLength = (int)(clockRadius * 0.65);
    int xMinute = (int)(xCenter + mLength *  
      Math.sin(minute * (2 * Math.PI / 60)));
    int yMinute = (int)(yCenter - mLength * 
      Math.cos(minute * (2 * Math.PI / 60)));
    g.setColor(Color.blue);
    g.drawLine(xCenter, yCenter, xMinute, yMinute);

    // Draw hour hand
    int hLength = (int)(clockRadius * 0.5);
    int xHour = (int)(xCenter + hLength * 
      Math.sin((hour + minute / 60.0) * (2 * Math.PI / 12)));
    int yHour = (int)(yCenter - hLength * 
      Math.cos((hour + minute / 60.0) * (2 * Math.PI / 12)));
    g.setColor(Color.green);
    g.drawLine(xCenter, yCenter, xHour, yHour);

    // Display current time in string
    g.setColor(Color.red);
    String time = "Hour: " + hour + " Minute: " + minute +
      " Second: " + second;
    FontMetrics fm = g.getFontMetrics();
    g.drawString(time, (getWidth() -
      fm.stringWidth(time)) / 2, yCenter+clockRadius + 30);
  }
}