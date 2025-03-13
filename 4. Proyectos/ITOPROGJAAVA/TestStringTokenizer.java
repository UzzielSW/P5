// TestStringTokenizer.java: Demonstrate StringTokenizer
import java.util.StringTokenizer;

public class TestStringTokenizer {
  /** Main method */
  public static void main(String[] args) {
    // Create a string and string tokenizer
    String s =
      "I am learning Java. Show me how to use StringTokenizer.";
    StringTokenizer st = new StringTokenizer(s);

    // Retrieve and display tokens
    System.out.println("The total number of words is " +
      st.countTokens());

    while (st.hasMoreTokens())
      System.out.println(st.nextToken());
  }
}