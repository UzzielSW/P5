// ViewFile.java: Read a text file and store it in a text area
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ViewFile extends JFrame implements ActionListener {
  // Button to view view
  private JButton jbtView = new JButton("View");

  // Text field to receive file name
  private JTextField jtfFilename = new JTextField(12);

  // Text area to display file
  private JTextArea jtaFile = new JTextArea();

  // Obtain the system line separator
  static String lineSeparator = (String)java.security.
    AccessController.doPrivileged(
    new sun.security.action.GetPropertyAction("line.separator"));

  /** Main method */
  public static void main(String[] args) {
    ViewFile frame = new ViewFile();
    frame.setTitle("View File");
    frame.setSize(400, 300);
    frame.setVisible(true);
  }

  /**  Default constructor */
  public ViewFile() {
    // Panel p to hold a label, a text field, and a button
    Panel p = new Panel();
    p.setLayout(new BorderLayout());
    p.add(new Label("Filename"), BorderLayout.WEST);
    p.add(jtfFilename, BorderLayout.CENTER);
    jtfFilename.setBackground(Color.yellow);
    jtfFilename.setForeground(Color.red);
    p.add(jbtView, BorderLayout.EAST);

    // Add jtaFile to a scroll pane
    JScrollPane jsp = new JScrollPane(jtaFile);

    // Add jsp and p to the frame
    getContentPane().add(jsp, BorderLayout.CENTER);
    getContentPane().add(p, BorderLayout.SOUTH);

    // Register listener
    jbtView.addActionListener(this);
  }

  /** Handle the "View" button */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtView)
      showFile();
  }

  /** Display the file in the text area */
  private void showFile() {
    // Use a BufferedReader to read text from the file
    BufferedReader infile = null;

    // Get file name from the text field
    String filename = jtfFilename.getText().trim();

    String inLine;

    try {
      // Create a buffered stream
      infile = new BufferedReader(new FileReader(filename));

      // Read a line and append the line to the text area
      while ((inLine = infile.readLine()) != null) {
        jtaFile.append(inLine + lineSeparator);
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found: " + filename);
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    finally {
      try {
        if (infile != null) infile.close();
      }
      catch (IOException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }
}