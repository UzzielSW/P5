/**
 * @(#)ServerPresionBusoSocket.java
 *    
 * @ Programacion V
 * @author Prof. Alvaro Pino N.
 * @version 2
 * @Date: 30/11/2021
 * @Date: 1/12/2021
 *  @Date: 2/12/2021
 */
import java.io.*;
import java.net.*;
import java.util.Date;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server2PresionBusoSocket extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
  private static JTextArea jtaLog;
  
  private static Punto puntoUno;
  
  private static ImplementaPresionBuso pb;
  private static Double presion;
 // private static Distancia d;
  private static Double profundidad;
  
   public static String actionCommand;
     
public Server2PresionBusoSocket(String titulo){
		super(titulo);
		
		 JScrollPane scrollPane = 
    	new JScrollPane( jtaLog = new JTextArea());

    // Add the scroll pane to the frame
    
    getContentPane().add(scrollPane, BorderLayout.CENTER);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setTitle("Presion Atmosferica sobre un Buso");
		this.setVisible(true);	
	} // fin del constructor de la clase
	     
      /** Define a thread to process the client registration */
  
  static class PresionBusoThread extends Thread {
  	
    // The socket to serve a client
    private Socket socket;
  
    private int clientNo; // The thread number

    // Object input stream to get input from the client
    private ObjectInputStream in;
    private ObjectOutputStream out;
      
    public PresionBusoThread (Socket socket, int clientNo) {
	
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
  }  // fin del constructor de la clase interna
  
 public void run() {
     
      try {
      	
        // Receive data from the client
           
       actionCommand = (String)in.readObject();
       
       System.out.println("\nEl servidor se recibe un objeto "+
       	"String actionCommand:  " + actionCommand);
      
      System.out.println("\nEl servidor se recibe "+
      	"Un Objeto Punto con el cual se calcula la profundidad" +
      	 " y la presion ejercida sobre el buso "+
         "Punto 1");
      	                            
      puntoUno = (Punto)in.readObject();
                  
       System.out.println("Punto 1: " + puntoUno.getDetails());
 /*              
    if ("PresionBuso".equals(actionCommand) || 
    	"Enter".equals(actionCommand) || 
    	"Presion".equals(actionCommand))
     {  
     */	   	  
     realizarCalculos();
  	   	              
  System.out.println("El servidor envia dos objetos Double  al cliente"); 
  System.out.println("Presion: " + pb.getPresion()); 
  presion = Double.valueOf(pb.getPresion());
  out.writeObject(presion);
  profundidad = Double.valueOf(pb.getProfundidad());
  System.out.println("Presion: " + pb.getProfundidad()); 
  out.writeObject(profundidad);
 
  //  }
      }catch (Exception ex) {
        System.out.println(ex);
        ex.printStackTrace();
      }
    
    } // fin del metodo run
     
   public void realizarCalculos()
   { 
   System.out.println("Profundidad:" + 
   	puntoUno.calcProfundidad());
	
	System.out.println("Punto 1" + puntoUno.getDetails());

 /*		
	d  = new Distancia(cargaUno.getPunto(), cargaDos.getPunto());
	System.out.println(d.getDetails());
	*/	
	System.out.println(puntoUno.getDetails());
		
	System.out.println(" Gravedad = " +ImplementaPresionBuso.GRAVEDAD);
    System.out.println(" Densidad = " +ImplementaPresionBuso.DENSIDAD);
	pb = new ImplementaPresionBuso(puntoUno);
		 
    System.out.println(" Gravedad= " +pb.getGravedad());
	System.out.println(" Profundidad= " +pb.getProfundidad());	
	System.out.println(pb.getDetails());
     
   } // fin del metodo  realizarCalculos
   
  }   // fin de la clase interna
  	
  	
/** Main method */
  public static void main(String [] args) {
  	
  Server2PresionBusoSocket frame = 
  	new Server2PresionBusoSocket("Servidor sobre el Buso");
    
      // Establish server socket
    
    try {
     
      // Create a server socket
      
      ServerSocket serverSocket = new ServerSocket(11000);
     
     Server2PresionBusoSocket.jtaLog.append(
     	new Date() + ": Start a new server\n");

      // Count the number of threads started
      
      int count = 1;

      while (true) {
       
        // Connect to a client
       System.out.println("El servidor espera que un cliente" +
       	" envie un Objeto String actionPerformed y "+
        " un Objeto Punto");  
        
        Socket socket = serverSocket.accept();
        
        jtaLog.append(new Date() + ": A client at " +
          socket.getInetAddress().getHostAddress() + " connected\n");

        // Start a new thread to register a client
   System.out.println("\nStart a new thread to register a client: "+count); 
        
   new PresionBusoThread(socket, count++).start();
        
      }
    }catch (IOException ex) {
      jtaLog.append(new Date() + ": " + ex);
    }catch(Exception e)
     	{
     	System.out.println("ERROR: " + e.getMessage());
 		
 		e.printStackTrace();	
     	//	System.out.println(e);
     	}
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //  frame.pack();
    frame.setResizable(false);
 //   frame.setLocationRelativeTo(null);
/*	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) 
	/ 2, (d.height - frame.getSize().height)/2);
*/	
    frame.setVisible(true);   
  }  // fin del main
  	
 } // fin de la clase.

