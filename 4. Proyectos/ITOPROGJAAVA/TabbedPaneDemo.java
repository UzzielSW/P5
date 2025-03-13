// TabbedPaneDemo.java: Use tabbed pane to select figures
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TabbedPaneDemo extends JFrame implements ItemListener {
  // Create a tabbed pane to hold figure panels
  private JTabbedPane jtpFigures = new JTabbedPane();

  // Radio buttons for specifying where tab is placed
  private JRadioButton jrbTop, jrbLeft, jrbRight, jrbBottom;

  /** Main method */
  public static void main(String[] args) {
    TabbedPaneDemo frame = new TabbedPaneDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 300);
    frame.setVisible(true);
  }

  /** Default constructor */
  public TabbedPaneDemo() {
    setTitle("Tabbed Pane Demo");

    jtpFigures.add(new FigurePanel(FigurePanel.SQUARE), "Square");
    jtpFigures.add(
      new FigurePanel(FigurePanel.RECTANGLE), "Rectangle");
    jtpFigures.add(new FigurePanel(FigurePanel.CIRCLE), "Circle");
    jtpFigures.add(new FigurePanel(FigurePanel.OVAL), "Oval");

    // Panel p to hold radio buttons for specifying tab location
    JPanel p = new JPanel();
    p.add(jrbTop = new JRadioButton("TOP"));
    p.add(jrbLeft = new JRadioButton("LEFT"));
    p.add(jrbRight = new JRadioButton("RIGHT"));
    p.add(jrbBottom = new JRadioButton("BOTTOM"));
    p.setBorder(new TitledBorder("Specify tab location"));

    // Group radio buttons
    ButtonGroup btg = new ButtonGroup();
    btg.add(jrbTop);
    btg.add(jrbLeft);
    btg.add(jrbRight);
    btg.add(jrbBottom);
    
    // Select the Top radio button
    jrbTop.setSelected(true);

    // Place tabbed pane and panel p into the frame
    this.getContentPane().add(jtpFigures, BorderLayout.CENTER);
    this.getContentPane().add(p, BorderLayout.SOUTH);

    // Register listeners
    jrbTop.addItemListener(this);
    jrbLeft.addItemListener(this);
    jrbRight.addItemListener(this);
    jrbBottom.addItemListener(this);
  }

  /** Handle radio button selection */
  public void itemStateChanged(ItemEvent e) {
    if (jrbTop.isSelected())
      jtpFigures.setTabPlacement(SwingConstants.TOP);
    else if (jrbLeft.isSelected())
      jtpFigures.setTabPlacement(SwingConstants.LEFT);
    else if (jrbRight.isSelected())
      jtpFigures.setTabPlacement(SwingConstants.RIGHT);
    else if (jrbBottom.isSelected())
      jtpFigures.setTabPlacement(SwingConstants.BOTTOM);
  }
}

// The panel for displaying a figure
class FigurePanel extends JPanel {
  final static int SQUARE = 1;
  final static int RECTANGLE = 2;
  final static int CIRCLE = 3;
  final static int OVAL = 4;
  private int figureType = 1;

  /** Construct a panel for a specified figure */
  public FigurePanel(int figureType) {
    this.figureType = figureType;
  }

  /** Return figureType */
  public int getFigureType() {
    return figureType;
  }

  /** Set figureType */
  public void setFigureType(int figureType) {
    this.figureType = figureType;
    repaint();
  }

  /** Draw a figure on the panel */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Get the appropriate size for the figure
    int width = getSize().width;
    int height = getSize().height;
    int side = (int)(0.80 * Math.min(width, height));

    switch (figureType) {
      case 1:
        g.drawRect((width - side) / 2, (height - side) / 2, 
          side, side);
        break;
      case 2:
        g.drawRect((int)(0.1 * width), (int)(0.1 * height),
          (int)(0.8 * width), (int)(0.8 * height));
        break;
      case 3:
        g.drawOval((width - side) /2, (height - side) / 2, side, side);
        break;
      case 4:
        g.drawOval((int)(0.1 * width), (int)(0.1 * height),
          (int)(0.8 * width), (int)(0.8 * height));
        break;
    }
  }
}