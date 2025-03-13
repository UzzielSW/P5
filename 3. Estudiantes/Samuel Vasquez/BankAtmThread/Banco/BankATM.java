/**
 * @(#)BankATM.java

 * @author Samuel Vásquez 9-720-1392
 * @version 1.00 2009/9/19
 */
import java.io.*;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Banking.*;
public class BankATM extends Thread implements ActionListener
{
	/* Declaracion de variables globales */
	public static LinkedList<Customer> cliente = new LinkedList<Customer>();
	Customer encontrado;
	JFrame fra;
	int pas,cont=0;
	String car = "";
	private JPanel P_Izquierdo, north, Pincluye_sur, sur, pad;
	private JButton[] boton;
	private JButton balance, deposit, withdrawal;
	private JTextField data;
	//////////////////////
	private JPanel P_Derecho;
	private JTextArea area;
	private JTextField message;
	private JLabel mensaje;
	/////////////////////////
	private JMenuBar barraHe;
	private JMenu Cliente, See, CerrarSes;
	private JMenuItem crearCliente, salir,ce_se,allClientes;
	
	private JTextField name, apell, sald;
	private JPasswordField contra;
	private JButton bot;
	private JDialog cr;
	String nom_apell = "";
	Principal obj;
	
	/**
	 * Constructor BankATM
	 */
	public BankATM(String Title)
	{
		fra = new JFrame(Title); //se crea el JFrame
		/**
		 * Es la Parte donde crea el Menu en la Parte 
		 *superior
		 */
		barraHe = new JMenuBar(); //se crea la barra del Menu
		Cliente = new JMenu("File"); //se crea el menu File
		crearCliente = new JMenuItem("Nuevo Cliente"); //se crea el sub menu Nuevo Cliente
		//codigo que escucha crear cliente, se añade el JMenuIten al JMenu Cliente
		crearCliente.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// se crean los paneles
				JPanel panel_izq = new JPanel(new GridLayout(4,1));
				JPanel panel_der = new JPanel(new GridLayout(4,1));
				JPanel panel = new JPanel(new BorderLayout());
				obj = new Principal(fra); // se instancia un objeto de la Clase Principal	
				if(obj.Validar()==true)// metodo que valida si el administrado ingreso los datos correctos
				{
					cr = new JDialog(fra,"Datos del Cliente"); //se crea un JDialog
					cr.setModal(true); // el jdialog es modal 
					// se crean los JLabel,JTextFiel,JRadioButton y botones que van en JDialog
					JLabel nom = new JLabel("Nombre");
					panel_izq.add(nom);// se agrega al panel
					name = new JTextField(10);
					panel_der.add(name);// se agrega al panel
					
					JLabel ape = new JLabel("Apellido");
					panel_izq.add(ape);// se agrega al panel
					apell = new JTextField(10);
					panel_der.add(apell);// se agrega al panel
					
					JLabel bala = new JLabel("Balance");
					panel_izq.add(bala);// se agrega al panel
					sald = new JTextField(10);
					panel_der.add(sald);// se agrega al panel
					
					JLabel pass = new JLabel("Clave    ");
					panel_izq.add(pass);// se agrega al panel
					contra = new JPasswordField(10);
					panel_der.add(contra);// se agrega al panel
					
					panel.add(panel_izq,BorderLayout.WEST);// se agrega el panel a otro panel
					panel.add(panel_der,BorderLayout.CENTER);// se agrega el panel a otro panel
					
					bot  = new JButton("   Aceptar");
					
					//se agregan los panels a el JDialog
					cr.getContentPane().add(panel, BorderLayout.NORTH);
					cr.getContentPane().add(bot, BorderLayout.SOUTH);
					//escucha del boton aceptar
					bot.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							//convierte el JPasswordField a un String
							char passArray[] = contra.getPassword();
			  				String pass = new String(passArray);
							if(name.getText().equals("")||apell.getText().equals("")||pass.equals("")||sald.getText().equals(""))
							{
								JOptionPane.showMessageDialog(cr, "Complete los campos");
							}
							else
							{
								try{
									int pas = Integer.parseInt(pass);
									if(BuscarCliente(pas)==true)
									{
										JOptionPane.showMessageDialog(cr, "La clave ya existe");
									}else
									{
										try
										{
										double sa = Double.parseDouble(sald.getText());
										if(pass.length()==4 && pas>999)
										{
											if(sa>0&&sa<=50)
											addCliente(name.getText(),apell.getText(), Double.parseDouble(sald.getText()),pas,"Ahorro");
											else
											addCliente(name.getText(),apell.getText(), Double.parseDouble(sald.getText()),pas,"Corriente");	
				  							cr.setVisible(false);
				  							JOptionPane.showMessageDialog(cr, "Cliente registrado con exito");
										}else
										{
											JOptionPane.showMessageDialog(cr, "La Clave debe ser de 4 digitos\n"+
											""+"y no debe empezar con cero.");
											contra.setText("");
										}
										}catch(Exception v1)
										{
										JOptionPane.showMessageDialog(cr, "En el campo balance ingrese solo numero");
										sald.setText("");
										}	
									}	
								}catch(Exception v)
								{
									JOptionPane.showMessageDialog(cr, "En el campo clave ingrese solo numero");
									contra.setText("");
								}
							}
						}
					});
					// estados del JDialog
					cr.setResizable(false);
					cr.setBounds(175,100,250,200);
					cr.setVisible(true);
				}
			}
		}		
		);
		Cliente.add(crearCliente);
		
		//se crea el JMenuIten Salir y el metodo que escucha y se añade a JMenu Cliente
		salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evv){
			System.exit(0);
		}});
		Cliente.add(salir);
		
		//se crea el JMenu See, se crea JMenuItem allCliente
		See = new JMenu("See");
		allClientes = new JMenuItem("Lista de Clientes");
		//escucha del JMenuItem allCliente
		allClientes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				obj = new Principal(fra);// se instancia un objeto de la clase Principal
				if(obj.Validar()==true)//se verifica si los datos dekl administrador son correctos
				{
					/* se crea un JDialog que mostrara una lista de los clientes
					 */
					cr = new JDialog(fra,"Lista de Cliente");
					cr.setModal(true);
					
					// el vector de string muestra los campos de la que apareceran en la tabla
					String vector[]={"Id","Nombre","Apellido","balance","Clave","Tipo de Cuenta"};
					Object matriz[][];//matriz de tipo Object
					Iterator it = cliente.iterator(); //se crea instancia de Iterator para recorrer la lista
					matriz= new Object [cliente.size()][6];
					int j=0;
					while (it.hasNext()) 
					{
		           	  Customer cust = (Customer)(it.next());  
		           	  //Aqui los datos estan siendo introducidos en la matriz que luego sera despeglada en el Jtable 
		              matriz[j][0]=j+"";
		              matriz[j][1]=cust.getFirstName();
		              matriz[j][2]=cust.getLastName();
		              matriz[j][3]=cust.getAccount().getBalance();
		              matriz[j][4]=cust.getIdCustomer(); 
		              matriz[j][5]=cust.getT_cuenta();        
		              j++;
		        	}
		        	//se crea una tabla que se le pasa matriz y vector
					JTable tabla = new JTable(matriz,vector);
					JScrollPane bar = new JScrollPane(tabla); //se instancia JScrollpane
					cr.getContentPane().add(bar,BorderLayout.CENTER); //se adiere el scrollpane al jdialog
					cr.setBounds(175,100,500,200);
					cr.setVisible(true);
				}
			}
		}
		);
		See.add(allClientes); //se adiere JMenuItem allCliente Jmenu See
		
		/*codigo Crea el JMenu Cerrarsec y el JMenuItem ce_se
		 ademas incluye la parte del escucha de ce_se*/
		CerrarSes = new JMenu("Cerrar Sesion");
		ce_se = new JMenuItem("Cerrar Sesion");
		ce_se.setEnabled(false);
		ce_se.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//desabiita los botones de balance,deposito y retiro
				balance.setEnabled(false);
				deposit.setEnabled(false);
				withdrawal.setEnabled(false);
				area.setText("Enter your customer ID into the key pad and press the ENTER button");
				message.setText("");
				car="";
				data.setText(car);
				data.setEnabled(true);
				ce_se.setEnabled(false);
				boton[12].setEnabled(true);
			}
		}
		);
		CerrarSes.add(ce_se);//se adiere JMenuItem cese Jmenu CerrarSes
		
		//agrega los JMenu a JMenuBar
		barraHe.add(Cliente);
		barraHe.add(See);
		barraHe.add(CerrarSes);
			
		fra.getContentPane().add(barraHe, BorderLayout.NORTH);//se agrega MenuBar al north
		
		/*se crea el panel que va a la izquierda*/
		P_Izquierdo = new JPanel(new BorderLayout());
		//panel que va al north pero en en panel izquierdo
		north = new JPanel(new GridLayout(3,1));
		/*se instancia los botones de balance, deposito, retirar, ademas se agregan 
		 al panel north*/
		balance = new JButton("Display account balance");
		balance.setEnabled(false);
		north.add(balance);
		deposit = new JButton("Make a deposit");
		deposit.setEnabled(false);
		north.add(deposit);
		withdrawal = new JButton("Make a withdrawal");
		withdrawal.setEnabled(false);
		//escucha botones de balance, deposito, retirar
		balance.addActionListener(this);
		deposit.addActionListener(this);
		withdrawal.addActionListener(this);
		
		north.add(withdrawal);
		P_Izquierdo.add(north, BorderLayout.NORTH);//se añade panel north a P_Izquierdo
		
		/*panel que va al sur pero en lado izquierdo*/
		Pincluye_sur = new JPanel();
		sur = new JPanel(new BorderLayout());		
		
		data = new JTextField(10);
		data.setHorizontalAlignment(JTextField.CENTER);
		sur.add(data, BorderLayout.NORTH);
		
				
		pad = new JPanel(new GridLayout(4,3));
		boton = new JButton[13];
		// se crean los botones y la escucha de los botones
		for (int i=1;i<=9;i++)
		{
			boton[i] = new JButton(""+i);
			boton[i].addActionListener(new ListenerBotones());
		}
		
		boton[10] = new JButton("0");
		boton[10].addActionListener(new ListenerBotones());
		boton[11] = new JButton("Clear");
		boton[11].addActionListener(new ListenerBotones());
		boton[12] = new JButton("Search");
		boton[12].addActionListener(new ListenerBotones());
		for (int i=1;i<=9;i++)
		{
			pad.add(boton[i]);
		}
		pad.add(boton[10]);	
		pad.add(boton[11]);
		pad.add(boton[12]);	
		sur.add(pad, BorderLayout.CENTER);
		Pincluye_sur.add(sur);
		P_Izquierdo.add(Pincluye_sur, BorderLayout.CENTER);		
		fra.getContentPane().add(P_Izquierdo, BorderLayout.WEST);
		//////////////////////////////////////
		P_Derecho = new JPanel(new BorderLayout());
		mensaje = new JLabel("B A N C O  D E  S A M U E L");
		mensaje.setBackground(new java.awt.Color(25,25,25));
		mensaje.setFont(new java.awt.Font("Georgia",1,20));
		mensaje.setForeground(new java.awt.Color(225,125,45));
		mensaje.setHorizontalAlignment(JLabel.CENTER);
		P_Derecho.add(mensaje , BorderLayout.NORTH);
		area = new JTextArea(70,75);
		area.setEditable(false);
		area.setBackground(new java.awt.Color(0,102,153));
		area.setFont(new java.awt.Font("Georgia",1,14));
		area.setForeground(new java.awt.Color(255,153,0));
		area.setText("Enter your customer ID into the key pad and press the ENTER button");
		JScrollPane scroll = new JScrollPane(area);
		P_Derecho.add(scroll, BorderLayout.CENTER);
		message = new JTextField(25);
		message.setEditable(false);
		P_Derecho.add(message, BorderLayout.SOUTH);
		fra.getContentPane().add(P_Derecho, BorderLayout.CENTER);
		
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.setResizable(false);
		fra.setBounds(175,100,750,300);
		fra.setVisible(true);	
	}
	
	/**
	 * Escucha los botones de balance, depositar y retirar.
	 */
	public void actionPerformed(ActionEvent ev)
	{
		double amount = 0;
		String source = ev.getActionCommand();
		if( ev.getSource() instanceof JButton )
		{
			if("Display account balance".equals(source))//presiona para ver el balance
			{
				if(BuscarCliente(pas)==true)
				area.setText(nom_apell+"\nDisplay account balance:  " + encontrado.getAccount().getBalance() );
			}
			else
			{
				if("Make a deposit".equals(source))//presiona para hacer deposito
				{
					if(car.equals(""))
					{
					message.setText("Please type numeric caracter into the Data Entry and Press deposit Button");
					}else
					{
					
						try
						{
							amount = Double.parseDouble(car);
							area.setText(nom_apell+"\nMake a deposit:  " + " " + encontrado.getAccount().deposit(amount));	
							message.setText("deposit Sussesful !");
		         			car = "";
		         			data.setText(car);
		         			Lista(encontrado.getAccount().getBalance());
						}
						catch(RuntimeException e1)
						{
							message.setText("Please type numeric caracter into the Data Entry and Press deposit Button");
							e1.printStackTrace();
						}
					}
				}
				else
				{
					if("Make a withdrawal".equals(source))//presiona para hacer retiro
					{
						if(car.equals(""))
						{
							message.setText("Please type numeric caracter into " +
					   	         "the Data Entry and Press Withdraw Button");
						}else
						{
							try
							{
								amount = Double.parseDouble(car);
								area.setText(nom_apell+"\nMake a withdrawal  " + amount);
	                			message.setText("withdraw Sussesful !");
	                			car = "";
		         				data.setText(car);
							}catch(RuntimeException e1)
							{
								message.setText("Please type numeric caracter into " +
					   	         "the Data Entry and Press Withdraw Button");
							}
							try
							{
								encontrado.getAccount().withdraw(amount);
								Lista(encontrado.getAccount().getBalance());
								System.out.println(encontrado.getAccount().getBalance()+"");
							}catch(OverdraftException e3)
							{
								message.setText("Deficit: " +e3.getDeficit() + " " + e3.getMessage() + 
		         				"Actual balance:  " + encontrado.getAccount().getBalance() );
							}
						}
					}					
				}
			}
		}
		else //escucha los JMenuItem
		{
			//if( ev.getSource() instanceof JMenuItem )
		}
	}
	
	/**
	 * Clase interna que escucha los botones de 0 hasta el 9, ademas escucha
	 * los botones de enter y clear.
	 */
	public class ListenerBotones implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			String or = ev.getActionCommand();
			if(or.equals("0")||or.equals("1")||or.equals("2")||or.equals("3")||or.equals("4")||or.equals("5")||or.equals("6")||or.equals("7")||or.equals("8")||or.equals("9"))
			{
				car = car + or;
				data.setText(car);
			}
			else
			{
				if(or.equals("Clear"))//cuando se presiona el boton clear.
				{
					car = "";
					data.setText(car);
					message.setText(car);
				}
				else
				{//cuando se presiona el boton Search
					String contraseña = data.getText();
					if(contraseña.equals(""))
					{
						message.setText("Es nesesario que proporcione una clave");
					}else
					{
						try
						{
							car = "";
							pas = Integer.parseInt(contraseña);
							if(BuscarCliente(pas)==true)
							{
								nom_apell ="\tWelcome "+ encontrado.getFirstName()+" "+  encontrado.getLastName();
								area.setText(nom_apell );				
								data.setText(car);
								balance.setEnabled(true);
								deposit.setEnabled(true);
								withdrawal.setEnabled(true);
								ce_se.setEnabled(true);
								message.setText("Su clave es Correcta, presione un boton para realizar una tranzaccion");
								boton[12].setEnabled(false);
							}
							else
							{
								data.setText(car);
								area.setText(area.getText()+"\n No found Customer");
				            	message.setText("Clave Incorrecta");
							}
						}catch(NumberFormatException err)
						{
							data.setText(car);
							area.setText("Enter your customer ID into the key pad and press the ENTER button");
				            message.setText("Clave Incorrecta");
						}
					}
				}
			}
		}
	}
	
	public static void main (String[] args) throws NullPointerException,EOFException
	{
		try
		{
		Thread obj1 = new BankATM("First BankATM 1 In Java");
		Thread obj2 = new BankATM("First BankATM 2 In Java");
		obj1.start();
		obj2.start();
		}catch(NullPointerException npe)
		{
			npe.getMessage();
		}
	}
	
	public void run()
	{
		
	}
	
	/**
	 *  Metodo que crea cliente pero primero recorre el archivo
	 */
	 public void addCliente(String n, String a, double b, int cl, String jrbselect) 
    {
    	Account acct = new Account(b);
		Customer cust = new Customer(n, a, jrbselect);
		cust.setAccount(acct);
		cust.setIdCustomer(cl);
		cliente.addLast(cust);
    }
    
    
    /**
     * Metodo que busca a un cliente a partir de una Clave. retorna true cuando lo encuantra
     * caso contrario false
     */
    public boolean BuscarCliente(int pas)
    {  
    	Customer cust;  	
    	boolean bol = false;
		Iterator<Customer> it = cliente.iterator();
		int k = cliente.size();
		int i=0;
		while (it.hasNext())
		{
			cust = (Customer)it.next();
			/*cuando encuentra al cliente se detiene, actualiza la variable cont
			  para usar como refernecia la posicion del cliente encontrado*/
			if( cust.getIdCustomer() == pas)
			{
				encontrado = cust;
				bol = true;
				//System.out.println("Hola");
				break;
			}
			i++;	
		}
		if(i == k )
		{
			bol = false;	
		}
    	return bol;
    }
    
    /**
     * Este metodo es utilizado para cuando se valla hacer deposito o retiro.
     * Como la lista ya esta actualizada solo la recorremos, actualizamos el balance 
     * agremos a otra lista y luego guardamos los nuevos datos
     */
    public void Lista(double amount)
    {
    	Customer cust;
		LinkedList<Customer> lista3 = new LinkedList<Customer>();
		Iterator<Customer> it = cliente.iterator();
		int j = 0;
        while(it.hasNext())
        {
        	Account acct;
        	Customer actualiza = (Customer)it.next();
        	if(actualiza.getIdCustomer() == pas)
        	{
        		acct = new Account(amount);
        		cust = new Customer(actualiza.getFirstName(), actualiza.getLastName(), actualiza.getT_cuenta());
        		cust.setIdCustomer(actualiza.getIdCustomer());
				cust.setAccount(acct);
        	}
        	else
        	{
        		acct = new Account(actualiza.getAccount().getBalance());
        		cust = new Customer(actualiza.getFirstName(), actualiza.getLastName(), actualiza.getT_cuenta());
        		cust.setIdCustomer(actualiza.getIdCustomer());
				cust.setAccount(acct);
        	}
        	lista3.add(cust);
        }
        cliente = lista3 ;
    }	
}//fin de la clae BankATM

