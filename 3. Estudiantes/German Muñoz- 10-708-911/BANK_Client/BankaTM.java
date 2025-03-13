import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.beans.EventHandler;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.net.*;

public class BankaTM extends JFrame implements ActionListener {

	private JButton [] button;													//Genera un vector de botones
	private JTextField Message,JTFuser;;													//
	private JPasswordField DataEntry,JTFpasw;;										    	//
	private JTextArea Output;																//
	JButton mw,dab,md;
	public String name,saldo,password;
	Double cantidad;
	JMenuItem JMOut;
	String usernombre = "Admin";
	String userpass = "123";
	boolean validauser=false;
	Frame t;
	String host = "localhost";
	private boolean isStandAlone = false;
	String mensaje = "",claveClienteActual="";
	 Socket socket;

	public BankaTM ( String title , Socket socket)
	{	
		super ( title );
		this.socket = socket;
		this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		BankDisplay();
	} 
	
	private void BankDisplay()
	{
		
		Container Contenedor = this.getContentPane();
		
		JMenuBar BarMenuB = new JMenuBar ();
		
		JMenu BankerFMenu = new JMenu( "File" );
		JMenu BankerSMenu = new JMenu( "See" );		
		JMenu BankerLMenu = new JMenu ( "Logout" );
		JMOut   = new JMenuItem ("Salir");
		BankerLMenu.add( JMOut );	
			JMOut.setEnabled(false);
	//	JMenuItem ArchivoItemA = new JMenuItem ( "Adding Customer " );
	//	JMenuItem ArchivoItemB = new JMenuItem ( "Administrador" );
		JMenuItem ArchivoItemC = new JMenuItem ( "Salir" );
	//	JMenuItem SeeTable     = new JMenuItem ( "See Table" );
	//	BankerFMenu.add( ArchivoItemA );
	//	BankerFMenu.add( ArchivoItemB );
		BankerFMenu.add( ArchivoItemC );
	//	BankerSMenu.add( SeeTable );
	
		setJMenuBar( BarMenuB );
		BarMenuB.add( BankerFMenu );
		BarMenuB.add( BankerSMenu );
		BarMenuB.add( BankerLMenu );
		
		JPanel ActionBp = new JPanel( new GridLayout(3,1) );
		JPanel KeyPp = new JPanel ( new GridLayout(4,3) );
		JPanel LadoIz = new JPanel ( new BorderLayout() );
		JPanel LadoDe = new JPanel ( new BorderLayout() );
		
		JLabel Bienvenido = new JLabel ("Bienvenido",SwingConstants.CENTER);
		Bienvenido.setFont( new Font( "Serif", Font.PLAIN, 18 ) );
		
		dab = new JButton( " Mostrar Balance " );
		md = new JButton( " Hacer un Deposito " );
		mw = new JButton( " Hacer un Retiro " );	
		mw.setEnabled( false );
		md.setEnabled( false );
		dab.setEnabled( false );
		
		button = new JButton[12];
		for (int i=0; i<=9;i++)
		{
			button[i]= new JButton ( ""+i );
		}
		button[10]= new JButton( "Clear" );
		button[11]= new JButton( "Enter" );
		
		DataEntry = new JPasswordField( 10 );	
		DataEntry.setBackground( Color.WHITE );
		DataEntry.setText( "" );
		DataEntry.setHorizontalAlignment( JTextField.CENTER );
		
		Output = new JTextArea( 10,40);	
		Output.setEditable( false );
		JScrollPane scrollPane = new JScrollPane(Output);
		Message = new JTextField( 10 );
		LadoDe.add( Bienvenido, BorderLayout.NORTH);
		LadoDe.add( scrollPane, BorderLayout.CENTER );
		LadoDe.add( Message, BorderLayout.SOUTH );
		
		ActionBp.add( dab );
		ActionBp.add( md );
		ActionBp.add( mw );
		
		for (int i=1;i<10;i++)
		{
			KeyPp.add( button[i] ); 
		}
		KeyPp.add( button[0]  );
		KeyPp.add( button[10] );
		KeyPp.add( button[11] );
		
		LadoIz.add( ActionBp, BorderLayout.NORTH );
		LadoIz.add( DataEntry, BorderLayout.CENTER );
		LadoIz.add( KeyPp, BorderLayout.SOUTH );
		
		Contenedor.add( LadoIz,BorderLayout.WEST );	
		Contenedor.add( LadoDe,BorderLayout.CENTER );
		Contenedor.setVisible(true);
		for (int i=0; i<12; i++)
		{
			button[i].addActionListener( this );
		}
	
		

			
		ArchivoItemC.addActionListener(
			new ActionListener (){
				public void actionPerformed ( ActionEvent e ){
					System.exit( 0 );
				}
			});
		
		JMOut.addActionListener(
			new ActionListener(){
				public void actionPerformed ( ActionEvent e ){
			//	System.out.println("dsds");
	 						for (int i=0; i<=11;i++)
							{
								button[i].setEnabled(true);
							}
							md.setEnabled ( false ); 
	 						mw.setEnabled ( false );
	 						dab.setEnabled ( false );
	 						DataEntry.setEnabled( true );
	 						validauser=false;
	 						Output.setText("");
	 						JMOut.setEnabled(false);
			}
		}
			);
		
		/** 
		 *Verifica el Balance de la cuenta del usuario actual
		 */	
		dab.addActionListener(
			new ActionListener(){
				public void actionPerformed ( ActionEvent e){
					int i=0;
					
					 try{
       	    
                		ObjectOutputStream toServer=new ObjectOutputStream(socket.getOutputStream());
         		       toServer.writeObject(new String[]{"Consultar",claveClienteActual});
    		            toServer.flush();
   			             ObjectInputStream isfromServer=new ObjectInputStream(socket.getInputStream());
                
     		           double balance = Double.parseDouble((String)isfromServer.readObject());		 
    	 	           Output.setText(Output.getText()+"Su Balance Actual es de B/ "+balance+"\n");               
    		            JOptionPane.showMessageDialog(null,"Su balance es de  B/ "+balance,"Consulta de balance",JOptionPane.INFORMATION_MESSAGE);
                
       	  	 	   }catch(Exception ex){
       	   		 	Message.setText("Problemas de conexion");	
           		     JOptionPane.showMessageDialog(null,"Problemas de conexion ","Problema",JOptionPane.INFORMATION_MESSAGE);
                	
       	   			 }
				
				}
			});
		
		/******************
		 *Deposito 
		 **/
		md.addActionListener(
			new ActionListener(){
				public void actionPerformed ( ActionEvent e ){
					double deposito;
	    	     	Message.setText("");		
	         		boolean veri;
	        		try{
	    		 		deposito=Double.parseDouble(JOptionPane.showInputDialog(null,"Cantidad a depositar:","DEPOSITO",JOptionPane.QUESTION_MESSAGE));	 
	    		 		if(deposito<0)
	    		 		{
	    		 			throw new Exception();
	    		 		}   
	    		 	veri=true;	
       	    		}catch(Exception ex){
       	    		deposito=Double.parseDouble(JOptionPane.showInputDialog(null,"Cantidad a depositar no numerica \n corrija:","Error de datos",JOptionPane.ERROR_MESSAGE));	    
       	    		veri=false;
       	    		}		   
	    	       	   
	    	   		if(veri){
	    	   			try{
	    	   				ObjectOutputStream toServer =new ObjectOutputStream(socket.getOutputStream());
                			toServer.writeObject(new String[]{"Depositar",claveClienteActual,""+deposito});
                			toServer.flush();
                			ObjectInputStream isfromServer=new ObjectInputStream(socket.getInputStream());
                
                			boolean depositobien =isfromServer.readBoolean();
   
                				Message.setText("Deposito exitoso ");	
                				Output.setText(Output.getText()+"Usted Hiso un Deposito de B/ : "+deposito+"\n");
                		
                			
                
       	    }catch(Exception ex){
       	    	Message.setText("Problemas de conexion");	
                	JOptionPane.showMessageDialog(null,"Problemas de coneccion ","Problema",JOptionPane.INFORMATION_MESSAGE);
                	
       	    }
	    	   }
					}
			});
			/****
			 *RETIRO
			 */
		mw.addActionListener(
			new ActionListener(){
				public void actionPerformed ( ActionEvent e ){
					
					double retiro=0;
	     		    Message.setText("");
	         		boolean veri;
	    	   
	    	 		try{
	    		 		retiro=Double.parseDouble(JOptionPane.showInputDialog(null,"Cantidad a retirar:","RETIRO",JOptionPane.QUESTION_MESSAGE));	 
	    		 		if(retiro<0)
	    		 		{
	    		 			throw new Exception();
	    		 		}   
	    		 		veri=true;	
       	    		}catch(Exception ex){
       	    		JOptionPane.showInputDialog(null,"Introduzca una cantidad numerica:","Error de datos",JOptionPane.ERROR_MESSAGE);	    
       	  	    	veri=false;
       	    		}   
	    	       	   
	    
	    	   if(veri){
	    	   	
	    	   	 // solo hace la conexion si lo que se introdujo es un numero
	    	   	try{
	    	   		ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
                	toServer.writeObject(new String[]{"Retirar",claveClienteActual,""+retiro});
                	toServer.flush();
                	ObjectInputStream isfromServer = new ObjectInputStream(socket.getInputStream());                
                	boolean depositoExitoso=isfromServer.readBoolean();
                	Output.setText(Output.getText()+"Usted Hiso un Retiro de B/ : "+retiro+"\n");
                	Message.setText("Retiro Exitoso ");	
              
       	      	}catch(Exception ex){
       	       	Message.setText("Problemas de coneccion");	
                JOptionPane.showMessageDialog(null,"Problemas de coneccion","Problema",JOptionPane.INFORMATION_MESSAGE);
                	
       	    }
	    	   }
				
			}});
		
		
		
		}
		
		
	public void actionPerformed ( ActionEvent e )
	 {
	 	String Clistener = e.getActionCommand();
	 	String num ;
	 		 	
	 	if( Clistener.equals( "1" ) || Clistener.equals( "2" ) ||
	 		Clistener.equals( "3" ) || Clistener.equals( "4" ) ||
	 		Clistener.equals( "5" ) || Clistener.equals( "6" ) ||
	 		Clistener.equals( "7" ) || Clistener.equals( "8" ) ||
	 	 	Clistener.equals( "9" ) || Clistener.equals( "0" ) ){
	 	 		DataEntry.setText(String.valueOf(DataEntry.getPassword())+Clistener);
	 	 	}
	 	 		 	 	
	 	if( Clistener.equals( "Clear" ))
	 		 DataEntry.setText( "" );
	 	if( Clistener.equals( "Enter" ))
	 	{
	 		
	    	try
	    		{
                
                ObjectOutputStream toServer=new ObjectOutputStream(socket.getOutputStream());
                toServer.writeObject(new String[]{"Confirmar",new String(DataEntry.getPassword())});
                toServer.flush();
                ObjectInputStream isfromServer=new ObjectInputStream(socket.getInputStream());
                
                boolean claveCorrecta=isfromServer.readBoolean();
                if(claveCorrecta)
                {
                	String nombre  = (String)isfromServer.readObject();
                	claveClienteActual=new String(DataEntry.getPassword()); // Guarda la clave que se introduce
     		     	Output.setText("Bienvenido Sr(a):"+""+nombre+"\n");
     		     	Message.setText("Cuenta CORRECTA");
     		    	 
     		    	 for (int i=0; i<=11;i++)
						{
								button[i].setEnabled(false);
							}
							DataEntry.setText( "" );
							md.setEnabled ( true ); 
	 						mw.setEnabled ( true );
	 						dab.setEnabled ( true );
	 						DataEntry.setEnabled( false);
	 						JMOut.setEnabled (true);
     		     			DataEntry.setText("");
               
                }
                else
                {
                	DataEntry.setText("");
                	JOptionPane.showMessageDialog(null,"CONTRASEÑA no valida","ERROR",JOptionPane.ERROR_MESSAGE);
                }	                             
                }catch (Exception ex) { System.err.println(ex); }  
                	  
	    }
	
	 
	 }
	 	
	 
	 	
	public static void main (String[] arg){
		
		
		JFrame.setDefaultLookAndFeelDecorated( true );
		
			try{
				Socket socket=new Socket("LocalHost",8000);
			 	BankaTM g = new BankaTM ( "Banco",socket );	
			  	g.pack();
				g.setLocationRelativeTo( null );
				g.setVisible( true );
			 
		   }catch(Exception ex){
				JOptionPane.showMessageDialog(null,"ERROR AL CONECTAR CON EL SERVIDOR","ERROR",JOptionPane.ERROR_MESSAGE);
		   }
		   	
	}	
		
}



