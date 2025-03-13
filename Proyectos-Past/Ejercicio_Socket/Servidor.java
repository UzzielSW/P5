// util base del servidor

// Servidor
import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {

  // mapa que relaciona cada número de identificación con el socket del cliente
  // correspondiente
  // podria manejar el primer int de la coleccion como el id de cuenta
  // facilitaria la busqueda de una cuenta especifoca
  //
  private static Map<Integer, Socket> clientes = new HashMap<>();

  public static void main(String[] args) throws IOException {
    // crear servidor en el puerto 8000
    ServerSocket servidor = new ServerSocket(8000);

    while (true) {
      // aceptar nuevas conexiones de clientes
      Socket socket = servidor.accept();

      // asignar número de identificación único al cliente y guardar en el mapa
      int id = asignarId();
      clientes.put(id, socket);

      // crear thread para procesar mensajes del cliente
      new Thread(new ClienteHandler(id, socket)).start();
    }
  }

  // asigna un número de identificación único al cliente
  //
  private static int asignarId() {
    // buscar número de identificación disponible
    int id = 1;
    while (clientes.containsKey(id)) {
      id++;
    }
    return id;
  }

  // clase que maneja los mensajes de un cliente en un thread separado
  private static class ClienteHandler implements Runnable {

    private int id;
    private Socket socket;

    public ClienteHandler(int id, Socket socket) {
      this.id = id;
      this.socket = socket;
    }

    public void run() {
      try {
        // obtener streams de entrada y salida
        // investigar si es mejor usar la siguiente forma:
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // enviar número de identificación al cliente
        out.println(id);

        // procesar mensajes del cliente
        while (true) {
          String mensaje = in.readLine();
          if (mensaje == null) {
            break;
          }

          // extraer número de identificación del mensaje
          int idCliente = Integer.parseInt(mensaje.substring(0, mensaje.indexOf(' ')));

          // buscar socket del cliente en el mapa
          // aqui se esta usandonla referencia de la clase padre
          // ya que es una inherclass.
          // otra forma es mandandole la referencia del server
          Socket clienteSocket = clientes.get(idCliente);
          if (clienteSocket == null) {
            continue;
          }

          // enviar respuesta al cliente
          out.println("Servidor: " + mensaje);
        }
      } catch (IOException e) {
      }
    }
  }
}
