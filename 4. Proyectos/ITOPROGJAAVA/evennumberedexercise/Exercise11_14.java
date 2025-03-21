// Exercise11_14.java: Demonstrate List properties
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;

public class Exercise11_14 extends JApplet {
  boolean isStandalone = false;
  JScrollPane jScrollPane1 = new JScrollPane();
  JList jList1 = new JList();
  
  JPanel jpSelectionMode = new JPanel();
  JComboBox jcboSelectionMode = new JComboBox();
  JLabel jlblStatus = new JLabel();
  
  JLabel jLabel1 = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  
  // Create an array of strings for country names
  String[] countries = {"United States", "United Kingdom", "China",
  "Germany", "France", "Canada"};
  
  //Construct the applet
  public Exercise11_14() {
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
    this.setSize(new Dimension(400, 300));
    
    jList1.setListData(countries);
    jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        jList1_valueChanged(e);
      }
    });
    jpSelectionMode.setLayout(borderLayout1);
    jcboSelectionMode.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jcboSelectionMode_actionPerformed(e);
      }
    });
    jlblStatus.setText("Status");
    jLabel1.setText("Choose Selection Mode");
    this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jList1, null);
    this.getContentPane().add(jpSelectionMode, BorderLayout.NORTH);
    jpSelectionMode.add(jLabel1, BorderLayout.WEST);
    jpSelectionMode.add(jcboSelectionMode, BorderLayout.CENTER);
    this.getContentPane().add(jlblStatus, BorderLayout.SOUTH);
    
    // Add selection modes to the combo box
    jcboSelectionMode.addItem("SINGLE_SELECTION");
    jcboSelectionMode.addItem("SINGLE_INTERVAL_SELECTION");
    jcboSelectionMode.addItem("MULTIPLE_INTERVAL_SELECTION");
  }
  
  //Main method
  public static void main(String[] args) {
    Exercise11_14 applet = new Exercise11_14();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    frame.setTitle("Exercise 10.14");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }
  
  // Handler for selecting items from a combo box
  void jcboSelectionMode_actionPerformed(ActionEvent e) {
    String selectedMode =
    (String)jcboSelectionMode.getSelectedItem();
    
    if (selectedMode.equals("SINGLE_SELECTION"))
      jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    else if (selectedMode.equals("SINGLE_INTERVAL_SELECTION"))
      jList1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    if (selectedMode.equals("MULTIPLE_INTERVAL_SELECTION"))
      jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
  }
  
  // Handler for item selection in the list
  void jList1_valueChanged(ListSelectionEvent e) {
    int[] indices = jList1.getSelectedIndices();
    Object[] selectedItems = jList1.getSelectedValues();
    String display = "";
    
    for (int i=0; i<indices.length; i++) {
      display += (String)selectedItems[i] + " ";
    }
    
    jlblStatus.setText(display);
  }
}