// class PanelsDemo -- version 2
package guiprogramming;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.geom.*;

public class PanelsDemo {
  public static void main(String[] args) {
    JFrame window = new JFrame();
      
    // create three panels
    JPanel topPanel = new JPanel();
    JPanel panel1 = new JPanel();

   // draw graphics on drawingPanel
    JPanel drawingPanel = new JPanel() {
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D myGraphics = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Float(100, 100, 200, 200);
        myGraphics.draw(circle);
       }
    };

    // add panel1, panel2, drawingPanel to topPanel
    topPanel.add(panel1);
    topPanel.add(drawingPanel);

    // set topPanel as content pane for this window
    window.setContentPane(topPanel);
      
    // add two buttons to panel1
    JButton button1 = new JButton("Rectangle");
    panel1.add(button1);
    JButton button2 = new JButton("Circle");
    panel1.add(button2);
      
    // set the size of drawingPanel
    drawingPanel.setPreferredSize(new Dimension(400, 400));
       
    window.setSize(500, 500);
    window.setTitle("Panels Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

