// DialogDemo.java: Use message dialog box to select information
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogDemo extends JFrame implements ActionListener {
  // Create sample student information in arrays
  // with name, SSN, password, and grade
  private String[][] student = {
     {"John Willow", "111223333", "a450", "A"},
     {"Jim Brown", "111223334", "b344", "B"},
     {"Bill Beng", "111223335", "33342csa", "C"},
     {"George Wall", "111223336", "343rea2", "D"},
     {"Jill Jones", "111223337", "34g", "E"}
    };

  // Declare text fields for last name, password, full name and score
  private JTextField jtfSSN;
  private JPasswordField jpfPassword;
  private JTextField jtfName;
  private JTextField jtfGrade;
  private JButton jbtFind;

  /** Main method */
  public static void main(String[] args) {
    DialogDemo frame = new DialogDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  /** Default constructor */
  public DialogDemo() {
    setTitle("Find The Score");

    // Panel jpLabels to hold labels
    JPanel jpLabels = new JPanel();
    jpLabels.setLayout(new GridLayout(4, 1));
    jpLabels.add(new JLabel("Enter SSN"));
    jpLabels.add(new JLabel("Enter Password"));
    jpLabels.add(new JLabel("Name"));
    jpLabels.add(new JLabel("Score"));

    // Panel jpTextFields to hold text fields and password
    JPanel jpTextFields = new JPanel();
    jpTextFields.setLayout(new GridLayout(4, 1));
    jpTextFields.add(jtfSSN = new JTextField(10));
    jpTextFields.add(jpfPassword = new JPasswordField(10));
    jpTextFields.add(jtfName = new JTextField(10));
    jpTextFields.add(jtfGrade = new JTextField(10));
    jtfName.setEditable(false);
    jtfGrade.setEditable(false);

    // Panel p1 for holding jpLabels and jpTextFields
    JPanel p1 = new JPanel();
    p1.setLayout(new BorderLayout());
    p1.add(jpLabels, BorderLayout.WEST);
    p1.add(jpTextFields, BorderLayout.CENTER);

    // Panel p2 for holding the Find button
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
    p2.add(jbtFind = new JButton("Find Score"));

    // Place panels into the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);

    // Register listener for jbtFind
    jbtFind.addActionListener(this);
  }

  /** Find a score */
  public void actionPerformed(ActionEvent e) {
    // Find the student in the database
    int index = find(jtfSSN.getText().trim(),
      new String(jpfPassword.getPassword()));

    if (index == -1) {
      JOptionPane.showMessageDialog(this, "SSN not found",
        "For Your Information", JOptionPane.INFORMATION_MESSAGE);
    }
    else if (index == -2) {
      JOptionPane.showMessageDialog(this,
        "Password does not match SSN",
        "For Your Information", JOptionPane.INFORMATION_MESSAGE);
    }
    else {
      // Display name and score
      jtfName.setText(student[index][0]);
      jtfGrade.setText(student[index][3]);
    }
  }

  /** Find the student who matched user name and password
     return the index if found; return -1 if SSN is not in
     the database, and return -2 if password does not match SSN */
  public int find(String SSN, String pw) {
    // Find a student who matches SSN and pw
    for (int i=0; i<student.length; i++)
      if (student[i][1].equals(SSN) && student[i][2].equals(pw))
        return i;

    // Determine if the SSN is in the database
    for (int i=0; i<student.length; i++)
      if (student[i][1].equals(SSN))
        return -2;

    // Return -1 since the SSN and pw do not match
    return -1;
  }
}