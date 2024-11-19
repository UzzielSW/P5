package guiprogramming;
import javax.swing.*;
import java.awt.event.*;

public class JTextFieldDemo {
  private JTextField inputField;
  private JTextField displayField;
	
  public JTextFieldDemo() {
    // create text fields with 10 columns 
    inputField = new JTextField("Type here", 10); 
    displayField = new JTextField(10);
		
    // make displayField non-writable
    displayField.setEditable(false); 
		
    // attach an event handler to inputField
    inputField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //get the text entered in inputField and put it in displayField
        displayField.setText(inputField.getText());
      }
    });
		
    JFrame window = new JFrame();
    JPanel topPanel = new JPanel();
	  
    // add the text fields to topPanel
    topPanel.add(inputField);
    topPanel.add(displayField);
		
    window.setContentPane(topPanel);
   //window.pack();
    window.setTitle("JTextField Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(500,200);
 
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
	
  public static void main(String[] args) {
    new JTextFieldDemo();	
  }
}

