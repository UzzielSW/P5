import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class DrawArc extends JPanel {

  public static void main(String[] args) {
    DrawArc jpanel = new DrawArc("DrawArc Test");
    JFrame jf = new JFrame();
    jf.getContentPane().add(jpanel, BorderLayout.CENTER);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.pack();
    jf.setLocationRelativeTo(null);
    jf.setVisible(true);
  }

  public JPanel arcPanel;

  Timer timer;

  public int reverse = 1;
  public boolean isOn = false;

  public DrawArc(String title) {
    setLayout(new BorderLayout());
    arcPanel = new ArcPanel();
    arcPanel.setBorder(new LineBorder(Color.BLACK, 1));
    add(arcPanel, BorderLayout.CENTER);

    TitledBorder border = new TitledBorder(title);
    border.setTitleColor(new Color(255, 140, 0));
    border.setBorder(new LineBorder(new Color(255, 140, 0), 1));
    setBorder(border);
    setBackground(Color.decode("#121212"));
    setPreferredSize(new Dimension(270, 270));
  }

  private class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }

  public void time(int speed) {
    if (speed >= 0) {
      timer = new Timer(speed, new TimerListener());
      timer.start();
    }
  }

  public void arcSpeed(int speed) {
    if (isOn) {
      if (timer != null) {
        timer.stop();
      }

      if (speed != 0) {
        time(100 - speed);
      }
    }
  }

  public void Power() {
    if (isOn) {
      timer.stop();
      isOn = false;
    } else {
      isOn = true;
    }
  }

  public void reverse() {
    reverse = -reverse;
  }

  class ArcPanel extends JPanel {

    public double currentTheta;

    public ArcPanel() {
      setBackground(Color.decode("#121212"));
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      Graphics2D g2d = (Graphics2D) g;
      currentTheta = currentTheta - 1;

      int xCenter = 0;
      int yCenter = 0;

      int radius = (int) (300 * 0.4) - 40;
      int x = xCenter - radius;
      int y = yCenter - radius;

      g2d.translate(this.getWidth() / 2, this.getHeight() / 2);

      g.setColor(Color.red);
      g.drawRect(-100, -100, 200, 200);

      g.setColor(Color.red);
      for (int i = -75; i <= 75; i += 25) {
        // Vertical Lines
        g.drawLine(i, 100, i, -100);

        // Horizontal Line
        g.drawLine(-100, i, 100, i);
      }

      // Fan blades orientation
      if (reverse < 0) {
        g2d.rotate(-currentTheta);
      } else if (reverse > 0) {
        g2d.rotate(currentTheta);
      }

      g.setColor(Color.decode("#050505"));
      g.fillArc(x - 5, y - 5, 2 * radius + 10, 2 * radius + 10, 0, 360);
      g.setColor(Color.decode("#1b1b1b"));
      g.fillArc(x, y, 2 * radius, 2 * radius, 0, 360);

      // elices
      g.setColor(Color.decode("#050505"));
      // g.setColor(Color.white);
      for (int i = 0; i <= 270; i += 90) {
        g.fillArc(x, y, 2 * radius, 2 * radius, i, 45);
      }
    }
  }

}
