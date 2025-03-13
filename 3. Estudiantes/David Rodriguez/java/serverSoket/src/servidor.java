import java.awt.Color;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class servidor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static int PUERTO = 3000;
	private InputStream aux;
	private DataInputStream read;
	private OutputStream Client_aux;
	private DataOutputStream Client_envio;
	private ObjectOutputStream oos;
	private JTextArea pantalla = new JTextArea();
	private JScrollPane pantalascr = new JScrollPane(pantalla);
	
	private servidor() {
		super("Server Terminal");
		try {
			Font font = new Font("Arial", Font.BOLD, 12);
			pantalla.setFont(font);
			pantalla.setBackground(Color.BLACK);
			pantalla.setForeground(Color.WHITE);
			pantalla.setEditable(false);
			pantalla.setEnabled(false);
			this.add(pantalascr);
			this.setSize(365,200);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);

			ServerSocket SerClient = new ServerSocket(PUERTO);
			pantalla.setText("puerto de enlace: " + PUERTO+"\n");
			Socket Client;
			while (true) {
				Client = SerClient.accept();
				pantalla.setText(pantalla.getText()+"cliente: " + Client+"\n");

				aux = Client.getInputStream();
				read = new DataInputStream(aux);
				String tem =read.readUTF();
				
				if (tem.compareTo("busca") == 0) {
					buscar(Client);
				}else if (tem.compareTo("Balance") == 0) {
					balance(Client);
				}else if (tem.compareTo("I_Cu") == 0) {
					ingreso(Client);
				}else if (tem.compareTo("R_Cu") == 0) {
					retiro(Client);
				}else if (tem.compareTo("info") == 0) {
					info(Client);
				}else if (tem.compareTo("addclient") == 0) {
					addclient(Client);
				}else if (tem.compareTo("pass") == 0) {
					pass(Client);
				}else if (tem.compareTo("upclient") == 0) {
					upclient(Client);
				}else if (tem.compareTo("busnoap") == 0) {
					busnoap(Client);
				}else if (tem.compareTo("vertabla") == 0) {
					vertabla(Client);
				}		
				
				Client.close();
			}
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}

	}

	private void vertabla(Socket Client) {
		try {
		Client_aux = Client.getOutputStream();
		oos = new ObjectOutputStream(Client_aux);
		oos.writeObject(envio_A.CreateData());
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
		
	}

	private void busnoap(Socket Client) {
		try {
			aux = Client.getInputStream();
			read = new DataInputStream(aux);
			envio_A.busnoap(read.readUTF());

			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream(Client_aux);
			Client_envio.writeUTF(envio_A.nombre);

			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream(Client_aux);
			Client_envio.writeUTF(envio_A.apellido);

		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}

	private void upclient(Socket Client) {
		try {
			String infoclient[] = new String[3];
			for (int i = 0; i < 3; i++) {
				aux = Client.getInputStream();
				read = new DataInputStream(aux);
				infoclient[i] = read.readUTF();
			}
			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream (Client_aux);
			Client_envio.writeUTF(""+envio_A.upclient(infoclient[0], infoclient[1], infoclient[2]));
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}

	private void pass(Socket Client) {
		try {
			aux = Client.getInputStream();
			read = new DataInputStream(aux);
			
			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream (Client_aux);
			Client_envio.writeUTF(""+envio_A.pass(Long.parseLong(read.readUTF())));
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}

	private void addclient(Socket Client) {//resive 5 cosas y envia 1
		try {
			String infoclient[] = new String[5];
			for (int i = 0; i < 5; i++) {
				aux = Client.getInputStream();
				read = new DataInputStream(aux);
				infoclient[i] = read.readUTF();
			}
			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream (Client_aux);
			Client_envio.writeUTF(""+envio_A.addclient(Long.parseLong(infoclient[0]), infoclient[1],infoclient[2], Double.parseDouble(infoclient[3]), Double.parseDouble(infoclient[4])));
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}

	public static void main(String[] args) {

		new servidor();

	}

	private void buscar(Socket Client) {//envio y resivo
		try {
			aux = Client.getInputStream();
			read = new DataInputStream(aux);
			
			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream (Client_aux);
			Client_envio.writeUTF(""+envio.busca(read.readUTF()));
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}
	private void balance(Socket Client) {// no envio si resivo
		try {
			aux = Client.getInputStream();
			read = new DataInputStream(aux);
			
			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream (Client_aux);
			Client_envio.writeUTF(":"+envio.balance(read.readUTF()));
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}
	private void ingreso(Socket Client) {
		try {
			aux = Client.getInputStream();
			read = new DataInputStream(aux);
			String tem = read.readUTF();
			
			aux = Client.getInputStream();
			read = new DataInputStream(aux);
			String tem1 = read.readUTF();
			
			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream (Client_aux);
			Client_envio.writeUTF(""+envio.I_Cu(Double.parseDouble(tem),tem1));
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}
	private void retiro(Socket Client) {
		try {
			aux = Client.getInputStream();
			read = new DataInputStream(aux);
			String tem = read.readUTF();
			
			aux = Client.getInputStream();
			read = new DataInputStream(aux);
			String tem1 = read.readUTF();
			
			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream (Client_aux);
			Client_envio.writeUTF(""+envio.R_Cu(Double.parseDouble(tem),tem1));
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}
	private void info(Socket Client) {
		try {
			Client_aux = Client.getOutputStream();
			Client_envio = new DataOutputStream (Client_aux);
			Client_envio.writeUTF(""+envio.info_U());
		} catch (Exception e) {
			pantalla.setText(e.getMessage());
		}
	}

}
