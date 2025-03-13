package guiprogramming;
import java.awt.*;
import javax.swing.*;

public class BoxLayoutDemo {
  public static void main(String[] args) {
    JFrame window = new JFrame();
    JPanel panel = new JPanel();

    // panel will arrange components in a single row
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

    window.setContentPane(panel);
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    JButton button4 = new JButton("Button 4");
    JButton button5 = new JButton("Button 5");
    panel.add(button1);
    panel.add(button2);

    // create a horizontal strut between buttons 2 and 3
    panel.add(Box.createHorizontalStrut(10)); 

    panel.add(button3);

    // create horizontal glue between buttons 3 and 4
    panel.add(Box.createHorizontalGlue());

    panel.add(button4);
    panel.add(button5);	
    window.pack();
    window.setTitle("BoxLayout Demo");
    window.setVisible(true);		
  }
}

