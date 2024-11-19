// class CustomPanel – version 2
package guiprogramming;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CustomPanel extends JPanel {
  private JPanel panel1;
  private SimplePanel drawingPanel;
  private JButton button1;
  private JButton button2;
	
  public CustomPanel() {
    setLayout(new BorderLayout());
    panel1 = new JPanel();
    drawingPanel = new SimplePanel();
		
    // create two buttons and add them to panel1
    button1 = new JButton("Rectangle");
    panel1.add(button1);
    button2 = new JButton("Circle");
    panel1.add(button2);

    // add panel1 and drawingPanel to this CustomPanel
    add(panel1, BorderLayout.NORTH);
    add(drawingPanel, BorderLayout.CENTER);	
  }
	
  public SimplePanel getDrawingPanel() {
    return drawingPanel;
  }
	
  public void registerEventHandler(ActionListener eventhandler) {
    button1.addActionListener(eventhandler);
    button2.addActionListener(eventhandler);
  }

  public static void main(String[] args) {  	
    JFrame window = new JFrame();
    CustomPanel mainPanel = new CustomPanel();

    // create the event handler
    EventHandler handler = new EventHandler(mainPanel.getDrawingPanel());

    // register the event handler
    mainPanel.registerEventHandler(handler);

    // set mainPanel as content pane for this window
    window.setContentPane(mainPanel);

    window.setSize(500, 500);
    window.setTitle("Event Handler Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}


