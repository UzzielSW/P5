package Servidor;

import java.net.*;
import java.io.*;

class Servidor extends Thread {

    private final ServerSocket serverSocket; //cambie a final

    public Servidor(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000); //10seg tiempo de espera
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Esperando clientes en el puerto: " + serverSocket.getLocalPort() + "...");
                Socket client = serverSocket.accept();
                System.out.println("Se ha conectado: " + client.getRemoteSocketAddress());
                
                DataInputStream in = new DataInputStream(client.getInputStream());
                System.out.println(in.readUTF());
                
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF("Thank you for connecting to " + client.getLocalSocketAddress()+ "<-mensaje enviado desde el servidor");
                
                client.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket ha caducado!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

    }

    public static void main(String[] args) {
        int port = Integer.parseInt("11000");
        try {
            Thread t = new Servidor(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
