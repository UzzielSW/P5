import java.rmi.*;
import java.net.*;
import java.util.*;
import java.io.*;


class RmiClient{
	
public static void main(String args[])
{
	
  		
  try{
  	String ip=" ";
  	String data,temp,t1,t2,t3,t4,t5;
  	
	InetAddress net=InetAddress.getLocalHost();
  	System.out.println("The client "+ net +" is started");
  	
  	DataInputStream user_input=new DataInputStream(System.in);
	System.out.print("\nEnter Your user name: ");
	temp=user_input.readLine();
	ip=net+", user: "+temp;
	RmiIntf im1=(RmiIntf)Naming.lookup("rmi://127.0.0.1/DB");
	String wel=im1.connect(ip);
	System.out.println(wel);
	   
  	boolean f;
	f=true;
	while(f){
	   System.out.print("\nEnter Your Choice Insert- i, Delete- d, Select- s, Exit- e :");
	   temp=user_input.readLine();
	   
	   RmiIntf im=(RmiIntf)Naming.lookup("rmi://127.0.0.1/DB");
	  
	  if (temp.equals("i")){
	  	
			System.out.print("Enter the Employee  code		:");
			t1=user_input.readLine();
			System.out.print("Enter the Employee  Name		:");
			t2=user_input.readLine();
			System.out.print("Enter the Employee  Salar		:");
			t3=user_input.readLine();
			System.out.print("Enter the Employee  Disignation	:");
			t4=user_input.readLine();
			System.out.print("Enter the Employee  Age		:");
			t5=user_input.readLine();
			String s1=im.insert("insert into one values("+t1+",'"+t2+"',"+t3+",'"+t4+"',"+t5+");",ip); 
			System.out.println(s1);}
	  	
	  else if(temp.equals("s")){		
		String s=im.select(ip);
		System.out.println(s);}
		
	  else if (temp.equals("d")) {
	 		System.out.print("\nEnter the Employee  code to delete :");
			temp=user_input.readLine();
			String s2=im.delete("delete from one where ecode="+temp,ip); 			
			System.out.println(s2);		}
			
	 	else if(temp.equals("e")){
	 		String dis=im.disconnect(ip);
	 		f=false;}
	 	else
	 		System.out.println("Wrong input given......"); 
		}
		
		
     } catch(Exception e1){System.out.println(e1);}
   }
  }
