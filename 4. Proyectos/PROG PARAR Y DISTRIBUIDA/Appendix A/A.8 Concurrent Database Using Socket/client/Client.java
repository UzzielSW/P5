import java.sql.*;
import java.io.*;
import java.net.*;
import java.lang.*;


class Client
{
	public static void main(String arg[]) throws Exception
	{
	Socket socket;
	DataInputStream input;
	PrintStream output;
	
	socket = new Socket("127.0.0.1",500);
	input=new DataInputStream(socket.getInputStream());
	output =new PrintStream(socket.getOutputStream());
	 		
	String data,temp,temp1;
	DataInputStream user_input=new DataInputStream(System.in);
	
	System.out.println("Enter your user name :");
	temp=user_input.readLine();
	InetAddress net=InetAddress.getLocalHost();
	String s= net + ", User:" + temp;
	output.println(s);
	System.out.println("Your address is "+s);
	
	boolean f;
	f=true;
	while(f)
	{
	
	  System.out.print("\nEnter Your Choice Insert- i, Delete- d, Select- s, Exit- e :");
	  temp=user_input.readLine();
	  output.println(temp);
	  
	   if (temp.equals("i")){
		System.out.print("\nEnter the Employee  Code: ");
		temp=user_input.readLine();
		output.println(temp);
		System.out.print("Enter the Employee  Name: ");
		temp=user_input.readLine();
		output.println(temp);
		System.out.print("Enter the Employee  Salar: ");
		temp=user_input.readLine();
		output.println(temp);
		System.out.print("Enter the Employee  Disignation: ");
		temp=user_input.readLine();
		output.println(temp);
		System.out.print("Enter the Employee  Age: ");
		temp=user_input.readLine();
		output.println(temp);		
		System.out.println("\nYour record has been saved");}
		
		else if (temp.equals("s")) {
			
			data=input.readLine();
			System.out.println("\n\t-----------------------------------");
			System.out.println("\tEcode\tName\tSalary\tdisi\tage");
			System.out.println("\t-----------------------------------");
			System.out.println(data); 
			System.out.println("\t-----------------------------------");
			}
			
	 	else if (temp.equals("d")) {
	 		System.out.print("\nEnter the Employee  code to delete :");
			temp=user_input.readLine();
			output.println(temp);
			System.out.println("\nYour record has been deleted");
			}
			
	 	else if(temp.equals("e"))
	 		f=false;
	 	else
	 		System.out.println("Wrong input given......"); 
	     }
    output.close();
    input.close();
  }
}