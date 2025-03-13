// dbweb.java
import java.io.*;
import java.sql.SQLException;
import sun.jdbc.rowset.WebRowSet;

class WebRS {
        //Constant representing the XML file
        private static String WRS_FILE_LOC ="wrs.xml";
public final static void main(String[] args) throws Exception {
        try {
               //Instantiate a WebRowSet object
               WebRowSet wrs = new WebRowSet();
               //Load driver and set connection parameters
               Class.forName("oracle.jdbc.driver.OracleDriver");
               wrs.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
               wrs.setUsername("username");
               wrs.setPassword("mypwd");
               //Configure command and execute
               System.out.println("Connecting to data source and " + "generating XML document.");
               String sql = "SELECT ssn, name FROM Employees";
               wrs.setCommand(sql);
               wrs.execute();
               //Write XML out to file
               System.out.println("Writing XML to file: " + WRS_FILE_LOC);
               FileWriter fw = new FileWriter(WRS_FILE_LOC);
               wrs.writeXml(fw);
               fw.close();
               wrs.close();
               System.out.println("Finished writing XML file.");
               }catch (SQLException se){
                              System.out.println(se);
               }catch (Exception ex) {
                              System.out.println(ex);
               }
               System.out.println("Goodbye!");
       }//end main()
}//end WebRS class
