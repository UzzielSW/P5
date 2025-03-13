
/*Eric Chen */import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

// esta clase debe tener el metodo run para recibir la informacion del servidor
public class RegistrationClientUsingTriangulo extends JApplet implements ActionListener {

  private JButton jbtRegister = new JButton("Register");
  private JButton jbtClear = new JButton("Clear");
  private static TrianguloPanel trianguloPanel = new TrianguloPanel();
  private boolean isStandAlone = false;
  String host = "localhost";
  Triangulo triangulo;

  public void init() {
    getContentPane().add(trianguloPanel, BorderLayout.CENTER);
    JPanel jpSouth = new JPanel(new FlowLayout());
    jpSouth.add(jbtRegister);
    jpSouth.add(jbtClear);
    getContentPane().add(jpSouth, BorderLayout.SOUTH);
    jbtRegister.addActionListener(this);
    jbtClear.addActionListener(this);
    if (!isStandAlone)
      host = getCodeBase().getHost();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtRegister) {
      try {
        // Establish connection with the server
        Socket socket = new Socket(host, 8000);
        // Create an output stream to the server
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        // Get text field
        triangulo = trianguloPanel.getTriangulo();
        // Get data from text fields and send it to the server
        toServer.writeObject(triangulo);
        ObjectInputStream ins = new ObjectInputStream(socket.getInputStream());
        try {
          // recibe informacion del Cliente
          triangulo = (Triangulo) ins.readObject();
          writeToArea(triangulo);
        } catch (Exception ex) {
          System.out.println(ex);
        }
        // areat.setText(t);
      } catch (IOException ex) {
        System.err.println(ex);
      }
    } else if (e.getSource() == jbtClear) {
      trianguloPanel.setClearTriangulo();
    }
  }

  private synchronized static void writeToArea(Triangulo t) {
    trianguloPanel.setTriangulo(t);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Register Triangulo Client");
    RegistrationClientUsingTriangulo applet = new RegistrationClientUsingTriangulo();
    applet.isStandAlone = true;
    if (args.length == 1)
      applet.host = args[0];
    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    // Invoke init() and start()
    applet.init();
    applet.start();
    // Display the frame
    frame.pack();
    frame.setVisible(true);
  }
}
