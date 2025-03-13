
/*Eric Chen */
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

// esta clase debe tener el metodo run para recibir la informacion del servidor
public class RegistrationClientUsingvalorFuturo extends JApplet implements ActionListener {

  private JButton jbtCalcular = new JButton("Calcular");
  private JButton jbtClear = new JButton("Clear");
  private static ValorFuturoPanel ValorFuturoPanel = new ValorFuturoPanel();
  private boolean isStandAlone = false;
  String host = "localhost";
  Valor_Futuro futuro;

  public void init() {
    add(ValorFuturoPanel, BorderLayout.CENTER);
    JPanel jpSouth = new JPanel(new FlowLayout());
    jpSouth.add(jbtCalcular);
    jpSouth.add(jbtClear);
    add(jpSouth, BorderLayout.SOUTH);
    jbtCalcular.addActionListener(this);
    jbtClear.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtCalcular) {
      try {
        Socket socket = new Socket(host, 8000);
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        futuro = ValorFuturoPanel.getValorFuturo();
        toServer.writeObject(futuro);
        ObjectInputStream ins = new ObjectInputStream(socket.getInputStream());
        try {
          futuro = (Valor_Futuro) ins.readObject();
          writeToArea(futuro);
        } catch (Exception ex) {
          System.out.println(ex);
        }
      } catch (IOException ex) {
        System.err.println(ex);
      }
    } else if (e.getSource() == jbtClear) {
      ValorFuturoPanel.setClearTriangulo();
    }
  }

  private synchronized static void writeToArea(Valor_Futuro t) {
    ValorFuturoPanel.setValorFuturo(t);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Register value Future Client");
    RegistrationClientUsingvalorFuturo applet = new RegistrationClientUsingvalorFuturo();
    applet.isStandAlone = true;
    if (args.length == 1)
      applet.host = args[0];
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();
    frame.pack();
    frame.setVisible(true);
  }
}
