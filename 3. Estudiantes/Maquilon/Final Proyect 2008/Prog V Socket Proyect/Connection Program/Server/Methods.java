
package clases;

import javax.swing.*;

import java.awt.*;

import java.io.*;

import java.util.*;

public class Methods
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
	
	public String permitir;
	
	public String permitirDepo;
	
	public String permitirWith;
	
	public String Balance;
	
	public synchronized void sesion(String n,String p)
	{		
			nombre = n;
			contrasena = p;
			try{
			LinkedList Lista = new LinkedList();
			if(!clientes.exists()){permitir="no hay clientes";}
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
				
			permitir = "si";
			
			System.out.println("Bienvenido " + name);
			
			apellid=buscar.get(1).toString();
			cedul=buscar.get(2).toString();
			sald=buscar.get(4).toString();
			
			
			try
			{
			Thread.sleep(2000);
			}catch(InterruptedException e){}
			
			
			/*verdata.setEnabled(true);
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
	   		nuevo.setEnabled(false);*/
	   		
	   		break;
			}
			else if(q == capacidad)
			{
			permitir = "no";
			/*JOptionPane.showMessageDialog(f,
    		"Usted no esta registrado en este Banco",
    		"Inane warning",
    		JOptionPane.WARNING_MESSAGE);*/
			}}
			else{ break; }
			q++;
			}}	
			}  catch(Exception d){}
    }
    
    
    public void Depositar(String Deposit)
    {
    		synchronized(this)
    		{
    	
    		String deposit;
    	
    		deposit = Deposit;
    	
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
	/*		System.out.println("Hola "+x);
			System.out.println("Hola "+x+" su balance actual es de "+buscar.get(4));
			String deposit = withdr.getText();    		*/
			System.out.println(deposit);
			boolean valida;
			try{
			System.out.println("Validando"); Double.parseDouble(deposit); 
	//		copia_deposit = Double.parseDouble(withdr.getText());
	
			////////////////////////////////////////////
			
			copia_deposit = Double.parseDouble(deposit);
					
			////////////////////////////////////////////
			
			valida=true;}catch(NumberFormatException err){ valida=false;}
			if(copia_deposit<=0 || valida==false)
			{
				
			///////////////////////
			
			permitirDepo = "no";
			
			////////////////////// 
 
    		}
    		
    		////////////////////////////////////////////////
    		
			else if(valida==true && copia_deposit>0){
			
			/////////////////////	
			
			permitirDepo = "si";
			
			////////////////////
				
			double balance = (Double) buscar.get(4);
			double nuevo = balance+copia_deposit;
			System.out.println(nuevo);
			buscar.set(4,nuevo);	    
			System.out.println(buscar.get(4));
			Lista = (LinkedList) Lista;
			Lista.set(f,buscar);
			ObjectOutput escribir = new ObjectOutputStream(new FileOutputStream("clientes.txt"));
        	escribir.writeObject(Lista);
        	
        	try
			{
			Thread.sleep(2000);
			}catch(InterruptedException e){}

        	
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
    }
    
    
    public synchronized void Retirar(String Withdraw)
    {
    	String retiro;
    	
    	retiro = Withdraw;
    	
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
		/*	System.out.println("Hola "+x);
			System.out.println("Hola "+x+" su balance actual es de "+buscar.get(4));
			String retiro = ret.getText();    		*/
			System.out.println(retiro);
			boolean valida;
			try{
			System.out.println("Validando"); Double.parseDouble(retiro); 
	//		copia_retiro = Double.parseDouble(ret.getText());
			
			////////////////////////////////////////////
			
			copia_retiro = Double.parseDouble(retiro);
					
			////////////////////////////////////////////
	
			saldo = (Double) buscar.get(4);
			valida=true;}catch(NumberFormatException err){ valida=false;}
			if(copia_retiro<=0 || valida==false || saldo<copia_retiro)
			{
			
			///////////////////////
			
			permitirWith = "no";
			
			////////////////////// 
				
    		}
    		
			else if(valida==true && copia_retiro>0){
				
			/////////////////////	
			
			permitirWith = "si";
			
			////////////////////
			
			double nuevo = saldo-copia_retiro;
			System.out.println(nuevo);
			buscar.set(4,nuevo);	    
			System.out.println(buscar.get(4));
			Lista = (LinkedList) Lista;
			Lista.set(f,buscar);
			ObjectOutput escribir = new ObjectOutputStream(new FileOutputStream("clientes.txt"));
        	escribir.writeObject(Lista);
        	
        	
        	try
			{
			Thread.sleep(2000);
			}catch(InterruptedException e){}
        	
        	
        	reti.hide();
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
    
    
    public synchronized void seeBalance()
    {
   			try{		
			LinkedList Lista = new LinkedList();
			ObjectInputStream sacar = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 									
        	Lista = (LinkedList) sacar.readObject();
       		int f = 0;
         	Vector buscar = new Vector();	
	//		System.out.println(name);
			while(f < Lista.size())
			{							
			if(f < Lista.size()){
			buscar = (Vector) Lista.get(f);
			String x = buscar.get(0).toString();
			if(x.equals(name))
			{
						try
						{
							Thread.sleep(2000);
						}catch(InterruptedException e){}
				
					Balance = buscar.get(4).toString();
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
    
}
