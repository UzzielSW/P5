// TestMulTableUsingStringBuffer.java: Demonstrate string buffers
public class TestMulTableUsingStringBuffer {
  /** Main method */
  public static void main(String[] args) {
    // Create a string buffer
    StringBuffer strBuf = new StringBuffer();

    // Get start time
    long startTime = System.currentTimeMillis();

    // Append the title to the buffer
    strBuf.append("       Multiplication Table" + '\n');
    strBuf.append("---------------------------------" + '\n');

    // Append the number title to the buffer
    strBuf.append("  | ");
    for (int j = 1; j <= 9; j++)
      strBuf.append("  " + j);
    strBuf.append('\n');

    // Append multiplication table body to the buffer
    for (int i = 1; i <= 9; i++) {
      strBuf.append(i + " | ");
      for (int j = 1; j <= 9; j++) {
        if (i * j < 10)
          strBuf.append("  " + i * j);
        else
          strBuf.append(" " + i * j);
      }

      strBuf.append(" " + '\n');
    }

    // Print the string buffer
    System.out.println(strBuf);

    // Get end time
    long endTime = System.currentTimeMillis();
    System.out.println("Elapsed time is " + (endTime - startTime)
      + " milliseconds");
  }
}