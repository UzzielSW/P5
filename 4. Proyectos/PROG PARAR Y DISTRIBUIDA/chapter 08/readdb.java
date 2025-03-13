// readdb.java
import java.sql.*;
class p10{
public static void main(String a[]){
try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:test");
   Statement st=con.createStatement();	
   ResultSet rs=st.executeQuery("Select *from address");
    while(rs.next()){
     System.out.print(rs.getString(1));
     System.out.print("\t\t\t");
     System.out.print(rs.getString(2));
     System.out.print("\n");     }
  con.close();	
  }catch(Exception e){System.out.println("Exception :-" +e);} }}
