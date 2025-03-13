


import java.util.*;

import java.net.*;

import java.io.*;

public class WeatherWatcher
{
	public static void main(String [] args)
	{
		while(true)
		{

		try
		{
			
		DatagramSocket persona = new DatagramSocket(4444);
		
		byte [] buffer = new byte[128];
		
		DatagramPacket recibido = new DatagramPacket(buffer,buffer.length);
		
		System.out.println("Esperando un paquete...");
		
		persona.receive(recibido);

		System.out.println(new String(buffer));
		
		} 
		
		catch(SocketTimeoutException s) {  System.out.println("Socket timed out!");  break;  }
			
		catch(IOException e) {  e.printStackTrace();   break;  }	
			
		
		}
	}
}