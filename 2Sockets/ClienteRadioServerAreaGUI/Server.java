// Server.java: The server accepts data from the client, processes it
// and returns the result back to the client
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {
  // Text area for displaying contents
  private JTextArea jta = new JTextArea();
  
  public static void main(String[] args) {
    new Server();
  }
  
  public Server() {
    // Place text area on the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);
    
    setTitle("Server");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!
    
    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);
      jta.append("Server started at " + new Date() + '\n');
      
      // Listen for a connection request
      Socket connectToClient = serverSocket.accept();
      
      // Create data input and output streams
      DataInputStream isFromClient = new DataInputStream(
        connectToClient.getInputStream());
      DataOutputStream osToClient = new DataOutputStream(
        connectToClient.getOutputStream());
      
      while (true) {
        // Receive radius from the client
        double radius = isFromClient.readDouble();
        
        // Compute area
        double area = radius*radius*Math.PI;
        
        // Send area back to the client
        osToClient.writeDouble(area);
        
        jta.append("radius received from client: " + radius + '\n');
        jta.append("Area found: " + area + '\n');
      }
    }
    catch(IOException ex) {
      System.err.println(ex);
    }
  }
}