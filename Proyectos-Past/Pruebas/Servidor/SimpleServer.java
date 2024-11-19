package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException {

// Crea un socket en el servidor y espera a que un cliente se conecte
        ServerSocket server = new ServerSocket(5555);
        Socket client = server.accept();
        
        System.out.println("Esperando clientes en el puerto: " + server.getLocalPort() + "...");

// Crea un flujo de salida para enviar un mensaje al cliente
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        
// Envía el mensaje al cliente
        out.println("Hola, cliente!");

// Crea un flujo de entrada para recibir un mensaje del cliente
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String message = in.readLine();
        System.out.println(message);
        
        
        
// Cierra el socket en el servidor
        server.close();

    }
}
