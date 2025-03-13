
/**
 * @(#)Bank_ATM.java
 *
 *  2008/12/18
 *
 * @author Maquilón S.
 * @version 1.0
 */
 
package clases;

import java.awt.*;

import javax.swing.*;

import javax.swing.event.*;

import java.awt.event.*;

import java.util.*;

import java.net.*;

import java.io.*;


 /**
  *Clase Principal, la misma extiende de JFrame e implementa ActionListener
  *@version 3.00 2008/12/18
  */
 

public class BankATM extends JFrame implements ActionListener
{
 /* public static void main(String [] args)
	{
		BankATM bank = new BankATM("BankATM");
	}                                         */
	
	///////////////////////////////////////////////////////////
	
	Sesion sesion;
	
	JPanel p1, p2, fondo;
	
	JMenuBar barra;
	
	JMenu opcion1, opcion2, opcion3, opcion4, opcion5, out;
	
	JMenuItem submenu1, submenu2, submenu3, submenu4, submenu5, submenu6;
	
	JButton balance, deposit, withdraw;
	
	
	/**
	 *Constructor de la Clase Bank_ATM
	 *Controla la creación de la Interfaz del Programa
	 *@param Title nombre o título con que se declara el Programa.
	 *@version 1.0
	 */
	
	
	public BankATM(String Title)
	{
		super(Title);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Interfaz();
		
		this.setSize(660,200);
		
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	
	
	/**
	 *Este Método ejecuta la creación de la Interfaz Bank - User
	 *@version 1.0
	 */
	
	public void Interfaz()
	{
		 GridLayout does = new GridLayout(3,1,1,0);
		
		 BorderLayout in = new BorderLayout();
		 
		 fondo = new JPanel();
		 
		 fondo.setLayout(in);
		 
		 fondo.setBackground(Color.white);
			
		 p1 = new JPanel();
		 
		 p1.setLayout(does);
		 
		 deposit = new JButton("Make a Deposit");
		 
		 withdraw = new JButton("Make a Withdraw");
		 
		 balance = new JButton("See my Balance");
		 
		 deposit.setBackground(Color.black);
		 
		 deposit.addActionListener(this);
		 
		 deposit.setEnabled(false);
		 
		 deposit.setForeground(Color.white);
		 
		 withdraw.setBackground(Color.black);
		 
		 withdraw.addActionListener(this);
		 
		 withdraw.setEnabled(false);
		 
		 withdraw.setForeground(Color.white);
		 
		 balance.setBackground(Color.black);
		 
		 balance.addActionListener(this);
		 
		 balance.setEnabled(false);
		 		 
		 balance.setForeground(Color.white);
		 
		 p1.add(deposit);
		 
		 p1.add(withdraw);
		 
		 p1.add(balance);
		 
		 barra = new JMenuBar();
		 
		 opcion1 = new JMenu("               File                ");
		 
		 opcion2 = new JMenu("     My Account Data                ");
		 
		 opcion3 = new JMenu("     Sesion                 ");
		 
		 opcion4 = new JMenu("     Bank Users            ");
		 
		 opcion5 = new JMenu("          Finish     ");
		 
		 submenu1 = new JMenuItem("new user");
		 
		 submenu2 = new JMenuItem("see my account data");
		 
		 submenu3 = new JMenuItem("End Program !");
		 
		 submenu4 = new JMenuItem("login");
		 
		 submenu5 = new JMenuItem("logout");
		 
		 submenu6 = new JMenuItem("Display Clients");
		 
		 submenu1.addActionListener(this);
		 
		 submenu2.addActionListener(this);
		 
		 submenu3.addActionListener(this);
		 
		 submenu4.addActionListener(this);
		 
		 submenu5.addActionListener(this);
		 
		 submenu6.addActionListener(this);
		 
		 submenu2.setEnabled(false);
		 
		 submenu5.setEnabled(false);
		 
		 opcion1.add(submenu1);
		 
		 barra.add(opcion1);
		 
		 opcion2.add(submenu2);
		 
		 opcion5.add(submenu3);
		 
		 barra.add(opcion2);
		 
		 opcion3.add(submenu4);
		 
		 opcion3.add(submenu5);
		 
		 barra.add(opcion3);
		 
		 opcion4.add(submenu6);
		 
		 barra.add(opcion4);
		 
		 barra.add(opcion5);
		 
		 barra.setBackground(Color.black);
		 
		 p1.setBackground(Color.white); 
		 
		 opcion1.setForeground(Color.white);
		 
		 opcion2.setForeground(Color.white);
		 
		 opcion3.setForeground(Color.white);
		 
		 opcion4.setForeground(Color.white);
		 
		 opcion5.setForeground(Color.white);
		 
		 fondo.add(barra,in.NORTH);
		 
		 fondo.add(p1,in.WEST);
		 
		 p2 = new JPanel();
		 
		 p2.setLayout(null);
		 
		 p2.setBackground(Color.white);
		 
		 fondo.add(p2,in.CENTER);
		 
		 this.getContentPane().add(fondo);
	}
	
	
		
	/**
	 *Método Performed
	 *Ejerce el manejo de todos los eventos del programa.
	 *@version 1.0
	 */
	
	
	public void actionPerformed(ActionEvent e)
	{
		
	String boton = e.getActionCommand();
			
	if(boton.equals("Make a Deposit"))
	{
			try{
			
			Client client =  new Client();
				
			ObjectOutputStream enviar = new ObjectOutputStream(client.user.getOutputStream());
			
			enviar.writeObject("realizar un Deposito");
			
			sesion.Depositar(this); 
			
			} catch(Exception f){  }
			
			if(sesion.access == false)
			{
				try{
					
				Client client = new Client();
					
				ObjectOutputStream sendcancelDeposit = new ObjectOutputStream(client.user.getOutputStream());
							
				sendcancelDeposit.writeObject("deposito Cancelado");
				
				} catch(Exception f){  }
			}
			
			else if(sesion.access == true)
			{
				
			try{
				
			Client client = new Client();
			
			ObjectOutputStream access = new ObjectOutputStream(client.user.getOutputStream());
							
			access.writeObject("deposito en Proceso");
			
			ObjectOutputStream sendDeposit = new ObjectOutputStream(client.user.getOutputStream());
						
			sendDeposit.writeObject(sesion.dep);
			
			ObjectInputStream recieveAnswer = new ObjectInputStream(client.user.getInputStream());
			
			String answer = recieveAnswer.readObject().toString();
			
			sesion.isDeposited(answer);
			
			} catch(Exception f){  }
			
			}
	}
        
    else if(boton.equals("See my Balance"))
    {
    		try{
			
			Client client =  new Client();
				
			ObjectOutputStream enviar = new ObjectOutputStream(client.user.getOutputStream());
			
			enviar.writeObject("Consultar Balance"); 
			
			ObjectInputStream recieveBalance = new ObjectInputStream(client.user.getInputStream());
			
			String actualBalance = recieveBalance.readObject().toString();
			
			sesion.Balance(this,actualBalance);
    	 	
			} catch(Exception f){  }
    }
         
    else if(boton.equals("Make a Withdraw"))
    {
    		try{
			
			Client client =  new Client();
				
			ObjectOutputStream enviar = new ObjectOutputStream(client.user.getOutputStream());
			
			enviar.writeObject("realizar un Retiro");
			
			sesion.Retirar(this);
			
			} catch(Exception f){  }
			
			if(sesion.access == false)
			{
				try{
					
				Client client = new Client();
					
				ObjectOutputStream sendcancelWithdraw = new ObjectOutputStream(client.user.getOutputStream());
							
				sendcancelWithdraw.writeObject("retiro Cancelado");
				
				} catch(Exception f){  }
			}
			
			else if(sesion.access == true)
			{
			
			try{ 
			
			Client client = new Client();
			
			ObjectOutputStream access = new ObjectOutputStream(client.user.getOutputStream());
							
			access.writeObject("retiro en Proceso");
			
			ObjectOutputStream sendDeposit = new ObjectOutputStream(client.user.getOutputStream());
						
			sendDeposit.writeObject(sesion.retiro);
			
			ObjectInputStream recieveAnswer = new ObjectInputStream(client.user.getInputStream());
			
			String answer = recieveAnswer.readObject().toString();
			
			sesion.isWithdraw(answer);
			
			} catch(Exception f){  }
			
			}
    }           
          
    else if(boton.equals("login"))
    {
    		try{
			
			Client client =  new Client();
				
			ObjectOutputStream enviar = new ObjectOutputStream(client.user.getOutputStream());
			
			enviar.writeObject("iniciar Sesion");
			
			/////////////////////////////////////////////////////////////////////////////////////////
			
			sesion = new Sesion(this,balance,deposit,withdraw,submenu4,submenu5,p2,submenu1,submenu2);
			
			if(sesion.access == false)
			{
				try{
					
				ObjectOutputStream sendcancelSesion = new ObjectOutputStream(client.user.getOutputStream());
							
				sendcancelSesion.writeObject("inicio de sesion Cancelado");
				
				} catch(Exception f){  }
			}
			
			else if(sesion.access == true)
			{
				
			ObjectOutputStream access = new ObjectOutputStream(client.user.getOutputStream());
							
			access.writeObject("inicio de sesion en Proceso");
			
			ObjectOutputStream sendSesionData = new ObjectOutputStream(client.user.getOutputStream());
			
			sendSesionData.writeObject(sesion.n);
			
			sendSesionData.writeObject(sesion.p);
			
			ObjectInputStream recieveAnswer = new ObjectInputStream(client.user.getInputStream());
			
			String answer = recieveAnswer.readObject().toString();
			
			if(answer.equals("si"))
			{
				ObjectInputStream recieveData = new ObjectInputStream(client.user.getInputStream());				
			
				String trueAnswer = recieveData.readObject().toString();
			
				String name = recieveData.readObject().toString();
				
				String lastName = recieveData.readObject().toString();
				
				String Id = recieveAnswer.readObject().toString();
				
				String m = recieveAnswer.readObject().toString();
			
				sesion.iniciarSesion(answer,name,lastName,Id,m);	
			}
			
			else if(answer.equals("no"))
			{
				ObjectInputStream recieveResp = new ObjectInputStream(client.user.getInputStream());				
				
				recieveResp.readObject();
				
				sesion.iniciarSesion(answer);			
			}
			
			else if(answer.equals("no hay clientes"))
			{
				ObjectInputStream recieveResp = new ObjectInputStream(client.user.getInputStream());				
				
				recieveResp.readObject();
				
				sesion.iniciarSesion(answer);
			}
			
			} 
			
			}  catch(Exception f){  }
    }
       
	else if(boton.equals("logout"))
	{		
		JOptionPane.showMessageDialog(this,
    	
    	"                    Hasta Pronto  -  "+sesion.nameP,
    	
    	"     Capital Bank - dice:",
    	
    	JOptionPane.PLAIN_MESSAGE);	
    	
    	sesion.welcome.setVisible(false);
		
		sesion.sal.setVisible(false);
		
		submenu2.setEnabled(false);
		
		deposit.setEnabled(false);
		
		balance.setEnabled(false);
		
		withdraw.setEnabled(false);
		
		submenu4.setEnabled(true);
		
		submenu1.setEnabled(true);
		
		submenu5.setEnabled(false);
		
		try{
		
		Thread.sleep(2000);
		
		sesion.welcome.setVisible(false); }catch(InterruptedException m){}
	}
        
    else if(boton.equals("new user"))
	{			
			try{
			
			Client client =  new Client();
			 
			ObjectOutputStream enviar = new ObjectOutputStream(client.user.getOutputStream());
			
			enviar.writeObject("nuevo Usuario"); 
			
			Register r = new Register(this); 
			
			/////////////////////////////////////////////////////////////////////////////////
			 
			if(r.access == false)
			{
				try{
					
				ObjectOutputStream sendcancelRegister = new ObjectOutputStream(client.user.getOutputStream());
							
				sendcancelRegister.writeObject("proceso de registro Cancelado");
				
				} catch(Exception f){  }
			}
			
			else if(r.access == true)
			{
			
			ObjectOutputStream access = new ObjectOutputStream(client.user.getOutputStream());
							
			access.writeObject("Creacion de un nuevo Usuario en proceso");
			
			ObjectOutputStream sendRegisterData = new ObjectOutputStream(client.user.getOutputStream());
			
			sendRegisterData.writeObject(r.na);
			
			sendRegisterData.writeObject(r.ap);
			
			sendRegisterData.writeObject(r.ce);
			
			sendRegisterData.writeObject(r.pa);
			
			sendRegisterData.writeObject(r.m);
			
			}
			
			} catch(Exception f){  }
	}
	
	else if(boton.equals("see my account data"))
	{		
		 sesion.data(); 
	}
			
	else if(boton.equals("Display Clients"))
	{	
			try{
			
			Client client =  new Client();
				
			ObjectOutputStream enviar = new ObjectOutputStream(client.user.getOutputStream());
			
			enviar.writeObject("Visualizar Clientes"); 
			
			ObjectInputStream recieveBankUsersData = new ObjectInputStream(client.user.getInputStream());
			
			LinkedList clientsList = new LinkedList();
			
			clientsList = (LinkedList) recieveBankUsersData.readObject(); 
			
			if(clientsList.size() == 0)
			{
				JOptionPane.showMessageDialog(null,
    			"No hay Clientes registrados en este Banco!",
    			"Inane warning",
    			JOptionPane.WARNING_MESSAGE);
			}
			
			else
			{
				Users myUsers = new Users(clientsList); 	
			}
			
			} catch(Exception f){  }
	}
	
	else if(boton.equals("End Program !"))
	{	
			try
			{	
	
			Client client =  new Client();
	
			ObjectOutputStream sendAnswer = new ObjectOutputStream(client.user.getOutputStream());
			
			sendAnswer.writeObject("End Program !");
			
				try{
		
				Thread.sleep(2000);
		
				sesion.welcome.setVisible(false);
				
				Thread.sleep(2000); 
				
				this.setVisible(false);
				
				}catch(InterruptedException m){}

			}  catch(Exception k) {    }
	}
	
	}    
}