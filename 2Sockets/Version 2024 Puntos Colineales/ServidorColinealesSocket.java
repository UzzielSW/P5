import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServidorColinealesSocket extends JFrame {
  public static void main(String args[]) {
    new ServidorColinealesSocket("Servidor de Colineales");
  }

  private static final long serialVersionUID = 1L;

  private static JTextArea jtaLog;

  private static Punto punto1;
  private static Punto punto2;
  private static Punto punto3;

  public static String infinitomp1p2;
  public static String infinitomp2p3;
  public static String infinitomp1p3;
  public static String actionCommand;

  public static double mp1p2;
  public static double mp2p3;
  public static double mp1p3;

  public static boolean resp;

  private static Boolean colineales;

  private static double distP1P2;
  private static double distP2P3;
  private static double distP1P3;

  public ServidorColinealesSocket(String titulo) {
    super(titulo);

    JScrollPane scrollPane = new JScrollPane(jtaLog = new JTextArea());

    add(scrollPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setTitle("Colineal Tree Points  Server Using Object Streams");
    setLocationRelativeTo(null);
    setVisible(true);

    InitServer(10000);
  }

  private void InitServer(int port) {
    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(port);
      ServidorColinealesSocket.jtaLog.append(new Date() + ": Start a new server\n");
      
      int count = 1; // Count the number of threads started

      while (true) {
        // Connect to a client
        System.out.println("El servidor espera que un cliente envie un Objeto String actionPerformed y tres objetos Punto p1, p2 y p3");

        Socket socket = serverSocket.accept();

        jtaLog.append(new Date() + ": A client at " +
            socket.getInetAddress().getHostAddress() + " connected\n");

        // Start a new thread to register a client
        System.out.println("\nStart a new thred to register a client: " + count);

        new PendienteDistanciaThread(socket, count++).start();
      }
    } catch (IOException ex) {
      jtaLog.append(new Date() + ": " + ex);
    } catch (Exception e) {
      System.out.println("ERROR: " + e.getMessage());
      e.printStackTrace();
    }
  }


  static class PendienteDistanciaThread extends Thread {

    private Socket socket;
    private int clientNo; // The thread number
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public PendienteDistanciaThread(Socket socket, int clientNo) {
      this.socket = socket;
      this.clientNo = clientNo;

      jtaLog.append(new Date() + ": Thread " + clientNo
          + " started\n");

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
        ImplPendDistSocket objimplpend_dist = new ImplPendDistSocket();

        actionCommand = (String) in.readObject();
        System.out.println("\nEl servidor se recibe un objeto actionCommand:  " +actionCommand);

        System.out.println("\nEl servidor se recibe los tres objetos Punto");

        punto1 = (Punto) in.readObject();
        punto2 = (Punto) in.readObject();
        punto3 = (Punto) in.readObject();

        System.out.println("Punto P1: " + punto1.display());
        System.out.println("Punto P2: " + punto2.display());
        System.out.println("Punto P3: " + punto3.display());

        if ("ColiDistancia".equals(actionCommand)) {
          System.out.println("El servidor Calcula la distancia entre los Puntos: ");

          distP1P2 = Math.abs(punto1.distancia(punto2));
          System.out.println("Distancia de P1 a P2: " + distP1P2);

          distP2P3 = Math.abs(punto2.distancia(punto3));
          System.out.println("Distancia de P2 a P3: " + distP2P3);

          distP1P3 = Math.abs(punto1.distancia(punto3));
          System.out.println("Distancia de P1 a P3: " + distP1P3);

          infinitomp1p2 = String.valueOf(mp1p2);
          infinitomp2p3 = String.valueOf(mp2p3);
          infinitomp1p3 = String.valueOf(mp1p3);

          if (!(infinitomp1p2.equals("-Infinity") || infinitomp1p2.equals("Infinity") ||
              infinitomp2p3.equals("-Infinity") || infinitomp2p3.equals("Infinity") ||
              infinitomp1p3.equals("-Infinity") || infinitomp1p3.equals("Infinity"))) {
            if (Math.abs(distP1P3 - (distP1P2 + distP2P3)) <= .0001)
              resp = Boolean.TRUE;
            else
              resp = Boolean.FALSE;

            colineales = Boolean.valueOf(resp);
          } else {
            resp = Boolean.TRUE;
            colineales = Boolean.valueOf(resp);
          }

        } 
        else if ("ColiPendiente".equals(actionCommand)) {
          System.out.println("El servidor Calcula la pendiente de los Puntos: ");
          mp1p2 = objimplpend_dist.calcula_pendiente(punto1, punto2);

          System.out.println(" m1  = " + objimplpend_dist.calcula_pendiente(punto1, punto2));

          mp2p3 = objimplpend_dist.calcula_pendiente(punto2, punto3);
          System.out.println(" m2  = " + objimplpend_dist.calcula_pendiente(punto2, punto3));

          mp1p3 = objimplpend_dist.calcula_pendiente(punto1, punto3);
          System.out.println(" m3  = " + objimplpend_dist.calcula_pendiente(punto1, punto3));

          infinitomp1p2 = String.valueOf(mp1p2);
          infinitomp2p3 = String.valueOf(mp2p3);
          infinitomp1p3 = String.valueOf(mp1p3);

          System.out.println("Pendiente entre P1 y P2: " + infinitomp1p2);
          System.out.println("Pendiente entre P2 y P3: " + infinitomp2p3);
          System.out.println("Pendiente entre P1 y P3: " + infinitomp1p3);

          if (!(infinitomp1p2.equals("-Infinity") || infinitomp1p2.equals("Infinity") ||
              infinitomp2p3.equals("-Infinity") || infinitomp2p3.equals("Infinity") ||
              infinitomp1p3.equals("-Infinity") || infinitomp1p3.equals("Infinity"))) {
            if (Math.abs(mp1p2 - mp2p3) < 0.0001 && Math.abs(mp2p3 - mp1p3) < 0.0001)
              resp = Boolean.TRUE;
            else
              resp = Boolean.FALSE;
            colineales = Boolean.valueOf(resp);
          } else {
            resp = true;
            colineales = Boolean.valueOf(resp);
          }
        }

        System.out.println("El servidor envia el objeto Boolean al cliente");
        System.out.println(" respuesta: " + Boolean.toString(resp));
        out.writeObject(colineales);
      } catch (Exception ex) {
        System.out.println(ex);
      }
    } // fin del metodo run
  } // fin de la clase interna PendienteDistanciaThread
} // fin de ServidorColinealesSocket.java