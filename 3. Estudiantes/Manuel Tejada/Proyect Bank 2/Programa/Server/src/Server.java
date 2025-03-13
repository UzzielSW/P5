/**
 * @(#)Server.java
 *
 *
 * @author 
 * @version 1.00 2009/12/21
 */
 
 
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import esqueleto.*;
import java.net.*;

/** This class represents the server where all the data and the necesary methods used by the clients that connect to it use
 *
 **/
public class Server extends JFrame{
        
  	/**jb_Crear is a JButton that handles the action of creating a new <code>CrearCuentaWindow</code> object to create a new customer*/
    private JButton jb_Crear;
    /**jb_Clear is a JButton that handles the action clearing the JTextArea*/
    private JButton jb_Clear;
    /**jb_Editar is a JButton that handles the action of creating a new <code>ConfirmeAccount</code> object so the administrator can enter the information of the customer whos info is going to be edited*/
    private JButton jb_Editar;
    /**jp_Botones is a JPanel where the buttons showed in the interface are going to be placed*/
   	private JPanel jp_Botones;
   /**jp_Data is a ClientsPanel that contains the <code>JTable</code> and the <code>JButtons</code> with the names of the clients of the bank*/
   	private ClientsPanel jp_Data;
   /**MiBanco is a Banco object that handles the real operation of the bank*/
	private Banco miBanco;
	/**currentCustomer is a int that holds the position of the customer that is going to be edited*/
	private int currentCustomer;
	/**ThisWindow is a Server that represents a way of accessing to the Server methods from innerClasses*/
	final private Server thisWindow;
	
	/**This methods is call to create a graphic representation of a Server
 	*By creating a Server instance*/
    public Server() {
    	
    	super("...:::Wardmatc Bank Server:::...");
    	miBanco=new Banco(); 
    	jp_Data=new ClientsPanel(this);
    	
    	thisWindow=this;
    	
    	dameForma();
	  	
	  	jb_Crear.addActionListener(new ActionListener(){
	  		public void actionPerformed(java.awt.event.ActionEvent e){
	  			CrearCuentaWindow j=new CrearCuentaWindow(thisWindow);
	  			j.setVisible(true);
	  		}
	  		});
	  	
	  	jb_Editar.addActionListener(new ActionListener(){
	  		public void actionPerformed(java.awt.event.ActionEvent e){
	  			new ConfirmAccount(thisWindow).setVisible(true);
	  		
	  		}
	  		});
	  	
	  	jb_Clear.addActionListener(new ActionListener(){
	  		public void actionPerformed(java.awt.event.ActionEvent e){
	  		thisWindow.regresaAreaDatos().setText("Wardmatc Bank\n");	
	  		}
	  		});
	  	
		esperaConeccion();
	  	
    }
    
    /**This method is where the <code>Server</code> window takes its finally form.
     **/    
    public void dameForma(){
 	
    	jp_Botones=new JPanel(new java.awt.GridLayout(miBanco.getNumOfCustomers(),1,5,5));
    
	  	jp_Botones=new JPanel(new java.awt.GridLayout(3,1,10,10));
	  	jb_Crear=new JButton("Add Client");
	  	jb_Editar=new JButton("Edit Client");
	  	jb_Clear=new JButton("Clear");
	  	
	  	jp_Botones.add(jb_Crear);
	  	jp_Botones.add(jb_Editar);
	  	jp_Botones.add(jb_Clear);
	  	
	  	
	  	this.add(jp_Data,java.awt.BorderLayout.CENTER);
	  	this.add(jp_Botones,java.awt.BorderLayout.EAST); 	
	  		
	  	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  	this.setSize(1000,350);
	  	this.setVisible(true);
    }
    
    /**This method is where the server waits for a client`s connection to arrives
     **/
    public void esperaConeccion(){
    	try {          
             ServerSocket server = new ServerSocket(8888);
               	
             System.out.println("Servidor iniciado \n Esperando instruccion .............\n");
             regresaAreaDatos().setText("Servidor iniciado Esperando instruccion .............\n")  ;	
             while(true){
                	
                	 Socket socket = server.accept();
                	
                	System.out.println("Coneccion Iniciada \n Direccion --> " + socket.getInetAddress().getHostAddress());
             		this.regresaAreaDatos().setText(this.regresaAreaDatos().getText()+"Coneccion Iniciada \n Direccion --> "+ socket.getInetAddress().getHostAddress()+"\n");  	
                	//Start a new thread to response to a client
                	
                	new ClientsThread(this,socket,-1).start(); //instancio el hilo
                	
                }
             }catch(IOException ex){}
    }

