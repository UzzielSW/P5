// Exercise12_10.java:
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise12_10 extends JApplet {
  KeyboardPanel c;

  public void init() {
    //create a panel to accept and display user input
    c = new KeyboardPanel();
    c.setBackground(Color.yellow);

    //place canvas c in the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(c, BorderLayout.CENTER);

    c.requestFocus();
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
      "Running a program as applet and frame");

    // Create an instance of MortgageApplet
    Exercise12_10 applet = new Exercise12_10();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setVisible(true);

    applet.c.requestFocus();
  }
}

class KeyboardPanel extends JPanel implements KeyListener {
  private int x = 100;
  private int y = 100;
  private char keyChar = 'A'; // Default key

  public KeyboardPanel() {
    addKeyListener(this); // Add listener

    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
      }
    });
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

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
    g.drawString(String.valueOf(keyChar), x, y);
  }
}