import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientObjectTriangulo extends JFrame implements ActionListener {

  public static void main(String[] args) {
    new ClientObjectTriangulo();
  }

  private JTextField jtf = new JTextField(10);
  private JTextField jtf2 = new JTextField(10);
  private JTextField jtfArea = new JTextField(10);
  // Text area to display contents
  private JTextArea jta = new JTextArea();
  private JButton jbCalcular = new JButton("Calcular");
  private JButton jbLimpiar = new JButton("Limpiar");
  public Triangulo trianguloCliente;
  public Triangulo trianguloServer;
  // IO streams
  private ObjectOutputStream toServer;
  private ObjectInputStream fromServer;
  private Socket socket;

  public ClientObjectTriangulo() {
    JPanel p = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new FlowLayout());
    p2.add(new JLabel("Base"));
    p2.add(jtf2);
    p2.add(new JLabel("Altura "));
    p2.add(jtf);
    p2.add(new JLabel("Area "));
    p2.add(jtfArea);
    jtfArea.setEditable(false);
    p.add(p2, BorderLayout.NORTH);
    JPanel p3 = new JPanel();
    p3.add(jbCalcular);
    p3.add(jbLimpiar);

    jtf.setHorizontalAlignment(JTextField.RIGHT);
    jtf2.setHorizontalAlignment(JTextField.RIGHT);

    setLayout(new BorderLayout());
    add(p, BorderLayout.NORTH);
    add(p3, BorderLayout.SOUTH);
    add(new JScrollPane(jta), BorderLayout.CENTER);

    jbCalcular.addActionListener(this);
    jbLimpiar.addActionListener(this);

    KeyAdapter keyA = new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          jbCalcular.doClick();
        }
      }
    };

    jtf.addKeyListener(keyA);
    jtf2.addKeyListener(keyA);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        disconnect();
      }
    });

    setTitle("Client Triangulo Object");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);

    try {
      // Create a socket to connect to the server
      socket = new Socket("localhost", 8000);
      toServer = new ObjectOutputStream(socket.getOutputStream());
      fromServer = new ObjectInputStream(socket.getInputStream());
    } catch (IOException ex) {
      jta.append(ex.toString() + '\n');
    }
  }

  public void clean() {
    jtf.setText("");
    jtf2.setText("");
    jta.setText("");
    jtfArea.setText("");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbCalcular) {
      try {
        double base = Double.parseDouble(jtf.getText().trim());
        double altura = Double.parseDouble(jtf2.getText().trim());

        jta.append("\nEl Cliente envia el Triangulo al Servidor");

        trianguloCliente = new Triangulo(base, altura);
        toServer.writeObject(trianguloCliente);
        toServer.flush();

        jta.append("\nEl Cliente recibe el Triangulo");
        try {
          trianguloServer = (Triangulo) fromServer.readObject();

          jta.append("\n" + trianguloServer.toString());
          jta.append("\nSu area es " + trianguloServer.getArea() + "\n");
          jtfArea.setText(Double.toString(trianguloServer.getArea()));
        } catch (ClassNotFoundException ex) {
          jta.append("error al hacer cast");
        }
      } catch (IOException ex) {
        System.err.println(ex);
      } catch (RuntimeException ex) {
        jta.setText("Error! Ingrese numeros de doble presicion");
        JOptionPane.showMessageDialog(this, ex.getMessage(),
            "Operation error", JOptionPane.ERROR_MESSAGE);
        clean();
      }
    } else if (e.getSource() == jbLimpiar) {
      clean();
    } 
  }

  public void disconnect() {
    try {
      socket.close();
    } catch (IOException io) {
    } finally {
      System.exit(0);
    }
  }
}