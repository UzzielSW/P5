// Clock.java: Show a running clock on the panel
import java.util.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Clock extends StillClock implements ActionListener {
  protected Timer timer;

  /** Default constructor */
  public Clock() {
    this(Locale.getDefault(), TimeZone.getDefault());
  }

  /** Construct a clock with specified locale and time zone */
  public Clock(Locale locale, TimeZone timeZone) {
    super(locale, timeZone);

    // Create a timer with delay 1000 ms and listener Clock
    timer = new Timer(1000, this);

    // Start the timer
    timer.start();
  }

  /** Resume the clock */
  public void resume() {
    timer.start();
  }

  /** Suspend the clock */
  public void suspend() {
    timer.stop();
  }

  /** Handle the action event */
  public void actionPerformed(ActionEvent e) {
    repaint();
  }
}