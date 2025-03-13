// javadb.java
import java.sql.*;  // package for database connectivity
public class javadb extends java.awt.Frame {   
String name="",place="",s="", db="";
Connection con=null;
Statement st=null;
ResultSet rs=null;
    // Variables declaration - do not modify
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private java.awt.Button button8;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    // End of variables declaration
        /** Creates new form javadb using frame */
    public javadb() {
       initComponents(); // calling method to create commponents 
        setLayout(null);  // layout is null
        setSize(600,400);  // setting a frame size
        setTitle("Java DB");  // setting title of the frame
    }
public  void connect() throws Exception{
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  // loading the driver
// loading MS Access driver
 db=System.getProperty ("user.dir") + "\\test.mdb";
 String s = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + db;       
 con=DriverManager.getConnection(s);
// creating a statement with specific result set
st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
rs=st.executeQuery("select * from address"); //creating query
}
public  void disconnect() throws Exception{
 con.close(); // closing database connection
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {  // creating all the components
        button1 = new java.awt.Button();
        label1 = new java.awt.Label();
        textField1 = new java.awt.TextField();
        textField2 = new java.awt.TextField();
        label2 = new java.awt.Label();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        button6 = new java.awt.Button();
        button7 = new java.awt.Button();
        button8 = new java.awt.Button();
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(null);
        button1.setLabel("Save");
        button1.addActionListener(new java.awt.event.ActionListener() {  // adding an action event to button1
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt); 
            }
        });
        // adding componends on the frame with specific location
        add(button1); 
        button1.setBounds(200, 130, 50, 24);
        label1.setText("Name");
        add(label1);
        label1.setBounds(90, 50, 38, 20);
        textField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(textField1);
        textField1.setBounds(170, 50, 200, 20);
        add(textField2);
        textField2.setBounds(170, 90, 200, 20);
        label2.setText("Place");
        add(label2);
        label2.setBounds(90, 80, 38, 20);
        button2.setLabel("Update");
        button2.addActionListener(new java.awt.event.ActionListener() { // adding an action event to button2
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        add(button2);
        button2.setBounds(270, 130, 56, 24);
        button3.setLabel("Delete");
        button3.addActionListener(new java.awt.event.ActionListener() {// adding an action event to button3
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        add(button3);
        button3.setBounds(340, 130, 52, 24);
        button4.setLabel("Next");
        button4.addActionListener(new java.awt.event.ActionListener() {// adding an action event to button4
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        add(button4);
        button4.setBounds(270, 170, 57, 24);
        button5.setLabel("Previous");
        button5.addActionListener(new java.awt.event.ActionListener() {// adding an action event to button5
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        add(button5);
        button5.setBounds(200, 170, 57, 24);
        button6.setLabel("New");
        button6.addActionListener(new java.awt.event.ActionListener() {// adding an action event to button6
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        add(button6);
        button6.setBounds(130, 130, 57, 24);
        button7.setLabel("First");
        button7.addActionListener(new java.awt.event.ActionListener() {// adding an action event to button7
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        add(button7);
        button7.setBounds(130, 170, 50, 24);
        button8.setLabel("Last");
        button8.addActionListener(new java.awt.event.ActionListener() {// adding an action event to button8
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        add(button8);
        button8.setBounds(340, 170, 57, 24);
        pack();
    }// </editor-fold>
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {          
        System.exit(0);
    }                         
   private void button1ActionPerformed(java.awt.event.ActionEvent evt) {// an action event saving record
  try{
   connect();
    name = textField1.getText();
    place = textField2.getText();
    s="insert into address values('"+name+"','"+place+"')";
    setTitle("Record Saved");
    st.executeUpdate(s);
    disconnect();
   }catch(Exception e){ System.out.println(e);  }
    }
private void button2ActionPerformed(java.awt.event.ActionEvent evt) {// an action event updating record
try{
    connect();
    name = textField1.getText();
    place = textField2.getText();
s = "UPDATE address set name='" + name + "', place='" + place + "' where name='" + name + "'";
    setTitle("Record Updated");
    st.executeUpdate(s);
    disconnect();
    }catch(Exception e){ System.out.println(e);}
    }
private void button3ActionPerformed(java.awt.event.ActionEvent evt) {// an action event deleting record
try{
    connect();
    name = textField1.getText();
    s = "Delete from address where name='" + name + "'";
    setTitle("Record Deleted");
    st.executeUpdate(s);
    textField1.setText("");
    textField2.setText("");
    disconnect();
    }catch(Exception e){ System.out.println(e);}
    }
 private void button4ActionPerformed(java.awt.event.ActionEvent evt) {
// an action event selecting next records
  try{
    connect();
    rs.next();
    textField1.setText(rs.getString(1));
    textField2.setText(rs.getString(2));
    disconnect();
}catch(Exception e){ System.out.println(e);}
    }
private void button5ActionPerformed(java.awt.event.ActionEvent evt) {
// an action event selecting previous records
try{
    connect();
    rs.previous();
    textField1.setText(rs.getString(1));
    textField2.setText(rs.getString(2));
    disconnect();
    }catch(Exception e){ System.out.println(e);}
    }
private void button6ActionPerformed(java.awt.event.ActionEvent evt) {// an action event to clear textfields
 try{
    textField1.setText("");
    textField2.setText("");
    textField1.setFocusable(true);
    }catch(Exception e){ System.out.println(e);}
    }
private void button7ActionPerformed(java.awt.event.ActionEvent evt) {
// an action event selecting first record
 try{
    connect();
    rs.first();
    textField1.setText(rs.getString(1));
    textField2.setText(rs.getString(2));
    disconnect();
  }catch(Exception e){System.out.println(e);}
    }
private void button8ActionPerformed(java.awt.event.ActionEvent evt) {
// an action event selecting last record
  try{
    connect();
    rs.last();
    textField1.setText(rs.getString(1));
    textField2.setText(rs.getString(2));
    disconnect();
  }catch(Exception e){ System.out.println(e);
    }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new javadb().setVisible(true); // creating an object to the class javadb
            }
        });
    }
}
