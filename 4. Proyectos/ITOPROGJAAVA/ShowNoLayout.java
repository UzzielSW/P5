// ShowNoLayout.java: Place components without using a layout manager
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowNoLayout extends JFrame {
  private JLabel jlbl =
    new JLabel("Resize the Window and Study No Layout",
      JLabel.CENTER);
  private JTextArea jta1 = new JTextArea("Text Area", 5, 10 );
  private JTextArea jta2 = new JTextArea("Text Area", 5, 10 );
  private JTextField jtf = new JTextField("TextField");
  private JPanel jp = new JPanel();
  private JButton jbt1 = new JButton("Cancel" );
  private JButton jbt2 = new JButton("Ok" );
  private GridBagLayout gbLayout;
  private GridBagConstraints gbConstraints;

  public static void main(String[] args) {
    ShowNoLayout frame = new ShowNoLayout();
    frame.setSize(400,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public ShowNoLayout() {
    setTitle("Show No Layout");

    // Set background color for the panel
    jp.setBackground(Color.red);

    // Specify no layout manager
    getContentPane().setLayout(null);

    // Add components to frame
    getContentPane().add(jlbl);
    getContentPane().add(jp);
    getContentPane().add(jta1);
    getContentPane().add(jta2);
    getContentPane().add(jtf);
    getContentPane().add(jbt1);
    getContentPane().add(jbt2);

    // Put components in the right place
    jlbl.setBounds(0, 10, 400, 40);
    jta1.setBounds(0, 50, 100, 100);
    jp.setBounds(100, 50, 200, 100);
    jta2.setBounds(300, 50, 100, 50);
    jtf.setBounds(300, 100, 100, 50);
    jbt1.setBounds(100, 150, 100, 50);
    jbt2.setBounds(200, 150, 100, 50);
  }
}