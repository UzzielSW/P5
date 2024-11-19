// pruebas chat socket
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConexionCliente extends Thread {

   private Socket socket;
   private DataInputStream entrada;
   private DataOutputStream salida;
   private CServidor servidor;
   private String nombre;

   public ConexionCliente(Socket socket, CServidor servidor, String nombre) throws IOException {
      this.socket = socket;
      this.servidor = servidor;
      this.nombre = nombre;
      this.entrada = new DataInputStream(socket.getInputStream());
      this.salida = new DataOutputStream(socket.getOutputStream());
   }

   public void run() {
      try {
         // Bucle infinito para recibir mensajes del cliente
         while (true) {
            // Leer el mensaje del cliente
            String mensaje = entrada.readUTF();

            // Si el mensaje es "salir", se termina la conexión
            if (mensaje.equals("salir")) {
               break;
            }

            // Enviar el mensaje al servidor para que lo reenvíe a todos los clientes
            servidor.enviarMensaje(nombre + ": " + mensaje);
         }
      } catch (IOException ex) {
         System.err.println("Error al recibir el mensaje: " + ex.getMessage());
      } finally {
         // Cerrar el socket y eliminar al cliente de la lista del servidor
         try {
            socket.close();
            servidor.eliminarCliente(this);
         } catch (IOException ex) {
            System.err.println("Error al cerrar el socket: " + ex.getMessage());
         }
      }
   }

   // Método para enviar un mensaje al cliente
   public void enviarMensaje(String mensaje) {
      try {
         salida.writeUTF(mensaje);
         salida.flush();
      } catch (IOException ex) {
         System.err.println("Error al enviar el mensaje: " + ex.getMessage());
      }
   }
}
