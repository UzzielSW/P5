package guiprogramming;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class CustomPanelAnonHandler extends JPanel {
  private JPanel panel1;
  private SimplePanel drawingPanel;
  JButton button1, button2;
			
  public CustomPanelAnonHandler() {
    setLayout(new BorderLayout());
    panel1 = new JPanel();
    drawingPanel = new SimplePanel();
			
    // create two buttons and add it to panel1
    button1 = new JButton("Rectangle");
    panel1.add(button1);
    button2 = new JButton("Circle");
    panel1.add(button2);
		
    // adding panel1, drawingPanel to CustomPanel
    this.add(panel1, BorderLayout.NORTH);
    this.add(drawingPanel, BorderLayout.CENTER);

    // add event handlers to buttons 1 and 2		
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        drawingPanel.changeShape(1);
      }
    });
			
    button2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        drawingPanel.changeShape(2);
      }
    });
  }

  public static void main(String[] args) {
    JFrame window = new JFrame("Custom panel demo");
    CustomPanelAnonHandler panel = new CustomPanelAnonHandler();
    window.setContentPane(panel);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(500, 500);
    window.setVisible(true);
  }
}
