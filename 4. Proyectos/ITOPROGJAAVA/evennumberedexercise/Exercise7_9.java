public class Exercise7_9 {
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    System.out.println(sort("abcABDs"));
  }
  
  public static String sort(String s) {
    StringBuffer buffer = new StringBuffer(s);
    
    char currentMax;
    int currentMaxIndex;

    for (int i=buffer.length()-1; i>=1; i--) {
      // Find the maximum in the buffer[0..i]
      currentMax = buffer.charAt(i);
      currentMaxIndex = i;

      for (int j=i-1; j>=0; j--) {
        if (currentMax < buffer.charAt(j)) {
          currentMax = buffer.charAt(j);
          currentMaxIndex = j;
        }
      }

      // Swap buffer.charAt(i) with buffer[currentMaxIndex] if necessary;
      if (currentMaxIndex != i) {
        buffer.setCharAt(currentMaxIndex, buffer.charAt(i));
        buffer.setCharAt(i, currentMax);
      }
    }
    
    return buffer.toString();
  }
}