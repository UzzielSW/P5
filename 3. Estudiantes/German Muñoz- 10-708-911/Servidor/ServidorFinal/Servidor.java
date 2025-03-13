import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class Servidor extends JFrame implements ActionListener 
{
	
	JFrame frame = new JFrame("BankaTM Server");
	JTextArea JTarea = new JTextArea();
	Font fuente;
	String getn;
//	int clave;

	LinkedList list;
	
	
public Servidor() 
{
	
		
		JMenuBar ServerMenu= new JMenuBar ();
		
		JMenu ServerAdd= new JMenu( "File" );
		JMenu ServerSee = new JMenu ( "See" );
		JMenu ServerExit = new JMenu ( "Exit" );
		
		JMenuItem ServerFAddClient = new JMenuItem ( "Adding Customer" );
		JMenuItem ServerFexit = new JMenuItem ("Exit");
		JMenuItem ServerSeeTable = new JMenuItem ( "See Table" );
		
		ServerAdd.add(ServerFAddClient);
		ServerAdd.add(ServerFexit);
		ServerSee.add(ServerSeeTable);
		
		setJMenuBar( ServerMenu );
		
		ServerMenu.add( ServerAdd );
		ServerMenu.add( ServerSee );
		ServerMenu.add( ServerExit );
		
		ServerFAddClient.addActionListener( this );
		ServerFexit.addActionListener( this );
		ServerSeeTable.addActionListener( this );
		
		getContentPane().add(new JScrollPane(JTarea));
		setBounds( 150,100,525,340 );
		
		setVisible(true);
		JTarea.setEditable(false);
		
	    JTarea.setText(JTarea.getText()+"Servidor iniciado\n");
	    
	    try {
	    	ServerSocket serverSocket = new ServerSocket(8000);
            
            while(true){
        	JTarea.setText(JTarea.getText()+"Esperando un Cliente...\n");    
            Socket connectToClient = serverSocket.accept();
            
            JTarea.setText(JTarea.getText()+"Coneccion iniciada con cliente con IP:  "+connectToClient.getInetAddress()+"\n");
            new ClienteThread(connectToClient).start();
            
            }
        }
        catch(Exception ex){}        
        
        }
        
        
        private class ClienteThread extends Thread{
       	
       	private Socket socket;
       	private Customer cliente;
       	
       	public ClienteThread(Socket socket){
       		this.socket=socket;
       	}
       	
       	public void run(){
       	
       			try{
       					
       				while(true){
       					
       				JTarea.setText(JTarea.getText()+"Esperando accion del cliente: "+socket.getInetAddress()+"\n");
       				
       	
       				ObjectInputStream tCliente=new ObjectInputStream(socket.getInputStream());
       				String[] datosCliente=(String[])tCliente.readObject();

       				String accion=(String)datosCliente[0];  
       					
       				JTarea.setText (JTarea.getText()+"accion recibida");
       				
       				
       				ObjectOutputStream pCliente = new ObjectOutputStream( socket.getOutputStream() );
       				
       				/***** CONFIRMA LA CUENTA *****/
       				 if(accion.equals("Confirmar"))
       				 {
       				 	
       				 	JTarea.setText(JTarea.getText()+"Confirmar cuenta\n");
       				 	      				 	
       				 	if(confirmarCuenta(datosCliente[1]))
       				 	{	
	       				 	JTarea.setText(JTarea.getText()+"Cliente encontrado\n");
	       				 	
	       				 	JTarea.setText(JTarea.getText()+"\nNombre\tApellido\tBalance\n");
	       				 	JTarea.setText(JTarea.getText()+""+cliente.getNombre()+"\t"+cliente.getApellido()+"\t"+cliente.getAccount().getBalance()+"\n"); 
	       				 	  				 	      				 	
	       				 	pCliente.writeBoolean(true);	
	       				 	pCliente.writeObject(cliente.getNombre()+" "+cliente.getApellido());
       				 	}
       				 	
       				 	
       				 	else
       				 	{
	       				 	JTarea.setText(JTarea.getText()+"Cliente no encontrado\n");
	       				 	pCliente.writeBoolean(false);	
       				 	}
       				 	
       				  }
       				 
       				 
       				 /***** CONSULTA BALANCE *****/
       				 else if(accion.equals("Consultar"))
       				 {
		       		     JTarea.setText(JTarea.getText()+"Consultar Saldo\n");
		       				 	
	       				 	
	       				 if(confirmarCuenta(datosCliente[1]))
	       				 {
	       				 	 JTarea.setText(JTarea.getText()+"\nNombre\tApellido\tBalance\n");
		       				 JTarea.setText(JTarea.getText()+""+cliente.getNombre()+"\t"+cliente.getApellido()+"\t"+cliente.getAccount().getBalance()+"\n");      				 	     				 		
		       				 pCliente.writeObject(""+cliente.getAccount().getBalance()); //le mando al cliente el balance
	       				 }
	       				 	
	       				 else
	       				 {
	       				 	JTarea.setText(JTarea.getText()+"Cliente no encontrado\n");  				 	
	       					pCliente.writeObject("");
	       				 }
       				 	
       				 }
       				 
       				
       				
       				 /***** DEPOSITO *****/
       				 else if(accion.equals("Depositar"))
       				 {
	       			   	 JTarea.setText(JTarea.getText()+"Depositar \n");
	       				
	       				 	
	       				 try{
	       				 
	       				 if(confirmarCuenta(datosCliente[1]))
	       				 {
	       				 	
	       				 	 JTarea.setText(JTarea.getText()+"\nNombre\tApellido\tBalance\n");
		       				 JTarea.setText(JTarea.getText()+""+cliente.getNombre()+"\t"+cliente.getApellido()+"\t"+cliente.getAccount().getBalance()+"\n");      				 	     				 		
		       					
		       				 double cantidadDeposito=Double.parseDouble(datosCliente[2]);
		       				 cliente.getAccount().deposit(cantidadDeposito);       				 		
		       				 pCliente.writeBoolean(true);
	       				 
	       				 }
	       				 	
	       				 else
	       				 {
	       				 	throw new Exception();
	       				 }
	       				 	
	       				 }catch(Exception ex){
	       				  JTarea.setText(JTarea.getText()+"Cliente no encontrado\n");
	         			  pCliente.writeObject("");
	       				  }
	       				 	ObjectOutput escribe=new ObjectOutputStream(new FileOutputStream("Usuario.txt"));
		    	 			escribe.writeObject(list);
       				 }
       			
       			
       				 
       				 /***** RETIRO *****/
       				 else if(accion.equals("Retirar"))
       				 {
	       				 JTarea.setText(JTarea.getText()+"Retirar\n");
	       				 	
						 try{
						 	
	       				 if(confirmarCuenta(datosCliente[1]))
	       				 {
		       				 double cantidadRetirar=Double.parseDouble(datosCliente[2]);
		       				 cliente.getAccount().withdraw(cantidadRetirar);       				 		
		       				 pCliente.writeBoolean(true);     				 		
		       				 JTarea.setText(JTarea.getText()+"Retiro exitoso\n");
	
	       				 		
	       				 }
	       				 
	       				 
	       				 else
	       				 {
	       				 	throw new Exception();
	       				 }
						 }catch(OverdraftException ex){								
	       				 	JTarea.setText(JTarea.getText()+"Retiro no permitido\nDeficit de "+ex.getDeficit()+"\n");			
		       				}catch(Exception ex){
	       				 		
	       				 	JTarea.setText(JTarea.getText()+"Cliente no encontrado\n");
	       				 	pCliente.writeObject("");
	       				 	}
	       				 	ObjectOutput escribe=new ObjectOutputStream(new FileOutputStream("Usuario.txt"));
		    	 			escribe.writeObject(list);
	       				 }
	       				 /********AAGREGA******************/
	       				
       				
	       				 
	       					pCliente.flush();
	       				
	       				 }   //fin while
	       				 
	       				 	
	       					
	       			     }catch(Exception ex){
	       				 JTarea.setText(JTarea.getText()+"Conexion finalizada\n");
       			     }
       			
       	}
       	      	
       	
       	
       	/***** CONFIRMAR CUENTA *****/
       	public boolean  confirmarCuenta(String id){
       		try {
            	ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("Usuario.txt")));
		    	LinkedList lista = new LinkedList();
			    lista = (LinkedList)in.readObject();
			    list=lista;
			    Iterator iterator=lista.iterator();
			    		    
	    		while(iterator.hasNext())
     	        {
     	        	Customer usuario = (Customer)(iterator.next());
     	            if(usuario.getContrasenia().equals(id))
     		        {
     		        
     			        getn = usuario.getNombre(); 
            		    JTarea.setText(JTarea.getText()+"Cliente conectado\n"+"Nombre: "+getn);
            		    cliente=usuario;
            		    return true;
            		
     		        }
     		        
     	        }

                        JTarea.setText(JTarea.getText()+"El cliente no existe en el archivo!");	
                        return false;
                    
     	        
     	    }catch(Exception w) { 
     	    	        JTarea.setText(JTarea.getText()+"\nProblemas cargando la base de datos!!");	
     	    	        	return false;
     	    	}  	
       		}
              		
       }
   
   		public void actionPerformed(ActionEvent e){
   			String escuchode = e.getActionCommand();
   			
   			if ( escuchode.equals( "Adding Customer" )){
   				AddingCustomer ahora = new AddingCustomer();
   			}
   			
   			if (escuchode.equals( "Exit" )){
   			System.exit( 0 );
   			}   
   			
   			if (escuchode.equals( "See Table" )){
   				TablaUsuario muestra = new TablaUsuario ();
   			}
   		}  
        
        public static void main(String args[]) throws Exception {
        		JFrame.setDefaultLookAndFeelDecorated( true );
		Servidor se = new Servidor();
	}
}