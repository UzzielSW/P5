// client.java
import java.io.*;
import java.net.*;
public class client{
	public static void main(String arg[])throws Exception	{
		boolean f;
		Socket socket;
		socket=new Socket ("10.129.50.20",85);
		DataInputStream input;
		input=new DataInputStream(socket.getInputStream());
		String data=input.readLine(); // received data from server
		System.out.println("\n\n");
		System.out.println(data);
		System.out.println("\nThis message Received from Remote system"); }}
