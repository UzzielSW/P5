// ImageAnimationUsingMediaTracker.java: Monitor loading images
// using MediaTracker 
import java.awt.*;
import javax.swing.*;

public class ImageAnimationUsingMediaTracker 
  extends ImageAnimation {
  private MediaTracker imageTracker = new MediaTracker(this);

  /** Initialize the applet */
  public void init() {
    // Load the image, the image files are named
    // L1 - L52 in image directory
    imageArray = new Image[numOfImages];
    for (int i = 0; i < imageArray.length; i++) {
      imageArray[i] = getImage(getCodeBase(),
        "image/L" + (i + 1) + ".gif" );

      // Register images with the imageTracker
      imageTracker.addImage(imageArray[i], i);
    }

    // Wait for all the images to be completely loaded
    try {
      imageTracker.waitForAll();
    }
    catch (InterruptedException ex) {
      System.out.println(ex);
    }

    // Dispose of imageTracker since it is no longer needed
    imageTracker = null;

    // Panel p to hold animation control
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Animation speed in millisecond"),
      BorderLayout.WEST);
    p.add(jtfSpeed, BorderLayout.CENTER);
    p.add(jbtReverse, BorderLayout.EAST);

    // Add the image panel and p to the applet
    getContentPane().add(new PlayImage(), BorderLayout.CENTER);
    getContentPane().add(p, BorderLayout.SOUTH);

    // Register listener
    jtfSpeed.addActionListener(this);
    jbtReverse.addActionListener(this);
  }
}