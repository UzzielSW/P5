/* WelcomeInMessageDialogBox.java: 
   This application program displays Welcome to Java!
   in a message dialog box. */
import javax.swing.JOptionPane;

public class WelcomeInMessageDialogBox { 
  public static void main(String[] args) { 
    // Display Welcome to Java! in a message dialog box
    JOptionPane.showMessageDialog(null, "Welcome to Java!",
      "Example 1.2 Output", JOptionPane.INFORMATION_MESSAGE);
    
    // Exit the program
    System.exit(0);
  }
}