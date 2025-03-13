import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.net.*;
import java.sql.*;

class RmiServer extends UnicastRemoteObject implements RmiIntf
{
	RmiServer()throws RemoteException{}

	public String connect(String ip)throws RemoteException{
	System.out.println("The system "+ip+ " has been connected");
     return "Hi " + ip+" welcome to the server..";    }

	public String disconnect(String ip)throws RemoteException{
	System.out.println("The system "+ip+ " is disconnected");
     return "Hi " + ip+" thank you";    }
     
   public String select(String ip)throws RemoteException{
	   String s1=" ";
	try{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   	  String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=net.mdb";
      Connection con=DriverManager.getConnection(url);
      
   	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from one");

	  while(rs.next())   {
		s1=s1+"\t"+rs.getString(1)+"\t"+rs.getString(2)+ "\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t\t\t\t\t";
	   } System.out.println(s1); 
		con.close();
	}catch(Exception e){ System.out.println("Error 1: " + e);}
     System.out.println("The system "+ip+ " has been viewed records");
     return s1;    }
   
   public String insert(String s,String ip)throws RemoteException{
   	try{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   	  String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=net.mdb";
      Connection con=DriverManager.getConnection(url);
      
   	  Statement st=con.createStatement();
	  st.executeUpdate(s);
	  con.close();
 	}catch(Exception e){ System.out.println("Error 1: " + e);}
   	System.out.println("The system "+ip+ " has been added record");
   	return "Your record saved";    	}
   	
   	public String delete(String s,String ip)throws RemoteException{
	try{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   	  String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=net.mdb";
      Connection con=DriverManager.getConnection(url);
   	  Statement st=con.createStatement();
	  st.executeUpdate(s);
	  con.close();
 	}catch(Exception e){ System.out.println("Error 1: " + e);}
   	System.out.println("The system "+ip+ " has been deleted record");
   	return "Your record deleted";   	}
	
public static void main(String args[]) {
try{
	String data,temp1,t1,t2,t3,t4,t5;
		
		InetAddress net=InetAddress.getLocalHost();
  		System.out.println("The server "+ net +" is started");
  		
	DataInputStream user_input=new DataInputStream(System.in);
	boolean f;
	f=true;
	while(f)
	{
		RmiServer rs=new RmiServer();
		Naming.rebind("rmi://127.0.0.1/DB",rs);
    } 
 	 }catch(Exception e){System.out.println("Runtime Error :"+e);}

    }}	