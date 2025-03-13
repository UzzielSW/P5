// serv.java
import java.io.*;
import java.net.*;
public class server{
public static void main(String args[])throws Exception{
  boolean f;
  Socket client;
  ServerSocket clientsocket;
  clientsocket=new ServerSocket (85);
  PrintStream output;
  String data1,temp1;
  System.out.println("\n\n\nEnter the data to store in local memory, which will distributed later :");
  DataInputStream ser_input=new DataInputStream(System.in);
  data1=ser_input.readLine(); // local memory data
    while(true){
	  client=clientsocket.accept();
	  output=new PrintStream(client.getOutputStream());
	  output.println(data1);  }    } }
