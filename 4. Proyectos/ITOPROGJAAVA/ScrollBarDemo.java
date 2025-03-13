// ScrollBarDemo.java: Use scrollbars to move the message
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScrollBarDemo extends JFrame 
  implements AdjustmentListener {
  // Declare scrollbars
  JScrollBar jscbHort, jscbVert;

  // Declare a MessagePanel
  MessagePanel messagePanel;

  /** Main method */
  public static void main(String[] args) {
    ScrollBarDemo frame = new ScrollBarDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  /** Default constructor */
  public ScrollBarDemo() {
    setTitle("ScrollBar Demo");

    // Create a vertical scrollbar
    jscbVert = new JScrollBar();
    jscbVert.setOrientation(Adjustable.VERTICAL);

    // Create a horizontal scrollbar
    jscbHort = new JScrollBar();
    jscbHort.setOrientation(Adjustable.HORIZONTAL);

    // Add scrollbars and message panel to the frame
    messagePanel = new MessagePanel("Welcome to Java");
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(messagePanel, BorderLayout.CENTER);
    getContentPane().add(jscbVert, BorderLayout.EAST);
    getContentPane().add(jscbHort, BorderLayout.SOUTH);

    // Register listener for the scrollbars
    jscbHort.addAdjustmentListener(this);
    jscbVert.addAdjustmentListener(this);
  }

  /** Handle scrollbar adjustment actions */
  public void adjustmentValueChanged(AdjustmentEvent e) {
    if (e.getSource() == jscbHort) {
      // getValue() and getMaximumValue() return int, but for better
      // precision, use double
      double value = jscbHort.getValue();
      double maximumValue = jscbHort.getMaximum();
      double newX = 
        (value * messagePanel.getSize().width / maximumValue);
      messagePanel.setXCoordinate((int)newX);
      messagePanel.repaint();
    }
    else if (e.getSource() == jscbVert) {
      // getValue() and getMaximumValue() return int, but for better
      // precision, use double
      double value = jscbVert.getValue();
      double maximumValue = jscbVert.getMaximum();
      double newY = 
        (value * messagePanel.getSize().height / maximumValue);
      messagePanel.setYCoordinate((int)newY);
      messagePanel.repaint();
    }
  }
}