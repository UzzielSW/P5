// Exercise14_6a.java: Display available locals and time zones using buttons
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class Exercise14_6a extends JApplet implements ActionListener {
  private JTextArea jtaDisplay = new JTextArea();
  private JButton jbtLocale = new JButton("All Locals");
  private JButton jbtTimeZone = new JButton("All Time Zones");
  
  public void init() {
    // Panel to hold buttons
    JPanel panel = new JPanel();
    panel.add(jbtLocale);
    panel.add(jbtTimeZone);
    
    JScrollPane jScrollPane1 = new JScrollPane(jtaDisplay);
    
    this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
    this.getContentPane().add(panel, BorderLayout.SOUTH);
    
    // Register listeners
    jbtLocale.addActionListener(this);
    jbtTimeZone.addActionListener(this);
  }
  
  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
    "Exercise 14.6: Available Locales and Time Zones");
    
    // Create an instance of the applet
    Exercise14_6a applet = new Exercise14_6a();
    
    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    
    // Invoke init() and start()
    applet.init();
    applet.start();
    
    // Display the frame
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
    // TODO: Implement this java.awt.event.ActionListener method
    if (e.getSource() == jbtLocale) {
      Locale[] availableLocales = Locale.getAvailableLocales();
      jtaDisplay.setText(null);
      for (int i=0; i<availableLocales.length; i++) {
        jtaDisplay.append(availableLocales[i].getDisplayName() + " "
        + availableLocales[i].toString() + '\n');
      }
    }
    else if (e.getSource() == jbtTimeZone) {
      String[] availableTimeZones = TimeZone.getAvailableIDs();
      jtaDisplay.setText(null);
      for (int i=0; i<availableTimeZones.length; i++) {
        jtaDisplay.append(availableTimeZones[i] + '\n');
      }
    }
  }
}