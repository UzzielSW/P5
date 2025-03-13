// Exercise10_14.java: Display a pie chart
import java.awt.*;
import javax.swing.*;

public class Exercise10_14 extends JFrame {
  public static void main(String[] args) {
    JFrame frame = new Exercise10_14();
    frame.setSize(300, 300);
    frame.setTitle("Exercise 10.14");
    frame.setVisible(true);
  }
  
  public Exercise10_14() {
    getContentPane().add(new PieChart1());
  }
}

class PieChart1 extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    int w = getWidth();
    int h = getHeight();
    int xCenter = w / 2;
    int yCenter = h / 2;
    int radius = (int)(Math.min(w, h) * 0.8 / 2);
    int x = xCenter - radius;
    int y = yCenter - radius;
    
    // Draw the arc for projects
    g.setColor(Color.red);
    g.fillArc(x, y, 2 * radius, 2 * radius, 0, (int)(20 * 360 / 100));
    g.setColor(Color.black);
    g.drawString("Projects -- 20%",
    (int)(xCenter + radius*Math.cos(2 * Math.PI * 0.1)),
    (int)(yCenter - radius*Math.sin(2 * Math.PI * 0.1)));
    
    // Draw the arc for quizzes
    g.setColor(Color.green);
    g.fillArc(x, y, 2 * radius, 2 * radius, (int)(20 * 360 / 100),
    (int)(10 * 360 / 100));
    g.setColor(Color.black);
    g.drawString("Quizzes -- 20%",
    (int)(xCenter + radius * Math.cos(2 * Math.PI * 0.25)),
    (int)(yCenter - radius * Math.sin(2 * Math.PI * 0.25)));
    
    // Draw the arc for midterm exams
    g.setColor(Color.blue);
    g.fillArc(x, y, 2 * radius, 2 * radius, (int)(30*360/100),
      (int)(30 * 360 / 100));
    g.setColor(Color.black);
    g.drawString("Midterms -- 20%",
      (int)(xCenter + radius*Math.cos(2 * Math.PI * 0.45)) - 40,
      (int)(yCenter - radius*Math.sin(2 * Math.PI * 0.45)));
    
    // Draw the arc for the final exam
    g.setColor(Color.white);
    g.fillArc(x, y, 2 * radius, 2 * radius, (int)(60 * 360 / 100),
      (int)(40 * 360 / 100));
    g.setColor(Color.black);
    g.drawString("Final -- 40%",
      (int)(xCenter + radius*Math.cos(2 * Math.PI * 0.8)),
      (int)(yCenter - radius*Math.sin(2 * Math.PI * 0.8)));
  }
}