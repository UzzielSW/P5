package moreguiprogramming;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDialogDemo {
  JDialog dialog;
  JPanel dialogPanel;
  JButton button;
  JLabel label;
	
  JDialogDemo(JFrame window) {
    dialog = new JDialog(window);
    dialogPanel = new JPanel();
    button = new JButton("OK");
    label = new JLabel("Game has ended");

    // this removes the dialog box when its OK button is clicked
    button.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
        dialog.dispose();//removes the dialog box
      }
    });

    dialogPanel.add(label);
    dialogPanel.add(button);
    dialog.setSize(150, 80);
    dialogPanel.setBackground(Color.yellow);
    dialog.setUndecorated(true);
    dialog.setContentPane(dialogPanel);
    dialog.setVisible(true);
  }
	
  public static void main(String[] args) {
    final JFrame window = new JFrame();
    JPanel topPanel = new JPanel(new BorderLayout());		
    JButton dialogButton = new JButton("Click me");	
		
    // creates a dialog box when this button is clicked 
    dialogButton.addActionListener(new ActionListener() {		
      public void actionPerformed(ActionEvent e) {
        new JDialogDemo(window);
      }
    });
		
    JTextField textField = new JTextField();
    topPanel.add(textField, BorderLayout.CENTER);
    topPanel.add(dialogButton, BorderLayout.NORTH);
    window.setContentPane(topPanel);
    window.setSize(500, 500);
    window.setTitle("JDialog Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
