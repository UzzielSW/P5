// RandomCharacter.java: Generate random characters
public class RandomCharacter {
  /** Main method */
  public static void main(String args[]) {
    final int NUM_OF_CHARS = 175;
    final int CHARS_PER_LINE = 25;
    
    // Print random characters between '!' and '~', 25 chars per line
    for (int i = 0; i < NUM_OF_CHARS; i++) {
      if ((i + 1) % CHARS_PER_LINE == 0) 
        System.out.println(getRandomChar('!', '~'));
      else
        System.out.print(getRandomChar('!', '~') + " ");
    }
  }
  
  /** Generate a random character between fromChar and toChar */
  public static char getRandomChar(char fromChar, char toChar) {
    // Get the Unicode of the character
    int unicode = fromChar + 
      (int)((toChar - fromChar + 1) * Math.random());
    
    // Return the character
    return (char)unicode;
  }
  
  /** Generate a random character */
  public static char getRandomChar() {
    return getRandomChar('\u0000', '\uFFFF');
  }
}