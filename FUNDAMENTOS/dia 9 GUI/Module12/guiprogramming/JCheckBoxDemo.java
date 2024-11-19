package guiprogramming;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCheckBoxDemo  {	
  private JTextArea textArea;
  private JCheckBox checkbox1;
  private JCheckBox checkbox2;
	
  public JCheckBoxDemo() {
    JFrame window = new JFrame();
    JPanel topPanel = new JPanel(new BorderLayout());
    JPanel checkboxPanel = new JPanel();
		
    textArea = new JTextArea(10, 25);
    checkbox1 = new JCheckBox("Check box 1", false);	
    checkbox2 = new JCheckBox("Check box 2", false);
		
    // create and add the event handler to checkbox1
    checkbox1.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if(checkbox1.isSelected())
          textArea.append("Check box 1 is selected\n");
        else 
          textArea.append("Check box 1 is deselected\n");
      }
    });
		 
    // create and add the event handler to checkbox2
    checkbox2.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if(checkbox2.isSelected())
          textArea.append("Check box 2 is selected\n");
        else 
          textArea.append("Check box 2 is deselected\n");
      }
    });
		 
    // add the checkboxes to checkboxPanel
    checkboxPanel.add(checkbox1);
    checkboxPanel.add(checkbox2);
 
    // use border layout for topPanel
    topPanel.add(checkboxPanel, BorderLayout.NORTH);
    topPanel.add(textArea, BorderLayout.CENTER);

    window.setContentPane(topPanel);
    window.pack();
    window.setTitle("JCheckBox Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
	
  public static void main(String[] args) {
    new JCheckBoxDemo();
  }
} 
