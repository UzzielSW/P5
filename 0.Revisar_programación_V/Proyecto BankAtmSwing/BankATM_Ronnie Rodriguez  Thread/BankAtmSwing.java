		

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * @(#)BankAtmSwing.java
 *
 *
 * @author  Ronnie Rodríguez
 * @version 1.00 2009/10/16
 */
public class BankAtmSwing extends JFrame implements ActionListener,Serializable,Runnable
{
  private int l,ll,i=0,claveid,vcuenta,cuenta,m=0;
  private int b1=0,b2=0,acciontype=0;
  private static int pos=0,pos1=0,valor_posicion=0;	
  private JTextArea jtA;
  private JPasswordField jtfDataE;
  private JTextField jtfMsn;
  private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
  private JButton jb8, jb9, jb0, jbEnter, jbClear;
  private JButton jbDisplay;
  private JButton jbDeposit;
  private JButton jbWithdraw;
  private JMenuItem menuCrear, menuSalir, menuSee, menuLogout;
  private JFrame Ventana= new JFrame("Stark BankATM");
  private JDialog contentPanel;
  
  public Create_User crea_usuario;
  public Customer co = new Customer();
  public ViewAccounts ver;
  public Archivo archivo;
  
  JLabel jlUser, jlPassword;
  JTextField jtUser;
  JPasswordField jtPassword;
  JButton jbLogin,jbCancel;
  static String cambia_nombrea,cambia_apellidoa;
  private LinkedList lista;
  private boolean first,test;
  boolean isValido = false;
  	 int clave;
	 double amount;
  
  //* Constructor*/
  
  public BankAtmSwing()
  {
  	   lista=new LinkedList();
       crea_usuario=new Create_User();
       archivo =new Archivo();
    
    // Creacion de la Barra de menu
	  
	  JMenuBar menuBar  = new JMenuBar();
	  JMenu menuClientes = new JMenu("File");
	  JMenu menuVer= new JMenu("See");
	  JMenu menuLog = new JMenu("Logout");
	  JMenu menuExit = new JMenu("Exit");
	  
	   menuCrear = new JMenuItem("Create_Customer");
	   menuSalir = new JMenuItem("Exit BankATM ");
	   menuSee = new JMenuItem("See");
	   menuLogout= new JMenuItem("Logout");
	 
	  menuClientes.add(menuCrear);
	  

	  menuLog.add(menuLogout);
	  menuVer.add(menuSee);
	  menuExit.add(menuSalir);
	  
	  menuBar.add(menuClientes);
	  menuBar.add(menuVer);
	  menuBar.add(menuLog);
	  menuBar.add(menuExit);
	  
	  // Escuchas de los MenuItems
	  menuCrear.addActionListener(this);
	  menuSalir.addActionListener(this);
	  menuSee.addActionListener(this);
     
	
	  
	 	  
	  this.setJMenuBar(menuBar);
	  menuLogout.addActionListener(this);

	  jtA= new JTextArea(10,75);
	  jtA.setText("                                             Stark BankATM" + "                         Ro4_Corporation");
	  jtfDataE= new JPasswordField(10);
	  jtfDataE.setHorizontalAlignment(JTextField.RIGHT);
	  jtfMsn= new JTextField(75);
	  jbDisplay= new JButton("Display account balance");
	  jbDeposit= new JButton("Make a deposit");
	  jbWithdraw= new JButton("Make a withdrawal");
	  
	  jbDisplay.setEnabled(false);
	  jbDeposit.setEnabled(false);
	  jbWithdraw.setEnabled(false);
	  
	  jb0= new JButton("0");
	  jb1= new JButton("1");
	  jb2= new JButton("2");
	  jb3= new JButton("3");
	  jb4= new JButton("4");
	  jb5= new JButton("5");
	  jb6= new JButton("6");
	  jb7= new JButton("7");
	  jb8= new JButton("8");
	  jb9= new JButton("9");
	  
	  jbEnter= new JButton("Enter");
	  jbClear= new JButton("Clear");
      first = true;
      test = false;
 // }
    
  /** Metodo para cargar el entorno de BankAtmSwing */

 
  /*public void launchFrame()
  {*/
  	  // formacion de los de la interface de BankAtmSwing
  	  lista=crea_usuario.get_lista();
	  JPanel pn= new JPanel(new GridLayout(4,3));
	  pn.add(jb1);
	  pn.add(jb2);
	  pn.add(jb3);
	  pn.add(jb4);
	  pn.add(jb5);
	  pn.add(jb6);
	  pn.add(jb7);
	  pn.add(jb8);
	  pn.add(jb9);
	  pn.add(jb0);
	  pn.add(jbClear);
	  pn.add(jbEnter);
	  
	  JPanel psw= new JPanel(new GridLayout(1,1));
	   	  
	  psw.add(pn);
	  
	  JPanel psda= new JPanel(new GridLayout(1,1));
	  
	  psda.add(jtfDataE);
	  
	  JPanel pbot= new JPanel(new GridLayout(3,1));
	      pbot.add(jbDisplay);
          pbot.add(jbDeposit);
          pbot.add(jbWithdraw);
          
      
	  
	  JPanel pwest= new JPanel(new BorderLayout());
	  pwest.add(pbot,BorderLayout.CENTER);
	  pwest.add(psda,BorderLayout.SOUTH);
	  
	  JPanel psnot= new JPanel(new GridLayout(2,1));
	  psnot.add(pwest);
	  psnot.add(psw);
	  
	  JPanel peast= new JPanel(new BorderLayout());
	  
	  jtA.setEnabled(false);
	  jtfMsn.setEnabled(false);
	  
	  peast.add(jtA, BorderLayout.CENTER);
	  peast.add(jtfMsn, BorderLayout.SOUTH);
	  
	  this.add(peast,BorderLayout.CENTER);
      this.add(psnot,BorderLayout.WEST);
	  
	 
	  this.setSize(600, 250);
	  this.setVisible(true);
	  this.setResizable(false);
	  this.setLocationRelativeTo(null);
	  
	 // Agregar escuchas a los botones de numeracion y de operacion
	  jb0.addActionListener(this);
	  jb1.addActionListener(this);
	  jb2.addActionListener(this);
	  jb3.addActionListener(this);
	  jb4.addActionListener(this); 
	  jb5.addActionListener(this); 
	  jb6.addActionListener(this);
	  jb7.addActionListener(this);
      jb8.addActionListener(this);
	  jb9.addActionListener(this);
	  
	  jbEnter.addActionListener(this);
	  jbClear.addActionListener(this);
	  
         jbDisplay.addActionListener(this);
         jbDeposit.addActionListener(this);
         jbWithdraw.addActionListener(this);
	 
	 
  }
  
  /** Ventana de permiso del Administrador */
    public void Login()
	{
	// Creacion del panel
	
		contentPanel = new JDialog();
		contentPanel.setLayout(new FlowLayout());
		jbLogin = new JButton("Login");
        jbCancel = new JButton("Cancel");
        jlUser = new JLabel("Username");
        jlPassword = new JLabel("Password");
        jtUser = new JTextField(10);
        jtPassword = new JPasswordField();
     
        
        jbLogin.addActionListener(this);
        jbCancel.addActionListener(this);         
	
		JPanel p1 = new JPanel(new GridLayout(2,2));
		p1.add(jlUser);
		p1.add(jtUser);
		p1.add(jlPassword);
		p1.add(jtPassword);
	    
	    JPanel p2 = new JPanel(new FlowLayout());
	    p2.add(jbLogin);
	    p2.add(jbCancel);
	    
	    contentPanel.add(p1,BorderLayout.SOUTH);
	    contentPanel.add(p2,BorderLayout.SOUTH);
	  // Configuracion del tamaño  
	    
	    contentPanel.setSize(250,125);
	    contentPanel.setLocationRelativeTo(null);
	    contentPanel.setVisible(true);
	    contentPanel.setResizable(false);
	    
	}
	
  
  /** Empleo de los eventos para los botones */
  
 public void actionPerformed(ActionEvent e)
  {
  	
  	// Evento de add Customer
  	if(e.getSource().equals(menuCrear))
  	{
  		  b2=0;
  	    if(b1==0) // Llave para evitar abrir la ventana 2 veces
	   	  {
	  	 	  Login();
	  	  	  b1=1;
	  	  	
	  	  }
	    else
	  	  {
	  	      jtUser.setText("");
	  	  	  jtPassword.setText("");
	  	  	  contentPanel.setVisible(true);
	  	  }
  	}
  	
  	// Evento para ver el registro de los usuarios
    if(e.getSource().equals(menuSee))
  	{
  		b2=1;
  	    if(b1==0) // Llave para evitar abrir la ventana 2 veces
	   	  {
	  	 	  Login();
	  	 	  b1=1;
      	  }
	    else
	  	  {
	  	      jtUser.setText("");
	  	  	  jtPassword.setText("");
	  	  	 contentPanel.setVisible(true);
	  	  }
  	}
  	
  		
  	// Evento de permiso del Administrador
  	else if(e.getSource().equals(jbLogin))
    	{
    		String  passuser;
    		String passkey;
    		String pass;
    		
    		passuser = jtUser.getText();           	
    	 	passkey =(String.valueOf(jtPassword.getPassword()));
    	 	pass=crea_usuario.Key1();
    	 	
    			
    		if( passuser.equals("Admin") && passkey.equals(pass))
    		{
    			if(b2==1) // llave para verificar de donde procede el llamado, si es para ver clientes o para ver la ventana de agregar clientes
    			{
    				synchronized (this)
    				{
    				crea_usuario.Archivos(archivo.Lectura());
    				ver= new ViewAccounts(crea_usuario.get_lista());
    				ver.setVisible(true);
    			    contentPanel.setVisible(false);
    				}
    			}
    			
    			else
    			{
    			crea_usuario.LaunchFrame();
    			contentPanel.setVisible(false);
    			}
    			
    		}
    		
    		else
    		{
    			JOptionPane.showMessageDialog(this,"Incorrect ID or Password","Information",JOptionPane.INFORMATION_MESSAGE);
    			jtUser.setText("");
    			jtPassword.setText("");
    			
    		}
    		
    	}
    else if(e.getSource().equals(jbCancel))
    {
    	
    	contentPanel.setVisible(false);
    	
    }
  	
  	else if(e.getSource().equals(menuSalir))
  	{
  		System.exit(0);
  	}
  	
  	else if(e.getSource().equals(menuLogout))
  	{
  		
  	  	  	  // Configuracion de la pantalla una vez terminada la sesion del cliente
	  	  	  
	  	      jbDisplay.setEnabled(false);
			  jbDeposit.setEnabled(false);
			  jbWithdraw.setEnabled(false);
			  jtA.setText("                                             Stark BankATM" + "                         Ro4_Corporation");
			  jtfDataE.setText("");
			  jtfMsn.setText("");
			  test=false;
			  first = true;	
			  isValido=false;
			  	
  	}
  	
   String buttonStr = e.getActionCommand();
   String menuIt = e.getActionCommand();
	  


	  
	  
	  // Manejo de los eventos de los botones
	  
   if ( e.getSource() instanceof JButton) 
    {
     //  Evento para desplazar el balance
     if( "Display account balance".equals(buttonStr))
     	{synchronized (this)
     	{
     	 crea_usuario.Archivos(archivo.Lectura());	
     	 try
     	 	{
        	 jtA.setText(jtA.getText()+"\nDisplay account balance: " +  crea_usuario.getCustomer(pos).getAccount().getBalance() );
           	}
         catch(RuntimeException e1)
         {
         	jtfMsn.setText("Please type numeric caracter into the Data Entry and Press deposit Button");
         	return;
         }
     	}
     	}
     
     else
     	//  Evento para realizar un deposito
         if( "Make a deposit".equals(buttonStr))
       	   {
       	   	acciontype=1;
       	   	run();
		   }
       	
        else 
        //  Evento para realizar un retiro
	       if("Make a withdrawal".equals(buttonStr))
	         {
	         	acciontype=2;
	         	run();
	         } 
	       else
	       	//  Evento para hacer posible la escritura con los botones numericos
                if(  buttonStr.equals("0") || buttonStr.equals("1") || buttonStr.equals("2") || buttonStr.equals("3") ||
		             buttonStr.equals("4") || buttonStr.equals("5") || buttonStr.equals("6") || buttonStr.equals("7") ||
		             buttonStr.equals("8") || buttonStr.equals("9") )
		          {
		          
		            
		             jtfDataE.setText(jtfDataE.getText() + buttonStr);
			            first = false;
		            
		          }
		          
		        else if (buttonStr.equals("Enter"))
		               {
		         // algoritmo de busqueda que debe encontrar al i- esimo cliente con el Id dado
		              	
		    	synchronized (this)
    				{
    					crea_usuario.Archivos(archivo.Lectura());
    				}
		    	synchronized(this)  
		    	{
    				try
    				{	
        			Thread.sleep(1000);
    				}catch(InterruptedException a)
    				{}
		    	if(m==0)/**if Para que solo lea el archivo una ves*/
      			{
	  			try
	  				{
	  	  				crea_usuario.Archivos(archivo.Lectura());/**Se llama al metodo Archivo de la clase Usuario2 para montar la lista que esta en el archivo en la memoria*/
      	  				m=1;
	  				}catch(RuntimeException   i)
	  				{
	  					//Error de Lectura de Archivo cundo el archino haun no se a creado
	  				}
      			}
		    	         if ( isValido == false )
		    	            {  	   	            	
		    	           try {
		    	          	     clave = Integer.parseInt(String.valueOf(jtfDataE.getPassword())); // Captura de la clave introducida en pantalla
		    	           	     l=crea_usuario.valor();  // Asignacion del tamaño de la lista a la variable l
		    	           	     
		    	           	        	           	
		    	            	 for(i=0;i<l;i++)   // recorrido de la lista
		    	            	 {
		    	            	    
		    	            	 	claveid = crea_usuario.getCustomer(i).getIdCustomer();  // Solicitando la clave del usuario i
		    	            	 	
		    	            	 	if(clave==claveid)   // si coincide las claves, se accede a los botones de retirar, depositar y ver el balance
		    	                    {
		    	                     pos=i;	
			                       	 jtA.setText("");
			                       	 jtA.setText("                                             Stark BankATM" + "                         Ro4_Corporation");
				                     jtA.setText(jtA.getText()+"\nWelcome " + crea_usuario.getCustomer(i).getFirstName() +
				                     	     "  " + crea_usuario.getCustomer(i).getLastName());
				                     jbDisplay.setEnabled(true);
	                                 jbDeposit.setEnabled(true);
	                                 jbWithdraw.setEnabled(true);
				                     jtfMsn.setText("Correct Key");
				                     jtfDataE.setText("");
				                     isValido= true;
				                     break;
		    	                    }	
				                    			    
			                        }
			                      if(isValido==false)
			                           {	         	
					                     jtA.setText(jtA.getText()+"\nCustomer Id was not found");
					                     jbDisplay.setEnabled(false);
	                                     jbDeposit.setEnabled(false);
	                                     jbWithdraw.setEnabled(false);
					                     jtfMsn.setText("Incorrect Password");
					                     JOptionPane.showMessageDialog(this,"   Password No Found","Information", JOptionPane.INFORMATION_MESSAGE);
					                    
				                       }
		    	            
		    	               }catch(RuntimeException e3)
			                     {
				                  jtA.setText("                                            Stark BankATM"+ "\n First Login your Id user");
				                  jtfMsn.setText("First Login");
				                  return;
			                   }
		    	              } 	
			              else
	                       	{
	             	       	if ( new String(jtfDataE.getPassword()) != "")
	             		     	{
	             		         jtfMsn.setText("Please Select Deposit or Withdraw Button");
	            	            }
		    	        	} 
		    	}  

		  }		                
		               
		         
		           
		    else 
			    if (buttonStr.equals("Clear") ) // Evento para limpiar la pantalla de las transacciones realizadas
		           {  
		         	if (isValido == false)      	
		         	{
				       jtA.setText("                                            Stark BankATM");
				       jtfDataE.setText("");
				       jtfMsn.setText("");
		         	}
		         		
			    
                  }
       }
 
  
} 
  
  public void run()
  {
  	try
  	{
  		if(acciontype==1)
  		{
       	     try
       	     {         	   		
       	   		amount = Double.parseDouble(JOptionPane.showInputDialog(null,"How much do you want to deposit?","Deposit",JOptionPane.QUESTION_MESSAGE));

	
       	     }catch(RuntimeException e1)
			  {
			    jtfMsn.setText("Please type numeric character into the Data Entry and Press deposit Button"); 
			    JOptionPane.showMessageDialog(null,"Please type numeric character into the Data Entry and Press deposit Button","Information",JOptionPane.INFORMATION_MESSAGE);
  				return;
			  }    
	         jtA.setText(jtA.getText()+"\nMake a deposit:  " + " " + crea_usuario.getCustomer(pos).getAccount().deposit(amount) );
	         jtfMsn.setText("deposit Sussesful !");
	         archivo.Escritura(crea_usuario.get_lista());
  		}
  		if(acciontype==2)
  		{
  			try
	          {
	          
	            amount = Double.parseDouble(JOptionPane.showInputDialog(null,"Make a Withdrawal","Withdrawal",JOptionPane.QUESTION_MESSAGE));
	       
       	   		  
			      }catch(RuntimeException e1)
			      {
				   jtfMsn.setText("Please type numeric character into " + "the Data Entry and Press Withdraw Button");
				     return;
			    }
			   try
			     {
				  crea_usuario.getCustomer(pos).getAccount().withdraw(amount); 
	             }catch(OverdraftException e3)
	             {
	            	jtfMsn.setText("Deficit: " +e3.getDeficit() + " " + e3.getMessage() + "Actual balance:  " + crea_usuario.getCustomer(pos).getAccount().getBalance() );
    
	             	return;
	             }
		      	jtA.setText(jtA.getText()+"\nMake a withdrawal  " + amount);
		      	archivo.Escritura(crea_usuario.get_lista());
                jtfMsn.setText("Withdraw Sussesful !");
  		}
  		Thread.sleep(1000);
  	}
  	catch(InterruptedException a)
  		{
  		}
  		
  }
  
 
 /** Metodo Principal */
  
  public static void main(String[] args)
  {
      BankAtmSwing batm1 = new BankAtmSwing(); 
  	  BankAtmSwing batm2 = new BankAtmSwing(); 	 
  	 
  	 batm1.setBounds(300,140,600,250);
  	 batm2.setBounds(300,400,600,250); 
  	  Thread bank1=	new Thread(batm1);
  	  Thread bank2= new Thread(batm2);
  	 
  	    	  
  	  bank1.start();
  	  bank2.start();
  	  
  	Thread.yield();
  }
}  

  
	  
	  
  
  
  
  
