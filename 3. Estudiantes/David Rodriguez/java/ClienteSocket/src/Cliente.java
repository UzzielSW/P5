import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

	final static String HOST = "127.0.0.1";
	//final static String HOST = "5.227.158.54";
	final static int PUERTO = 3000;
	private static OutputStream aux;
	private static DataOutputStream envio;
	private static InputStream serv_aux;
	private static DataInputStream read;
	private static ObjectInputStream oos;
	public static String[][] data= null;
	public static String tem = null;
	public static String tem2 = null;
	
	public static String Client(String operasion, String variable, String var1, String var2, String var3, String var4) {

		try {
			Socket Client = new Socket(HOST, PUERTO);

			aux = Client.getOutputStream();
			envio = new DataOutputStream(aux);
			envio.writeUTF(operasion);
			if (variable != null) {
				aux = Client.getOutputStream();
				envio = new DataOutputStream(aux);
				envio.writeUTF(variable);
			}
			if (var1 != null) {
				aux = Client.getOutputStream();
				envio = new DataOutputStream(aux);
				envio.writeUTF(var1);
			}
			if (var2 != null) {
				aux = Client.getOutputStream();
				envio = new DataOutputStream(aux);
				envio.writeUTF(var2);
			}
			if (var3 != null) {
				aux = Client.getOutputStream();
				envio = new DataOutputStream(aux);
				envio.writeUTF(var3);

				aux = Client.getOutputStream();
				envio = new DataOutputStream(aux);
				envio.writeUTF(var4);
			}
			if (operasion.compareTo("busnoap") == 0) {
				serv_aux = Client.getInputStream();
				read = new DataInputStream(serv_aux);
				tem2 = read.readUTF();
			}
			if (operasion.compareTo("vertabla") == 0) {
				serv_aux = Client.getInputStream();
				oos = new ObjectInputStream(serv_aux);
				data = (String[][]) oos.readObject();
			} else {
				serv_aux = Client.getInputStream();
				read = new DataInputStream(serv_aux);
				tem = read.readUTF();
			}

			Client.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tem;
	}
}
