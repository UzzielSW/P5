
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

  public static void main(String[] args) throws IOException {
    // Crea un socket para conectarse al servidor en el puerto especificado
    Socket client = new Socket("localhost", 5555);

    // Crea un flujo de entrada para recibir el mensaje del servidor
    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

    // Lee el mensaje del servidor y lo muestra en la consola
    String message = in.readLine();
    System.out.println(message);

    // Crea un flujo de salida para enviar el mensaje al servidor
    PrintWriter out = new PrintWriter(client.getOutputStream(), true);

    // Envía el mensaje al Servidor
    out.println("Hola, Servidor!");

    // Cierra el socket en el cliente
    client.close();
  }
}
