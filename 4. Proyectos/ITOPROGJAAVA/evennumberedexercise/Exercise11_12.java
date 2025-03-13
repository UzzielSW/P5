// Exercise11_12.java: Demonstrate TextField properties
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise11_12 extends JApplet {
  boolean isStandalone = false;
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField jtf = new JTextField();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JRadioButton jrbLeft = new JRadioButton();
  GridLayout gridLayout1 = new GridLayout();
  JRadioButton jrbCenter = new JRadioButton();
  JRadioButton jrbRight = new JRadioButton();
  TitledBorder titledBorder1;
  JLabel jLabel2 = new JLabel();
  JTextField jtfColumns = new JTextField();

  //Construct the applet
  public Exercise11_12() {
  }

  //Initialize the applet
  public void init() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.setSize(new Dimension(322, 197));
    jLabel1.setText("Text field");
    jrbLeft.setText("Left");
    jrbLeft.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        jrbLeft_actionPerformed(e);
      }
    });
    jPanel2.setLayout(gridLayout1);
    gridLayout1.setRows(2);
    jrbCenter.setText("Center");
    jrbCenter.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        jrbCenter_actionPerformed(e);
      }
    });
    jrbRight.setText("Right");
    jrbRight.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        jrbRight_actionPerformed(e);
      }
    });
    jPanel3.setBorder(titledBorder1);
    titledBorder1.setTitle("Horizontal Alignment");
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jLabel2.setText("Column Size");
    jtfColumns.setFont(new java.awt.Font("Monospaced", 1, 16));
    jtfColumns.setForeground(Color.red);
    jtfColumns.setColumns(10);
    jtfColumns.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        jtfColumns_actionPerformed(e);
      }
    });
    jtf.setFont(new java.awt.Font("Monospaced", 1, 16));
    jtf.setForeground(Color.red);
    jtf.setToolTipText("Demonstrate JTextField");
    jtf.setText("Type any thing");
    jtf.setColumns(10);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jtf, null);
    this.getContentPane().add(jPanel2, BorderLayout.SOUTH);
    jPanel2.add(jPanel3, null);
    jPanel3.add(jrbLeft, null);
    jPanel3.add(jrbCenter, null);
    jPanel3.add(jrbRight, null);
    jPanel2.add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    jPanel4.add(jtfColumns, null);
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  //Main method
  public static void main(String[] args) {
    Exercise11_12 applet = new Exercise11_12();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    frame.setTitle("Exercise 11.12");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }

  void jrbLeft_actionPerformed(ActionEvent e) {
    if (jrbLeft.isSelected()) {
      jtf.setHorizontalAlignment(SwingConstants.LEFT);
    }
  }

  void jrbCenter_actionPerformed(ActionEvent e) {
    if (jrbCenter.isSelected()) {
      jtf.setHorizontalAlignment(SwingConstants.CENTER);
    }
  }

  void jrbRight_actionPerformed(ActionEvent e) {
    if (jrbRight.isSelected()) {
      jtf.setHorizontalAlignment(SwingConstants.RIGHT);
    }
  }

  void jtfColumns_actionPerformed(ActionEvent e) {
    jtf.setColumns(
      (new Integer(jtfColumns.getText().trim()).intValue()));
    validate();
  }
}