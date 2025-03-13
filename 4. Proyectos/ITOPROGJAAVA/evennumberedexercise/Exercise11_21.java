import javax.swing.*;

public class Exercise11_21 {
  /** Main method */
  public static void main(String[] args) {
    StringBuffer strBuf = new StringBuffer();
    
    for (int row = 1; row < 6; row++) {
      // Print leading spaces
      for (int column = 1; column < 6 - row; column++)
        strBuf.append(" ");

      // Print leading numbers
      for (int num = row; num >= 1; num--)
        strBuf.append(num);

      // Print ending numbers
      for (int num = 2; num <= row; num++)
        strBuf.append(num);

      // Start a new line
      strBuf.append("\n");
    }
    
    JOptionPane.showMessageDialog(null, strBuf.toString(),
      "Exercise 11.21: Result", JOptionPane.INFORMATION_MESSAGE);
  }
}