// CheckBoxDemo.java: Use check boxes to select one or more choices
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxDemo extends JFrame implements ItemListener {
  // Declare check boxes
  private JCheckBox jchkCentered, jchkBold, jchkItalic;

  // Declare a combo box to hold font names
  private JComboBox jcboFontName = new JComboBox();
  
  // Declare a combo box to hold font sizes
  private JComboBox jcboFontSize = new JComboBox();
  
  // Font name
  private String fontName = "SansSerif";
  
  // Font style
  private int fontStyle = Font.PLAIN;
  
  // Font Size
  private int fontSize = 12;
  
  // Declare a panel for displaying message
  private MessagePanel messagePanel;

  /** Main method */
  public static void main(String[] args) {
    CheckBoxDemo frame = new CheckBoxDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  /** Default constructor */
  public CheckBoxDemo() {
    setTitle("Check Box Demo");

    // Find all available font names
    GraphicsEnvironment e = 
      GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] fontnames = e.getAvailableFontFamilyNames();
    for (int i = 0; i < fontnames.length; i++)
      jcboFontName.addItem(fontnames[i]);
    jcboFontName.setSelectedItem("" + fontName);

    // Add font sizes into jcboFontSize
    for (int i = 1; i <= 100; i++)
      jcboFontSize.addItem("" + i);
    jcboFontSize.setSelectedItem("" + fontSize);

    // Create the message panel
    messagePanel = new MessagePanel();
    messagePanel.setMessage("Welcome to Java!");
    messagePanel.setBackground(Color.yellow);

    // Hold font name label and combo box
    JPanel p1 = new JPanel();
    p1.setLayout(new BorderLayout());
    p1.add(new JLabel("Font Name"), BorderLayout.WEST);
    p1.add(jcboFontName, BorderLayout.CENTER);
    
    // Hold font size label and combo box
    JPanel p2 = new JPanel();
    p2.setLayout(new BorderLayout());
    p2.add(new JLabel("Font Size"), BorderLayout.WEST);
    p2.add(jcboFontSize, BorderLayout.CENTER);
    
    // Add p1 and p2 into p3
    JPanel p3 = new JPanel();
    p3.setLayout(new BorderLayout());
    p3.add(p1, BorderLayout.CENTER);
    p3.add(p2, BorderLayout.EAST);

    // Put three check boxes in panel p
    JPanel p = new JPanel();
    p.add(jchkCentered = new JCheckBox("Centered"));
    p.add(jchkBold = new JCheckBox("Bold"));
    p.add(jchkItalic = new JCheckBox("Italic"));

    // Set keyboard mnemonics
    jchkCentered.setMnemonic('C');
    jchkBold.setMnemonic('B');
    jchkItalic.setMnemonic('I');
    
    // Place messagePanel, p3, and p in the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(messagePanel, BorderLayout.CENTER);
    getContentPane().add(p3, BorderLayout.NORTH);
    getContentPane().add(p, BorderLayout.SOUTH);

    // Register listeners on jcboFontName and jcboFontSize
    jcboFontName.addItemListener(this);
    jcboFontSize.addItemListener(this);
 
    // Register listeners on jchkCentered, jchkBold, and jchkItalic
    jchkCentered.addItemListener(this);
    jchkBold.addItemListener(this);
    jchkItalic.addItemListener(this);
  }

  /** Handle check box selection */
  public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == jcboFontName) {
      fontName = (String)(jcboFontName.getSelectedItem());
 
      // Set font for the message
      messagePanel.setFont(new Font(fontName, fontStyle, fontSize));
    } 
    else if (e.getSource() == jcboFontSize) {
      fontSize = Integer.parseInt(
        (String)(jcboFontSize.getSelectedItem()));

      // Set font for the message
      messagePanel.setFont(new Font(fontName, fontStyle, fontSize));
    }
    else if ((e.getSource() == jchkBold) || 
      (e.getSource() == jchkItalic)) {
      fontStyle = Font.PLAIN;
      
      // Determine a font style
      if (jchkBold.isSelected())
        fontStyle = fontStyle + Font.BOLD;
      if (jchkItalic.isSelected())
        fontStyle = fontStyle + Font.ITALIC;

      // Set font for the message
      messagePanel.setFont(new Font(fontName, fontStyle, fontSize));
    }
    else if (e.getSource() == jchkCentered) {    
      if (jchkCentered.isSelected())
        messagePanel.setCentered(true);
      else
        messagePanel.setCentered(false);

      // Repaint the message panel
      messagePanel.repaint();
    }
  }
}