// ScrollPaneDemo.java: Use scroll pane to view large maps
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ScrollPaneDemo extends JFrame implements ItemListener {
  // Create images in labels
  private JLabel lblIndianaMap =
    new JLabel(new ImageIcon("image/indianaMap.gif"));
  private JLabel lblOhioMap =
    new JLabel(new ImageIcon("image/ohioMap.gif"));

  // Declare a scroll pane to scroll map in the labels
  private JScrollPane jspMap;

  /** Main method */
  public static void main(String[] args) {
    ScrollPaneDemo frame = new ScrollPaneDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

  /** Default constructor */
  public ScrollPaneDemo() {
    setTitle("ScrollPane Demo");

    // Create a scroll pane with northern California map
    jspMap = new JScrollPane(lblIndianaMap);

    // Create a combo box for selecting maps
    JComboBox jcboMap = new JComboBox();
    jcboMap.addItem("Indiana");
    jcboMap.addItem("Ohio");

    // Panel p to hold combo box
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(jcboMap);
    p.setBorder(new TitledBorder("Select a map to display"));

    // Set row header, column header and corner header
    jspMap.setColumnHeaderView(
      new JLabel(new ImageIcon("image/horizontalRuler.gif")));
    jspMap.setRowHeaderView(
      new JLabel(new ImageIcon("image/verticalRuler.gif")));
    jspMap.setCorner(JScrollPane.UPPER_LEFT_CORNER,
      new CornerPanel(JScrollPane.UPPER_LEFT_CORNER));
    jspMap.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER,
      new CornerPanel(JScrollPane.UPPER_RIGHT_CORNER));
    jspMap.setCorner(JScrollPane.LOWER_RIGHT_CORNER,
      new CornerPanel(JScrollPane.LOWER_RIGHT_CORNER));
    jspMap.setCorner(JScrollPane.LOWER_LEFT_CORNER,
      new CornerPanel(JScrollPane.LOWER_LEFT_CORNER));

    // Add the scroll pane and combo box panel to the frame
    getContentPane().add(jspMap, BorderLayout.CENTER);
    getContentPane().add(p, BorderLayout.NORTH);

    // Register listener
    jcboMap.addItemListener(this);
  }

  /** Show the selected map */
  public void itemStateChanged(ItemEvent e) {
    String selectedItem = (String)e.getItem();
    if (selectedItem.equals("Indiana")) {
      // Set a new view in the view port
      jspMap.setViewportView(lblIndianaMap);
    }
    else if (selectedItem.equals("Ohio")) {
      // Set a new view in the view port
      jspMap.setViewportView(lblOhioMap);
    }

    // Revalidate the scroll pane
    jspMap.revalidate();
  }
}

// A panel displaying a line used for scroll pane corner
class CornerPanel extends JPanel implements ScrollPaneConstants {
  // Line location
  private String location;

  /** Default constructor */
  public CornerPanel(String location) {
    this.location = location;
  }

  /** Draw a line depending on the location */
  public void paintComponent(Graphics g) {
    super.paintComponents(g);

    if (location == "UPPER_LEFT_CORNER")
      g.drawLine(0, getSize().height, getSize().width, 0);
    else if (location == "UPPER_RIGHT_CORNER")
      g.drawLine(0, 0, getSize().width, getSize().height);
    else if (location == "LOWER_RIGHT_CORNER")
      g.drawLine(0, getSize().height, getSize().width, 0);
    else if (location == "LOWER_LEFT_CORNER")
      g.drawLine(0, 0, getSize().width, getSize().height);
  }
}