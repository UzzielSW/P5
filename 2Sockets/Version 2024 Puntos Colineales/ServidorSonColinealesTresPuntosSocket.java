/**
 * @(#)ServidorSonColinealesTresPuntosSocket.java
 *
 * @author  Prof. Alvaro Pino N.
 * @version 1.00
 * @Date  8/11/2021
 * @Date  24/10/2024
 * Programa Servidor recibe un Objeto String actionCommand y 
 *  tres  objetos Puntos remotos y  ofrece el servicio de determinar 
 *  si son colineales a traves de socket.
 *
 */

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ServidorSonColinealesTresPuntosSocket 
               extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private static JTextArea jtaLog;
	
	private static Punto punto1;
	private static Punto punto2;
	private static Punto punto3;
	
   public static String infinitomp1p2;
   public static String infinitomp2p3;
   public static String infinitomp1p3;
   public static String actionCommand;
   
   public static double mp1p2;
   		
   public static double mp2p3;
  
   public static double mp1p3;
   
   public static boolean resp;
   
   private static Boolean colineales;
   
  private static double distP1P2;
  private static double distP2P3;
  private static double distP1P3;
	
	public ServidorSonColinealesTresPuntosSocket(String titulo) {
       super(titulo);
   
    // Create a scroll pane to hold text area
    
    JScrollPane scrollPane = 
    	new JScrollPane( jtaLog = new JTextArea());

    // Add the scroll pane to the frame
    
    getContentPane().add(scrollPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setTitle("Colineal Tree Points  Server Using Object Streams");
    setVisible(true);
}
    
 public static void main(String args [])
 {	
 	ServidorSonColinealesTresPuntosSocket pendiente =
 new ServidorSonColinealesTresPuntosSocket("Servidor de Son Colineales ?");
 	 	
    // Establish server socket
    
    try {
     
      // Create a server socket
      
      ServerSocket serverSocket = new ServerSocket(10000);
     
     ServidorSonColinealesTresPuntosSocket.jtaLog.append(new Date() + ": Start a new server\n");

      // Count the number of threads started
      
      int count = 1;

      while (true) {
       
        // Connect to a client
       System.out.println("El servidor espera que un cliente" +
       	" envie un Objeto String actionPerformed y "+
        " tres objetos Punto p1, p2 y p3");  
        
        Socket socket = serverSocket.accept();
        
        jtaLog.append(new Date() + ": A client at " +
          socket.getInetAddress().getHostAddress() + " connected\n");

        // Start a new thread to register a client
     System.out.println("\nStart a new thred to register a client: "+count); 
        
      new PendienteDistanciaThread(socket, count++).start();
        
      }
    }catch (IOException ex) {
      jtaLog.append(new Date() + ": " + ex);
    }catch(Exception e)
     	{
     	System.out.println("ERROR: " + e.getMessage());
 		
 		e.printStackTrace();	
     	//	System.out.println(e);
     	}
 
  }
  
    /** Define a thread to process the client registration */
  
  static class PendienteDistanciaThread extends Thread {
  	
    // The socket to serve a client
    private Socket socket;
  
    private int clientNo; // The thread number

    // Object input stream to get input from the client
    private ObjectInputStream in;
    private ObjectOutputStream out;
      
    public PendienteDistanciaThread(Socket socket, int clientNo) {
	
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
      ImplPendDistSocket  objimplpend_dist = 
      	new ImplPendDistSocket();
           
       actionCommand = (String)in.readObject();
       System.out.println("\nEl servidor se recibe un objeto "+
       	"String actionCommand:  " + actionCommand);
      
      System.out.println("\nEl servidor se recibe "+
      	"los tres objetos puntos  "+
      "Punto punto1, punto2 y punto3");
      	                            
      punto1 = (Punto)in.readObject();
      punto2 = (Punto)in.readObject();
      punto3 = (Punto)in.readObject();
           
       System.out.println("Punto P1: " + punto1.display());
       System.out.println("Punto P2: " + punto2.display());
       System.out.println("Punto P3: " + punto3.display());
       
    if ("ColiDistancia".equals(actionCommand))
     { 
  	  System.out.println("El servidor Calcula la distancia entre los Puntos: ");
  	
  	 distP1P2 = Math.abs( punto1.distancia(punto2));
       		
    System.out.println("Distancia de P1 a P2: " + distP1P2  );

   distP2P3 =Math.abs(objimplpend_dist.distancia(punto2,punto3));
        		
   System.out.println("Distancia de P2 a P3: " + distP2P3);
   
  distP1P3 = Math.abs(objimplpend_dist.distancia(punto1,punto3));
  System.out.println("Distancia de P1 a P3: " + distP1P3 );
  
      if ( Math.abs(distP1P3 - ( distP1P2 + distP2P3 ) ) <= .0001 ) 
        	resp = Boolean.TRUE;
     else 
    	    resp = Boolean.FALSE;
    //	colineales = new Boolean(resp);   	    		  
       colineales = Boolean.valueOf(resp);	  
          	
   }// if ("ColiDistancia".equals(actionCommand)) 
   else if ("ColiPendiente".equals(actionCommand))
     {
     System.out.println("El servidor Calcula la pendiente de los Puntos: ");
     mp1p2 =objimplpend_dist.calcula_pendiente( punto1,punto2);

      System.out.println(" m1  = " + 
      objimplpend_dist.calcula_pendiente( punto1,punto2));

      mp2p3= objimplpend_dist.calcula_pendiente( punto2,punto3);

     System.out.println(" m2  = " +
     objimplpend_dist.calcula_pendiente( punto2,punto3));

     mp1p3 = objimplpend_dist.calcula_pendiente( punto1,punto3);

   System.out.println(" m3  = " +
    objimplpend_dist.calcula_pendiente( punto1,punto3));

   infinitomp1p2 =  String.valueOf(mp1p2);
   infinitomp2p3 = String.valueOf(mp2p3) ;
   infinitomp1p3 =  String.valueOf(mp1p3);
                    
   System.out.println("Pendiente entre P1 y P2: " + infinitomp1p2); 
   System.out.println("Pendiente entre P2 y P3: " + infinitomp2p3);
   System.out.println("Pendiente entre P1 y P3: " + infinitomp1p3); 
                    	
 if( !(( infinitomp1p2.equals("-Infinity") || infinitomp1p2.equals("Infinity"))&&
 	  (infinitomp2p3.equals("-Infinity")   ||  infinitomp2p3.equals("Infinity"))  &&
 	  (infinitomp1p3.equals("-Infinity")   || infinitomp1p3.equals("Infinity")) ) )
       {  
           if ( Math.abs( mp1p2 - mp2p3) < 0.0001 &&
           	    Math.abs( mp2p3 -  mp1p3) < 0.0001 &&
           	    Math.abs( mp1p2 -  mp1p3) < 0.0001  ) 
        		  resp = Boolean.TRUE;
           else 
    	         resp = Boolean.FALSE;
    	              		  
        	colineales = Boolean.valueOf(resp);	  
      }
      else {
      	        resp = true;
                colineales = Boolean.valueOf(resp);
               }
                                    	                 	                 	
     } // if ("ColiPendiente".equals(actionCommand))
     
  System.out.println("El servidor envia el objeto Boolean al cliente"); 
  System.out.println(" respuesta: " + Boolean.toString(resp));	
  out.writeObject(colineales);
  	   
      }catch (Exception ex) {
        System.out.println(ex);
        ex.printStackTrace();
      }
    
    } // fin del metodo run
  
   } // fin de la clase interna PendienteDistanciaThread
}  // fin de ServidorColinealesSocket.java