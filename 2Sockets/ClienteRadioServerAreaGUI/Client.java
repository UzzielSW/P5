// Client.java: The client sends the input to the server and receives
// result back from the server
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {
  // Text field for receiving radius
  private JTextField jtf = new JTextField(); 
  
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
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Enter radius"), BorderLayout.WEST);
    p.add(jtf, BorderLayout.CENTER);
    jtf.setHorizontalAlignment(JTextField.RIGHT);
    
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p, BorderLayout.NORTH);
    getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

    jtf.addActionListener(this); // Register listener

    setTitle("Client");
    setSize(500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    try {
      // Create a socket to connect to the server
      Socket connectToServer = new Socket("localhost", 8000);
      //Socket connectToServer = new Socket("130.254.204.36", 8000);
      //Socket connectToServer = new Socket(
      //  "drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      isFromServer = new DataInputStream(
        connectToServer.getInputStream());

      // Create an output stream to send data to the server
      osToServer =
        new DataOutputStream(connectToServer.getOutputStream());
    }
    catch (IOException ex) {
      jta.append(ex.toString() + '\n');
    }
  }

  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    if (e.getSource() instanceof JTextField) {
      try {
        // Get the radius from the text field
        double radius = Double.parseDouble(jtf.getText().trim());

        // Send the radius to the server
        osToServer.writeDouble(radius);
        osToServer.flush();

        // Get area from the server
        double area = isFromServer.readDouble();

        // Display to the text area
        jta.append("Radius is " + radius + "\n");
        jta.append("Area received from the server is " 
          + area + '\n');
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
    }
  }
}