import java.awt.*;
import javax.swing.*;

public class Exercise10_21 extends JFrame {
  public Exercise10_21() {
    Container container = getContentPane();
    container.add(new Chessboard());
  }

  public static void main(String[] args) {
    Exercise10_21 frame = new Exercise10_21();
    frame.setTitle("Exercise 10.21");
    frame.setSize(400, 400);
    frame.setVisible(true);
  }
}

class Chessboard extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Fill in the code
    for (int y = 0; y<400; y+=20) {
      for (int x = 0; x<400; x+=20) {
        g.setColor(Color.white);
        g.fillRect(x, y, 20, 20);
        x +=20;
        g.setColor(Color.black);
        g.fillRect(x, y, 20, 20);
      }

      y +=20;
      for (int x = 0; x<400; x+=20) {
        g.setColor(Color.black);
        g.fillRect(x, y, 20, 20);
        x +=20;
        g.setColor(Color.white);
        g.fillRect(x, y, 20, 20);
      }
    }
  }
}