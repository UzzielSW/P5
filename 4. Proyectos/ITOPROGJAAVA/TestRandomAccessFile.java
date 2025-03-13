// TestRandomAccessFile.java: Store and read data
// using RandomAccessFile
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TestRandomAccessFile extends JFrame {
  // Create a tabbed pane to hold two panels
  private JTabbedPane jtpStudent = new JTabbedPane();

  // Random access file for access the student.dat file
  private RandomAccessFile raf;

  /** Main method */
  public static void main(String[] args) {
    TestRandomAccessFile frame = new TestRandomAccessFile();
    frame.pack();
    frame.setTitle("Test RandomAccessFile");
    frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
   
  }

  /** Default constructor */
  public TestRandomAccessFile() {
    // Open or create a random access file
    try {
      raf = new RandomAccessFile("student.dat", "rw");
    }
    catch(IOException ex) {
      System.out.print("Error: " + ex);
      System.exit(0);
    }

    // Place buttons in the tabbed pane
    jtpStudent.add(new RegisterStudent(raf), "Register Student");
    jtpStudent.add(new ViewStudent(raf), "View Student");

    // Add the tabbed pane to the frame
    getContentPane().add(jtpStudent);
  }
}

// Register student panel
class RegisterStudent extends JPanel implements ActionListener {
  // Button for registering a student
  private JButton jbtRegister;
  private JButton jbtClear;

  // Student information panel
  private StudentPanel studentPanel;

  // Random access file
  private RandomAccessFile raf;

  public RegisterStudent(RandomAccessFile raf) {
    // Pass raf to RegisterStudent Panel
    this.raf = raf;

    // Add studentPanel and jbtRegister in the panel
    setLayout(new BorderLayout());
    add(studentPanel = new StudentPanel(),
      BorderLayout.CENTER);
      JPanel jPanSouth= new JPanel(); 
      jPanSouth.add(jbtRegister = new JButton("Register"));
      jPanSouth.add( jbtClear = new JButton("Clear"));
      add(jPanSouth,BorderLayout.SOUTH);
   
   // add(jbtRegister = new JButton("Register"),
    //  BorderLayout.SOUTH);
   // add(jbtClear = new JButton("Clear"),
   //   BorderLayout.SOUTH);
   
    // Register listener
    jbtRegister.addActionListener(this);
    jbtClear.addActionListener(this);
  }

  /** Handle button actions */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtRegister) {
      Student student = studentPanel.getStudent();

      try {
        raf.seek(raf.length());
        student.writeStudent(raf);
      }
      catch(IOException ex) {
        System.out.print("Error: " + ex);
      }
    }else if (e.getSource() == jbtClear) {
    	
    studentPanel.jtfName.setText(null);
    studentPanel.jtfStreet.setText(null);
    studentPanel.jtfCity.setText(null);
    studentPanel.jtfState.setText(null);
    studentPanel.jtfZip.setText(null);
    }
  }
}

// View student panel
class ViewStudent extends JPanel implements ActionListener {
  // Buttons for viewing student information
  private JButton jbtFirst, jbtNext, jbtPrevious, jbtLast;

  // Random access file
  private RandomAccessFile raf = null;

  // Current student record
  private Student student = new Student();

  // Create a student panel
  private StudentPanel studentPanel = new StudentPanel();

  // File pointer in the random access file
  private long lastPos;
  private long currentPos;

  public ViewStudent(RandomAccessFile raf) {
    // Pass raf to ViewStudent
    this.raf = raf;

    // Panel p to hold four navigator buttons
    JPanel p = new JPanel();
    p.setLayout(new FlowLayout(FlowLayout.LEFT));
    p.add(jbtFirst = new JButton("First"));
    p.add(jbtNext = new JButton("Next"));
    p.add(jbtPrevious = new JButton("Previous"));
    p.add(jbtLast = new JButton("Last"));

    // Add panel p and studentPanel to ViewPanel
    setLayout(new BorderLayout());
    add(studentPanel, BorderLayout.CENTER);
    add(p, BorderLayout.SOUTH);

    // Register listeners
    jbtFirst.addActionListener(this);
    jbtNext.addActionListener(this);
    jbtPrevious.addActionListener(this);
    jbtLast.addActionListener(this);
  }

  /** Handle navigation button actions */
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    if (e.getSource() instanceof JButton) {
      try {
        if ("First".equals(actionCommand)) {
          if (raf.length() > 0)
            retrieve(0);
        }
        else if ("Next".equals(actionCommand)) {
          currentPos = raf.getFilePointer();
          if (currentPos < raf.length())
            retrieve(currentPos);
        }
        else if ("Previous".equals(actionCommand)) {
          currentPos = raf.getFilePointer();
          if (currentPos > 0 )
          {
          
            retrieve(currentPos - 2*2*Student.RECORD_SIZE);
          }
        }
        else if ("Last".equals(actionCommand)) {
          lastPos = raf.length();
          if (lastPos > 0)
            retrieve(lastPos - 2*Student.RECORD_SIZE);
        }
      }
      catch(IOException ex) {
    JOptionPane.showMessageDialog(this, "No hay Registros antes del primero", "Error", JOptionPane.WARNING_MESSAGE);
        System.out.print("Error: " + ex);
      }
    }
  }

  /** Retrieve a record at specified position */
  public void retrieve(long pos) {
    try {
      raf.seek(pos);
      student.readStudent(raf);
      studentPanel.setStudent(student);
    }
    catch(IOException ex) {
      System.out.print("Error: " + ex);
    }
  }
}

// This class contains static methods for reading and writing
// fixed length records
class FixedLengthStringIO {
  // Read fixed number of characters from a DataInput stream
  public static String readFixedLengthString(int size,
    DataInput in) throws IOException {
    char c[] = new char[size];

    for (int i=0; i<size; i++)
      c[i] = in.readChar();

    return new String(c);
  }

  // Write fixed number of characters (string s with padded spaces)
  // to a DataOutput stream
  public static void writeFixedLengthString(String s, int size,
    DataOutput out) throws IOException {
    char cBuffer[] = new char[size];
    s.getChars(0, s.length(), cBuffer, 0);
    for (int i = s.length(); i < cBuffer.length; i++)
      cBuffer[i] = ' ';
    String newS = new String(cBuffer);
    out.writeChars(newS);
  }
}