
package clases;

import java.net.*;

import java.io.*;

/**
 *
 *  Esta es La Clase Client, en ella se inicia la conexion cliente - servidor.
 *
 *  @author Maquilon S.
 *
 *  @version 1.0
 *
 **/

public class Client 
{	
	public static String server = "localhost";
	
	public static Socket user;
	
	public static void main(String [] args)
	{		
		//////////////////////////////////////////////////////////////////////////
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		int port = 5000;

		try
		{
			System.out.println("\n\n\tConnecting to server: " + server + " for the port " + port);
			
			user = new Socket( server, port );
		
			System.out.println("\n\tWelcome to This Server:   \n\n\n\t User:" + user.getRemoteSocketAddress());
			
			/////////////////////////////////////////////////
			
			BankATM program = new BankATM("Welcome to BankATM");
			
			/////////////////////////////////////////////////											 
			
		 }catch(Exception f){ }
	}
}