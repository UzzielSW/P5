/**
 * Convert Java source code from the next-line brace style to the
 * end-of-line brace style. Invoke the program with
 * java Exercise17_12 Test.java
 * to convert the Java source file Test.java into the end-of-line
 * brace style.
 *
 * 5/18/01
 */
import java.util.*;
import java.io.*;

public class Exercise17_12 {
  static BufferedReader input;
  static BufferedWriter output;
  static StringBuffer buffer = new StringBuffer();
  static String lineSeparator =	(String)java.security.
    AccessController.doPrivileged(
    new sun.security.action.GetPropertyAction("line.separator"));
  static String filename = null;

  /**Main method*/
  public static void main(String[] args) {
    try {
      filename = args[0];
      input = new BufferedReader(new FileReader(filename));

      input = new BufferedReader(new FileReader(filename));
      format();
      output = new BufferedWriter(new FileWriter(filename));
      output.write(buffer.toString());
      output.close();
    }
    catch (Exception ex) {
    }
  }

  public static void format() {
   try {
      String line;
      buffer = new StringBuffer();

      boolean firstLine = true;

      while ((line = input.readLine()) != null) {
        if ((line.trim().length() > 0) && (line.trim().charAt(0) == '{')) {
          buffer.append(" {");

          String s = line.replace('{', ' ');
          if (s.trim().length() > 0) {
            buffer.append(lineSeparator);
            buffer.append(s);
            System.out.println("Alert: " + filename + " has stuff after {");
          }
        }
        else {
          if (firstLine)
            firstLine = false;
          else
            buffer.append(lineSeparator);

          buffer.append(line);
        }
      }
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
    finally {
      try {
        input.close();
      }
      catch (Exception ex) {
      }
    }
  }
}