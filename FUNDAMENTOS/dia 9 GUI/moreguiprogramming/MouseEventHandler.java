package moreguiprogramming;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventHandler implements MouseInputListener {
	
  public void mouseClicked(MouseEvent e) {
    System.out.println("Mouse clicked");
  }
  public void mousePressed(MouseEvent e){
    System.out.println("Mouse pressed");
  }
  public void mouseReleased(MouseEvent e){
    System.out.println("Mouse released");
  }
  public void mouseEntered(MouseEvent e){
    System.out.println("Mouse entered");
  }
  public void mouseExited(MouseEvent e){
    System.out.println("Mouse exited");
  }
  public void mouseDragged(MouseEvent e){
    System.out.println("Mouse dragged");
  }
  public void mouseMoved(MouseEvent e){
    System.out.println("Mouse moved");
  }
	
  public static void main(String[] args) {
    JFrame window = new JFrame();

    // create the event handler
    MouseEventHandler eventHandler = new MouseEventHandler();
		
    // add it to the window
    window.addMouseListener(eventHandler);
    window.addMouseMotionListener(eventHandler);
		
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(500, 500);
    window.setVisible(true);
  }
}

