// Exercise10_12.java: Display a clock in a panel
import java.awt.*;
import javax.swing.*;

public class Exercise10_12 extends JFrame {
  // Main method with three auguments:
  // args[0]: hour
  // args[1]: minute
  // args[2]: second
  public static void main(String[] args) {
    // Declare hour, minute, and second values
    int hour = 0;
    int minute = 0;
    int second = 0;

    // Check usage and get hour, minute, second
    if (args.length > 3) {
      System.out.println(
        "Usage: java DisplayClock hour minute second");
      System.exit(0);
    }
    else if (args.length == 3) {
      hour = new Integer(args[0]).intValue();
      minute = new Integer(args[1]).intValue();
      second = new Integer(args[2]).intValue();
    }
    else if (args.length == 2) {
      hour = new Integer(args[0]).intValue();
      minute = new Integer(args[1]).intValue();
    }
    else if (args.length == 1) {
      hour = new Integer(args[0]).intValue();
    }

    // Create a frame to hold the clock
    Exercise10_12 frame = new Exercise10_12();
    frame.setTitle("Exercise 10.12: Display Clock");
    frame.getContentPane().add(new DrawClock(hour, minute, second));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 350);
    frame.setVisible(true);
  }
}

class DrawClock extends JPanel {
  private int hour;
  private int minute;
  private int second;
  protected int xCenter, yCenter;
  protected int clockRadius;

  // Construct a clock panel
  public DrawClock(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  // Draw the clock
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Initialize clock parameters
    clockRadius =
      (int)(Math.min(getSize().width, getSize().height)*0.8*0.5);
    xCenter = (getSize().width)/2;
    yCenter = (getSize().height)/2;

    // Draw circle
    g.setColor(Color.black);
    g.drawOval(xCenter - clockRadius,yCenter - clockRadius,
      2*clockRadius, 2*clockRadius);

    // Draw second hand
    int sLength = (int)(clockRadius*0.75);
    int xSecond =
      (int)(xCenter + sLength*Math.sin(second*(2*Math.PI/60)));
    int ySecond =
      (int)(yCenter - sLength*Math.cos(second*(2*Math.PI/60)));
    g.setColor(Color.red);
    g.drawLine(xCenter, yCenter, xSecond, ySecond);

    // Draw minute hand
    int mLength = (int)(clockRadius*0.65);
    int xMinute =
      (int)(xCenter + mLength*Math.sin(minute*(2*Math.PI/60)));
    int yMinute =
      (int)(yCenter - mLength*Math.cos(minute*(2*Math.PI/60)));
    g.setColor(Color.blue);
    g.drawLine(xCenter, yCenter, xMinute, yMinute);

    // Draw hour hand
    int hLength = (int)(clockRadius*0.5);
    int xHour = (int)(xCenter +
      hLength*Math.sin((hour+minute/60.0)*(2*Math.PI/12)));
    int yHour = (int)(yCenter -
      hLength*Math.cos((hour+minute/60.0)*(2*Math.PI/12)));
    g.setColor(Color.black);
    g.drawLine(xCenter, yCenter, xHour, yHour);

    // Display current time in string
    g.setColor(Color.red);
    String time = "Hour: " + hour + " Minute: " + minute +
      " Second: " + second;
    FontMetrics fm = g.getFontMetrics();
    g.drawString(time, (getSize().width -
      fm.stringWidth(time))/2, yCenter+clockRadius+30);

    // Display more details on the clock
    for (int i=0; i<60; i++) {
      double percent;

      if (i%5 == 0) {
        percent = 0.9;
      }
      else {
        percent = 0.95;
      }

      int xOuter = (int)(xCenter +
        clockRadius*Math.sin(i*(2*Math.PI/60)));
      int yOuter = (int)(yCenter -
        clockRadius*Math.cos(i*(2*Math.PI/60)));
      int xInner = (int)(xCenter +
        percent*clockRadius*Math.sin(i*(2*Math.PI/60)));
      int yInner = (int)(yCenter -
        percent*clockRadius*Math.cos(i*(2*Math.PI/60)));

      g.drawLine(xOuter, yOuter, xInner, yInner);
    }

    // Display hours on the clock
    g.setColor(Color.black);
    for (int i=0; i<12; i++) {
      int x = (int)(xCenter +
        0.8*clockRadius*Math.sin(i*(2*Math.PI/12)));
      int y = (int)(yCenter -
        0.8*clockRadius*Math.cos(i*(2*Math.PI/12)));

      g.drawString(""+((i==0)?12:i), x, y);
    }
  }
}