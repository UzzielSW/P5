
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CServidor extends Thread {

  private static int ID = 0;
  private int puerto;
  private ServerSocket servidor;
  private List<ConexionCliente> clientes;

  public CServidor(int puerto) throws IOException {
    this.puerto = puerto;
    this.servidor = new ServerSocket(puerto);
    this.clientes = new ArrayList<>();
  }

  public void run() {
    System.out.println("Servidor iniciado en el puerto " + puerto);

    while (true) {
      try {
        // Aceptar una nueva conexión
        Socket socket = servidor.accept();
        System.out.println("Cliente conectado: " + socket.getInetAddress().getHostName());

        // Crear un objeto para atender al cliente
        ConexionCliente cc = new ConexionCliente(socket, this, "Cliente #" + ID++);
        // Añadir el cliente a la lista
        clientes.add(cc);

        // Iniciar el hilo del cliente
        cc.start();
      } catch (IOException ex) {
        System.err.println("Error al aceptar conexión: " + ex.getMessage());
      }
    }
  }

  // Método para enviar un mensaje a todos los clientes
  public void enviarMensaje(String mensaje) {
    for (ConexionCliente cc : clientes) {
      cc.enviarMensaje(mensaje);
    }
  }

  // Método para eliminar un cliente de la lista
  public void eliminarCliente(ConexionCliente cc) {
    clientes.remove(cc);
  }

  public static void main(String[] args) {
    try {
      // Crear un objeto servidor con el puerto 50000
      CServidor sc = new CServidor(50000);

      // Iniciar el servidor
      sc.start();

    } catch (IOException ex) {
      System.err.println("Error al crear el servidor: " + ex.getMessage());
    }
  }
}
