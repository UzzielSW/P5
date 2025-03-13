// writedb.java
import java.io.*;
import java.sql.*;
class p11 {
public static void main(String a[]){
String name="",place="";
try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:test");
   Statement st=con.createStatement();
    DataInputStream in = new DataInputStream(System.in);
    System.out.println("Enter your name:");name = in.readLine();
    System.out.println("Enter your place:");place = in.readLine();
st.executeUpdate("insert into address values('"+name+"','"+place+"');");
     con.close();
   }catch(Exception e){System.out.println("Exception :-" +e);}
   System.out.println("Name	:"+name+"\n");
	  System.out.println("Place	:"+place+"\n");
  }}
