
/**
 * @(#)Sesion.java
 *
 * @author Maquilón S.
 * @version 3.00 2008/12/18
 */

package clases;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.border.*;

import javax.swing.*;

import java.io.*;

import java.awt.*;

import java.util.*;



	 /**
	 *Esta es la Clase Sesion que implementa Serializable, ya que en ella se ejecuta el manejo de Datos externos.
	 *
	 *En ella se crea la interfaz de interacción con el usuario, cuando el mismo desee iniciar su sesión, 
	 *depositar, retirar o consultar su balance.
	 *@version 1.0
	 */

public class Sesion implements java.io.Serializable
{
	JDialog entrar;
	public JLabel welcome;
	JTextField name2, pass2;
	JButton accept2, cancel2, clear2;
	String nombre, apellido, cedula, contrasena;
	int conseguido;
	JFrame frame;
	JDialog deposito;
	JTextField withdr;
	JFrame f;
	JDialog bala;
	JTextField bal;
	JDialog reti;
	JTextField ret;
	String referencia;
	public String password, name;
	
	public static File clientes = new File("clientes.txt");
		
	
	//   ATRIBUTOS PRINCIPALES
		
	JDialog depositar;
	private JButton [] buttons;
	JPanel background, calculator_background, calculator, display, left_botons,
	right_botons;
	JButton bank_users, sign_out, registrate;
	
	
	JMenuItem login,logout,nuevo,verdata;
	
	

	JTextField valores;
	JButton balance, deposit, withdraw;
	JTextArea impresiones;
	double copia_deposit;
	double copia_retiro;
	double saldo;
	
	JMenuBar barra;
	
	public JPanel p2;
	
	public String cedul,sald,apellid;
	
	public JLabel cedu, sal; 
	
	
	
	 /**
	 *Este es el constructor de la Clase Sesion
	 *@param a Trae una referencia de La Clase Principal Bank_atm, la cual extiende de JFrame
	 *@param b trae la referencia del JButton Balance, creado en la clase prinicipal Bank_atm
	 *@param c trae la referencia del JButton Depositar, creado en la clase prinicipal Bank_atm
	 *@param d trae la referencia del JButton Retirar, creado en la clase prinicipal Bank_atm
	 *@param e trae la referencia del JButton login, creado en la clase prinicipal Bank_atm
	 *@param f trae la referencia del JButton logout, creado en la clase prinicipal Bank_atm
	 *@param g trae la referencia del JPanel display, creado en la clase prinicipal Bank_atm
	 *@param h trae la referencia del JButton new user , creado en la clase prinicipal Bank_atm
	 *@param i trae la referencia del JPanel fondo, creado en la clase prinicipal Bank_atm
	 *Aqui se crea la interfaz Bank - User, cuando el usuario desee iniciar su sesión
	 *@version 1.0
	 */
	
	
	//   INTERFAZ - SESION
	
