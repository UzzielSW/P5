// MultipleWindowsDemo.java: Display histogram in a separate window
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleWindowsDemo extends JFrame 
  implements ActionListener {
  private JTextArea jta;
  private JButton jbtShowHistogram = new JButton("Show Histogram");
  private Histogram histogram = new Histogram();

  // Create a new frame to hold the histogram panel
  private JFrame histogramFrame = new JFrame();

  /** Default construct */
  public MultipleWindowsDemo() {
    // Store text area in a scroll pane
    JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());
    scrollPane.setPreferredSize(new Dimension(300, 200));
    jta.setWrapStyleWord(true);
    jta.setLineWrap(true);

    // Place scroll pane and button in the frame
    getContentPane().add(scrollPane, BorderLayout.CENTER);
    getContentPane().add(jbtShowHistogram, BorderLayout.SOUTH);

    // Register listener
    jbtShowHistogram.addActionListener(this);

    // Create a new frame to hold the histogram panel
    histogramFrame.getContentPane().add(histogram);
    histogramFrame.pack();
    histogramFrame.setTitle("Histogram");
  }

  /** Handle the button action */
  public void actionPerformed(ActionEvent e) {
    // Count the letters in the text area
    int[] count = countLetters();

    // Set the letter count to histogram for display
    histogram.showHistogram(count);

    // Show the frame
    histogramFrame.setVisible(true);
  }

  /** Count the letters in the text area */
  private int[] countLetters() {
    // Count for 26 letters
    int[] count = new int[26];

    // Get contents from the text area
    String text = jta.getText();

    // Count occurrence of each letter (case insensitive)
    for (int i = 0; i < text.length(); i++) {
      char character = text.charAt(i);

      if ((character >= 'A') && (character <= 'Z')) {
        count[(int)character - 65]++; // The ASCII for 'A' is 65
      }
      else if ((character >= 'a') && (character <= 'z')) {
        count[(int)character - 97]++; // The ASCII for 'a' is 97
      }
    }

    return count; // Return the count array
  }

  /** Main method */
  public static void main(String[] args) {
    MultipleWindowsDemo frame = new MultipleWindowsDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Multiple Windows Demo");
    frame.pack();
    frame.setVisible(true);
  }
}