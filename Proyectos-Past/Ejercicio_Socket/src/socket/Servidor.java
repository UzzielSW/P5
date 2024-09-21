package socket;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Servidor {

    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner escaner = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

    public void levantarConexion(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            mostrarTexto("Esperando conexión entrante en el puerto " + serverSocket.getLocalPort() + "...");
            socket = serverSocket.accept();
            mostrarTexto("\nConexión establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
        } catch (IOException e) {
            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
            System.exit(0);
        }
    }

    public void flujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void recibirDatos() {
        String st;
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n[Cliente] => " + st);
                mostrarTexto("\n[Servidor] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
            cerrarConexion();
        }
    }

    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en enviar(): " + e.getMessage());
        }
    }

    public static void mostrarTexto(String s) {
        System.out.print(s);
    }

    public void escribirDatos() {
        while (true) {
            mostrarTexto("\n[Servidor] => ");
            enviar(escaner.nextLine());
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
        } catch (IOException e) {
            mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
        } finally {
            mostrarTexto("Conexión terminada....");
            System.exit(0);
        }
    }

    public void ejecutarConexion(int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //se elimino un try sin catch y con finally que parecia imnecesario
                    levantarConexion(puerto);
                    flujos();
                    recibirDatos();
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }

    public static void main(String[] args) throws IOException {
        Servidor s = new Servidor();
        Scanner sc = new Scanner(System.in);

//        mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
//        String puerto = sc.nextLine();
//        if (puerto.length() <= 0) {
//            puerto = "5050";
//        }
        s.ejecutarConexion(Integer.parseInt("5050"));
        s.escribirDatos();
    }
}
