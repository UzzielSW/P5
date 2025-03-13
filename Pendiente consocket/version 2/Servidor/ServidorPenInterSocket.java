import java.io.*;
import java.net.*;
import *;
import java.awt.*;
import java.util.Date;

public class ServidorPenInterSocket extends JFrame {

    private static JTextArea jtaLog;

    private Punto p1;
    private Punto p2;

    public ServidorPenInterSocket() {

        // Create a scroll pane to hold text area

        JScrollPane scrollPane = new JScrollPane(jtaLog = new JTextArea());

        // Add the scroll pane to the frame

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setTitle("Pendiente   Server Using Object Streams");
        setVisible(true);
    }

    public static void main(String args[]) {

        ServidorPenInterSocket pendiente = new ServidorPenInterSocket();

        //	ImplPendInterSocket  objimplpend = new ImplPendInterSocket();

        // Establish server socket

        try {

            // Create a server socket

            ServerSocket serverSocket = new ServerSocket(8000);

            pendiente.jtaLog.append(new Date() + ": Start a new server\n");

            // Count the number of threads started

            int count = 1;

            while (true) {

                // Connect to a client
                System.out.println("El servidor espera que un cliente envie una linea con los  Punto p1 y p2");

                Socket socket = serverSocket.accept();

                jtaLog.append(new Date() + ": A client at " +
                    socket.getInetAddress().getHostAddress() + " connected\n");

                // Start a new thread to register a client
                System.out.println("\nStart a new thread to register a client: " + count);

                new PendienteThread(socket, count++).start();

            }
        } catch (IOException ex) {
            jtaLog.append(new Date() + ": " + ex);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());

            e.printStackTrace();
            //	System.out.println(e);
        }
    }

    /** Define a thread to process the client registration */

    static class PendienteThread extends Thread {

        // The socket to serve a client
        private Socket socket;

        private Linea objLinea;

        private String infinito2;

        private int clientNo; // The thread number

        // Object input stream to get input from the client
        private ObjectInputStream in ;
        private ObjectOutputStream out;

        public PendienteThread(Socket socket, int clientNo) {
            // Create a  thread
            this.socket = socket;
            this.clientNo = clientNo;

            jtaLog.append(new Date() + ": Thread " + clientNo +
                " started\n");
            // Create an input stream to receive data from a client

            try {
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());

            } catch (IOException ex) {
                jtaLog.append(new Date() + ": " + ex);
            }
        }

        public void run() {
            try {

                // Receive data from the client
                ImplPendInterSocket objimplpend = new ImplPendInterSocket();

                objLinea = (Linea) in.readObject();

                System.out.println("\nEl servidor se recibe la linea con los  Punto p1 y p2");

                System.out.println("Punto P1: " + objLinea.p1.display());
                System.out.println("Punto P2: " + objLinea.p2.display());

                System.out.println("Valida la existencia de la Pendiente");

                objLinea.existe = objLinea.validar_pendiente(objLinea.p1, objLinea.p2);

                System.out.println(" Si o no " + objLinea.existe);

                if (objLinea.existe == true) {
                    System.out.println("El servidor Calcula la pendiente");

                    objLinea.setPendiente(objimplpend.calcula_pendiente(objLinea.p1, objLinea.p2));

                    System.out.println("Pendiente m = " + objLinea.getPendiente());

                    //   objLinea.setB(objimplpend.calculaB(objLinea.p1,objLinea.getPendiente()));

                    objLinea.setB(objimplpend.calculaB(objLinea));

                    System.out.println("Valor de b = " + objLinea.getB());

                    System.out.println(objLinea.imprime_linea());

                    if (objLinea.getPendiente() != 0.0) {

                        objLinea.setInterEjeX(objimplpend.calIntersecEjeX(objLinea));

                        System.out.println("Interseccion EjeX: " + objLinea.getInterEjeX().display());

                    }

                    objLinea.setInterEjeY(objimplpend.calIntersecEjeY(objLinea));
                    System.out.println("Interseccion EjeY: " + objLinea.getInterEjeY().display());
                } else {

                    objLinea.m = objimplpend.calcula_pendiente(objLinea);
                    System.out.println("Pendiente m = " + objLinea.getPendiente());
                    objLinea.setB(objimplpend.calculaB(objLinea));

                    infinito2 = String.valueOf(objLinea.getB());

                    if (infinito2.equals("NaN")) {
                        infinito2 = "Infinity";

                    }

                    System.out.println("Valor de b = " + infinito2);

                    System.out.println(objLinea.imprime_linea2());

                    objLinea.setInterEjeX(objimplpend.calIntersecEje2X(objLinea));

                    System.out.println("Interseccion EjeX: " + objLinea.getInterEjeX().display());
                }

                System.out.println("El servidor envia el objeto linea al cliente");
                out.writeObject(objLinea);

            } catch (Exception ex) {
                System.out.println(ex);
                ex.printStackTrace();
            }
43875
        } // fin del metodo run

    } // fin de la clase interna PendienteThread
} // fin de ServidorPenInterSocket.java