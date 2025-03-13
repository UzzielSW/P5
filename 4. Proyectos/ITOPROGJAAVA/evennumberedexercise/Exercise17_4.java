// Exercise17_4.java: Display country's flag and description.
// Descriptions are in the file
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Exercise17_4 extends JFrame implements ItemListener {
  // Declare an array of Strings for flag titles
  private String[] flagTitle = {"Canada", "China", "Denmark",
    "France", "Germany", "India", "Norway", "United Kingdom",
    "United States of America"};

  // Declare an ImageIcon array for the national flags of 9 countries
  private ImageIcon[] flagImage = new ImageIcon[9];

  // Declare an array of strings for flag descriptions
  private String[] flagDescription = new String[9];

  // Declare and create a description panel
  private DescriptionPanel descriptionPanel = new DescriptionPanel();

  // The combo list for selecting countries
  private JComboBox jcbo;

  // Base directory for the files
  String baseDirectory;

  // Main Method
  public static void main(String[] args) {
    Exercise17_4 frame = new Exercise17_4();
    frame.pack();
    frame.setTitle("Exercise 17.4");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  // Default Constructor
  public Exercise17_4() {
    // Get base directory
    baseDirectory = System.getProperty("user.dir");

    // Load images info flagImage array
    flagImage[0] = new ImageIcon(baseDirectory + "/images/ca.gif");
    flagImage[1] = new ImageIcon(baseDirectory + "/images/china.gif");
    flagImage[2] = new ImageIcon("images/denmark.gif");
    flagImage[3] = new ImageIcon("images/fr.gif");
    flagImage[4] = new ImageIcon("images/germany.gif");
    flagImage[5] = new ImageIcon("images/india.gif");
    flagImage[6] = new ImageIcon("images/norway.gif");
    flagImage[7] = new ImageIcon("images/uk.gif");
    flagImage[8] = new ImageIcon("images/us.gif");

    // Set text description
    for (int i=0; i<9; i++) {
      flagDescription[i] = getDescription(i);
    }

    // Create items into the combo box
    jcbo = new JComboBox(flagTitle);

    // Set the first country (Canada) for display
    setDisplay(0);

    // Add combo box and description panel to the list
    getContentPane().add(new JScrollPane(jcbo), BorderLayout.NORTH);
    getContentPane().add(descriptionPanel, BorderLayout.CENTER);

    // Register listener
    jcbo.addItemListener(this);
  }

  // Handle item selection
  public void itemStateChanged(ItemEvent e) {
    setDisplay(jcbo.getSelectedIndex());
  }

  // Set display information on the description panel
  public void setDisplay(int index) {
    descriptionPanel.setTitle(flagTitle[index]);
    descriptionPanel.setImageIcon(flagImage[index]);
    descriptionPanel.setTextDescription(flagDescription[index]);
  }

  private String getDescription(int i) {
    String result = new String();

    try {
      BufferedReader in = new BufferedReader(new FileReader(
        baseDirectory + "/text/description" + i + ".txt"));

      String line;

      while ((line = in.readLine()) != null) {
        result += line + '\n';
      }
    }
    catch (IOException ex) {
      System.out.println(ex);
    }

    return result;
  }
}