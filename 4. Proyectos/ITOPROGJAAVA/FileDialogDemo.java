// FileDialogDemo.java: Demonstrate using JFileDialog to display
// file dialog boxes for opening and saving files
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class FileDialogDemo extends JFrame
  implements ActionListener {
  // Menu items Open, Save, exit, and About
  private JMenuItem jmiOpen, jmiSave,jmiExit, jmiAbout;

  // Text area for displaying and editing text files
  private JTextArea jta = new JTextArea();

  // Status label for displaying operation status
  private JLabel jlblStatus = new JLabel();

  // File dialog box
  private JFileChooser jFileChooser = new JFileChooser();

  /** Main method */
  public static void main(String[] args) {
    FileDialogDemo frame = new FileDialogDemo();
    frame.setSize(300, 150);
    frame.setVisible(true);
  }

  public FileDialogDemo() {
    setTitle("Test JFileChooser");

    // Create a menu bar mb and attach to the frame
    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);

    // Add a "File" menu in mb
    JMenu fileMenu = new JMenu("File");
    mb.add(fileMenu);

    //add a "Help" menu in mb
    JMenu helpMenu = new JMenu("Help");
    mb.add(helpMenu);

    // Create and add menu items to the menu
    fileMenu.add(jmiOpen = new JMenuItem("Open"));
    fileMenu.add(jmiSave = new JMenuItem("Save"));
    fileMenu.addSeparator();
    fileMenu.add(jmiExit = new JMenuItem("Exit"));
    helpMenu.add(jmiAbout = new JMenuItem("About"));

    // Set default directory to the current directory
    jFileChooser.setCurrentDirectory(new File("."));

    // Set BorderLayout for the frame
    getContentPane().add(new JScrollPane(jta), 
      BorderLayout.CENTER);
    getContentPane().add(jlblStatus, BorderLayout.SOUTH);

    // Register listeners
    jmiOpen.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiAbout.addActionListener(this);
    jmiExit.addActionListener(this);
  }

  /** Handle ActionEvent for menu items */
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    
    if (e.getSource() instanceof JMenuItem) {
      if ("Open".equals(actionCommand))
        open();
      else if ("Save".equals(actionCommand))
        save();
      else if ("About".equals(actionCommand))
        JOptionPane.showMessageDialog(this,
          "Demonstrate Using File Dialogs",
          "About This Demo",
          JOptionPane.INFORMATION_MESSAGE);
      else if ("Exit".equals(actionCommand))
        System.exit(0);
    }
  }

  /** Open file */
  private void open() {
    if (jFileChooser.showOpenDialog(this) ==
      JFileChooser.APPROVE_OPTION) {
      open(jFileChooser.getSelectedFile());
    }
  }

  /** Open file with the specified File instance */
  private void open(File file) {
    try {
      // Read from the specified file and store it in jta
      BufferedInputStream in = new BufferedInputStream(
        new FileInputStream(file));
      byte[] b = new byte[in.available()];
      in.read(b, 0, b.length);
      jta.append(new String(b, 0, b.length));
      in.close();

      // Display the status of the Open file operation in jlblStatus
      jlblStatus.setText(file.getName() + " Opened");
    }
    catch (IOException ex) {
      jlblStatus.setText("Error opening " + file.getName());
    }
  }

  /** Save file */
  private void save() {
    if (jFileChooser.showSaveDialog(this) ==
      JFileChooser.APPROVE_OPTION) {
      save(jFileChooser.getSelectedFile());
    }
  }

  /** Save file with specified File instance */
  private void save(File file) {
    try {
      // Write the text in jta to the specified file
      BufferedOutputStream out = new BufferedOutputStream(
        new FileOutputStream(file));
      byte[] b = (jta.getText()).getBytes();
      out.write(b, 0, b.length);
      out.close();

      // Display the status of the save file operation in jlblStatus
      jlblStatus.setText(file.getName()  + " Saved ");
    }
    catch (IOException ex) {
      jlblStatus.setText("Error saving " + file.getName());
    }
  }
}