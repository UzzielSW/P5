// WelcomeApplet.java: Applet for displaying a message
import java.awt.*;
import javax.swing.*;

public class WelcomeApplet extends JApplet {
  /** Initialize the applet */
  public void init() {
    getContentPane().add(new MessagePanel("Welcome to Java"));
  }
}