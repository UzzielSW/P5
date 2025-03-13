

import java.net.*;
import java.io.*;


public class TalkClient 
{	
	public static void main(String [] args)
	{
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		String servidor = "localhost";
		
		String nombre;
		
		int puerto = 5050;

		try
		{
			System.out.println("\n\n\tConectando al servidor: " + servidor + " por el puerto " + puerto);
			
			Socket usuario = new Socket(servidor, puerto);

			System.out.println("Bienvenidos a este Servidor:   \n\n\t USUARIO:" + usuario.getRemoteSocketAddress());

			System.out.println("Introduzca su nombre: ");
			
			nombre = leer.readLine();
			
			
			OutputStream outToServer = usuario.getOutputStream();
			
			DataOutputStream out = new DataOutputStream(outToServer);
			
			out.writeUTF(nombre/* + usuario.getLocalSocketAddress()*/);
			

			InputStream inFromServer = usuario.getInputStream();
			
			DataInputStream in = new DataInputStream(inFromServer);
			
			System.out.println("El Servidor dice: " + in.readUTF());

			usuario.close();
			
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}