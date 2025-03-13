// Exercise18_4.java: Retrieve remote files in applets.
// This program can also run as an application.
import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Exercise18_4 extends JApplet {
  // The author's Web site URL string for the input file
  private String urlString =
    // Get in.dat from a remote host
    // "http://www.cs.armstrong.edu/liang/intro3e/in.dat";
    // Get in.dat from the local file system
    "file:/C:\\jb4im\\exercise\\in.dat";

  // Declare a Java URL object
  private URL url;

  // The StreamTokenizer for parsing input
  private StreamTokenizer in;

  // The fields in the file
  private String sname = null;
  private double midterm1 = 0;
  private double midterm2 = 0;
  private double finalScore = 0;

  // Total score for a student
  private double total = 0;

  // Text area for displaying result
  JTextArea jta = new JTextArea(5, 10);

  // Initialize the applet
  public void init() {
    try {
      url = new URL(urlString);  // Create a URL
      InputStream is = url.openStream();  // Create a stream

      // Create streamtokenizer
      in = new StreamTokenizer(
        new BufferedReader(new InputStreamReader(is)));
    }
    catch (MalformedURLException ex) {
      System.out.println("Bad URL : " + url);
    }
    catch (IOException ex) {
      System.out.println("IO Error : " + ex.getMessage());
    }

    // Create a scroll pane and add text area to the scroll pane
    JScrollPane jsp = new JScrollPane(jta);

    // Add the scroll pane to the applet
    getContentPane().add(jsp);

    try {
      // Read first token
      in.nextToken();

      // Process a record
      while (in.ttype != in.TT_EOF) {
        // Get student name
        if (in.ttype == in.TT_WORD)
          sname = in.sval;
        else
          System.out.println("Bad file format");

        // Get midterm1
        if (in.nextToken() == in.TT_NUMBER)
          midterm1 = in.nval;
        else
          System.out.println("Bad file format");

        // Get midterm2
        if (in.nextToken() == in.TT_NUMBER)
          midterm2 = in.nval;
        else
          System.out.println("Bad file format");

        // Get final score
        if (in.nextToken() == in.TT_NUMBER)
          finalScore = in.nval;

        // Compute total score
        total = midterm1*0.3 + midterm2*0.3 + finalScore*0.4;

        // Display result
        jta.append(sname + " " + total + '\n');

        // Get the next token
        in.nextToken();
      }
    }
    catch (IOException ex) {
      System.out.println("IO Errors " + ex.getMessage());
    }
  }

  /**Run the applet as an application*/
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame(
      "Exercise 18.4: Read and Process Remote File");

    // Create an instance of the applet
    Exercise18_4 applet = new Exercise18_4();

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setVisible(true);
  }
}