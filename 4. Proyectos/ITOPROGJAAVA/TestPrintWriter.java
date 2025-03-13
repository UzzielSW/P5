// TestPrintWriter.java: Create a text file using PrintWriter
import java.io.*;

public class TestPrintWriter {
  /** Main method: args[0] is the output file */
  public static void main(String[] args) {
    // Declare print stream
    PrintWriter pw = null;

    // Check usage
    if (args.length != 1) {
      System.out.println("Usage: java TestPrintWriters file");
      System.exit(0);
    }

    File tempFile = new File(args[0]);

    if (tempFile.exists()) {
      System.out.println("The file " + args[0] +
        " already exists, delete it, rerun the program");
      System.exit(0);
    }

    // Write data
    try {
      // Create data output stream for tempFile
      pw = new PrintWriter(new FileOutputStream(tempFile), true);
      for (int i = 0; i < 10; i++)
        pw.print(" " + (int)(Math.random() * 1000));
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    finally {
      // Close files
      if (pw != null) pw.close();
    }
  }
}