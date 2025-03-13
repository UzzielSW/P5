// MyFrameWithComponents.java: Add components into a frame
import javax.swing.*;

public class MyFrameWithComponents {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Adding Components into the Frame");

    // Add a button into the frame
    frame.getContentPane().add(new JButton("OK"));

    frame.setSize(400, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}