// TestDataStream.java: Create a file, store it in binary form, and
// display it on the console
import java.io.*;

public class TestDataStream {
  /** Main method */
  public static void main(String[] args) {
    // Declare data input and output streams
    DataInputStream dis = null;
    DataOutputStream dos = null;

    // Construct a temp file
    File tempFile = new File("mytemp.dat");

    // Check if the temp file exists
    if (tempFile.exists()) {
      System.out.println("The file mytemp.dat already exists,"
        + " delete it, rerun the program");
      System.exit(0);
    }

    // Write data
    try {
      // Create data output stream for tempFile
      dos = new DataOutputStream(new FileOutputStream(tempFile));
      for (int i = 0; i < 10; i++)
        dos.writeInt((int)(Math.random() * 1000));
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    finally {
      try {
        // Close files
        if (dos != null) dos.close();
      }
      catch (IOException ex) {
      }
    }

    // Read data
    try {
      // Create data input stream
      dis = new DataInputStream(new FileInputStream(tempFile));
      for (int i = 0; i < 10; i++)
        System.out.print("  " + dis.readInt());
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    finally {
      try {
        // Close files
        if (dis != null) dis.close();
      }
      catch (IOException ex) {
        System.out.println(ex);
      }
    }
  }
}