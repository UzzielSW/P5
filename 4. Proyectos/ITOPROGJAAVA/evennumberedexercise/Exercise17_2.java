// Exercise17_2.java: Count characters, words, and lines in a file
import java.io.*;

public class Exercise17_2 {
  public static void main(String args[]) {
    // Declare input and output file streams
    FileReader in = null;
    FileWriter out = null;

    int charCount = 0, wordCount = 0, lineCount = 0;
    boolean newWord = true, newLine = false;

    // Check usage
    if (args.length !=1) {
      System.out.println("Usage: java Exercise17_2 file");
      System.exit(0);
    }

    try {
      // Create file input stream
      in = new FileReader(new File(args[0]));

      int r;

      while ((r = in.read()) != -1) {
        charCount++;
        if ((char)r == '\n') {
          lineCount++;
          newLine = true;
        }
        else
          newLine = false;

        if (((r == ' ') || (r == '\n') || (r == '\t')) && !newWord)
          newWord = true;
        if ((r != ' ') && (r != '\n') && (r!= '\t') && newWord) {
          newWord = false;
          wordCount++;
        }
      }

      if (!newLine) lineCount++;

      System.out.println("File " + args[0] + " has \n" + charCount +
        " characters, \n" + wordCount + " words, and \n" + lineCount
        + " lines.");
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found: " + args[0]);
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    finally {
      try {
        // Close files
        if (in != null) in.close();
        if (out != null) out.close();
      }
      catch (IOException ex) {}
    }
  }
}