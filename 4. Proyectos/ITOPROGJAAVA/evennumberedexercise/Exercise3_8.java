// Exercise3_8.java: Print a pattern
public class Exercise3_8 {
  public static void main(String[] args) {
    int number = 0; // Number to print

    for (int row = 0; row <= 7; row++) {
      // Pad leading blanks
      for (int col = 1; col <= 7 - row; col++)
        System.out.print("     ");

      // Print left half of the row
      for (int col = 0; col <= row; col++) {
        number = (int)Math.pow(2, col);

        // You can write a method in Chapter 4 for this section
        if (number > 100) {
          System.out.print("  " + number);
        }
        else if (number > 10) {
          System.out.print("   " + number);
        }
        else {
          System.out.print("    " + number);
        }
      }

      // Print the right half of the row
      for (int col = row - 1; col >= 0; col--) {
        number = (int)Math.pow(2, col);

        // You can write a method in Chapter 4 for this section
        if (number > 100) {
          System.out.print("  " + number);
        }
        else if (number > 10) {
          System.out.print("   " + number);
        }
        else {
          System.out.print("    " + number);
        }
      }

      // Start a new line
      System.out.print('\n');
    }
  }
}