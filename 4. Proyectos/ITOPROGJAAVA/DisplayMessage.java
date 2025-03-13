// DisplayMessage.java: Display a message on a panel in the applet
import javax.swing.*;

public class DisplayMessage extends JApplet {
  private String message = "A default message"; // Message to display
  private int x = 20; // Default x coordinate
  private int y = 20; // Default y coordinate

  /** Initialize the applet */
  public void init() {
    // Get parameter values from the HTML file
    message = getParameter("MESSAGE");
    x = Integer.parseInt(getParameter("X"));
    y = Integer.parseInt(getParameter("Y"));

    // Create a message panel
    MessagePanel messagePanel = new MessagePanel(message);
    messagePanel.setXCoordinate(x);
    messagePanel.setYCoordinate(y);

    // Add the message panel to the applet
    getContentPane().add(messagePanel);
  }
}