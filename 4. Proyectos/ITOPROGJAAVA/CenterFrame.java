// CenterFrame.java: Display a frame
import javax.swing.*;
import java.awt.*;

public class CenterFrame {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Centered Frame");
    frame.setSize(400, 300);

    // New in JDK 1.3 to exit the program upon closing
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Get the dimension of the screen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

    // Get the dimension of the frame
    Dimension frameSize = frame.getSize();
    int x = (screenWidth - frameSize.width)/2;
    int y = (screenHeight - frameSize.height)/2;

    frame.setLocation(x, y);
    frame.setVisible(true);
  }
}