/**
 * @(#)ServidorPenInter con socket
 *
 *
 * @author 
 *Modificado por Prof. Alvaro Pino N.
 * @version 1.00 2008/11/19
 * Programa Servidor que genera el objeto remoto y 
 * lo ofrece a traves de socket.
 *
 */

import java.io.*;
import java.net.*;
import *;
import java.awt.*;
import java.util.Date;




public class ServidorPenInterSocket extends JFrame{
	
	private static JTextArea jtaLog;
	
	private Punto p1;
	private Punto p2;
	
	public ServidorPenInterSocket() {
   
   
    // Create a scroll pane to hold text area
    
    JScrollPane scrollPane = new JScrollPane( jtaLog = new JTextArea());

    // Add the scroll pane to the frame
    
    getContentPane().add(scrollPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setTitle("Pendiente   Server Using Object Streams");
    setLocationRelativeTo(null);
    setVisible(true);
}
    
 public static void main(String args [])
 {
 	
 	ServidorPenInterSocket pendiente = new ServidorPenInterSocket();
 	 	
 	
 		
 	ImplPendInterSocket  objimplpend = new ImplPendInterSocket();
 	
 	
 	
 	
    // Establish server socket
    
    try {
     
      // Create a server socket
      
      ServerSocket serverSocket = new ServerSocket(9000);
     
      pendiente.jtaLog.append(new Date() + ": Start a new server\n");

      // Count the number of threads started
      
      int count = 1;

      while (true) {
       
        // Connect to a client
        
        Socket socket = serverSocket.accept();
        
        jtaLog.append(new Date() + ": A client at " +
          socket.getInetAddress().getHostAddress() + " connected\n");

        // Start a new thread to register a client
        
      new PendienteThread(socket, count++).start();
        
      }
    }catch (IOException ex) {
      jtaLog.append(new Date() + ": " + ex);
    }
  
  
  
  }

 	
 	
// Naming.rebind("//127.0.0.1/ImplObjeRemoto", objimplpend);
 	
/* System.out.println("Objeto   registrado");
 	
 		
     	}catch(Exception e)
     	{
     	System.out.println("ERROR: " + e.getMessage());
 		
 		e.printStackTrace();	
     	//	System.out.println(e);
     	}
 } */


    
    
    /** Define a thread to process the client registration */
  
  static class PendienteThread extends Thread {
  	
    // The socket to serve a client
    private Socket socket;
    
    private Linea objLinea;
    
    private double m;
    
    private int clientNo; // The thread number

    // Object input stream to get input from the client
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    
    public PendienteThread(Socket socket, int clientNo) {

    	
    // Create a  thread
      this.socket = socket;
      this.clientNo = clientNo;

      jtaLog.append(new Date() + ": Thread " + clientNo
        + " started\n");
       // Create an input stream to receive data from a client
      
try  {
     in = new ObjectInputStream(socket.getInputStream());
     out = new ObjectOutputStream(socket.getOutputStream());
     
     }catch(IOException ex) {
        jtaLog.append(new Date() + ": " + ex);
     } 
  }



    public void run() {
      try {
      	
        // Receive data from the client
      ImplPendInterSocket  objimplpend = new ImplPendInterSocket();
      
      objLinea = (Linea)in.readObject();
     //  p2  = (Punto) in.readObject();
       
      System.out.println("En el servidor se recibe los Punto p1 y p2");
   
       System.out.println(objLinea.p1.display());
       System.out.println(objLinea.p2.display());
       
       
     
      // desplegar(p2);      	
    //  sumar(C);
     
   //  desplegar(C);
   System.out.println("El servidor Calcula la pendiente");
  
    objLinea.setPendiente(objimplpend.calcula_pendiente( objLinea.p1,objLinea.p2));
   
   System.out.println("m = " + objLinea.getPendiente());
   
   objLinea.setB(objimplpend.calculaB(objLinea.p1,objLinea.getPendiente()));
    
   System.out.println("b = " + objLinea.getB());
   
   objLinea.setEjeX(objimplpend.calIntersecEjeX(objLinea.p1,objLinea.getB(),objLinea.getPendiente()));
   objLinea.setEjeY(objimplpend.calIntersecEjeY(objLinea.getB())); 
 
    
   /*      
    Linea l = new Linea(linea.p1,m);
    l.calcula_pendiente();
    l.imprime_linea();
   //   C = calcular();
    //  desplegar(C);
  */    
  
    
    System.out.println(objLinea.imprime_linea()); 
   
    out.writeObject(objLinea);
           
      }
      catch (Exception ex) {
        System.out.println(ex);
        ex.printStackTrace();
      }
    }
  
  
   
  
}
}