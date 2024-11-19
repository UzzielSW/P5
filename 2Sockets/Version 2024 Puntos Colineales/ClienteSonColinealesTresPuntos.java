
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClienteSonColinealesTresPuntos extends JFrame implements ActionListener {

  public static void main(String[] args) {
    new ClienteSonColinealesTresPuntos("Cliente Son Tres Puntos Colineales ?");
  }

  private JButton jbtColiDistancia;
  private JButton jbtColiPendiente;
  private JButton jbtClear;

  public Punto punto1;
  public Punto punto2;
  public Punto punto3;

  // Text fields for Point 1
  private JTextField jtfNumx1, jtfNumy1;

  // Text fields for Point 2
  private JTextField jtfNumx2, jtfNumy2;

  // Text fields for Point 3
  private JTextField jtfNumx3, jtfNumy3;

  // Text fields for Colineal
  private JTextField jtfCol1, jtfCol2, jtfCol3;

  private Boolean resp;

  public String infinitomp1p2;
  public String infinitomp2p3;
  public String infinitomp1p3;

  public String actionCommand;

  public String host = "localhost";
  private Socket socket;

  private ObjectOutputStream toServer;
  private ObjectInputStream fromServer;

  public ClienteSonColinealesTresPuntos(String titulo) {
    super(titulo);

    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new JLabel("Punto 1: "));
    p1.add(new JLabel("Coordenada x"));
    p1.add(jtfNumx1 = new JTextField(5));
    p1.add(new JLabel("Coordenada y"));
    p1.add(jtfNumy1 = new JTextField(5));

    p1.add(new JLabel("Colineal"));
    p1.add(jtfCol1 = new JTextField(8));

    jtfCol1.setEditable(false);

    JPanel p3 = new JPanel();
    p3.setLayout(new FlowLayout());
    p3.add(new JLabel("Punto 2: "));
    p3.add(new JLabel("Coordenada x"));
    p3.add(jtfNumx2 = new JTextField(5));
    p3.add(new JLabel("Coordenada y"));
    p3.add(jtfNumy2 = new JTextField(5));

    p3.add(new JLabel("Colineal "));
    p3.add(jtfCol2 = new JTextField(8));

    jtfCol2.setEditable(false);

    JPanel p43 = new JPanel();
    p43.setLayout(new FlowLayout());

    p43.add(new JLabel("Punto 3:"));
    p43.add(new JLabel("Coordenada x"));
    p43.add(jtfNumx3 = new JTextField(5));
    p43.add(new JLabel("Coordenada y"));
    p43.add(jtfNumy3 = new JTextField(5));
    p43.add(new JLabel("Colineal "));
    p43.add(jtfCol3 = new JTextField(8));
    jtfCol3.setEditable(false);

    // Panel p2 to hold buttons
    JPanel p2 = new JPanel();

    p2.setLayout(new FlowLayout());
    p2.add(jbtColiDistancia = new JButton("ColiDistancia"));
    p2.add(jbtColiPendiente = new JButton("ColiPendiente"));
    p2.add(jbtClear = new JButton("Clear"));

    // Add panels to the frame
    JPanel p4 = new JPanel(new GridLayout(4, 1));
    p4.add(p1);
    p4.add(p3);
    p4.add(p43);

    setLayout(new BorderLayout());
    add(p4, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    // Register listeners
    jbtColiDistancia.addActionListener(this);
    jbtColiPendiente.addActionListener(this);

    jbtClear.addActionListener((ActionEvent e) -> {
      // clear();
      clearText();
    });

    System.out.println("El Cliente enviara un Objeto String actionPerformed y  tres objetos Punto p1, p2 y p3");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void conectar() {
    try {
      // Establish connection with the server
      socket = new Socket(host, 10000);

      // Create an output stream to the server
      toServer = new ObjectOutputStream(socket.getOutputStream());
      fromServer = new ObjectInputStream(socket.getInputStream());

      System.out.println("El Cliente envia el Objeto String " + actionCommand);
      toServer.writeObject(actionCommand);

      System.out.println("El Cliente envia los  tres Puntos");
      toServer.writeObject(punto1);
      toServer.writeObject(punto2);
      toServer.writeObject(punto3);

      System.out.println("El Cliente recibe la respuesta son colineales ?");
      resp = (Boolean) fromServer.readObject();
      desplegarSolucion();
    } catch (NumberFormatException n) {
      JOptionPane.showMessageDialog(null, n.getMessage(),
          "Operation No ha capturado los datos",
          JOptionPane.ERROR_MESSAGE);
    } catch (RuntimeException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
          "Operation error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e2) {
      System.out.println(e2.getMessage());
    }
  }

  public void actionPerformed(ActionEvent e) {
    actionCommand = e.getActionCommand();
    if ("ColiDistancia".equals(actionCommand) || "ColiPendiente".equals(actionCommand)) {
      sacaValores();
      conectar();
    }
  }// fin del metodo actionPerformed

  public void sacaValores() {
    double numx1;
    double numy1;

    double numx2;
    double numy2;

    double numx3;
    double numy3;

    try {
      numx1 = (Double.parseDouble(jtfNumx1.getText().trim()));
      numy1 = (Double.parseDouble(jtfNumy1.getText().trim()));
      punto1 = new Punto(numx1, numy1);

      numx2 = (Double.parseDouble(jtfNumx2.getText().trim()));
      numy2 = (Double.parseDouble(jtfNumy2.getText().trim()));
      punto2 = new Punto(numx2, numy2);

      numx3 = (Double.parseDouble(jtfNumx3.getText().trim()));
      numy3 = (Double.parseDouble(jtfNumy3.getText().trim()));
      punto3 = new Punto(numx3, numy3);

    } catch (NumberFormatException m) {
      JOptionPane.showMessageDialog(null,
          "Tiene que ingresar un valor double",
          " Esto es un ERROR",
          JOptionPane.ERROR_MESSAGE);
      clearText();
    }
  }

  public void desplegarSolucion() {
    jtfCol1.setText(String.valueOf(resp));
    jtfCol2.setText(String.valueOf(resp));
    jtfCol3.setText(String.valueOf(resp));
  }

  private void clear() {
    jtfNumx1.setText("");
    jtfNumy1.setText("");
    jtfNumx2.setText("");
    jtfNumy2.setText("");
    jtfNumx3.setText("");
    jtfNumy3.setText("");
    jtfCol1.setText("");
    jtfCol2.setText("");
    jtfCol3.setText("");
  }

  public void clearText() {
    String sjtextnumx1, sjtextnumy1;
    String sjtextnumx2, sjtextnumy2;
    String sjtextnumx3, sjtextnumy3;

    sjtextnumx1 = jtfNumx1.getText().trim();
    sjtextnumy1 = jtfNumy1.getText().trim();

    sjtextnumx2 = jtfNumx2.getText().trim();
    sjtextnumy2 = jtfNumy2.getText().trim();

    sjtextnumx3 = jtfNumx3.getText().trim();
    sjtextnumy3 = jtfNumy3.getText().trim();

    if (!(sjtextnumx1.equals("") || sjtextnumy1.equals("")) ||
        !(sjtextnumx2.equals("") || sjtextnumy2.equals("")) ||
        !(sjtextnumx3.equals("") || sjtextnumy3.equals("")) ||
        (sjtextnumx1.length() != 0 || sjtextnumy1.length() != 0) ||
        (sjtextnumx2.length() != 0 || sjtextnumy2.length() != 0) ||
        (sjtextnumx3.length() != 0 || sjtextnumy3.length() != 0)) {
      clear();
    } else {
      JOptionPane.showMessageDialog(this,
          "Los campos  estan limpios",
          " Esto es un ERROR",
          JOptionPane.ERROR_MESSAGE);
    }
  }
} // fin de la clase.