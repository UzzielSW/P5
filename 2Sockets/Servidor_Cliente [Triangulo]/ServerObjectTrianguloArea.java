import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerObjectTrianguloArea extends JFrame {
  // Text area for displaying contents
  private JTextArea jta = new JTextArea();
  private Triangulo objTriangulo;
  private ServerSocket serverSocket;

  public static void main(String[] args) {
    new ServerObjectTrianguloArea();
  }

  public ServerObjectTrianguloArea() {
    setLayout(new BorderLayout());
    add(new JScrollPane(jta), BorderLayout.CENTER);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          serverSocket.close();
        } catch (IOException ex) {
        }
        System.exit(0);
      }
    });

    setTitle("Server Triangulo Object");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);

    try {
      // Create a server socket
      serverSocket = new ServerSocket(8000);
      jta.append("Server started at " + new Date() + '\n');

      // Listen for a connection request
      Socket connectToClient = serverSocket.accept();

      ObjectInputStream in = new ObjectInputStream(connectToClient.getInputStream());
      ObjectOutputStream out = new ObjectOutputStream(connectToClient.getOutputStream());

      while (true) {
        try {
          jta.append("\n\n.:El Servidor recibe el Triangulo del cliente:.");

          objTriangulo = (Triangulo) in.readObject();
          objTriangulo.calcArea();

          jta.append("\n" + objTriangulo.toString());
          jta.append("\nEl area es: " + objTriangulo.getArea());

          jta.append("\n.:El servidor devuelve el objeto Triangulo al cliente:.");
          out.writeObject(objTriangulo);
        } catch (ClassNotFoundException e) {
          System.out.println("error al hacer cast");
        } // fin del try interno
      } // fin del while
    } catch (IOException ex) {
      System.err.println(ex);
    } // fin del try externo
  } // fin del Constructor
}// fin de la clase