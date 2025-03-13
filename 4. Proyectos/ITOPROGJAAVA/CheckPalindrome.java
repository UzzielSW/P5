// CheckPalindrome.java: Check whether a string is a palindrome
import javax.swing.JOptionPane;

public class CheckPalindrome {
  /** Main method */
  public static void main(String[] args) {
    // Prompt the user to enter a string
    String s = JOptionPane.showInputDialog(null, 
      "Enter a string:", "Example 7.1 Input", 
      JOptionPane.QUESTION_MESSAGE);

    // Declare and initialize output string
    String output = "";

    if (isPalindrome(s)) 
      output += s + " is a palindrome";
    else 
      output += s + " is not a palindrome";
    
    // Display the result
    JOptionPane.showMessageDialog(null, output, 
      "Example 7.1 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }

  /** Check if a string is a palindrome */
  public static boolean isPalindrome(String s) {
    // The index of the first character in the string
    int low = 0;

    // The index of the last character in the string
    int high = s.length() - 1;

    while (low < high) {
      if (s.charAt(low) != s.charAt(high))
        return false; // Not a palindrome

      low++;
      high--;
    }

    return true; // The string is a palindrome
  }
}