// ShowBorderLayout.java: Demonstrate using BorderLayout
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

public class ShowBorderLayout extends JFrame {
  /** Default constructor */
  public ShowBorderLayout() {
    // Get the content pane of the frame
    Container container = getContentPane();

    // Set BorderLayout with horizontal gap 5 and vertical gap 10
    container.setLayout(new BorderLayout(5, 10));

    // Add buttons to the frame
    container.add(new JButton("East"), BorderLayout.EAST);
    container.add(new JButton("South"), BorderLayout.SOUTH);
    container.add(new JButton("West"), BorderLayout.WEST);
    container.add(new JButton("North"), BorderLayout.NORTH);
    container.add(new JButton("Center"), BorderLayout.CENTER);
  }

  /** Main method */
  public static void main(String[] args) {
    ShowBorderLayout frame = new ShowBorderLayout();
    frame.setTitle("Show BorderLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}