	public Sesion(JFrame a,JButton b,JButton c,JButton d,JMenuItem e,JMenuItem f,JPanel g,JMenuItem h
	              
	              ,JMenuItem i)
	{
			frame = a;
			
			balance = b;
			
			deposit = c;
			
			withdraw = d;
			
			login = e;
			
			logout = f;
			
			p2 = g;
			
			nuevo = h;	
			
			verdata = i;	
	
			entrar = new JDialog(frame," welcome",true);
			entrar.setBounds(350,285,462,350);
			name2 = new JTextField(15);
			JLabel username2  = new JLabel("Username");
			username2.setBounds(25,40,100,30);
			name2.setBounds(100,45,150,20);
			pass2 = new JPasswordField();
			JLabel password2  = new JLabel("Password");
			password2.setBounds(25,95,150,20);
			pass2.setBounds(100,98,105,20);
			JPanel title_Border = new JPanel();
			title_Border.setLayout(null);
			title_Border.setBounds(68,30,310,210);
			title_Border.setBorder(BorderFactory.createTitledBorder(" LOGIN "));
			title_Border.add(name2);
			title_Border.add(username2);
			title_Border.add(password2);
			title_Border.add(pass2);
			title_Border.setBackground(Color.white);
			JLabel terms1 = new JLabel("Welcome to Capital Bank, enjoyment of the best");
			JLabel terms2 = new JLabel("offerings here in this bank for excellence");
    		Font sistema = new Font("Times new Roman",Font.PLAIN,12); 
    		terms1.setFont(sistema);
    		terms2.setFont(sistema);		
			JButton accept2 = new JButton("Submit");
			JButton cancel2 = new JButton("Cancel");
			JButton clear2 = new JButton("Clear");
			terms1.setBounds(25,100,250,100);
			terms2.setBounds(25,120,305,100);
			accept2.setBounds(73,255,95,25);
			cancel2.setBounds(176,255,94,25);
			clear2.setBounds(278,255,95,25);
			clear2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			String boton = e.getActionCommand();
			if(boton.equals("Clear"))
			name2.setText("");
			pass2.setText("");
			}
			});
			cancel2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			String boton = e.getActionCommand();
			if(boton.equals("Cancel"))
			entrar.setVisible(false);					
			}
			});
			
			accept2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			if(name2.getText().equals("") || pass2.getText().equals(""))
			{
			JOptionPane.showMessageDialog(frame,
    		"Llene todos los campos, por favor",
    		"Inane warning",
    		JOptionPane.WARNING_MESSAGE);
			}
			else
			{
			String n = String.valueOf(name2.getText());
        	String p = String.valueOf(pass2.getText());				    			        						
        	sesion(n,p);
			entrar.setVisible(false);
			}
			}
			});
			
			JPanel background = new JPanel();
			background.setLayout(null);
			title_Border.add(terms1);
			title_Border.add(terms2);
			accept2.setBackground(Color.black);
			cancel2.setBackground(Color.black);
			clear2.setBackground(Color.black);
			accept2.setForeground(Color.white);
			cancel2.setForeground(Color.white);
			clear2.setForeground(Color.white);
			background.add(accept2);
			background.add(cancel2);
			background.add(clear2);
			background.add(title_Border);  
			background.setBorder(BorderFactory.createLineBorder(Color.black));
			background.setBackground(Color.white); 
			entrar.add(background);
			entrar.setVisible(true);
	}
		
		
		/**
		 *Este Método es el encargado de manejar el evento: INICIO DE SESION
		 *@param n trae la referencia del nombre del cliente, sumnistrada en el constructor
		 *@param p trae la referencia de la contraseña del cliente, sumnistrada en el constructor de esta clase.
		 *@version 1.0
		 */
		
		
		
	//  INICIAR SESION
		
		
	public void sesion(String n,String p)
	{		
			nombre = n;
			contrasena = p;
			try{
			LinkedList Lista = new LinkedList();
			if(!clientes.exists()){JOptionPane.showMessageDialog(null,
    							"No hay Clientes registrados en este Banco!",
    							"Inane warning",
    							JOptionPane.WARNING_MESSAGE);}
			else{	
			ObjectInputStream sacar = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 									
        	Lista = (LinkedList) sacar.readObject();
        	int capacidad = (Integer)(Lista.size()-1);
        	int q = 0;	
			Vector buscar = new Vector();
			while(q < Lista.size())
			{							
			if(q < Lista.size()){
			buscar = (Vector) Lista.get(q);
			name = buscar.get(0).toString();
			password = buscar.get(3).toString();
			if(name.equals(nombre) && password.equals(contrasena))
			{
			apellid=buscar.get(1).toString();
			cedul=buscar.get(2).toString();
			sald=buscar.get(4).toString();
			verdata.setEnabled(true);
			login.setEnabled(false);
			System.out.println("Hola "+name);
			welcome = new JLabel("Welcome "+name+" "+apellid+"    ID: "+cedul);  
        	welcome.setBounds(50,-50,400,200);
	    	Date fecha = new Date();
			sal = new JLabel("Your balance today, "+fecha+" is: "+sald);
			sal.setBounds(105,-20,400,200);
			p2.add(welcome);
			p2.add(sal);
			welcome.setVisible(false);
			sal.setVisible(false);
	    	logout.setEnabled(true);
			deposit.setEnabled(true);
	   		balance.setEnabled(true);
	   		withdraw.setEnabled(true);
	   		nuevo.setEnabled(false);
	   		break;
			}
			else if(q == capacidad)
			{
			JOptionPane.showMessageDialog(f,
    		"Usted no esta registrado en este Banco",
    		"Inane warning",
    		JOptionPane.WARNING_MESSAGE);
			}}
			else{ break; }
			q++;
			}}	
			}  catch(Exception d){}
     }
       
       
       /**
        *Método que presenta en pantalla los datos originales del cliente
        */
       
       
     
     public void data()
     {
		welcome.setVisible(true);
		sal.setVisible(true);
     }
     
     
     
       /**
		 *Este Método es el encargado de manejar el evento: DEPOSITAR
		 *@param d Trae una referencia de La Clase Principal Bank_atm, la cual extiende de JFrame
		 *@version 1.0
		 */
     
     
    //  DEPOSITAR

       
    public void Depositar(JFrame d) throws Exception
	{		
			f = d;		
			deposito = new JDialog(d,"welcome",true);
			deposito.setBounds(350,285,462,290);
			withdr = new JTextField(15);
			JLabel deposita  = new JLabel("Depositar");
			deposita.setBounds(25,40,100,30);
			withdr.setBounds(100,45,150,20);		
			JPanel title_Border = new JPanel();
			title_Border.setLayout(null);
			title_Border.setBounds(68,30,310,150);
			title_Border.setBorder(BorderFactory.createTitledBorder(" DEPOSIT "));
			title_Border.add(withdr);
			title_Border.add(deposita);
			title_Border.setBackground(Color.white);
			JLabel terms1 = new JLabel("Welcome to Capital Bank, enjoyment of the best");
			JLabel terms2 = new JLabel("offerings here in this bank for excellence");
    		Font sistema = new Font("Times new Roman",Font.PLAIN,12); 
    		terms1.setFont(sistema);
    		terms2.setFont(sistema);
			JButton accept2 = new JButton("Depositar");
			JButton cancel2 = new JButton("Cancel");
			JButton clear2 = new JButton("Clear");
			terms1.setBounds(25,50,250,100);
			terms2.setBounds(25,65,305,100);
			accept2.setBounds(73,200,95,25);
			cancel2.setBounds(176,200,94,25);
			clear2.setBounds(278,200,95,25);
			
			
			clear2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			withdr.setText("");					
			}
			});
			
			cancel2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			String boton = e.getActionCommand();
			if(boton.equals("Cancel"))
			deposito.setVisible(false);					
			}
			});
			
			
			accept2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{	
			if(withdr.getText().equals(""))
			{
			JOptionPane.showMessageDialog(f,
    		"Llene todos los campos, por favor",
    		"Inane warning",
    		JOptionPane.WARNING_MESSAGE);
			}
			try {
			LinkedList Lista = new LinkedList();
			ObjectInputStream sacar = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 									
        	Lista = (LinkedList) sacar.readObject();
        	int f = 0;			
			Vector buscar = new Vector();		
			while(f < Lista.size())
			{							
			if(f < Lista.size()){
			buscar = (Vector) Lista.get(f);
			String x = buscar.get(0).toString();
			if(x.equals(name))
			{
			System.out.println("Hola "+x);
			System.out.println("Hola "+x+" su balance actual es de "+buscar.get(4));
			String deposit = withdr.getText();    		
			System.out.println(deposit);
			boolean valida;
			try{
			System.out.println("Validando"); Double.parseDouble(deposit); 
			copia_deposit = Double.parseDouble(withdr.getText());
			valida=true;}catch(NumberFormatException err){ valida=false;}
			if(copia_deposit<=0 || valida==false)
			{JOptionPane.showMessageDialog(null,
    		"El Monto depositado no es correcto!, sea serio",
    		"Inane error",
    		JOptionPane.ERROR_MESSAGE); }
			else if(valida==true && copia_deposit>0){
			double balance = (Double) buscar.get(4);
			double nuevo = balance+copia_deposit;
			System.out.println(nuevo);
			buscar.set(4,nuevo);	    
			System.out.println(buscar.get(4));
			Lista = (LinkedList) Lista;
			Lista.set(f,buscar);
			ObjectOutput escribir = new ObjectOutputStream(new FileOutputStream("clientes.txt"));
        	escribir.writeObject(Lista);
        	deposito.hide();
        	}
			}
			else
			{
			System.out.println("equivocado");
			}
			}
			else{  break; }
			f++;
			}		
			}  catch(Exception d){}
			}
			});
			
			JPanel background = new JPanel();
			background.setLayout(null);
			title_Border.add(terms1);
			title_Border.add(terms2);
			accept2.setBackground(Color.black);
			cancel2.setBackground(Color.black);
			clear2.setBackground(Color.black);
			accept2.setForeground(Color.white);
			cancel2.setForeground(Color.white);
			clear2.setForeground(Color.white);
			background.add(accept2);
			background.add(cancel2);
			background.add(clear2);
			background.add(title_Border);  
			background.setBorder(BorderFactory.createLineBorder(Color.black));
			background.setBackground(Color.white); 
			deposito.add(background);
			deposito.setVisible(true);
	}	
       
          
       
        /**
		 *Este Método es el encargado de manejar el evento: CONSULTAR BALANCE
		 *@param d Trae una referencia de La Clase Principal Bank_atm, la cual extiende de JFrame
		 *@version 1.0
		 */
       
       
       
   //  BALANCE 
       
       
    public void Balance(JFrame d)
	{
			f = d;		
			bala = new JDialog(f," welcome",true);
			bala.setBounds(350,285,462,415);
			bal = new JTextField(15);
			Date date = new Date();
			JLabel fecha = new JLabel(""+date);
			fecha.setBounds(90,30,190,30);
			JLabel ba  = new JLabel("Your actual balance is: ");
			ba.setBounds(40,70,190,30);
			bal.setBounds(100,127,150,20);
			JPanel title_Border = new JPanel();
			title_Border.setLayout(null);
			title_Border.setBounds(68,30,310,278);
			title_Border.setBorder(BorderFactory.createTitledBorder(" BALANCE "));
			title_Border.add(bal);
			title_Border.add(fecha);
			title_Border.add(ba);
			title_Border.setBackground(Color.white);
			JLabel terms1 = new JLabel("Welcome to Capital Bank, enjoyment of the best");
			JLabel terms2 = new JLabel("offerings here in this bank for excellence");
    		Font sistema = new Font("Times new Roman",Font.PLAIN,12); 
    		terms1.setFont(sistema);
    		terms2.setFont(sistema);
			JButton accept2 = new JButton("Volver");
			JButton ver = new JButton("Mi Balance");
			terms1.setBounds(25,140,250,100);
			terms2.setBounds(25,160,305,100);
			accept2.setBounds(110,324,95,25);
			ver.setBounds(220,324,120,25);
			
			
			accept2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			bala.setVisible(false);					
			}
			});
			

			ver.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			try{		
			LinkedList Lista = new LinkedList();
			ObjectInputStream sacar = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 									
        	Lista = (LinkedList) sacar.readObject();
       		int f = 0;
         	Vector buscar = new Vector();	
			System.out.println(name);
			while(f < Lista.size())
			{							
			if(f < Lista.size()){
			buscar = (Vector) Lista.get(f);
			String x = buscar.get(0).toString();
			if(x.equals(name))
			{
			bal.setText(buscar.get(4).toString());
			}
			else
			{
			System.out.println("equivocado");
			}
			}
			else{ break; }
			f++;
			}
			}catch(Exception g){}
			}
			});
			
			JPanel background = new JPanel();
			background.setLayout(null);
			title_Border.add(terms1);
			title_Border.add(terms2);
			accept2.setBackground(Color.black);
			accept2.setForeground(Color.white);
			ver.setForeground(Color.white);
			ver.setBackground(Color.black);
			background.add(accept2);
			background.add(ver);
			background.add(title_Border);  
			background.setBorder(BorderFactory.createLineBorder(Color.black));
			background.setBackground(Color.white); 
			bala.add(background);
			bala.setVisible(true);	
		}	
				
	
		 /**
		 *Este Método es el encargado de manejar el evento: RETIRAR
		 *@param d Trae una referencia de La Clase Principal Bank_atm, la cual extiende de JFrame
		 *@version 1.0
		 */
	
		
	//  RETIRAR	
		
		
	public void Retirar(JFrame d)
	{
			f = d;		
			reti = new JDialog(f," welcome",true);
			reti.setBounds(350,285,462,415);
			Date date = new Date();
			JLabel fecha = new JLabel(""+date);
			fecha.setBounds(90,30,190,30);
			ret = new JTextField(15);
			JLabel r  = new JLabel("Retirar");
			r.setBounds(25,95,100,30);
			ret.setBounds(100,100,150,20);
			JPanel title_Border = new JPanel();
			title_Border.setLayout(null);
			title_Border.setBounds(68,30,310,278);
			title_Border.setBorder(BorderFactory.createTitledBorder(" WITHDRAW "));
			title_Border.add(ret);
			title_Border.add(fecha);
			title_Border.add(r);
			title_Border.setBackground(Color.white);
			JLabel terms1 = new JLabel("Welcome to Capital Bank, enjoyment of the best");
			JLabel terms2 = new JLabel("offerings here in this bank for excellence");
    		Font sistema = new Font("Times new Roman",Font.PLAIN,12); 
    		terms1.setFont(sistema);
    		terms2.setFont(sistema);
			JButton accept2 = new JButton("Retirar");
			JButton cancel2 = new JButton("Cancel");
			JButton clear2 = new JButton("Clear");
			terms1.setBounds(25,140,250,100);
			terms2.setBounds(25,160,305,100);
			accept2.setBounds(73,324,95,25);
			cancel2.setBounds(176,324,94,25);
			clear2.setBounds(278,324,95,25);
			
			clear2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{					
			ret.setText("");					
			}
			});
			
			cancel2.addActionListener(new ActionListener()
		    {
			public void actionPerformed(ActionEvent e)
			{
			reti.setVisible(false);					
			}
			});
			
			
			accept2.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
			try {
			LinkedList Lista = new LinkedList();
			ObjectInputStream sacar = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 									
        	Lista = (LinkedList) sacar.readObject();
        	int f = 0;			
			Vector buscar = new Vector();		
			while(f < Lista.size())
			{							
			if(f < Lista.size()){
			buscar = (Vector) Lista.get(f);
			String x = buscar.get(0).toString();
			if(x.equals(name))
			{
			System.out.println("Hola "+x);
			System.out.println("Hola "+x+" su balance actual es de "+buscar.get(4));
			String retiro = ret.getText();    		
			System.out.println(retiro);
			boolean valida;
			try{
			System.out.println("Validando"); Double.parseDouble(retiro); 
			copia_retiro = Double.parseDouble(ret.getText());
			saldo = (Double) buscar.get(4);
			valida=true;}catch(NumberFormatException err){ valida=false;}
			if(copia_retiro<=0 || valida==false || saldo<copia_retiro)
			{JOptionPane.showMessageDialog(null,
    		"El Monto retirado no es correcto!, sea serio",
    		"Inane error",
    		JOptionPane.ERROR_MESSAGE); }
			else if(valida==true && copia_retiro>0){
			double nuevo = saldo-copia_retiro;
			System.out.println(nuevo);
			buscar.set(4,nuevo);	    
			System.out.println(buscar.get(4));
			Lista = (LinkedList) Lista;
			Lista.set(f,buscar);
			ObjectOutput escribir = new ObjectOutputStream(new FileOutputStream("clientes.txt"));
        	escribir.writeObject(Lista);
        	reti.setVisible(false);
        	}
			}
			else
			{
			System.out.println("equivocado");
			}
			}
			else{  break; }
			f++;
			}		
			}  catch(Exception u){}
			}
			});
			
			JPanel background = new JPanel();
			background.setLayout(null);
			title_Border.add(terms1);
			title_Border.add(terms2);
			accept2.setBackground(Color.black);
			cancel2.setBackground(Color.black);
			clear2.setBackground(Color.black);
			accept2.setForeground(Color.white);
			cancel2.setForeground(Color.white);
			clear2.setForeground(Color.white);
			background.add(accept2);
			background.add(cancel2);
			background.add(clear2);
			background.add(title_Border);  
			background.setBorder(BorderFactory.createLineBorder(Color.black));
			background.setBackground(Color.white); 
			reti.add(background);
			reti.setVisible(true);
	}	
}




        	