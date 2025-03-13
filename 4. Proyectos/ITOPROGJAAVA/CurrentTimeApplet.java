// CurrentTimeApplet.java: Display a still clock on the applet
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CurrentTimeApplet extends JApplet {
  protected Locale locale;
  protected TimeZone timeZone;
  protected StillClock stillClock;
  private boolean isStandalone = false;

  /** Construct the applet */
  public CurrentTimeApplet() {
  }

  /** Initialize the applet */
  public void init() {
    if (!isStandalone) {
      // Get locale and timezone from HTML
      getHTMLParameters();
    }

    // Add the clock to the applet
    plugClock();
  }

  /** Create a clock and add it to the applet */
  public void plugClock() {
    getContentPane().add(stillClock = 
      new StillClock(locale, timeZone));
  }

  /** Obtain HTML parameters if runs as applet */
  public void getHTMLParameters() {
    // Get parameters from the HTML
    String language = getParameter("language");
    String country = getParameter("country");
    String timezone = getParameter("timezone");

    // Set default values if parameters are not given 
    // in the HTML file
    if (language == null)
      language = "en";

    if (country == null)
      country = "US";

    if (timezone == null)
      timezone = "CST";

    // Set locale and timezone
    locale = new Locale(language, country);
    timeZone = TimeZone.getTimeZone(timezone);
  }

  /** Main method with three arguments:
     @param args[0] language such as en
     @param args[1] country such as US
     @param args[2]: timezone such as CST
   */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Display Current Time");

    // Create an instance of the applet
    CurrentTimeApplet applet = new CurrentTimeApplet();

    // It runs as an application
    applet.isStandalone = true;

    // Get parameters from the command line
    applet.getCommandLineParameters(args);

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /** Get command line parameters if runs standalone */
  public void getCommandLineParameters(String[] args) {
    // Declare locale and timezone with default values
    locale = Locale.getDefault();
    timeZone = TimeZone.getDefault();

    // Check usage and get language, country and time zone
    if (args.length > 3) {
      System.out.println(
        "Usage: java CurrentTimeApplet language country timezone");
      System.exit(0);
    }
    else if (args.length == 3) {
      locale = new Locale(args[0], args[1]);
      timeZone = TimeZone.getTimeZone(args[2]);
    }
    else if (args.length == 2) {
      locale = new Locale(args[0], args[1]);
      timeZone = TimeZone.getDefault();
    }
    else if (args.length == 1) {
      System.out.println(
        "Usage: java DisplayTime language country timezone");
      System.exit(0);
    }
    else {
      locale = Locale.getDefault();
      timeZone = TimeZone.getDefault();
    }
  }
}