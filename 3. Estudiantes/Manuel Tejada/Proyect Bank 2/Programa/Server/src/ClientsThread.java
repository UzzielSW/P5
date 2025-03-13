/**
 * @(#)ClientsThread.java
 *
 *
 * @author 
 * @version 1.00 2009/12/31
 */

import java.io.*;
import java.net.*;
import esqueleto.*;


class ClientsThread extends Thread {
  	
    /**socket is a Socket that is used to serve a client*/
    private  Socket socket;
    /**position is a int that is the position of the client that is using the conection*/
	private  int posicion=-1;
	
    private int clientNo; // The thread number
    /**Object input stream to get input from the client*/
    private ObjectInputStream in;
    /**miBanco is a Banco */
	private Banco miBanco;
	/**owner is a Server that is the owner*/
	private Server owner;	
	
	/***/
	private String[] comando;
	
    /** Create a registration thread
     **/
    public ClientsThread(Server owner,Socket socket,int clienNo) {
    	
      this.owner=owner;
      this.socket = socket;
      this.clientNo = clientNo;
	  this.miBanco=owner.getBanco();
	  
	  comando=new String[]{"Confirmacion de cuenta","Display Balance","Deposit","Withdrawal","Conection Test"};
   
    }
	
	/**This method is where the orders are recived from the client
	 **/
    public void run() {
     
     		 try {
      	
        		/* Receive data from the client
        		[A][B][C] <-- Vector que recive
        			[A] se indica que tipo de operacion se va a realizar
        				[0] Confirmacion de cuenta
        				[1] Display Balance
        				[2] Deposit
        				[3] Withdrawal
        				[4] Conection Test
        			[B] se indica lo siguiente dependiendo de los casos
        			
        	*Si [A] = [0] --> [B] = Numero de cuenta
        	*Si [A] = [1] o [2] o [3] --> [B] = Posicion del cliente en el vector
        	
        			[C] se indica lo siguiente dependiendo de los casos
        	*Si [A] = [2] o [3] --> [C] = Cantidad a depositar o retirar
        */
      
      	while(true)
      		{
      			in = new ObjectInputStream(socket.getInputStream());
       			String[] queHacer=((String[])in.readObject());
    	
    			System.out.println ("Peticion recibida \n Fuente --> "+ socket.getInetAddress().getHostAddress()+"\nInstruccion --> "+comando[Integer.parseInt(queHacer[0])]+"\n");
    			
    			if(!(comando[4].equals(comando[Integer.parseInt(queHacer[0])])))
    			{
    					owner.regresaAreaDatos().setText(owner.regresaAreaDatos().getText()+"\n Peticion recibida \n Fuente --> "+ socket.getInetAddress().getHostAddress()+
      				"\nInstruccion --> "+comando[Integer.parseInt(queHacer[0])]+"\n");  
    	
    			}
    			
    			System.out.println ("Recibido exitoso");
    			if(Integer.parseInt(queHacer[0])==0){
    				
    				confirmAccount(socket,new String[]{queHacer[1],queHacer[2],queHacer[3]});
    
    			}else if(Integer.parseInt(queHacer[0])==4){
    				System.out.println ("Conection Test");
    			}else{
    				operacion(socket,queHacer);
    			}   
    		
			owner.setClientsConectionColor();
			owner.actualizarTabla();
       		}  
       
      }
      catch (Exception ex) {
        System.out.println("Excepcion --> "+ex);
      }
      
    }
    
    /**This methods is where a confirmation of a clients information is made
     **/
    public synchronized void confirmAccount(Socket socket,String[] datos)throws Exception{
	
	
	ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
    
    	
    	try{
    	
    			owner.setButtonThread(posicion,null);
    	}catch(Exception ex){
    		
    	}
    		posicion=miBanco.checkCustomer(0,datos[0],datos[1],datos[2]);
    	try{
    		
    		 	boolean estado=miBanco.getCustomer(posicion).getState();
    		 	
    			out.writeObject(new Object[]{""+posicion,estado});
    			
    			if(estado)
    			owner.setButtonThread(posicion,this);
    			
    	}catch(IndexOutOfBoundsException ex){
    			out.writeObject(new Object[]{	""+posicion});
    	}
    	out.flush();
    
		System.out.println ("Enviado exitoso");	
}

	/**This method is where the accion that the client request are made
	 **/
	public void operacion(Socket socket,String[] queHacer)throws Exception{
	
	ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
	int posicion =Integer.parseInt(queHacer[1]);
	Object[] datosParaEnviar;
	try{
	System.out.println ("Entro hasta las opciones");
	if(queHacer[0].equals("1")){
	
			System.out.println ("Entro a display");
			
		String fullName=miBanco.getCustomer(posicion).getFirstName()+" "+miBanco.getCustomer(posicion).getLastName() ;
		
		double balance=miBanco.getCustomer(posicion).getBalance();
		System.out.println ("bALANCE --> "+balance);
			datosParaEnviar=new Object[]{true,fullName,""+balance};
			System.out.println ("Salio Display");
	}
	else if(queHacer[0].equals("2")){ //DEPOSITO
	
		double deposito=Double.parseDouble(queHacer[2]);
		if(deposito<0){
			throw new Exception();
		}
		miBanco.getCustomer(posicion).deposit(deposito);
	
		datosParaEnviar=new Object[]{true};
		
	}
	else if(queHacer[0].equals("3")){//RETIRO
	
		double retiro=Double.parseDouble(queHacer[2]);
		if(retiro<0){
			throw new Exception();
		}
		try{
			miBanco.getCustomer(posicion).withdraw(retiro);
				
		datosParaEnviar=new Object[]{true,false};
		}catch(OverdraftException ex){
		
		datosParaEnviar=new Object[]{false,true,""+ex.getDeficit()};
		}

	}
			else{
		throw new Exception();
	}
	}catch(Exception ex){
		//out.writeBoolean(false);
		datosParaEnviar=new Object[]{false};
	}
	out.writeObject(datosParaEnviar);
	out.flush();
}
	
	/**This method is called when a customer has been edited ,inorder to save the changes
     **/	
	public void saveCustomer(int position,Customer client){
    
    	    	miBanco.addCustomer(position,client);
    	}
	
	/**This method is called to close the current connection
	 **/
    public void closeConection(){
    	try{
    		socket.close();
    	}
    	catch(Exception es){
    	}
    }
    /**This method returns the conection socket object*/
    public Socket getSocket(){
    	return socket;
    }
   
        
  }    