package guiprogramming;
import java.awt.*;
import javax.swing.*;

public class BorderLayoutDemo {
  public static void main(String[] args) {
    JFrame window = new JFrame();

    // create a panel that uses BorderLayout
    JPanel panel = new JPanel(new BorderLayout());
    window.setContentPane(panel);

    // create the buttons
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");
    JButton button5 = new JButton("Button 5");

    // add the buttons to the panel using BorderLayout
    panel.add(button1, BorderLayout.NORTH);
    panel.add(button2, BorderLayout.SOUTH);
    panel.add(button3, BorderLayout.WEST);
    panel.add(button4, BorderLayout.EAST);
    panel.add(button5, BorderLayout.CENTER);

    window.pack();
    window.setTitle("BorderLayout Demo");
    window.setVisible(true);		
  }
}

