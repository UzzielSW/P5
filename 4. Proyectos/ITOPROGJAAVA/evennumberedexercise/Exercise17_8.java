// Exercise17_8.java: Displays a histogram that shows the occurence
// of each letter in a text file
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise17_8 extends JFrame implements ActionListener {
  int count[] = new int[26];
  private JTextField jtf = new JTextField(20);
  private Histogram display = new Histogram();

  public Exercise17_8() {
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Text File"), BorderLayout.WEST);
    p.add(jtf, BorderLayout.CENTER);

    display.setBorder(new LineBorder(Color.red, 1));

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p, BorderLayout.SOUTH);
    getContentPane().add(display, BorderLayout.CENTER);

    jtf.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    FileReader in = null;

    for (int i = 0; i<26; i++) {
      count[i] = 0;
    }

    try {
      // Create file input stream
      in = new FileReader(new File(jtf.getText().trim()));

      int r;

      while ((r = in.read()) != -1) {
        if ((r >= 65) && (r<=90)) {
          count[r-65]++;
        }
        else if ((r >= 97) && (r<=122)) {
          count[r-97]++;
        }
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found: " + jtf.getText().trim());
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    finally {
      try {
        if (in != null) in.close();
      }
      catch (IOException ex) {}
    }

    display.showHistogram(count);
  }

  public static void main (String[] args) {
    Exercise17_8 frame = new Exercise17_8();
    frame.setSize(500, 300);
    frame.setTitle("Exercise 17.8");
    frame.setVisible(true);
  }
}
