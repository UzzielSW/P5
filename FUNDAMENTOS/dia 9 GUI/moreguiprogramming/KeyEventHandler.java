package moreguiprogramming;
import java.awt.event.*;
import javax.swing.*;

public class KeyEventHandler implements KeyListener {
  // displays the key code of the key that has been pressed
  public void keyPressed(KeyEvent e) {
    System.out.println("Key with keycode " +e.getKeyCode() +" pressed");
  }

  // displays the key code of the key that has been released	
  public void keyReleased(KeyEvent e) {
    System.out.println("Key with keycode " +e.getKeyCode() +" released");
  }

  // displays the key char of the key that has been pressed
  public void keyTyped(KeyEvent e) {
    System.out.println("Key with char " +e.getKeyChar() +" typed");
  }
	
  public static void main(String[] args) {
    JFrame window = new JFrame();
    JPanel panel = new JPanel();

    // create the event handler
    KeyEventHandler eventHandler = new KeyEventHandler();
		
    // make the panel focusable so it can receive keyboard events
    panel.setFocusable(true);
    panel.addKeyListener(eventHandler);

    window.setContentPane(panel);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(500, 500);
    window.setVisible(true);
  }
}
