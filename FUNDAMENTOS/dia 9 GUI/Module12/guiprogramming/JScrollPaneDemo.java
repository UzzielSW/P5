package guiprogramming;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JScrollPaneDemo {
  private JTextField textField;
  private JFrame window;
  private JPanel topPanel;
  private JRadioButton rbutton1;
  private JRadioButton rbutton2;

  public JScrollPaneDemo() {
    window = new JFrame();
    topPanel = new JPanel(new BorderLayout());
    textField = new JTextField();
		
    // create the radio buttons and put them in a group
    rbutton1 = new JRadioButton("true");
    rbutton2 = new JRadioButton("false");
    ButtonGroup group = new ButtonGroup();
    group.add(rbutton1);
    group.add(rbutton2);

    // item listeners for the radio buttons
    rbutton1.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
      if( ((JRadioButton) e.getSource()).isSelected())
        textField.setText("That is correct!");
      }
    });
		
    rbutton2.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if( ((JRadioButton) e.getSource()).isSelected())
          textField.setText("That is incorrect!");
        }
      });
		
  // add radioButtonPanel and textField using border layout
  JPanel radioButtonPanel = new JPanel();
  radioButtonPanel.add(new JLabel("Java is a programming language and the name of an island"));
  radioButtonPanel.add(rbutton1);
  radioButtonPanel.add(rbutton2);
    topPanel.add(radioButtonPanel, BorderLayout.CENTER);
    topPanel.add(textField, BorderLayout.SOUTH);
	
    // create the scroll pane and add topPanel to it
    JScrollPane scrollPane = new JScrollPane(topPanel);
		
    // add the scroll pane to the content pane
    window.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
    window.setSize(100, 100);
    window.setTitle("JScrollPane Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
  public static void main(String[] args) {
    new JScrollPaneDemo();
  }
}



