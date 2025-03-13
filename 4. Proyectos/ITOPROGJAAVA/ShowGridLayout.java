// ShowGridLayout.java: Demonstrate using GridLayout
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;

public class ShowGridLayout extends JFrame {
  /** Default constructor */
  public ShowGridLayout() {
    // Get the content pane of the frame
    Container container = getContentPane();

    // Set GridLayout, 4 rows, 3 columns, and gaps 5 between
    // components horizontally and vertically
    container.setLayout(new GridLayout(4, 3, 5, 5));

    // Add buttons to the frame
    for (int i = 1; i <= 10; i++)
      container.add(new JButton("Component " + i));
  }

  /** Main method */
  public static void main(String[] args) {
    ShowGridLayout frame = new ShowGridLayout();
    frame.setTitle("Show GridLayout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}