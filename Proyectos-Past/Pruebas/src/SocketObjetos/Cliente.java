
package SocketObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            Message message = new Message("Hola desde el cliente!");
            
            outToServer.writeObject(message);
            
            message = (Message) inFromServer.readObject();
            
            System.out.println("Mensaje recibido: " + message.getText());
            
            
            inFromServer.close();
            outToServer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
