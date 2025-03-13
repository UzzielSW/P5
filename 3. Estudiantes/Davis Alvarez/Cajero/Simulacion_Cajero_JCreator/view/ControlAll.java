//Clase de la interfaz grafica para poder utilizar a la vez tanto los cajeros como el banco
package view;

import events.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlAll extends JFrame{
	
	//Para hacer rerferncia a los objetos Cashier y Bannk creados
	private Cashier cajero1;
	private Cashier cajero2;
	private Bank bank;
	
	//Componentes del JFrame
	private JLabel lCuenta;
	private JLabel lRetiro;
	private JLabel lDeposito;
	
	private JTextField tCuenta;
	private JTextField tRetiro;
	private JTextField tDeposito;
	
	private JButton bAceptar;
	
	private JPanel pComponents;
	private JPanel pWest;
	private JPanel pEast;
	private JPanel pCenter;
	private JPanel pSouth;
	
	private ControlAllListener manejador;
	
	public ControlAll(Cashier cajero1,Cashier cajero2, Bank bank){
		
		super("Control De Los Dos Cajeros y el Banco");
		
		this.cajero1=cajero1;
		this.cajero2=cajero2;
		this.bank = bank;
		
		addComponents();
		
		//Escucucha de la clase
		manejador = new ControlAllListener(cajero1,cajero2,bank,tCuenta,tRetiro,tDeposito);	
		bAceptar.addActionListener(manejador); 
		
		this.setResizable(false);
		this.pack();
	}
	
	public void addComponents(){//Adicionando componentes 
		
		pComponents = new JPanel(new BorderLayout());
		pWest = new JPanel();
		pEast = new JPanel();
		pCenter= new JPanel();
		pSouth= new JPanel();
		
		
		lCuenta = new JLabel("Numero de Cuenta");
		lRetiro = new JLabel("Retiro");
		lDeposito=new JLabel("Deposito");
		tCuenta = new JTextField(4);
		tRetiro = new JTextField(15);
		tDeposito = new JTextField(15);
		bAceptar = new JButton("Aceptar");
		
		pWest.add(lCuenta);
		pWest.add(tCuenta);
		
		pEast.add(lRetiro);
		pEast.add(tRetiro);
		
		pCenter.add(lDeposito);
		pCenter.add(tDeposito);
		
		pSouth.add(bAceptar);
		
		pComponents.add(pWest,BorderLayout.WEST);
		pComponents.add(pEast,BorderLayout.EAST);
		pComponents.add(pCenter,BorderLayout.CENTER);
		pComponents.add(pSouth,BorderLayout.SOUTH);
		
		this.getContentPane().add(pComponents);
		
	}
	

	
	
}