package moreguiprogramming;
import javax.swing.*;
import java.awt.event.*;

public class MouseAdapterDemo {
  public static void main(String[] args) {
    JFrame window = new JFrame("MouseAdapter Demo");

    // create the event handler and add it to window
    window.addMouseListener( new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        //display the position where the mouse was clicked
        System.out.println("(" +e.getX() +"," +e.getY() +")");
      }
    } );
			
	
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(500, 500);
    window.setVisible(true);
  }
}
