

import java.util.*;

import java.net.*;

import java.io.*;

public class WeatherUpdater extends TimerTask
{
	DatagramSocket datasock;
	
	String recipientName;
	
	int recipientPort;
	
	public WeatherUpdater(String d, int r)
	{
		try
		{
			
		recipientName = d;
		
		recipientPort = r;
		
		datasock = new DatagramSocket();
		
		}catch(SocketException e){}
	}
	
	public void run()
	{
		try
		{
				
		int N_aleatorio = (int) (Math.random() * 101);
		
		String cadena = "Current temperature: "+ N_aleatorio +" Farenheit";
			
		byte [] buffer = cadena.getBytes();
		
		try
		{
		
		InetSocketAddress direccion = new InetSocketAddress(recipientName,recipientPort);
		
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, direccion);
		
		datasock.send(packet);
		
		}  catch(SocketException f){}
		
		} catch(IOException e){}   
		
		
	}
	
	public static void main(String [] args)
	{
		try
		{
			
		WeatherUpdater wu = new WeatherUpdater("localhost",4444);
		
		Timer tiempo = new Timer();
		
		tiempo.schedule(wu, 0, 15000);
		
		} catch(IllegalStateException r){}
	}
}