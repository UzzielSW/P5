// dbcach.java
import java.io.*;
import java.sql.SQLException;
import sun.jdbc.rowset.CachedRowSet;
public class CachedRS {
//Constant to hold file name used to store the CachedRowSet
   private final static String CRS_FILE_LOC ="cachedrs.crs";
public static void main(String[] args) throws Exception {
     try {
          //Create serialized CachedRowSet
          writeCachedRowSet();
          //Create CachedRowSet from serialized object
          CachedRowSet crs = readCachedRowSet();
          //Display values
          while(crs.next()){
                    System.out.print("SSN: " + crs.getInt("ssn"));
                    System.out.print(", Name: " + crs.getString("name"));
                    System.out.print(", Salary: $" + crs.getDouble("salary"));
                    System.out.print(", HireDate: " + crs.getDate("hiredate"));
                    System.out.println();
          }
          //Close resource
          crs.close();
          }catch (SQLException se){
                    System.out.println(se);
          }catch (Exception ex) {
                    System.out.println(ex);
          }
}//end main
public static void writeCachedRowSet() throws Exception{
          //Instantiate a CachedRowSet object, set connection parameters
          CachedRowSet crs = new CachedRowSet();
          Class.forName("oracle.jdbc.driver.OracleDriver");
          crs.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
          crs.setUsername("username");
          crs.setPassword("password");
          //Set and execute the command. Notice the parameter query.
          String sql = "SELECT SSN, Name, Salary, Hiredate ";
          sql = sql + "FROM Employees WHERE SSN=?";
          crs.setCommand(sql);
          crs.setInt(1,111111111);
          crs.execute();
          //Serialize CachedRowSet object.
          FileOutputStream fos = new FileOutputStream(CRS_FILE_LOC);
          ObjectOutputStream out = new ObjectOutputStream(fos);
          out.writeObject(crs);
          out.close();
          crs.close();
          }//end writeCachedRowSet()
public static CachedRowSet readCachedRowSet() throws Exception{
          //Read serialized CachedRowSet object from storage
          FileInputStream fis = new FileInputStream(CRS_FILE_LOC);
          ObjectInputStream in = new ObjectInputStream(fis);
          CachedRowSet crs = (CachedRowSet)in.readObject();
          fis.close();
          in.close();
          return crs;
          }//end readCachedRowSet()
}//end CachedRS
