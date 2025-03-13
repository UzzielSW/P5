// NewClockApplet.java: Display a running clock on the applet
import java.awt.event.*;
import javax.swing.Timer;

public class NewClockApplet extends CurrentTimeApplet
  implements ActionListener {
  protected Timer timer;

  /** Initialize applet */
  public void init() {
    super.init();

    // Create a timer with delay 1000 ms and listener NewClockApplet
    timer = new Timer(1000, this);
  }

  /** Override the start method in the Applet class */
  public void start() {
    timer.start();
  }

  /** Override the stop method in the Applet class */
  public void stop() {
    timer.stop();
  }

  /** Handle the action event */
  public void actionPerformed(ActionEvent e) {
    repaint();
  }
}