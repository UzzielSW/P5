// TextAreaDemo.java: Display an image in a label, the title for
// the image in a label, and the description of the image in a
// text area
import java.awt.*;
import javax.swing.*;

public class TextAreaDemo extends JFrame {
  // Declare and create a description panel
  private DescriptionPanel descriptionPanel = new DescriptionPanel();

  /** Main method */
  public static void main(String[] args) {
    TextAreaDemo frame = new TextAreaDemo();
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Text Area Demo");
    frame.setVisible(true);
  }

  /** Default constructor */
  public TextAreaDemo() {
    // Set title, text and image in the description panel
    descriptionPanel.setTitle("Canada");
    String description = "The Maple Leaf flag \n\n" +
      "The Canadian National Flag was adopted by the Canadian " +
      "Parliament on October 22, 1964 and was proclaimed into law " +
      "by Her Majesty Queen Elizabeth II (the Queen of Canada) on " +
      "February 15, 1965. The Canadian Flag (colloquially known " +
      "as The Maple Leaf Flag) is a red flag of the proportions " +
      "two by length and one by width, containing in its center a " +
      "white square, with a single red stylized eleven-point " +
      "mapleleaf centered in the white square.";
    descriptionPanel.setTextDescription(description);
    descriptionPanel.setImageIcon(new ImageIcon("image/ca.gif"));

    // Add the description panel to the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(descriptionPanel, BorderLayout.CENTER);
  }
}

// Define a panel for displaying image and text
class DescriptionPanel extends JPanel {
  /** Label for displaying an image icon */
  private JLabel jlblImage = new JLabel();

  /** Label for displaying a title */
  private JLabel jlblTitle = new JLabel();

  /** Text area for displaying text */
  private JTextArea jtaTextDescription;

  /** Default constructor */
  public DescriptionPanel() {
    // Group image label and title label in a panel
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(jlblImage, BorderLayout.CENTER);
    panel.add(jlblTitle, BorderLayout.SOUTH);

    // Create a scroll pane to hold text area
    JScrollPane scrollPane = new JScrollPane
      (jtaTextDescription = new JTextArea());

    // Center the title on the label
    jlblTitle.setHorizontalAlignment(JLabel.CENTER);

    // Set the font for the title and text
    jlblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
    jtaTextDescription.setFont(new Font("Serif", Font.PLAIN, 14));

    // Set lineWrap and wrapStyleWord true for text area
    jtaTextDescription.setLineWrap(true);
    jtaTextDescription.setWrapStyleWord(true);

    // Set preferred size for the scroll pane
    scrollPane.setPreferredSize(new Dimension(200, 100));

    // Set BorderLayout for the whole panel, add panel and scrollpane
    setLayout(new BorderLayout(5, 5));
    add(scrollPane, BorderLayout.CENTER);
    add(panel, BorderLayout.WEST);
  }

  /** Set the title */
  public void setTitle(String title) {
    jlblTitle.setText(title);
  }

  /** Set the image icon */
  public void setImageIcon(ImageIcon icon) {
    jlblImage.setIcon(icon);
    Dimension dimension = new Dimension(icon.getIconWidth(),
      icon.getIconHeight());
    jlblImage.setPreferredSize(dimension);
  }

  /** Set the text description */
  public void setTextDescription(String text) {
    jtaTextDescription.setText(text);
  }
}