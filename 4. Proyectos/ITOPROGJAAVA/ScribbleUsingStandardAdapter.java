// ScribbleUsingStandardAdapter.java: 
// Create a frame to test window events
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class ScribbleUsingStandardAdapter extends JApplet {
  /** Main method */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Scribbling Demo");

    // Create an instance of the applet
    ScribbleUsingStandardAdapter applet =
      new ScribbleUsingStandardAdapter();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /** Initialize the applet */
  public void init() {
    // Create a PaintPanel and add it to the applet
    getContentPane().add(new ScribblePanelUsingStandardAdapter(),
      BorderLayout.CENTER);
  }
}

// ScribblePanelUsingStandardAdapter for scribbling using the mouse
class ScribblePanelUsingStandardAdapter extends JPanel {
  final int CIRCLESIZE = 20; // Circle diameter used for erasing
  private Point lineStart = new Point(0, 0); // Line start point
  private Graphics g; // Create a Graphics object for drawing

  public ScribblePanelUsingStandardAdapter() {
    // Register listener for the mouse event
    addMouseListener(new MouseListenerAdapter(this));
    addMouseMotionListener(new MouseMotionListenerAdapter(this));
  }

  public void mousePressed(MouseEvent e) {
    lineStart.move(e.getX(), e.getY());
  }

  public void mouseDragged(MouseEvent e) {
    g = getGraphics(); // Get graphics context

    if (e.isMetaDown()) { // Detect right button pressed
      // Erase the drawing using an oval
      g.setColor(getBackground());
      g.fillOval(e.getX() - (CIRCLESIZE / 2),
         e.getY() - (CIRCLESIZE / 2), CIRCLESIZE, CIRCLESIZE);
    }
    else {
      g.setColor(Color.black);
      g.drawLine(lineStart.x, lineStart.y,
        e.getX(), e.getY());
    }

    lineStart.move(e.getX(), e.getY());

    // Dispose this graphics context
    g.dispose();
  }
}

/** Standard adapter for mouse pressed */
class MouseListenerAdapter extends MouseAdapter {
  ScribblePanelUsingStandardAdapter adaptee;

  MouseListenerAdapter(ScribblePanelUsingStandardAdapter adaptee) {
    this.adaptee = adaptee;
  }

  public void mousePressed(MouseEvent e) {
    adaptee.mousePressed(e);
  }
}

/** Standard adapter for mouse dragged */
class MouseMotionListenerAdapter extends MouseMotionAdapter {
  ScribblePanelUsingStandardAdapter adaptee;

  MouseMotionListenerAdapter(ScribblePanelUsingStandardAdapter
    adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseDragged(MouseEvent e) {
    adaptee.mouseDragged(e);
  }
}