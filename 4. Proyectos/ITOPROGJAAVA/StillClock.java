// StillClock.java: Display a clock in JPanel
import java.awt.*;
import java.util.*;
import java.text.*;
import javax.swing.*;

public class StillClock extends JPanel {
  protected TimeZone timeZone;
  protected int xCenter, yCenter;
  protected int clockRadius;
  protected DateFormat formatter;

  /** Default constructor */
  public StillClock() {
    this(Locale.getDefault(), TimeZone.getDefault());
  }

  /** Construct a clock with specified locale and time zone */
  public StillClock(Locale locale, TimeZone timeZone) {
    setLocale(locale);
    this.timeZone = timeZone;
  }

  /** Set timezone using a time zone id such as "CST" */
  public void setTimeZoneID(String newTimeZoneID) {
    timeZone = TimeZone.getTimeZone(newTimeZoneID);
  }

  /** Override the paintComponent to display a clock */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Initialize clock parameters
    clockRadius =
      (int)(Math.min(getSize().width, getSize().height) * 0.7 * 0.5);
    xCenter = (getSize().width) / 2;
    yCenter = (getSize().height) / 2;

    // Draw circle and hours
    g.setColor(Color.black);
    g.drawOval(xCenter - clockRadius,yCenter - clockRadius,
      2 * clockRadius, 2 * clockRadius);
    g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
    g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
    g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
    g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

    // Get current time using GregorianCalendar
    GregorianCalendar cal = new GregorianCalendar(timeZone);

    // Draw second hand
    int second = (int)cal.get(GregorianCalendar.SECOND);
    int sLength = (int)(clockRadius * 0.8);
    int xSecond = (int)(xCenter + sLength *
      Math.sin(second * (2 * Math.PI / 60)));
    int ySecond = (int)(yCenter - sLength * 
      Math.cos(second * (2 * Math.PI / 60)));
    g.setColor(Color.red);
    g.drawLine(xCenter, yCenter, xSecond, ySecond);

    // Draw minute hand
    int minute = (int)cal.get(GregorianCalendar.MINUTE);
    int mLength = (int)(clockRadius * 0.65);
    int xMinute = (int)(xCenter + mLength * 
      Math.sin(minute * (2 * Math.PI / 60)));
    int yMinute = (int)(yCenter - mLength *
      Math.cos(minute * (2 * Math.PI / 60)));
    g.setColor(Color.blue);
    g.drawLine(xCenter, yCenter, xMinute, yMinute);

    // Draw hour hand
    int hour = (int)cal.get(GregorianCalendar.HOUR_OF_DAY);
    int hLength = (int)(clockRadius * 0.5);
    int xHour = (int)(xCenter + hLength *
      Math.sin((hour + minute / 60.0) * (2 * Math.PI / 12)));
    int yHour = (int)(yCenter - hLength * 
      Math.cos((hour + minute / 60.0) * (2 * Math.PI / 12)));
    g.setColor(Color.black);
    g.drawLine(xCenter, yCenter, xHour, yHour);

    // Set display format in specified style, locale and timezone
    formatter = DateFormat.getDateTimeInstance
      (DateFormat.MEDIUM, DateFormat.LONG, getLocale());
    formatter.setTimeZone(timeZone);

    // Display current date
    g.setColor(Color.red);
    String today = formatter.format(cal.getTime());
    FontMetrics fm = g.getFontMetrics();
    g.drawString(today, (getSize().width -
      fm.stringWidth(today)) / 2, yCenter + clockRadius + 30);
  }
}