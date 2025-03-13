// ListDemo.java: Use list to select a country and display the
// selected country's flag
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo extends JFrame 
  implements ListSelectionListener {
  // Declare an ImageIcon array for the national flags of 9 countries
  private ImageIcon[] imageIcon = new ImageIcon[9];

  // Arrays of labels for displaying images
  private JLabel[] jlblImageViewer = new JLabel[9];

  // The list for selecting countries
  JList jlst;

  /** Main Method */
  public static void main(String[] args) {
    ListDemo frame = new ListDemo();
    frame.setSize(650, 500);
    frame.setTitle("List Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /** Default Constructor */
  public ListDemo() {
    // Load images into imageIcon array
    imageIcon[0] = new ImageIcon("image/us.gif");
    imageIcon[1] = new ImageIcon("image/ca.gif");
    imageIcon[2] = new ImageIcon("image/uk.gif");
    imageIcon[3] = new ImageIcon("image/germany.gif");
    imageIcon[4] = new ImageIcon("image/fr.gif");
    imageIcon[5] = new ImageIcon("image/denmark.gif");
    imageIcon[6] = new ImageIcon("image/norway.gif");
    imageIcon[7] = new ImageIcon("image/china.gif");
    imageIcon[8] = new ImageIcon("image/india.gif");

    // Create a string of country names
    String[] countries = {"United States of America", "Canada",
      "United Kingdom", "Germany", "France", "Denmark", "Norway",
      "China", "India"};

    // Create a list with the country names
    jlst = new JList(countries);

    // Create a panel to hold nine labels
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(3, 3, 5, 5));

    for (int i = 0; i < 9; i++) {
      p.add(jlblImageViewer[i] = new JLabel());
      jlblImageViewer[i].setHorizontalAlignment
        (SwingConstants.CENTER);
    }

    // Add p and the list to the frame
    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(new JScrollPane(jlst), BorderLayout.WEST);

    // Register listeners
    jlst.addListSelectionListener(this);
  }

  /** Handle list selection */
  public void valueChanged(ListSelectionEvent e) {
    // Get selected indices
    int[] indices = jlst.getSelectedIndices();
 
    int i;
    // Set icons in the labels
    for (i = 0; i < indices.length; i++) {
      jlblImageViewer[i].setIcon(imageIcon[indices[i]]);
    }

    // Remove icons from the rest of the labels
    for ( ; i < 9; i++) {
      jlblImageViewer[i].setIcon(null);
    }
  }
}