

package clases;

import java.awt.*;

import java.net.*;

import java.io.*;

import java.util.*;

import javax.swing.*;

/**
 *
 *  Esta es La Clase Client, en ella se inicia la conexion servidor - cliente
 *
 *  @author Maquilon S.
 *
 *  @version 1.0
 *
 **/

public class Server
{
	public Server()
	{
		try{
		
		int Client = 1;
		
		//////////////////////////////////////////////
		
		ServerSocket server = new ServerSocket(5000);
		
		while(true) {
			
		System.out.println("\n\n\t  The Server is waiting in the port " + server.getLocalPort() + "...");
		
        Socket client = server.accept();
					
		System.out.print("\n\tGood Morning...!, " + client.getRemoteSocketAddress());

        newClient user = new newClient(client,Client);

		//////////////////////////////////////

                     user.start();
        
        /////////////////////////////////////

		System.out.println("\n\n\tCliente # " + Client + " your connection was success ...!");

        Client++;
      }
      
      } catch(IOException f){}
      
      	////////////////////////////////////////////
	}
	
	public static void main(String [] args) 
	{				
		new Server();
	}
}