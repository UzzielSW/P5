
/**
 * @(#)Bank_ATM.java
 *
 * @author Maquilón S.
 * @version 3.00 2008/12/18
 */
 
package clases;

import java.awt.*;

import javax.swing.*;

import javax.swing.event.*;

import java.awt.event.*;

import java.util.*;


/**
  *Clase Principal, la misma extiende de JFrame e implementa ActionListener
  *@version 3.00 2008/12/18
  */
 

public class BankATM extends JFrame implements ActionListener
{
	public static void main(String [] args)
	{
		Runnable first = new Runnable() 
		{  	
	    	public void run() 
	    	{ 	
	    		Duplicate();
	    	}
	    }; 
	        	
	   	Thread thread1 = new Thread(first, "Cajero1"); 	
	   	
	   	thread1.start();
	   
		Runnable second = new Runnable() 
		{  	 
	    	public void run() 
	    	{ 	
	    		Duplicate();	
	    	}
	    }; 
		
		Thread thread2 = new Thread(second, "Cajero2"); 	
	   	
	   	thread2.start();

	}
	
	public static void Duplicate()
	{
		BankATM  bank_atm = new BankATM("Welcome to BankATM"); 	
		
		String name = Thread.currentThread().getName();
		
		System.out.println(name);
	}
	
	
	Sesion sesion;
	
	JPanel p1, p2, fondo;
	
	JMenuBar barra;
	
	boolean permitir;
	
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
		
		///////////////////
		 
		 permitir = false;
		 
		//////////////////
		
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
		 
		 opcion2 = new JMenu("    My Account Data                ");
		 
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
		 
		 barra.add(opcion2);
		 
		 opcion3.add(submenu4);
		 
		 opcion3.add(submenu5);
		 
		 barra.add(opcion3);
		 
		 opcion4.add(submenu6);
		 
		 barra.add(opcion4);
		 
		 opcion5.add(submenu3);
		 
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
	 * Método Performed
	 *Ejerce el manejo de todos los eventos del programa.
	 *@version 1.0
	 */
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		
	String boton = e.getActionCommand();
			
	if(boton.equals("Make a Deposit"))
	{
		try {
		
		sesion.Depositar(this);
		
		}catch(Exception d){}
	}
        
    else if(boton.equals("See my Balance"))
    {
    	sesion.Balance(this);
    }
         
    else if(boton.equals("Make a Withdraw"))
    {
    	sesion.Retirar(this);        	
    }           
          
    else if(boton.equals("login"))
    {
    	sesion = new Sesion(this,balance,deposit,withdraw,submenu4,submenu5,p2,submenu1,submenu2);
    }
       
	else if(boton.equals("logout"))
	{
		
		JOptionPane.showMessageDialog(this,
    	
    	"                    Hasta Pronto  -  "+sesion.name,
    	
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
    	
    	System.out.println("procesando");
		
		try{
		
		Thread.sleep(2000);
		
		sesion.welcome.setVisible(false);}catch(InterruptedException m){}
	}
        
    else if(boton.equals("new user"))
	{
		Register r = new Register(this);
	}
	
	else if(boton.equals("see my account data"))
	{
		sesion.data();	
	}
			
	else if(boton.equals("Display Clients"))
	{	
		Users u = new Users();
	}
	
	else if(boton.equals("End Program !"))
	{			
		permitir = false;
		
		if(permitir == false)
		{		
			this.setVisible(false);
		}
	}
	
	}    
}