

import java.net.*;
import java.net.ServerSocket;
import java.io.*;

public class TalkServer extends Thread
{

private ServerSocket servidor;

int contador = 1;

	public TalkServer(int puerto) throws IOException
	{
		servidor = new ServerSocket(puerto);
	}
		public void run()
		{
			while(true)
			{
				
			try
			{
				System.out.println(contador+".  Esperando en el puerto " + servidor.getLocalPort() + "...");
				Socket persona = servidor.accept();

				System.out.print("Buenos dias, "/* + persona.getRemoteSocketAddress()*/);
				
				DataInputStream in = new DataInputStream(persona.getInputStream());
				System.out.println(in.readUTF());
				
			//	String saludo = in.readUTF();
				
				System.out.println("\n\n");

		
		DataOutputStream out = new DataOutputStream(persona.getOutputStream());
				
		out.writeUTF("\n\n\tGracias por conectarte! " /*persona.getLocalSocketAddress()*/ + "Hasta pronto!");

				persona.close();
				
			}catch(SocketTimeoutException s)
			{
				System.out.println("Socket timed out!");
				break;
			}catch(IOException e)
			{
				e.printStackTrace();
				break;
			}
			
			contador++;
			
			}
			
		}
	
	public static void main(String [] args)
	{
		try
		{
			Thread t = new TalkServer(5050);
			t.start();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}