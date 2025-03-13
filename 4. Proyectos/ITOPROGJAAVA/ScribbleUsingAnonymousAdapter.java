// ScribbleUsingAnonymousAdapter.java: 
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class ScribbleUsingAnonymousAdapter extends JApplet {
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
    getContentPane().add(new ScribblePanelUsingAnonymousAdapter(),
      BorderLayout.CENTER);
  }
}

// ScribblePanelUsingAnonymousAdapter for scribbling using the mouse
class ScribblePanelUsingAnonymousAdapter extends JPanel {
  final int CIRCLESIZE = 20; // Circle diameter used for erasing
  private Point lineStart = new Point(0, 0); // Line start point
  private Graphics g; // Create a Graphics object for drawing

  public ScribblePanelUsingAnonymousAdapter() {
    // Register listener for the mouse event
    addMouseListener(
      // Anonymous adapter
      new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
          // Invoke the outer class's mousePressed method
          ScribblePanelUsingAnonymousAdapter.this.mousePressed(e);
        }
      }
    );

    addMouseMotionListener(
      // Anonymous adapter
      new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) {
          // Invoke the outer class's mouseDragged method
          ScribblePanelUsingAnonymousAdapter.this.mouseDragged(e);
        }
      }
    );
  }

  public void mousePressed(MouseEvent e) {
    lineStart.move(e.getX(), e.getY());
  }

  public void mouseDragged(MouseEvent e) {
    g = getGraphics(); // Get graphics context

    if (e.isMetaDown()) { // Detect right button pressed
      // Erase the drawing using an oval
      g.setColor(getBackground());
      g.fillOval(e.getX() - (CIRCLESIZE/2),
         e.getY() - (CIRCLESIZE/2), CIRCLESIZE, CIRCLESIZE);
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