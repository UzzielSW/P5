// ClockGroup.java: Display a group of international clocks
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ClockGroup extends JApplet implements ActionListener { 
  // Declare three clock panels
  private ClockPanel clockPanel1, clockPanel2, clockPanel3;

  // Declare group control buttons
  private JButton jbtResumeAll, jbtSuspendAll;

  /** This main method enables the applet to run as an application */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Clock Group Demo");

    // Create an instance of the applet
    ClockGroup applet = new ClockGroup();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(600, 300);
    frame.setVisible(true);
  }

  /** Initialize the applet */
  public void init() {
    // Panel p1 for holding three clocks
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(1, 3));

    // Create a clock for Berlin
    p1.add(clockPanel1 = new ClockPanel());
    clockPanel1.setTitle("Berlin");
    clockPanel1.clock.setTimeZoneID("ECT");
    clockPanel1.clock.setLocale(Locale.GERMAN);

    // Create a clock for San Francisco
    p1.add(clockPanel2 = new ClockPanel());
    clockPanel2.clock.setLocale(Locale.US);
    clockPanel2.clock.setTimeZoneID("PST");
    clockPanel2.setTitle("San Francisco");

    // Create a clock for Taichung
    p1.add(clockPanel3 = new ClockPanel());
    clockPanel3.setTitle("\u53f0\u4e2d");
    clockPanel3.clock.setLocale(Locale.CHINESE);
    clockPanel3.clock.setTimeZoneID("CTT");

    // Panel p2 for holding two group control buttons
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(jbtResumeAll = new JButton("Resume All"));
    p2.add(jbtSuspendAll = new JButton("Suspend All"));

    // Add panel p1 and p2 into the applet
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);

    // Register listeners
    jbtResumeAll.addActionListener(this);
    jbtSuspendAll.addActionListener(this);
  }

  /** Handle group control buttons */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtResumeAll) {
      // Start all clocks
      clockPanel1.resume();
      clockPanel2.resume();
      clockPanel3.resume();
    }
    else if (e.getSource() == jbtSuspendAll) {
      // Stop all clocks
      clockPanel1.suspend();
      clockPanel2.suspend();
      clockPanel3.suspend();
    }
  }
}

// ClockPanel for holding a header, a clock, and control buttons
class ClockPanel extends JPanel implements ActionListener {
  // Header title of the clock panel
  private JLabel jlblTitle;

  protected Clock clock  = null;

  // Individual clock Resume and Suspend control buttons
  private JButton jbtResume, jbtSuspend;

  /** Constructor */
  public ClockPanel() {
    // Panel jpButtons for grouping buttons
    JPanel jpButtons = new JPanel();
    jpButtons.add(jbtResume = new JButton("Resume"));
    jpButtons.add(jbtSuspend = new JButton("Suspend"));

    // Set BorderLayout for the ClockPanel
    setLayout(new BorderLayout());

    // Add title label to the north of the panel
    add(jlblTitle = new JLabel(), BorderLayout.NORTH);
    jlblTitle.setHorizontalAlignment(JLabel.CENTER);

    // Add the clock to the center of the panel
    add(clock = new Clock(), BorderLayout.CENTER);

    // Add jpButtons to the south of the panel
    add(jpButtons, BorderLayout.SOUTH);

    // Register ClockPanel as a listener to the buttons
    jbtResume.addActionListener(this);
    jbtSuspend.addActionListener(this);
  }

  /** Set label on the title */
  public void setTitle(String title) {
    jlblTitle.setText(title);
  }

  /** Handle buttons "Resume" and "Suspend" */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtResume) {
      clock.resume();
    }
    else if (e.getSource() == jbtSuspend) {
      clock.suspend();
    }
  }

  /** Resume the clock */
  public void resume() {
    if (clock != null) clock.resume();
  }

  /** Resume the clock */
  public void suspend() {
    if (clock != null) clock.suspend();
  }
}