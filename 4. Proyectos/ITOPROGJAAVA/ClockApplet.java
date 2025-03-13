// ClockApplet.java: Display a running clock on the applet
import java.applet.*;
import java.awt.*;
import java.util.*;

public class ClockApplet extends CurrentTimeApplet
  implements Runnable {
  // Declare a thread for running the clock
  private Thread thread = null;

  // Determine if the thread is suspended
  private boolean suspended = false;

  /** Initialize applet */
  public void init() {
    super.init();

    // Create the thread
    thread = new Thread(this);

    // Start the thread
    thread.start();
  }

  /** Implement the start() method to resume the thread */
  public void start() {
    resume();
  }

  /** Implement the run() method to dictate what the thread will do */
  public void run() {
    while (true) {
      // Repaint the clock to display current time
      stillClock.repaint();

      try {
        thread.sleep(1000);
        waitForNotificationToResume();
      }
      catch (InterruptedException ex) {
      }
    }
  }

  private synchronized void waitForNotificationToResume()
    throws InterruptedException {
    while (suspended)
      wait();
  }

  /** Implement the stop method to suspend the thread */
  public void stop() {
    suspend();
  }

  /** Destroy the thread */
  public void destroy() {
    thread = null;
  }

  /** Resume the suspended thread */
  public synchronized void resume() {
    if (suspended) {
      suspended = false;
      notify(); // Notify the waiting object
    }
  }

  /** Suspend the thread */
  public synchronized void suspend() {
    suspended = true;
  }
}