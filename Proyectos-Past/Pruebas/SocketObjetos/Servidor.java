
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket clientSocket = serverSocket.accept();

            ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream outToCliente = new ObjectOutputStream(clientSocket.getOutputStream());
            
            Message messageFromClient = (Message) inFromClient.readObject();

            System.out.println("Mensaje recibido: " + messageFromClient.getText());
            Message message = new Message("Hola desde el servidor!");
            
            outToCliente.writeObject(message);
            
            outToCliente.close();
            inFromClient.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

