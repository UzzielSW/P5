// CountEachLetter.java: Count letters in the string
import javax.swing.JOptionPane;

public class CountEachLetter {
  /** Main method */
  public static void main(String[] args) {
    // Prompt the user to enter a string
    String s = JOptionPane.showInputDialog(null, 
      "Enter a string:", "Example 7.2 Input", 
      JOptionPane.QUESTION_MESSAGE);
    
    // Invoke the countLetters method to count each letter
    int[] count = countLetters(s.toLowerCase());
    
    // Declare and initialize output string
    String output = "";

    // Display results
    for (int i = 0; i < count.length; i++) {
      if (count[i] != 0)
        output += (char)('a' + i) + " appears  " + 
          count[i] + ((count[i] == 1) ? " time\n" : " times\n");
    }
    
    // Display the result
    JOptionPane.showMessageDialog(null, output, 
      "Example 7.2 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }
  
  // Count each letter in the string
  public static int[] countLetters(String s) {
    int[] count = new int[26];
    
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i))) 
        count[(int)(s.charAt(i) - 'a')]++;
    }
    
    return count;
  }
}