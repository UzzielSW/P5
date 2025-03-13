//Clase que nos permite implementar la interfas del banco

package view;
import infocustomer.*;
import runnables.*;
import events.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Bank extends JFrame{
	
	
	//componentes principanles del JFrame
	private  JTabbedPane jTabs;
	private JPanel panel1;
	private JPanel panel2;
	
	//componentes del panel 1
	private JTextField tNombrePanel1 ;
	private JTextField tIdPanel1 ;
	private JTextField tDireccionPanel1;
	private JTextField tDepositoPanel1 ;
	private	JTextArea tSalidaPanel1;
	private JButton bAceptarPanel1;
	private JLabel lNombrePanel1 ;
	private JLabel lIdPanel1; 
	private JLabel lDireccionPanel1;
	private JLabel lDepositoPanel1 ;
	
	//Paneles principanles del panel 1
	private JPanel pNortePanel1;
	private JPanel pCentroPanel1;
	private JPanel pSurPanel1;
	
	//Subpaneles del panel del norte dentro del panel 1
	private JPanel pNorteIntoNortePanel1;
	private JPanel pEsteIntoNorteIntoNortePanel1 ;
	private JPanel pOesteIntoNorteIntoNortePanel1 ;
		
	//Subpaneles del panel del centro dentro del panel 1
	private JPanel pCentroIntoCentroPanel1;
	private JPanel pEsteIntoCentroIntoCentroPanel1;
	private JPanel pOesteIntoCentroIntoCentroPanel1;
	
	//Subpaneles del panel del sur dentro del panle 1	
	private JPanel pOesteIntoSurPanel1 = new JPanel();
	private JPanel pEsteIntoSurPanel1 = new JPanel();
	
		
	//componentes del panel2
	private JLabel lNombrePanel2;
	private JLabel lIdPanel2;
	private JLabel lDireccionPanel2;
	private JLabel lCuentaPanel2;
	private JLabel lDepositoPanel2;
	private JLabel lRetiroPanel2;
	private JLabel lBalancePanel2;	
	private JTextField tCuentaPanel2;	
	private JTextField tNombrePanel2;
	private JTextField tIdPanel2 ;
	private JTextField tDireccionPanel2;
	private JTextField tDepositoPanel2; 
	private JTextField tRetiroPanel2;
	private JTextField tBalancePanel2;
	private ButtonGroup rGrupoPanel2;
	private JRadioButton rDepositoPanel2 ;
	private	JRadioButton rRetiroPanel2 ;
	private JButton bEncuentraPanel2;
	private JButton bAceptarPanel2;
	
	
	//paneles  principales del panel 2
	private JPanel pNortePanel2;
	private JPanel pCentroPanel2;
	private JPanel pSurPanel2 ;
	
	//subpanel del panel del norte dentro del panel 2 	
	private JPanel pOesteIntoNortePanel2;
	
	
	//subpaneles del panel del centro dentro del panel 2	
	private JPanel pNorteIntoCentroPanel2;
	private JPanel pEsteIntoNorteIntoCentroPanel2;
	private JPanel pOesteIntoNorteIntoCentroPanel2;
	private JPanel pCentroIntoCentroPanel2;
	private JPanel pOesteIntoCentroIntoCentroPanel2;
	private JPanel pEsteIntoCentroIntoCentroPanel2;
	
	
	//subpaneles del panel del sur dentro del panel 2	
	private JPanel pNorteIntoSurPanel2;
	private JPanel pOesteIntoNorteIntoSurPanel2;
	private JPanel pCentroIntoSurPanel2;
	private JPanel pOesteIntoCentroIntoSurPanel2;
	private JPanel pEsteIntoCentroIntoSurPanel2;
	
	
	
	
	private Customer customers[];
	private Account accounts[];
	private ViewTransaction transaccion;
	private BankListener manejador ;
	
	
	public Bank(ViewTransaction transaccion) {
	
		
		super("Banco");	
	
		this.transaccion=transaccion;
		//crear objetos JTabbedPane
		jTabs = new JTabbedPane();
		
		//adicionando elementos a los paneles principales
		addPanel1();
		addPanel2();
		
		//Crear un arreglo de 10 objetos customers
		customers = new Customer[10];
		//Crear un arreglo de 10 objetos accounts
		accounts = new Account[10];
		
		
		//Escucha de la clase
		manejador = new BankListener (tNombrePanel1,tIdPanel1,tDireccionPanel1,tDepositoPanel1,
		tSalidaPanel1, bAceptarPanel1,tCuentaPanel2,bEncuentraPanel2,tNombrePanel2,
		tIdPanel2,tDireccionPanel2,tDepositoPanel2,tRetiroPanel2,
		tBalancePanel2, rDepositoPanel2,rRetiroPanel2 ,bAceptarPanel2,customers,accounts,transaccion);
		
	
		bAceptarPanel1.addActionListener(manejador);
		bEncuentraPanel2.addActionListener(manejador);
		rDepositoPanel2.addActionListener(manejador);
		rRetiroPanel2.addActionListener(manejador);
		bAceptarPanel2.addActionListener(manejador);
		
		this.getContentPane().add(jTabs);
		this.pack();
		this.setResizable(false);
	
		
		
	
	}
	
	
	public void addPanel1(){
		
		
		//Establecer panel1 y agregarlo a tabs 
	
		panel1 = new JPanel(new BorderLayout());
		jTabs.addTab("Agregar Cliente",null,panel1,"Nuevo Cliente");
		
		
		lNombrePanel1 = new JLabel("Nombre");
		lIdPanel1 = new JLabel("Cédula");
		lDireccionPanel1= new JLabel("Dirección");
		lDepositoPanel1 = new JLabel("Deposito Inicial");
		
		//Campos de entrada de datos
		tNombrePanel1 = new JTextField(15);
		tIdPanel1 = new JTextField(15);
		tDireccionPanel1= new JTextField(15);
		tDepositoPanel1 = new JTextField(15);
		
		
		//Salida de aceptacion
		tSalidaPanel1 = new JTextArea(10,20);
		
		//Aceptar un cliente
		bAceptarPanel1 = new JButton("Aceptar"); 
		
		
		
		
		//Componentes del panel del norte dentro del panell1
		pNortePanel1 = new JPanel(new BorderLayout());
		
		pNorteIntoNortePanel1= new JPanel(new BorderLayout());
		pEsteIntoNorteIntoNortePanel1 = new JPanel(new FlowLayout());
		pOesteIntoNorteIntoNortePanel1 = new JPanel(new FlowLayout());
		
		
		pOesteIntoNorteIntoNortePanel1.add(lNombrePanel1);
		pOesteIntoNorteIntoNortePanel1.add(tNombrePanel1);	
		pEsteIntoNorteIntoNortePanel1.add(lIdPanel1);
		pEsteIntoNorteIntoNortePanel1.add(tIdPanel1);
		
		
		pNorteIntoNortePanel1.add(pOesteIntoNorteIntoNortePanel1,BorderLayout.WEST);
		pNorteIntoNortePanel1.add(pEsteIntoNorteIntoNortePanel1,BorderLayout.EAST);
		
		pNortePanel1.add(pNorteIntoNortePanel1);
		
		
		//Componentes del panel del centro dentro del panell1
		pCentroPanel1 = new JPanel(new BorderLayout());
		
		pCentroIntoCentroPanel1= new JPanel(new BorderLayout());
		pEsteIntoCentroIntoCentroPanel1 = new JPanel(new FlowLayout());
		pOesteIntoCentroIntoCentroPanel1 = new JPanel(new FlowLayout());
		
		
		pOesteIntoCentroIntoCentroPanel1.add(lDireccionPanel1);
		pOesteIntoCentroIntoCentroPanel1.add(tDireccionPanel1);	
		pEsteIntoCentroIntoCentroPanel1.add(lDepositoPanel1);
		pEsteIntoCentroIntoCentroPanel1.add(tDepositoPanel1);
		
		
		pCentroIntoCentroPanel1.add(pOesteIntoCentroIntoCentroPanel1,BorderLayout.WEST);
		pCentroIntoCentroPanel1.add(pEsteIntoCentroIntoCentroPanel1,BorderLayout.EAST);
		
		pCentroPanel1.add(pCentroIntoCentroPanel1);
		
	    
	    
	    //Componentes del panel del sur dentro del panell1
		pSurPanel1 = new JPanel(new BorderLayout());
		
		pOesteIntoSurPanel1 = new JPanel();
		pEsteIntoSurPanel1 = new JPanel();
		
		pOesteIntoSurPanel1.add(tSalidaPanel1);
		pEsteIntoSurPanel1.add(bAceptarPanel1);
		
		pSurPanel1.add(pOesteIntoSurPanel1,BorderLayout.WEST);
		pSurPanel1.add(pEsteIntoSurPanel1,BorderLayout.EAST);
		
		
		//adicionando componetes al panel1
		panel1.add(pNortePanel1,BorderLayout.NORTH);
	    panel1.add(pCentroPanel1,BorderLayout.CENTER);
	    panel1.add(pSurPanel1, BorderLayout.SOUTH);
		
	}
	
	public void addPanel2(){//Adiciona los componentes del panel2
		
		lNombrePanel2 = new JLabel("Nombre");
		lIdPanel2 = new JLabel("Cédula");
		lDireccionPanel2= new JLabel("Dirección");
		lCuentaPanel2 = new JLabel("Ingrese Numero de Cuenta");
		lDepositoPanel2 = new JLabel("Deposito");
		lRetiroPanel2 = new JLabel("Retiro");
		lBalancePanel2 = new JLabel("Balance");
		
		
		//Grupo de radioButtons
		rGrupoPanel2 = new ButtonGroup();
		rDepositoPanel2 = new JRadioButton("Deposito");
		rRetiroPanel2 = new JRadioButton("Retiro");
		rGrupoPanel2.add(rDepositoPanel2);
		rGrupoPanel2.add(rRetiroPanel2);
		
		
		//Establecer panel2 y agregarlo a tabs 
		panel2 = new JPanel(new BorderLayout());
		jTabs.addTab("Hacer Transacción",null,panel2,"Realizar Transacción");
		
		tCuentaPanel2 = new JTextField(4);
		
		//Campos de entrada de datos
		tNombrePanel2 = new JTextField(15);
		tIdPanel2= new JTextField(15);
		tDireccionPanel2= new JTextField(15);
		tDepositoPanel2 = new JTextField(15);
		tRetiroPanel2 =new JTextField(10);
		tBalancePanel2 = new JTextField(15);
		
		
	
		//Para buzcar un cliente	
		bEncuentraPanel2 = new JButton("Buscar");
		
		//Para realizar una transaccion
		bAceptarPanel2 = new JButton("Aceptar");
		
		//Componentes del panel del norte dentro del panell2
		pNortePanel2 = new JPanel(new BorderLayout());
		
		pOesteIntoNortePanel2 = new JPanel();
		
		pOesteIntoNortePanel2.add(lCuentaPanel2);
		pOesteIntoNortePanel2.add(tCuentaPanel2);
		pOesteIntoNortePanel2.add(bEncuentraPanel2);
		
		pNortePanel2.add(pOesteIntoNortePanel2,BorderLayout.WEST);
		panel2.add(pNortePanel2,BorderLayout.NORTH);
		
	
		//Componentes del panel del centro dentro del panel2
		
		pCentroPanel2 = new JPanel(new BorderLayout());
		
		pNorteIntoCentroPanel2= new JPanel(new BorderLayout());
		pEsteIntoNorteIntoCentroPanel2 = new JPanel();
		pOesteIntoNorteIntoCentroPanel2 = new JPanel();
		
		
		pOesteIntoNorteIntoCentroPanel2.add(lNombrePanel2);
		pOesteIntoNorteIntoCentroPanel2.add(tNombrePanel2);	
		pEsteIntoNorteIntoCentroPanel2.add(lIdPanel2);
		pEsteIntoNorteIntoCentroPanel2.add(tIdPanel2);
		
		
		pNorteIntoCentroPanel2.add(pOesteIntoNorteIntoCentroPanel2,BorderLayout.WEST);
		pNorteIntoCentroPanel2.add(pEsteIntoNorteIntoCentroPanel2,BorderLayout.EAST);
		pCentroPanel2.add(pNorteIntoCentroPanel2,BorderLayout.NORTH);
		
		
	
		pCentroIntoCentroPanel2= new JPanel(new BorderLayout());
		pOesteIntoCentroIntoCentroPanel2 = new JPanel();
		pEsteIntoCentroIntoCentroPanel2 = new JPanel();
	
		pOesteIntoCentroIntoCentroPanel2.add(lDireccionPanel2);
		pOesteIntoCentroIntoCentroPanel2.add(tDireccionPanel2);	
		
		pEsteIntoCentroIntoCentroPanel2.add(lBalancePanel2);
		pEsteIntoCentroIntoCentroPanel2.add(tBalancePanel2);
		
		pCentroIntoCentroPanel2.add(pOesteIntoCentroIntoCentroPanel2,BorderLayout.WEST);
		pCentroIntoCentroPanel2.add(pEsteIntoCentroIntoCentroPanel2,BorderLayout.EAST);
	
	
		pCentroPanel2.add(pCentroIntoCentroPanel2,BorderLayout.CENTER);
		panel2.add(pCentroPanel2,BorderLayout.CENTER);
		
		
		
		//Componentes del panel del sur dentro del panel2
		
		pSurPanel2 = new JPanel();
		
		pNorteIntoSurPanel2 = new JPanel(new BorderLayout());
		pOesteIntoNorteIntoSurPanel2 = new JPanel();
		
		pOesteIntoNorteIntoSurPanel2.add(rDepositoPanel2);
		pOesteIntoNorteIntoSurPanel2.add(rRetiroPanel2);
		
		pNorteIntoSurPanel2.add(pOesteIntoNorteIntoSurPanel2, BorderLayout.WEST); 
		
		pSurPanel2.add(pNorteIntoSurPanel2, BorderLayout.NORTH);
		
		
		
		pCentroIntoSurPanel2 = new JPanel(new BorderLayout());
		
		pOesteIntoCentroIntoSurPanel2 = new JPanel();
		pEsteIntoCentroIntoSurPanel2 = new JPanel();
		
		pOesteIntoCentroIntoSurPanel2.add(lDepositoPanel2);
		pOesteIntoCentroIntoSurPanel2.add(tDepositoPanel2);
		
		pEsteIntoCentroIntoSurPanel2.add(lRetiroPanel2);
		pEsteIntoCentroIntoSurPanel2.add(tRetiroPanel2);
		pEsteIntoCentroIntoSurPanel2.add(bAceptarPanel2);
		
		pCentroIntoSurPanel2.add(pOesteIntoCentroIntoSurPanel2,BorderLayout.WEST);
		pCentroIntoSurPanel2.add(pEsteIntoCentroIntoSurPanel2,BorderLayout.EAST);
		
		pSurPanel2.add(pCentroIntoSurPanel2, BorderLayout.CENTER);
		
		panel2.add(pSurPanel2, BorderLayout.SOUTH);

	}
	
	
	//Retorn auna cuenta de un cliente
	public Account getAccounts(int i){
	
			return accounts[i];
	}
	
	
	//retorna la cantidad de cuentas que tengamos 
	public int getNumberOfAccounts(){
		
			return manejador.getNumberOfAccounts();
	}
	
	public boolean encuentraCliente(int clave){
		
		 return (manejador.encuentraCliente(clave));
	}
	
	public int getIndiceCliente(){
		
		return (manejador.getIndiceCliente());
	}

}
	
	
