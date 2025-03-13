// ImageAnimation.java: Display a sequence of images
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ImageAnimation extends JApplet 
  implements ActionListener {
  private Image imageToDisplay;
  protected Image imageArray[]; // Hold images
  protected int numOfImages = 52, // Total number of images
                currentImageIndex = 0, // Current image subscript
                sleepTime = 100; // Milliseconds to sleep
  protected int direction = 1; // Image rotating direction

  // Image display panel
  protected PlayImage imagePanel = new PlayImage();

  // Text field for receiving speed
  protected JTextField jtfSpeed = new JTextField(5);

  // Button for reversing direction
  JButton jbtReverse = new JButton("Reverse");

  /** Initialize the applet */
  public void init() {
    // Load the image, the image files are named
    // L1 - L52 in image directory
    imageArray = new Image[numOfImages];
    for (int i = 0; i < imageArray.length; i++ ) {
      imageArray[i] = getImage(getCodeBase(),
        "image/L" + (i + 1) + ".gif" );
    }

    // Panel p to hold animation control
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Animation speed in millisecond"),
      BorderLayout.WEST);
    p.add(jtfSpeed, BorderLayout.CENTER);
    p.add(jbtReverse, BorderLayout.EAST);

    // Add the image panel and p to the applet
    getContentPane().add(imagePanel, BorderLayout.CENTER);
    getContentPane().add(p, BorderLayout.SOUTH);

    // Register listener
    jtfSpeed.addActionListener(this);
    jbtReverse.addActionListener(this);
  }

  /** Handle ActionEvent */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jtfSpeed) {
      sleepTime = Integer.parseInt(jtfSpeed.getText());
      imagePanel.setSpeed(sleepTime);
    }
    else if (e.getSource() == jbtReverse) {
      direction = -direction;
    }
  }

  /** Override the start method in the Applet class */
  public void start() {
    imagePanel.start();
  }

  /** Override the stop method in the Applet class */
  public void stop() {
    imagePanel.stop();
  }

  protected class PlayImage extends JPanel 
    implements ActionListener {
    protected Timer timer;

    /** Constructor */
    public PlayImage() {
      // Start with the first image
      currentImageIndex = 0;

      // Set line border on the panel
      setBorder(new LineBorder(Color.red, 1));

      // Create a timer with delay 1000 ms and listener Clock
      timer = new Timer(1000, this);

      // Start the timer
      timer.start();
    }

    public void setSpeed(int sleepTime) {
      timer.setDelay(sleepTime);
    }

    public void start() {
      timer.start();
    }

    public void stop() {
      timer.stop();
    }

    // Choose a new image to display
    public void actionPerformed(ActionEvent e) {
      imageToDisplay =
        imageArray[currentImageIndex % numOfImages];

      // Make sure currentImageIndex is nonnegative
      if (currentImageIndex == 0) currentImageIndex = numOfImages;
      currentImageIndex = currentImageIndex + direction;
      repaint();
    }


    /** Display an image */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (imageToDisplay != null) {
        g.drawImage(imageToDisplay, 0, 0, getSize().width,
          getSize().height, this);
      }
    }
  }
}