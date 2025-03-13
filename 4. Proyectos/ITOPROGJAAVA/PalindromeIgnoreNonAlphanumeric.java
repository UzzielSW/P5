// PalindromeIgnoreNonAlphanumeric.java
import javax.swing.JOptionPane;

public class PalindromeIgnoreNonAlphanumeric {
  /** Main method */
  public static void main(String[] args) {
    // Prompt the user to enter a string
    String s = JOptionPane.showInputDialog(null, 
      "Enter a string:", "Example 7.3 Input", 
      JOptionPane.QUESTION_MESSAGE);

    // Declare and initialize output string
    String output = "Ignoring non-alphanumeric characters, \nis "
      + s + " a palindrome? " + isPalindrome(s);

    // Display the result
    JOptionPane.showMessageDialog(null, output, 
      "Example 7.3 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }

  /** Return true if a string is a palindrome */
  public static boolean isPalindrome(String s) {
    // Create a new string by eliminating non-alphanumeric chars
    String s1 = filter(s);

    // Create a new string that is the reversal of s1
    String s2 = reverse(s1);

    // Compare if the reversal is the same as the original string
    return s2.equals(s1);
  }

  /** Create a new string by eliminating non-alphanumeric chars */
  public static String filter(String s) {
    // Create a string buffer
    StringBuffer strBuf = new StringBuffer();

    // Examine each char in the string to skip alphanumeric char
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetterOrDigit(s.charAt(i))) {
        strBuf.append(s.charAt(i));
      }
    }

    // Return a new filtered string
    return strBuf.toString();
  }

  /** Create a new string by reversing a specified string */
  public static String reverse(String s) {
    StringBuffer s1 = new StringBuffer(s);
    s1.reverse(); // Use the reverse method for StringBuffer object
    return s1.toString();
  }
}