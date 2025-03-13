// Exercise7_4.java: Check whether the first string is a substring
// of the second string
import javax.swing.JOptionPane;

public class Exercise7_4 {
  public static void main(String[] args) {
    // Prompt the user to enter two strings
    String first = JOptionPane.showInputDialog(
      null, "Enter the first string:",
      "Exercise7_4 Input", JOptionPane.QUESTION_MESSAGE);
    
    String second = JOptionPane.showInputDialog(
      null, "Enter the second string:",
      "Exercise7_4 Input", JOptionPane.QUESTION_MESSAGE);

    if (isSubstring(first, second)) {
      System.out.println(first + " is a substring of " + second);
    }
    else {
      System.out.println(first + " is not a substring of " + second);
    }
  }

  /**Check if the first string is a substring of the second string*/
  public static boolean isSubstring(String first, String second) {
    int remainingLength = second.length();
    int startingIndex = 0;

    // Note toWhile is a label. You can use break with a label
    // attached.
    toWhile: while (first.length() <= remainingLength) {
      // What is wrong if the following line is used
      // for (int i=startingIndex; i<=first.length(); i++)
      for (int i = 0; i < first.length(); i++) {
        if (first.charAt(i) != second.charAt(startingIndex+i)) {
          startingIndex++;
          remainingLength--;
          continue toWhile;
        }
      }

      return true;
    }

    return false;
  }
}