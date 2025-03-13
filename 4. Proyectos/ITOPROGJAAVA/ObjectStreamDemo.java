// ObjectStreamDemo.java: Demonstrate store and restore objects
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Date;

public class ObjectStreamDemo extends JFrame
  implements ActionListener {
  // Radio buttons for selecting a color for the message
  JRadioButton jrbRed = new JRadioButton("Red");
  JRadioButton jrbGreen = new JRadioButton("Green");
  JRadioButton jrbYellow = new JRadioButton("Yellow");

  // Buttons for Store, Restore, Left, and Right
  JButton jbtStore = new JButton("Store");
  JButton jbtRestore = new JButton("Restore");
  JButton jbtLeft = new JButton("<=");
  JButton jbtRight = new JButton("=>");

  // Status label to display date when the object is stored
  JLabel jlbStatusBar = new JLabel();

  // Create a MessagePanel instance
  MessagePanel messagePanel = new MessagePanel();

  // Panel for holding radio buttons, message panel, and buttons
  JPanel jpSerialization = new JPanel();

  /** Construct the frame */
  public ObjectStreamDemo() {
    // Create a panel to group radio buttons
    JPanel jpRadioButtons = new JPanel();
    jpRadioButtons.add(jrbRed);
    jpRadioButtons.add(jrbGreen);
    jpRadioButtons.add(jrbYellow);

    // Group radio buttons
    ButtonGroup btg = new ButtonGroup();
    btg.add(jrbRed);
    btg.add(jrbGreen);
    btg.add(jrbYellow);

    // Create a panel to group buttons
    JPanel jpButtons = new JPanel();
    jpButtons.add(jbtStore);
    jpButtons.add(jbtRestore);
    jpButtons.add(jbtLeft);
    jpButtons.add(jbtRight);

    // Group jpRadioButtons, messagePanel, and jpButtons
    jpSerialization.setLayout(new BorderLayout());
    jpSerialization.add(jpRadioButtons, BorderLayout.NORTH);
    jpSerialization.add(messagePanel, BorderLayout.CENTER);
    jpSerialization.add(jpButtons, BorderLayout.SOUTH);

    // Set borders
    jpRadioButtons.setBorder(BorderFactory.createEtchedBorder());
    jpButtons.setBorder(BorderFactory.createEtchedBorder());
    messagePanel.setBorder(BorderFactory.createRaisedBevelBorder());

    // Add jpSerialization and jlbStatusBar to the frame
    Container container = getContentPane();
    container.add(jlbStatusBar, BorderLayout.SOUTH);
    container.add(jpSerialization, BorderLayout.CENTER);

    // Register listeners
    jrbRed.addActionListener(this);
    jrbGreen.addActionListener(this);
    jrbYellow.addActionListener(this);
    jbtStore.addActionListener(this);
    jbtRestore.addActionListener(this);
    jbtLeft.addActionListener(this);
    jbtRight.addActionListener(this);
  }

  /** Handle action events */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jrbRed)
      messagePanel.setBackground(Color.red);
    else if (e.getSource() == jrbGreen)
      messagePanel.setBackground(Color.green);
    else if (e.getSource() == jrbYellow)
      messagePanel.setBackground(Color.yellow);
    else if (e.getSource() == jbtStore) {
      try {
        ObjectOutputStream out =
          new ObjectOutputStream(new FileOutputStream("object.dat"));
        out.writeObject(messagePanel);
        out.writeObject(new Date());
        out.close();
        jlbStatusBar.setText("The object is stored in object.dat");
      }
      catch (IOException ex) {
        System.out.println(ex);
      }
    }
    else if (e.getSource() == jbtRestore) {
      try {
        ObjectInputStream in =
          new ObjectInputStream(new FileInputStream("object.dat"));
        MessagePanel c = (MessagePanel)in.readObject();
        Date d = (Date)in.readObject();
        jpSerialization.remove(messagePanel);
        messagePanel = c;
        jpSerialization.add(messagePanel, BorderLayout.CENTER);
        jpSerialization.repaint();
        in.close();
        jlbStatusBar.setText("The object saved at " + d.toString()
          + " is restored");
      }
      catch (IOException ex1) {
        System.out.println(ex1);
      }
      catch (ClassNotFoundException ex2) {
        System.out.println(ex2);
      }
    }
    else if (e.getSource() == jbtLeft)
      left();
    else if (e.getSource() == jbtRight)
      right();
  }

  /** Move the message in the panel left */
  private void left() {
    int x = messagePanel.getXCoordinate();
    if (x > 10) {
      // Shift the message to the left
      messagePanel.setXCoordinate(x - 10);
      messagePanel.repaint();
    }
  }

  /** Move the message in the panel right */
  private void right() {
    int x = messagePanel.getXCoordinate();
    if (x < getSize().width - 20) {
      // Shift the message to the right
      messagePanel.setXCoordinate(x + 10);
      messagePanel.repaint();
    }
  }

  /** Main method */
  public static void main(String[] args) {
    ObjectStreamDemo frame = new ObjectStreamDemo();
    frame.setTitle("Test Object Serialization");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}