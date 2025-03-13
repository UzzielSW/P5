// KeyboardEventDemo.java: Receive key input
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardEventDemo extends JFrame {
	
  private KeyboardPanel keyboardPanel = new KeyboardPanel();

  /** Main method used if run as an application */
  
  public static void main(String[] args) {
  
    // Create a frame
    JFrame frame = new JFrame("KeyboardEvent Demo");

    // Create an instance of the applet
    KeyboardEventDemo applet = new KeyboardEventDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("KeyboardEventDemo");
	Color fondo =  new Color(0,192,255);
	applet.setBackground(fondo);
	
    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
    frame.setVisible(true);

    // Set focus on the keyboardPanel
    applet.focus();
  }

  /** Set focus on the panel */
  public void focus() {
    // It is required for receiving key input
    keyboardPanel.requestFocus();
  }
}

// KeyboardPanel for receiving key input
class KeyboardPanel extends JPanel implements KeyListener {
  private int x = 100;
  private int y = 100;
  private char keyChar = 'A'; // Default key

  public KeyboardPanel() {
    addKeyListener(this); // Register listener
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_DOWN: y += 10; break;
      case KeyEvent.VK_UP: y -= 10; break;
      case KeyEvent.VK_LEFT: x -= 10; break;
      case KeyEvent.VK_RIGHT: x += 10; break;
      default: keyChar = e.getKeyChar();
    }

    repaint();
  }

  /** Draw the character */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
    g.drawString(String.valueOf(keyChar), x, y);
  }

  /** Override this method to enable keyboard focus */
  public boolean isFocusTraversable() {
    return true;
  }
  
 
}