
// Client.java: The client sends the input to the server and receives
// result back from the server
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {
  // Text field for receiving radius
  private JTextField jtf = new JTextField();
  private JTextField jtf2 = new JTextField();
  // Text area to display contents
  private JTextArea jta = new JTextArea();

  // IO streams
  DataOutputStream osToServer;
  DataInputStream isFromServer;

  public static void main(String[] args) {
    new Client();
  }

  public Client() {
    // Panel p to hold the label and text field
    JPanel p = new JPanel();
    JPanel p2 = new JPanel(new BorderLayout());
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Base"), BorderLayout.WEST);
    p2.add(new JLabel("Altura "), BorderLayout.WEST);
    p2.add(jtf2, BorderLayout.CENTER);
    p.add(jtf, BorderLayout.CENTER);
    p.add(p2, BorderLayout.SOUTH);
    jtf.setHorizontalAlignment(JTextField.RIGHT);
    jtf2.setHorizontalAlignment(JTextField.RIGHT);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p, BorderLayout.NORTH);
    getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

    jtf.addActionListener(this); // Register listener
    jtf2.addActionListener(this);

    setTitle("Client");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    try {
      // Create a socket to connect to the server
      Socket connectToServer = new Socket("localhost", 8000);
      // Socket connectToServer = new Socket("130.254.204.36", 8000);
      // Socket connectToServer = new Socket(
      // "drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      isFromServer = new DataInputStream(
          connectToServer.getInputStream());

      // Create an output stream to send data to the server
      osToServer = new DataOutputStream(connectToServer.getOutputStream());
    } catch (IOException ex) {
      jta.append(ex.toString() + '\n');
    }
  }

  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    if (e.getSource() instanceof JTextField) {
      try {
        // Get the radius from the text field
        double base = Double.parseDouble(jtf.getText().trim());
        double altura = Double.parseDouble(jtf2.getText().trim());
        // Send the base y altura to the server
        osToServer.writeDouble(base);
        osToServer.writeDouble(altura);
        osToServer.flush();

        // Get area from the server
        double area = isFromServer.readDouble();

        // Display to the text area
        jta.append("Tringulo de Base " + base + " y altura " + altura);
        jta.append("\nSu area es " + area);
      } catch (IOException ex) {
        System.err.println(ex);
      }
    }
  }
}