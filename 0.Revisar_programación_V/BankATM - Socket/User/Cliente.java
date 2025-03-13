import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
  final static String HOST = "localhost";
  final static int PUERTO = 3000;
  private static OutputStream aux;
  private static DataOutputStream envio;
  private static InputStream serv_aux;
  private static DataInputStream read;
  private static ObjectInputStream oos;
  public static Object[][] data;
  public static String tem = null;
  public static String tem2 = null;

  public static String Client(String accion, String clave, String nombre, String apellido, String TipoCuenta,
      String apertura) {

    try {
      Socket User = new Socket(HOST, PUERTO);

      aux = User.getOutputStream();
      envio = new DataOutputStream(aux);
      envio.writeUTF(accion);
      if (clave != null) {
        aux = User.getOutputStream();
        envio = new DataOutputStream(aux);
        envio.writeUTF(clave);
      }
      if (nombre != null) {
        aux = User.getOutputStream();
        envio = new DataOutputStream(aux);
        envio.writeUTF(nombre);
      }
      if (apellido != null) {
        aux = User.getOutputStream();
        envio = new DataOutputStream(aux);
        envio.writeUTF(apellido);
      }
      if (TipoCuenta != null) {
        aux = User.getOutputStream();
        envio = new DataOutputStream(aux);
        envio.writeUTF(TipoCuenta);
      }
      if (apertura != null) {
        aux = User.getOutputStream();
        envio = new DataOutputStream(aux);
        envio.writeUTF(apertura);
      }
      if (accion.compareTo("busnoap") == 0) {
        serv_aux = User.getInputStream();
        read = new DataInputStream(serv_aux);
        tem2 = read.readUTF();
      }
      if (accion.compareTo("view_accounts") == 0) {
        serv_aux = User.getInputStream();
        oos = new ObjectInputStream(serv_aux);
        data = (Object[][]) oos.readObject();
      } else {
        serv_aux = User.getInputStream();
        read = new DataInputStream(serv_aux);
        tem = read.readUTF();
      }

      User.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return tem;
  }
}
