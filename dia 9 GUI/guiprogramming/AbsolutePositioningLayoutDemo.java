package guiprogramming;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class AbsolutePositioningLayoutDemo {
  public static void main(String[] args) {
    JFrame window = new JFrame();
    JPanel panel = new JPanel();
		
    // a layout manager is not used
    panel.setLayout(null);
		
    window.setContentPane(panel);
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    panel.add(button1);
    panel.add(button2);
        
    // create a gray-colored border of width 8 around panel
    Border border = BorderFactory.createLineBorder(Color.gray, 8);
    panel.setBorder(border);
		
    // this button is positioned incorrectly on top of the border
    button1.setBounds(400, 0, 100, 50);

    // get information about the panel’s borders	
    Insets inset = panel.getInsets();
		
    // this button is positioned inside the border 
    button2.setBounds(inset.left, inset.top, 100, 50);
		
    // print out 8, which is the border width 
    System.out.println(inset.left);
    System.out.println(inset.top);
	// when window is closed, terminate the program as well		
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
    window.setSize(500, 500);
    window.setTitle("AbsolutePositiong Demo");
    window.setLocationRelativeTo(null);
    window.setVisible(true);	
   }
}

