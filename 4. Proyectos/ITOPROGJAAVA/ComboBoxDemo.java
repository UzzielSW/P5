// ComboBoxDemo.java: Use a combo box to select a country and 
// display the selected country's flag information
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxDemo extends JFrame implements ItemListener {
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

  /** Main Method */
  public static void main(String[] args) {
    ComboBoxDemo frame = new ComboBoxDemo();
    frame.pack();
    frame.setTitle("Combo Box Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /** Default Constructor */
  public ComboBoxDemo() {
    // Load images into flagImage array
    flagImage[0] = new ImageIcon("image/ca.gif");
    flagImage[1] = new ImageIcon("image/china.gif");
    flagImage[2] = new ImageIcon("image/denmark.gif");
    flagImage[3] = new ImageIcon("image/fr.gif");
    flagImage[4] = new ImageIcon("image/germany.gif");
    flagImage[5] = new ImageIcon("image/india.gif");
    flagImage[6] = new ImageIcon("image/norway.gif");
    flagImage[7] = new ImageIcon("image/uk.gif");
    flagImage[8] = new ImageIcon("image/us.gif");

    // Set text description
    flagDescription[0] = "The Maple Leaf flag \n\n" +
      "The Canadian National Flag was adopted by the Canadian " +
      "Parliament on October 22, 1964 and was proclaimed into law " +
      "by Her Majesty Queen Elizabeth II (the Queen of Canada) on " +
      "February 15, 1965. The Canadian Flag (colloquially known " +
      "as The Maple Leaf Flag) is a red flag of the proportions " +
      "two by length and one by width, containing in its center a " +
      "white square, with a single red stylized eleven-point " +
      "mapleleaf centered in the white square.";
    flagDescription[1] = "Description for China ... ";
    flagDescription[2] = "Description for Denmark ... ";
    flagDescription[3] = "Description for France ... ";
    flagDescription[4] = "Description for Germany ... ";
    flagDescription[5] = "Description for India ... ";
    flagDescription[6] = "Description for Norway ... ";
    flagDescription[7] = "Description for UK ... ";
    flagDescription[8] = "Description for US ... ";

    // Create items into the combo box
    jcbo = new JComboBox(flagTitle);

    // Set the first country (Canada) for display
    setDisplay(0);

    // Add combo box and description panel to the list
    getContentPane().add(jcbo, BorderLayout.NORTH);
    getContentPane().add(descriptionPanel, BorderLayout.CENTER);

    // Register listener
    jcbo.addItemListener(this);
  }

  /** Handle item selection */
  public void itemStateChanged(ItemEvent e) {
    setDisplay(jcbo.getSelectedIndex());
  }

  /** Set display information on the description panel */
  public void setDisplay(int index) {
    descriptionPanel.setTitle(flagTitle[index]);
    descriptionPanel.setImageIcon(flagImage[index]);
    descriptionPanel.setTextDescription(flagDescription[index]);
  }
}