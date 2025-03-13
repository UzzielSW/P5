import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class InstantMessageDialog extends JDialog
{
	private JButton send, cancel;
	
	private JTextArea message;

	public InstantMessageDialog(Frame owner, String recipient, String sender) throws IOException
	{
		super(owner, "SendMessage Dialog", true);
		
		String servidor = "localhost";
		
		int puerto = 5555;
		
		String nombre;

		try
		{
			///////////////////////////////////////////////////////////////////////////////////////////////////////
			
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("\n\n\tConectando al servidor: " + servidor + " por el puerto " + puerto);
			
			Socket usuario = new Socket(servidor, puerto);

			System.out.println("Bienvenidos a este Servidor:   \n\n\t USUARIO:" + usuario.getRemoteSocketAddress());

			System.out.println("Introduzca su nombre: ");
			
			nombre = leer.readLine();
			
			OutputStream outToServer = usuario.getOutputStream();
			
			DataOutputStream out = new DataOutputStream(outToServer);
			
			out.writeUTF(nombre /*+ usuario.getLocalSocketAddress()*/);
			
	/*		InputStream desdeServer = usuario.getInputStream();
			
			DataInputStream in = new DataInputStream(desdeServer);
			
			in.readUTF();*/
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Container contentPane = this.getContentPane();

		send = new JButton("Send");
		
		cancel = new JButton("Cancel");
		
		message = new JTextArea();

		JPanel south = new JPanel();
		
		south.add(send);
		
		south.add(cancel);
		
		contentPane.add(south, BorderLayout.SOUTH);

		JScrollPane center = new JScrollPane(message);
		
		contentPane.add(center, BorderLayout.CENTER);

		JLabel north = new JLabel("Sending message to " + recipient);
		
		contentPane.add(north, BorderLayout.NORTH);

		this.setSize(400,200);

	//	PipedInputStream in = new PipedInputStream();
	
	//	PipedOutputStream out = new PipedOutputStream(in);

		SendMessage listener = new SendMessage(message, recipient, sender, this, outToServer);
		
		send.addActionListener(listener);
		
		cancel.addActionListener(listener);

	//	Participant user = new Participant(recipient, desdeServer);

	//	user.start();
		
		}catch(SocketTimeoutException s)
			{
				System.out.println("Socket timed out!");

			}catch(IOException e)
			{
				e.printStackTrace();

			}catch(Exception d){	}
	}

	public static void main(String [] args)
	{
		try
		{
			InstantMessageDialog d = new InstantMessageDialog(null, "a person", "usuario");
			
			d.show();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}