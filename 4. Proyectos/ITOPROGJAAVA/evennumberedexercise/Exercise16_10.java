// NOTE: The audio files are not supplied in the solution.
// The images supplied are not real persons.
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Exercise16_10 extends JApplet implements Runnable {
  // Description panel to display photo, name and text
  private NewDescriptionPanel descriptionPanel =
    new NewDescriptionPanel();

  // Number of the slides specified in the HTML page
  private int numOfStudents = 0;

  private ImageIcon[] imageIcon;
  private String[] text;
  private String[] name;

  // Run slide show on a separate thread
  private Thread thread = null;

  // Control the slides show
  private boolean suspended = false;

  // Initialize the applet
  public void init() {
    // Get the numOfStudents parameter from the HTML page
    numOfStudents =
      Integer.valueOf(getParameter("numOfStudents")).intValue();
    System.out.println("number of students " + numOfStudents);

    // Create arrays for imageIcon, text and name
    imageIcon = new ImageIcon[numOfStudents];
    text = new String[numOfStudents];
    name = new String[numOfStudents];

    // Initialize text, name and imageIcon
    for (int i=0; i<numOfStudents; i++) {
      text[i] = getParameter("paragraph" + i);
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
      show(current%numOfStudents);	// Show the current slide
      current = current + 1;

      try {
        thread.sleep(10000);
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


// Define a panel for displaying image and text
// Image is displayed to fit in a fixed size in a panel
class NewDescriptionPanel extends JPanel {
  // Use ImagePanel to display an image
  // instead of using the label to display an iamge icon
  private ImagePanel imagePanel = new ImagePanel();
  // Label for displaying a title
  private JLabel jlblTitle = new JLabel();
  // Text area for displaying text
  private JTextArea jtaTextDescription = new JTextArea(300, 300);

  // Default constructor
  public NewDescriptionPanel() {
    // Group image label and title label in a panel
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(imagePanel, BorderLayout.CENTER);
    panel.add(jlblTitle, BorderLayout.SOUTH);

    // Create a scroll pane to hold text area
    //JScrollPane scrollPane = new JScrollPane
      //(jtaTextDescription = new JTextArea());

    // Center the title on the label
    jlblTitle.setHorizontalAlignment(JLabel.CENTER);

    // Set the font for the title and text
    jlblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
    jtaTextDescription.setFont(new Font("Serif", Font.PLAIN, 14));

    // Set lineWrap and wrapStyleWord true for text area
    jtaTextDescription.setLineWrap(true);
    jtaTextDescription.setWrapStyleWord(true);

    // Set preferred size for the image label and scroll pane
    imagePanel.setPreferredSize(new Dimension(175, 200));
    //scrollPane.setPreferredSize(new Dimension(200, 100));

    // Set BorderLayout for the whole panel, add panel and scrollpane
    setLayout(new BorderLayout());
    add(jtaTextDescription, BorderLayout.CENTER);
    add(panel, BorderLayout.WEST);
  }

  // Set the title
  public void setTitle(String title) {
    jlblTitle.setText(title);
  }

  // Set the image icon
  public void setImage(Image image) {
    imagePanel.showImage(image);
  }

  /**Set the text description*/
  public void setTextDescription(String text) {
    jtaTextDescription.setText(text);
  }

  public void setImageIcon(ImageIcon imageIcon) {
    imagePanel.showImage(imageIcon.getImage());
  }
}