// ClockWithAudio.java: Display a clock and announce time
import java.awt.*;
import java.util.*;

public class ClockWithAudio extends Clock {
  protected ClockAppletWithAudio applet;

  /** Construct a clock with specified locale, timezone, and applet */
  public ClockWithAudio(Locale locale, TimeZone timeZone,
    ClockAppletWithAudio applet) {
    // Invoke the Clock class's constructor
    super(locale, timeZone);

    this.applet = applet;
  }

  /** Modify the paintComponent() method to play sound */
  public void paintComponent(Graphics g) {
    // Invoke the paintComponent method in the Clock class
    super.paintComponent(g);

    // Get current time using GregorianCalendar
    GregorianCalendar calendar = new GregorianCalendar(timeZone);

    // Get second, minute and hour
    int s = (int)calendar.get(GregorianCalendar.SECOND);
    int m = (int)calendar.get(GregorianCalendar.MINUTE);
    int h = (int)calendar.get(GregorianCalendar.HOUR_OF_DAY);

    // Announce current time
    applet.announceTime(s, m, h);
  }
}