	/**This method is called to set the button`s Thread so a conection can be canceled
	 *@param pos Is the position of the customer that is conected
	 *@param thread Is the thread asosiated to the conection
	 **/
    public void setButtonThread(int pos,ClientsThread thread){
    jp_Data.setButtonThread(pos,thread);
    }
    
    	/**This method is called to get the button`s Thread 
	 *@param pos Is the position of the customer that is conected
	 
	 **/
    public ClientsThread getButtonThread(int pos){
    return jp_Data.getThread(pos);
    }
    
    /**This method is called to chage the colors of the buttons
     **/
    public void setClientsConectionColor(){
    	jp_Data.setClientsConectionColor();
    }
    
    /**This method is called to edit a <code>Customer</code> Info into the table
     *@param position Is the row number that is going to be edited
     *@param client Is the client with the new data that must be display into the Jtable*/
    public void changeCustomerInTable(int position,Customer client){
    	jp_Data.changeCustomerInTable(position,client);
    	}
    
   /**This method returns the number of Clients the Banck has
        **/
    public int getNumOfCustomers(){
	return miBanco.getNumOfCustomers();
}
	
	/**This method is call to set the <code>currentCustomer</code> 
	 *@param currentCustomer
	 **/
	public void setCurrentCustomer(int currentCustomer){
    	this.currentCustomer=currentCustomer;
    }
    
    /**This method is called to get the <code>currentCustomer</code>
     *@return Returns the index of the <code>Customer</code> that is going to be edited */
	public int getCurrentCustomer(){
    	return currentCustomer;
    }
    
    /**This method is used to get a <code>Customer</code> in a specified position
     *@param pos Is the position that a <code>Customer</code> 
     *@return The <code>Customer> that is into the <code>LinketList</code> in position <code>pos</code>*/
	public Customer getCustomer(int pos){
	return miBanco.getCustomer(pos);
}   
    
    /**This method is called when a customer has been edited ,inorder to save the changes
     **/	
    public void saveCustomer(int position,Customer client){
    
    	    	miBanco.addCustomer(position,client);
    	}
    
    /**This method is called to save the data into a file
     **/	
    public void guardaLista(){
    	try{
    		miBanco.guardaLista();
    		System.out.println ("Se guardo");
    	}catch(Exception ex){
    	}
    }
    
    /**This method is called to check if the data of a <code>Customer</code> that is going to be edited is ok
     *@param startFrom Is the position of where the search must start from. 
     *@param firstName Is the First Name of the <code>Custome</code> that is going to be edited.
     *@param lastName Is the Last Name of the <code>Custome</code> that is going to be edited.
     *@param password Is the Password of the <code>Custome</code> that is going to be edited.
     *@return The position of the <code>Custome</code> that is going to be edited. If the <code>Custome</code> is not found it returns <code>-1</code>.
     *
     **/
    public int  checkCustomer(int startFrom,String firstName,String lastName,String password){
     	
     	return miBanco.checkCustomer(startFrom,firstName, lastName, password);
     	}
    
    /**This method is called to get the <code>Banco</code> object
     **/
    public Banco getBanco(){
    	return miBanco;
    }
        
    /**This methods is called so the new <code>Customer</code> information is showed into the <code>LinkedList</code>
     *@param client is the new new <code>Customer</code> whose information is going to be showed into the <code>LinkedList</code>
     **/
    public void addCustomerToTable(Customer client){
     	jp_Data.addCustomerToTable(client);
     	}
    
    /**This method is called to get the <code>JTextArea</code> where the <code>Server</code> activity is going to be display
     **/
    public synchronized  JTextArea regresaAreaDatos(){
    	return jp_Data.regresaAreaDatos();
    }
    
     /**This method is called to update the JTable*/
    public void actualizarTabla(){
    	jp_Data.actualizarTabla();
    }    
    
    public static void main(String[] args) {
    javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
        new Server();
      
    }
    	
     
    }
