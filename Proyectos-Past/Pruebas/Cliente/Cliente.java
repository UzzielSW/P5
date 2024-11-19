import java.net.*;
import java.io.*;

public class Cliente {

  public static void main(String[] args) {
    String serverName = "localhost";
    int port = 11000;

    try {
      System.out.println("Conectando a: " + serverName + ", en el puerto: " + port);
      Socket client = new Socket(serverName, port);

      System.out.println("Se ha conectado a: " + client.getRemoteSocketAddress());

      OutputStream outToServer = client.getOutputStream();
      DataOutputStream out = new DataOutputStream(outToServer);

      out.writeUTF("Hello from " + client.getLocalSocketAddress() + "<-mensaje enviado desde el cliente");

      InputStream inFromServer = client.getInputStream();
      DataInputStream in = new DataInputStream(inFromServer);

      System.out.println("El servidor te dice: " + in.readUTF());

      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
