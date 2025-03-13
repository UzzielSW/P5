// Exercise14_6.java: Display available locals and time zones
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class Exercise14_6b extends JApplet {
  private JTabbedPane jtp = new JTabbedPane();
  private JTextArea jtaLocales = new JTextArea();
  private JTextArea jtaTimeZone = new JTextArea();
  
  public void init() {
    jtp.add(new JScrollPane(jtaLocales), "Available Locales");
    jtp.add(new JScrollPane(jtaTimeZone), "Available Timezones");
    jtp.setTabPlacement(SwingConstants.BOTTOM);
    initialize();
    this.getContentPane().add(jtp, BorderLayout.CENTER);
  }
  
  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
      "Exercise 14.6: Available Locales and Time Zones");
    
    // Create an instance of the applet
    Exercise14_6b applet = new Exercise14_6b();
    
    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    
    // Invoke init() and start()
    applet.init();
    applet.start();
    
    // Display the frame
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
  
  public void initialize() {
    Locale[] availableLocales = Locale.getAvailableLocales();
    jtaLocales.setText(null);
    for (int i=0; i<availableLocales.length; i++) {
      jtaLocales.append(availableLocales[i].getDisplayName() + " "
      + availableLocales[i].toString() + '\n');
    }

    String[] availableTimeZones = TimeZone.getAvailableIDs();
    jtaTimeZone.setText(null);
    for (int i=0; i<availableTimeZones.length; i++) {
      jtaTimeZone.append(availableTimeZones[i] + '\n');
    }
  }
}