// ShowCardLayout.java: Using CardLayout to display images
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowCardLayout extends JFrame
  implements ActionListener, ItemListener {
  private CardLayout cardLayout = new CardLayout();
  private JPanel cardPanel = new JPanel();
  private JButton jbtFirst, jbtNext, jbtPrevious, jbtLast;
  private JComboBox jcboImage;

  public ShowCardLayout() {
    // Use CardLayout for cardPanel
    cardPanel.setLayout(cardLayout);

    // Add 9 labels for displaying images into cardPanel
    for (int i = 1; i <= 9; i++)
      cardPanel.add
        (new JLabel(new ImageIcon("image/flag" + i + ".gif")),
          String.valueOf(i));

    // Panel p to hold buttons and a combo box
    JPanel p = new JPanel();
    p.add(jbtFirst = new JButton("First"));
    p.add(jbtNext = new JButton("Next"));
    p.add(jbtPrevious= new JButton("Previous"));
    p.add(jbtLast = new JButton("Last"));
    p.add(new JLabel("Image"));
    p.add(jcboImage = new JComboBox());

    // Initialize combo box items
    for (int i = 1; i <= 9; i++)
      jcboImage.addItem(String.valueOf(i));

    // Place panels in the frame
    getContentPane().add(cardPanel, BorderLayout.CENTER);
    getContentPane().add(p, BorderLayout.SOUTH);

    // Register listeners with the source objects
    jbtFirst.addActionListener(this);
    jbtNext.addActionListener(this);
    jbtPrevious.addActionListener(this);
    jbtLast.addActionListener(this);
    jcboImage.addItemListener(this);
  }

  /** Main method */
  public static void main(String[] args) {
    ShowCardLayout frame = new ShowCardLayout();
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("CardLayout Demo");
    frame.setVisible(true);
  }

  /** Handle button actions */
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    if (e.getSource() instanceof JButton)
      if ("First".equals(actionCommand))
        // Show the first component in cardPanel
        cardLayout.first(cardPanel);
      else if ("Last".equals(actionCommand))
        // Show the last component in cardPanel
        cardLayout.last(cardPanel);
      else if ("Previous".equals(actionCommand))
        // Show the previous component in cardPanel
        cardLayout.previous(cardPanel);
      else if ("Next".equals(actionCommand))
        // Show the next component in cardPanel
        cardLayout.next(cardPanel);
  }

  /** Handle selection of combo box item */
  public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == jcboImage)
      // Show the component at specified index
      cardLayout.show(cardPanel, (String)e.getItem());
  }
}