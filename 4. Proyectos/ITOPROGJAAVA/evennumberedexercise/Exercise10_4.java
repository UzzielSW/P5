// Exercise10_4.java: Practice on containers and layout
import java.awt.*;
import javax.swing.*;

public class Exercise10_4 extends JFrame {
  public static void main(String[] args) {
    Exercise10_4 frame = new Exercise10_4();
    frame.pack();
    frame.setTitle("Exercise 10.3");
    frame.setVisible(true);
  }

  public Exercise10_4() {
    // Create panel p1 add three buttons
    JPanel p1 = new NewPanel("Button 1", "Button 2", "Button 3");

    // Create Panel p2 and add three buttons
    JPanel p2 = new NewPanel("Button 4", "Button 5", "Button 6");

    // Create a frame with FlowLayout.
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.SOUTH);
    getContentPane().add(p2, BorderLayout.CENTER);
 }
}

class NewPanel extends JPanel {
  public NewPanel(String s1, String s2, String s3) {
    setLayout(new GridLayout(2, 2));
    add(new JButton(s1));
    add(new JButton(s2));
    add(new JButton(s3));
  }
}