// Exercise16_8.java: (Rewrite Exercise16_8) Slides show of students
// (Using panel to display images)
// NOTE: The audio files are not supplied in the solution.
// The images supplied are not real persons.
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Exercise16_8 extends JApplet implements Runnable {
  // Description panel to display photo, name and text
  private NewDescriptionPanel descriptionPanel =
    new NewDescriptionPanel();

  // Number of the slides specified in the HTML page
  private int numOfCountries = 0;

  private ImageIcon[] imageIcon;
  private String[] text;
  private String[] name;

  // Run slide show on a separate thread
  private Thread thread = null;

  // Control the slides show
  private boolean suspended = false;

  // Initialize the applet
  public void init() {
    // Get the numOfCountries parameter from the HTML page
    numOfCountries =
      Integer.valueOf(getParameter("numOfCountries")).intValue();
    System.out.println("number of students " + numOfCountries);

    // Create arrays for imageIcon, text and name
    imageIcon = new ImageIcon[numOfCountries];
    text = new String[numOfCountries];
    name = new String[numOfCountries];

    // Initialize text, name and imageIcon
    for (int i=0; i<numOfCountries; i++) {
      text[i] = getParameter("description" + i);
      name[i] = getParameter("name" + i);
      imageIcon[i] = new ImageIcon(getImage(getCodeBase(),
        "photo/photo" + i + ".gif"));
    }

    // Set applet layout and add text area and panel
    getContentPane().add(descriptionPanel, BorderLayout.CENTER);

    // Create the thread
    thread = new Thread(this);
    thread.start();
  }

  public void start() {
    resume();
  }

  public void stop() {
    suspend();
  }

  public void destroy() {
    thread = null;
  }

  // Run a slide show
  public void run() {
    int current = 0;
    while (true) {
      show(current%numOfCountries);	// Show the current slide
      current = current + 1;

      try {
        thread.sleep(10000); // 10 seconds
        synchronized (this) {
          while (suspended)
            wait();
        }
      }
      catch (InterruptedException ex) {
      }
    }
  }

  private void show(int current) {
    // Show text
    descriptionPanel.setTextDescription(text[current]);

    // Show name
    descriptionPanel.setTitle(name[current]);

    // Show imageIcon
    descriptionPanel.setImageIcon(imageIcon[current]);
  }

  public synchronized void resume() {
    if (suspended) {
      suspended = false;
      notify();
    }
  }

  public synchronized void suspend() {
    suspended = true;
  }
}