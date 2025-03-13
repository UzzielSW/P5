// Clock.java: Show a running clock on the panel
import java.util.*;

class Clock extends StillClock implements Runnable {
  // Declare a thread for running the clock
  private Thread thread = null;

  // Determine if the thread is suspended
  private boolean suspended = false;

  // Default constructor
  public Clock() {
    this(Locale.getDefault(), TimeZone.getDefault());
  }

  // Construct a clock with specified locale and time zone
  public Clock(Locale locale, TimeZone timeZone) {
    super(locale, timeZone);

    // Create the thread
    thread = new Thread(this);

    // Start the thread
    thread.start();
  }

  // Implement the run() method to dictate what the thread will do
  public void run() {
    while (true) {
      repaint();
      try {
        thread.sleep(1000);
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

  // Resume the clock
  public synchronized void resume() {
    if (suspended) {
      suspended = false;
      notify();
    }
  }

  // Suspend the clock
  public synchronized void suspend() {
    suspended = true;
  }
}