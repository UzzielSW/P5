import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    // Lista de clientes conectados al servidor
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Puerto en el que escuchará el servidor
        int port = 8000;

        // Creamos un objeto ServerSocket para aceptar conexiones de clientes
        ServerSocket server = new ServerSocket(port);
        System.out.println("Servidor iniciado en el puerto " + port);

        // Bucle infinito para esperar a que se conecten los clientes
        while (true) {
            // Aceptamos la conexión de un cliente
            Socket client = server.accept();

            // Agregamos el cliente a la lista de clientes conectados
            clients.add(client);

            // Creamos una nueva hebra para gestionar la comunicación con el cliente
            Thread thread = new Thread(new ClientHandler(client));
            thread.start();

            System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress());
        }
    }

    // Clase interna que se encarga de gestionar la comunicación con un cliente
    private static class ClientHandler implements Runnable {
        private final Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Creamos los flujos de entrada y salida de datos
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Bucle infinito para recibir y enviar mensajes
                while (true) {
                    // Leemos el mensaje enviado por el cliente
                    String message = in.readUTF();

                    // Mostramos el mensaje en consola
                    System.out.println("Mensaje recibido de " + client.getInetAddress().getHostAddress);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}