// TestFontMetrics.java: Draw a message at the center of a panel
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.*;

public class TestFontMetrics extends JFrame {
  /** Default constructor */
  public TestFontMetrics() {
    MessagePanel messagePanel = new MessagePanel("Welcome to Java");

    // Set font SansSerif 20-point bold
    messagePanel.setFont(new Font("SansSerif", Font.BOLD, 20));

    // Center the message
    messagePanel.setCentered(true);
    
    getContentPane().add(messagePanel);
  }

  /** Main method */
  public static void main(String[] args) {
    TestFontMetrics frame = new TestFontMetrics();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setTitle("TestFontMetrics");
    frame.setVisible(true);
  }
}