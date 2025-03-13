/**
 * Run
 * java CreateFileListing *
 * to generate an HTML file to list all the .java files
 */
import java.io.*;
public class CreateFileListing {
  public static void main(String[] args) {
    try  {
      BufferedWriter out = new BufferedWriter(new FileWriter("filelisting.html"));

      out.write("<html>\n");
      out.write("<head><title>Solution to Even-Numbered Exercises</title></head>\n");
      out.write("<body>\n");
      out.write("<h1>Download the solution to even-numbered exercises in the book<p>\n");
      out.write("<table border=\"1\" width=\"100%\">\n");

      int count = 0;

      for (int i=0; i<args.length; i++) {
        if (args[i].endsWith(".java") && !(args[i].equals("CreateFileListing.java")) ) {
          if (count%3 == 0)
            out.write("<tr>\n");

          out.write("<td width=\"33%\"><a href=\"" + args[i] + "\">" + args[i] + "</a></td>\n");
          count++;

          if (count%3 == 0)
            out.write("</tr>\n");
        }
      }

      out.write("</table>");
      out.write("</body></html>");
      out.close();
    }
    catch (Exception ex) {
    }
  }
}