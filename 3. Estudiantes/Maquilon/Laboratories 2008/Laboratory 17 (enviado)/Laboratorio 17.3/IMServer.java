
import java.awt.*;

import java.net.*;

import java.io.*;

public class IMServer implements Runnable
{
	public Participant usuarios;
	
	ServerSocket servidor;
	
	Socket usuario;
	
	public void run()
	{
		try{
		
		servidor = new ServerSocket(5555);
		
		while(true)
		{
		
		System.out.println("Esperando a un Usuario !"); 
		
		usuario = servidor.accept();
		
		InputStream desdeUsuario = usuario.getInputStream();
		
		DataInputStream recibe = new DataInputStream(desdeUsuario);
		
		String nombre = recibe.readUTF().toString();
			
		usuarios = new Participant(usuario,nombre);
		
		usuarios.start();
		
		}
		
		} catch(IOException f){ }
	}
	
	public static void main(String [] args)
	{
		IMServer server = new IMServer();
		
		Thread hilo = new Thread(server,"corre");
		
		hilo.start();	
	}
}