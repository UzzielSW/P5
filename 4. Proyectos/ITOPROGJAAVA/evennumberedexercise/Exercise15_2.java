// Exercise15_2.java: Display a moving label
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise15_2 extends JApplet {
  public void init() {
    this.getContentPane().add(new MoveLabel());
  }

  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise 15.2: Move Label");

    // Create an instance of the applet
    Exercise15_2 applet = new Exercise15_2();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}

class MoveLabel extends JPanel implements Runnable, MouseListener {
  private int x = getSize().width;
  private int y = 40;
  private Thread thread;
  private boolean suspended = false;

  public MoveLabel() {
    thread = new Thread(this);
    thread.start();
    addMouseListener(this);
  }

  public void run() {
    while (true) {
      if (x < -20)
        x = getSize().width;
      else
        x -= 10;

      repaint();

      try {
        Thread.sleep(200);
        synchronized (this) {
          while (suspended)
            wait();
        }
      }
      catch (InterruptedException ex) {
      }
    }
  }

  public synchronized void resume() {
    if (suspended) {
      suspended = false;
      notify();
    }
  }

  public synchronized void suspend() {
    suspended = true;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawString("Welcom to Java!", x, y);
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
    suspend();
  }

  public void mouseReleased(MouseEvent e) {
    resume();
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }
}