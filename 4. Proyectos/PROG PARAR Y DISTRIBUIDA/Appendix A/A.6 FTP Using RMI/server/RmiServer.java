import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.net.*;
import java.sql.*;

class RmiServer extends UnicastRemoteObject implements RmiIntf
{
	RmiServer()throws RemoteException{}
	String temp,data="";
	public String connect(String ip)throws RemoteException{
	System.out.println("The system "+ip+ " has been connected");
     return "Hi " + ip+" welcome to the server..";    }

	public String disconnect(String ip)throws RemoteException{
	System.out.println("The system "+ip+ " is disconnected");
     return "Hi " + ip+" thank you";    }
     
   public void upload(String fn,String fdata, String ip)throws RemoteException{
   	try{
		System.out.println("The system " + ip + " is uploaded " + fn +" file");	
		System.out.println("---------------------------------------------------------------");		
		System.out.println(fdata);		
		System.out.println("---------------------------------------------------------------");		
		FileWriter f=new FileWriter("download\\"+fn);
		f.write(fdata);
		f.close();
	}catch(Exception e){ System.out.println("Error 1: " + e);}
	}
   
   public String download(String fn,String ip)throws RemoteException{
   	System.out.println("The file "+fn+"\t is downloaded by "+ip);
   	try{
		BufferedReader file= new BufferedReader(new FileReader("download\\"+fn));
		temp=file.readLine();
		data=temp;
		while(temp != null)	{
			temp=file.readLine();
			data=data + "\n" + temp;
		}			
		   											
									
	file.close();							
 	}catch(Exception e){ System.out.println("Error 1: " + e);}
   	return data;    	}
   	
	
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
		Naming.rebind("rmi://127.0.0.1/FTP",rs);
    } 
 	 }catch(Exception e){System.out.println("Runtime Error :"+e);}

    }}	