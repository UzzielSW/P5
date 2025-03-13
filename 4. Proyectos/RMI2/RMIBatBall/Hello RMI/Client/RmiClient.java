// RmiClient.java
import java.rmi.*;
import java.io.*;

class RmiClient {
public static void main(String args[]){
try{
//RmiIntf im=(RmiIntf)Naming.lookup("rmi://10.129.50.20/call");
  RmiIntf im = (RmiIntf)Naming.lookup("rmi://127.0.0.1/call");
	     String s=im.call();
	     System.out.println(s);
	   
	   
	    System.out.print("Enter para Terminar: ");
	    String text= capturaEdad();
	   
		  
	     
	}catch(Exception e1){System.out.println(e1);}
}

	public static String capturaEdad() throws IOException
		{
		
		 InputStreamReader reader = new InputStreamReader(System.in);
		 BufferedReader input = new BufferedReader(reader);
	
		 
		 String  text  = input.readLine();
		
		 return (text);
		}


}
