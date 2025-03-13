// ServerObjectTrianguloArea.java: 
//The server accepts Triangle from the client, processes it
// and returns the result back to the client
//The client sends the input to the server and receives
// result back from the server  
/*
 * @author: MSc. Álvaro Pino N.
 *  Date: 26/10/2021
 *  Version 2
 *  Prueba Formativa
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Date;

public class ServerObjectTrianguloArea extends JFrame {
  // Text area for displaying contents
  private JTextArea jta = new JTextArea();
  private Triangulo objTriangulo;
   
  public static void main(String[] args) {
    new ServerObjectTrianguloArea();
  }
  
  public ServerObjectTrianguloArea() {
    // Place text area on the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);
    
    setTitle("Server Object Triangulo");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setVisible(true); // It is necessary to show the frame here!
    
    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);
      jta.append("Server started at " + new Date() + '\n');
      
      // Listen for a connection request
      Socket connectToClient = serverSocket.accept();
         
    ObjectInputStream  in = 
    	new ObjectInputStream(connectToClient.getInputStream());
    ObjectOutputStream out = 
    	new ObjectOutputStream(connectToClient.getOutputStream());
         
      while (true) {
      	try{
      	
        System.out.println("El Servidor recibe el Triangulo from the client");
        
        objTriangulo = (Triangulo)in.readObject();
        objTriangulo.calcArea();
        
         System.out.println("\nTriangulo de Base: " + objTriangulo.getBase() +
        	" y de Altura "+objTriangulo.getAltura() + "\n");
        System.out.println("El area es: " +objTriangulo.getArea());
        
        System.out.println("El servidor devuelve  el objeto Triangulo al cliente"); 
        out.writeObject(objTriangulo);
  
         jta.append("\nTriangulo de Base: " + objTriangulo.getBase() +
        	" y de Altura "+objTriangulo.getAltura() + "\n");
        	
        jta.append("\nArea : " + objTriangulo.calcArea() + "\n");
        
      	}catch(ClassNotFoundException e){
      		System.out.println("Error");
      	}  // fin del try interno
         
      }  // fin del while
    }catch(IOException ex) {
      System.err.println(ex);
    }  // fin del try externo
  } // fin del Constructor
}// fin de la clase