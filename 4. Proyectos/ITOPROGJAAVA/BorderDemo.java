// BorderDemo.java: Use borders for JComponent components
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;

public class BorderDemo extends JFrame implements ActionListener {
  // Declare a panel for displaying message
  private MessagePanel messagePanel;

  // A check box for selecting a border with or without a title
  private JCheckBox jchkTitled;

  // Radio buttons for border styles
  private JRadioButton jrbLoweredBevel, jrbRaisedBevel,
    jrbEtched, jrbLine, jrbMatte, jrbEmpty;

  // Radio buttons for titled border options
  private JRadioButton jrbAboveBottom, jrbBottom,
    jrbBelowBottom, jrbAboveTop, jrbTop, jrbBelowTop,
    jrbLeft, jrbCenter, jrbRight;

  // TitledBorder for the message panel
  private TitledBorder messagePanelBorder;

  /** Main method */
  public static void main(String[] args) {
    BorderDemo frame = new BorderDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  /** Constructor */
  public BorderDemo() {
    setTitle("Border Demo");

    // Create a MessagePanel instance and set colors
    messagePanel = new MessagePanel("Display the border type");
    messagePanel.setCentered(true);
    messagePanel.setBackground(Color.yellow);
    messagePanel.setBorder(messagePanelBorder);

    // Place title position radio buttons
    JPanel jpPosition = new JPanel();
    jpPosition.setLayout(new GridLayout(3, 2));
    jpPosition.add(
      jrbAboveBottom = new JRadioButton("ABOVE_BOTTOM"));
    jpPosition.add(jrbAboveTop = new JRadioButton("ABOVE_TOP"));
    jpPosition.add(jrbBottom = new JRadioButton("BOTTOM"));
    jpPosition.add(jrbTop = new JRadioButton("TOP"));
    jpPosition.add(
      jrbBelowBottom = new JRadioButton("BELOW_BOTTOM"));
    jpPosition.add(jrbBelowTop = new JRadioButton("BELOW_TOP"));
    jpPosition.setBorder(new TitledBorder("Position"));

    // Place title justification radio buttons
    JPanel jpJustification = new JPanel();
    jpJustification.setLayout(new GridLayout(3,1));
    jpJustification.add(jrbLeft = new JRadioButton("LEFT"));
    jpJustification.add(jrbCenter = new JRadioButton("CENTER"));
    jpJustification.add(jrbRight = new JRadioButton("RIGHT"));
    jpJustification.setBorder(new TitledBorder("Justification"));

    // Create panel jpTitleOptions to hold jpPosition and 
    // jpJustification
    JPanel jpTitleOptions = new JPanel();
    jpTitleOptions.setLayout(new BorderLayout());
    jpTitleOptions.add(jpPosition, BorderLayout.CENTER);
    jpTitleOptions.add(jpJustification, BorderLayout.EAST);

    // Create Panel jpTitle to hold a check box and title position
    // radio buttons, and title justification radio buttons
    JPanel jpTitle = new JPanel();
    jpTitle.setBorder(new TitledBorder("Border Title"));
    jpTitle.setLayout(new BorderLayout());
    jpTitle.add(jchkTitled = new JCheckBox("Titled"),
      BorderLayout.NORTH);
    jpTitle.add(jpTitleOptions, BorderLayout.CENTER);

    // Group radio buttons for title position
    ButtonGroup btgTitlePosition = new ButtonGroup();
    btgTitlePosition.add(jrbAboveBottom);
    btgTitlePosition.add(jrbBottom);
    btgTitlePosition.add(jrbBelowBottom);
    btgTitlePosition.add(jrbAboveTop);
    btgTitlePosition.add(jrbTop);
    btgTitlePosition.add(jrbBelowTop);

    // Group radio buttons for title justification
    ButtonGroup btgTitleJustification = new ButtonGroup();
    btgTitleJustification.add(jrbLeft);
    btgTitleJustification.add(jrbCenter);
    btgTitleJustification.add(jrbRight);

    // Create Panel jpBorderStyle to hold border style radio buttons
    JPanel jpBorderStyle = new JPanel();
    jpBorderStyle.setBorder(new TitledBorder("Border Style"));
    jpBorderStyle.setLayout(new GridLayout(6, 1));
    jpBorderStyle.add(jrbLoweredBevel =
      new JRadioButton("Lowered Bevel"));
    jpBorderStyle.add(jrbRaisedBevel =
      new JRadioButton("Raised Bevel"));
    jpBorderStyle.add(jrbEtched = new JRadioButton("Etched"));
    jpBorderStyle.add(jrbLine = new JRadioButton("Line"));
    jpBorderStyle.add(jrbMatte = new JRadioButton("Matte"));
    jpBorderStyle.add(jrbEmpty = new JRadioButton("Empty"));

    // Group radio buttons for border styles
    ButtonGroup btgBorderStyle = new ButtonGroup();
    btgBorderStyle.add(jrbLoweredBevel);
    btgBorderStyle.add(jrbRaisedBevel);
    btgBorderStyle.add(jrbEtched);
    btgBorderStyle.add(jrbLine);
    btgBorderStyle.add(jrbMatte);
    btgBorderStyle.add(jrbEmpty);

    // Create Panel jpAllChoices to place jpTitle and jpBorderStyle
    JPanel jpAllChoices = new JPanel();
    jpAllChoices.setLayout(new BorderLayout());
    jpAllChoices.add(jpTitle, BorderLayout.CENTER);
    jpAllChoices.add(jpBorderStyle, BorderLayout.EAST);

    // Place panels in the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(messagePanel, BorderLayout.CENTER);
    getContentPane().add(jpAllChoices, BorderLayout.SOUTH);

    // Register listeners
    jchkTitled.addActionListener(this);
    jrbAboveBottom.addActionListener(this);
    jrbBottom.addActionListener(this);
    jrbBelowBottom.addActionListener(this);
    jrbAboveTop.addActionListener(this);
    jrbTop.addActionListener(this);
    jrbBelowTop.addActionListener(this);
    jrbLeft.addActionListener(this);
    jrbCenter.addActionListener(this);
    jrbRight.addActionListener(this);
    jrbLoweredBevel.addActionListener(this);
    jrbRaisedBevel.addActionListener(this);
    jrbLine.addActionListener(this);
    jrbEtched.addActionListener(this);
    jrbMatte.addActionListener(this);
    jrbEmpty.addActionListener(this);
  }

  /** Handle ActionEvents on check box and radio buttons */
  public void actionPerformed(ActionEvent e) {
    // Get border style
    Border border = new EmptyBorder(2, 2, 2, 2);

    if (jrbLoweredBevel.isSelected()) {
      border = new BevelBorder(BevelBorder.LOWERED);
      messagePanel.setMessage("Lowered Bevel Style");
    }
    else if (jrbRaisedBevel.isSelected()) {
      border = new BevelBorder(BevelBorder.RAISED);
      messagePanel.setMessage("Raised Bevel Style");
    }
    else if (jrbEtched.isSelected()) {
      border = new EtchedBorder();
      messagePanel.setMessage("Etched Style");
    }
    else if (jrbLine.isSelected()) {
      border = new LineBorder(Color.black, 5);
      messagePanel.setMessage("Line Style");
    }
    else if (jrbMatte.isSelected()) {
      border = new MatteBorder(20, 20, 20, 20,
        new ImageIcon("image/swirl.gif"));
      messagePanel.setMessage("Matte Style");
    }
    else if (jrbEmpty.isSelected()) {
      border = new EmptyBorder(2, 2, 2, 2);
      messagePanel.setMessage("Empty Style");
    }

    if (jchkTitled.isSelected()) {
      // Get the title position and justification
      int titlePosition = TitledBorder.DEFAULT_POSITION;
      int titleJustification = TitledBorder.DEFAULT_JUSTIFICATION;

      if (jrbAboveBottom.isSelected())
        titlePosition = TitledBorder.ABOVE_BOTTOM;
      else if (jrbBottom.isSelected())
        titlePosition = TitledBorder.BOTTOM;
      else if (jrbBelowBottom.isSelected())
        titlePosition = TitledBorder.BELOW_BOTTOM;
      else if (jrbAboveTop.isSelected())
        titlePosition = TitledBorder.ABOVE_TOP;
      else if (jrbTop.isSelected())
        titlePosition = TitledBorder.TOP;
      else if (jrbBelowTop.isSelected())
        titlePosition = TitledBorder.BELOW_TOP;

      if (jrbLeft.isSelected())
        titleJustification = TitledBorder.LEFT;
      else if (jrbCenter.isSelected())
        titleJustification = TitledBorder.CENTER;
      else if (jrbRight.isSelected())
        titleJustification = TitledBorder.RIGHT;

      messagePanelBorder = new TitledBorder("A Title");
      messagePanelBorder.setBorder(border);
      messagePanelBorder.setTitlePosition(titlePosition);
      messagePanelBorder.setTitleJustification(titleJustification);
      messagePanelBorder.setTitle("A Title");
      messagePanel.setBorder(messagePanelBorder);
    }
    else {
      messagePanel.setBorder(border);
    }
  }
}