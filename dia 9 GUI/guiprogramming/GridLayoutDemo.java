package guiprogramming;
import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo {
  public static void main(String[] args) {
    JFrame window = new JFrame("GridLayout Demo");

   // panel will arrange components in 3 columns with the given spacing 
    JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));

    window.setContentPane(panel);
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");
    JButton button5 = new JButton("Button 5");
     JButton button6 = new JButton("Button 6");
    panel.add(button1);
    panel.add(button2);
    panel.add(button3);
    panel.add(button4);
    panel.add(button5);
    panel.add(button6);
    window.setSize(500,200);
    //window.pack();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.setVisible(true);		
  }
}
