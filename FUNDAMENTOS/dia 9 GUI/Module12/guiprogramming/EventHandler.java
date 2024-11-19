package guiprogramming;
import javax.swing.*;
import java.awt.event.*;

public class EventHandler implements ActionListener {
  private SimplePanel drawingPanel;
	
  public EventHandler (SimplePanel p) {
    drawingPanel = p;
  }	
  public void actionPerformed(ActionEvent e) { 
    if (e.getActionCommand().equals("Rectangle")) {
      // draw rectangle, if Rectangle button was clicked
      drawingPanel.changeShape(1); 
    } else if (e.getActionCommand().equals("Circle")) {
      // draw circle, if Circle button was clicked
      drawingPanel.changeShape(2); 
    }
  }
}

