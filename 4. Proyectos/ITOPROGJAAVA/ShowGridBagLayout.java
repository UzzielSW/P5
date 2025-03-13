// ShowGridBagLayout.java: Using GridBagLayout
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowGridBagLayout extends JFrame {
  private JLabel jlbl;
  private JTextArea jta1, jta2;
  private JTextField jtf;
  private JPanel jp;
  private JButton jbt1, jbt2;
  private GridBagLayout gbLayout;
  private GridBagConstraints gbConstraints;

  /** Main method */
  public static void main(String[] args) {
    ShowGridBagLayout frame = new ShowGridBagLayout();
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /** Add a component to the container */
  private void addComp(Component c, GridBagLayout gbLayout,
                       GridBagConstraints gbConstraints,
                       int row, int column, int numRows,
                       int numColumns, int weightx, int weighty) {
    // Set parameters
    gbConstraints.gridx = column;
    gbConstraints.gridy = row;
    gbConstraints.gridwidth = numColumns;
    gbConstraints.gridheight = numRows;
    gbConstraints.weightx = weightx;
    gbConstraints.weighty = weighty;

    // Set constraints in the GridBagLayout
    gbLayout.setConstraints(c, gbConstraints);

    // Add component to the container
    getContentPane().add(c);
  }

  /** Default Constructor */
  public ShowGridBagLayout() {
    setTitle("Show GridBagLayout");

    // Initialize UI components
    jlbl = new JLabel("Resize the Window and Study GridBagLayout",
                   JLabel.CENTER);
    jp = new JPanel();
    jta1 = new JTextArea("Text Area", 5, 15 );
    jta2 = new JTextArea("Text Area", 5, 15 );
    jtf = new JTextField("JTextField");
    jbt1 = new JButton("Cancel" );
    jbt2 = new JButton("Ok" );

    // Create GridBagLayout and GridBagConstraints object
    gbLayout = new GridBagLayout();
    gbConstraints = new GridBagConstraints();
    getContentPane().setLayout(gbLayout);

    // Place JLabel to occupy row 0 (the first row)
    gbConstraints.fill = GridBagConstraints.BOTH;
    gbConstraints.anchor = GridBagConstraints.CENTER;
    addComp(jlbl, gbLayout, gbConstraints, 0, 0, 1, 4, 0, 0);

    // Place text area 1 in row 1 and 2, and column 0
    addComp(jta1, gbLayout, gbConstraints, 1, 0, 2, 1, 0, 0);

    // Place Panel in row 1 and 2, and column 1 and 2
    addComp(jp, gbLayout, gbConstraints, 1, 1, 2, 2, 100, 100);
    jp.setBackground(Color.red);

    // Place text area 2 in row 1 and column 3
    addComp(jta2, gbLayout, gbConstraints, 1, 3, 1, 1, 0, 100);

    // Place text field in row 2 and column 3
    addComp(jtf, gbLayout, gbConstraints, 2, 3, 1, 1, 0, 0);

    // Place JButton 1 in row 3 and column 1
    addComp(jbt1, gbLayout, gbConstraints, 3, 1, 1, 1, 0, 0);

    // Place JButton 2 in row 3 and column 2
    addComp(jbt2, gbLayout, gbConstraints, 3, 2, 1, 1, 0, 0);
  }
}