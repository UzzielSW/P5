// Exercise16_4: Media track
// Please run this program from DOS prompt and quit
// other applications to save memory. This program consumes a lot of
// memory.
import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.applet.*;

public class Exercise16_4 extends ImageAnimation {
  private MediaTracker imageTracker = new MediaTracker(this);

  // Obtain a Toolkit instance
  Toolkit toolkit = Toolkit.getDefaultToolkit();

  URL url;

  // Initialize the applet
  public void init() {
    // Load the image, the image files are named
    // L1 - L52 in Images directory
    imageArray = new Image[numOfImages];
    for (int i=0; i<imageArray.length; i++ ) {

      // Get the URL for the file name
      url = this.getClass().getResource("Images/L" + (i+1) + ".gif" );

      imageArray[i] = toolkit.getImage(url );

      // Register images with the imageTracker
      imageTracker.addImage(imageArray[i], i);
    }

    // Play a sound
    url = this.getClass().getResource("Ticker.au");
    AudioClip audioClip = Applet.newAudioClip(url);
    PlayAudio playAudio = new PlayAudio(audioClip, true);

    // Wait for all the images to be completely loaded
    try {
      imageTracker.waitForAll();
    }
    catch (InterruptedException ex) {
      System.out.println(ex);
    }

    // Dispose of imageTracker and audioClip since they are no longer needed
    imageTracker = null;
    audioClip = null;

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

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
      "Exercise 14.4: Modify Example 14.6");

    // Create an instance of the applet
    Exercise16_4 applet = new Exercise16_4();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(500, 200);
    frame.setVisible(true);
  }
}

class PlayAudio extends Thread {
  AudioClip audioClip;
  boolean loop;

  public PlayAudio(AudioClip audioClip, boolean loop) {
    this.audioClip = audioClip;
    this.loop = loop;
    start();
  }

  public void run() {
    if (loop)
      audioClip.loop();
  }
}