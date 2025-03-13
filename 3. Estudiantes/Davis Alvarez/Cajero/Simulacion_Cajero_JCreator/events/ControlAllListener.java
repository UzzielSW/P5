package events;

import messages.*;
import view.*;
import runnables.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
public class ControlAllListener implements ActionListener,Messages{
		
		
		//Para hacer referencia a los objetos Cashier y Bannk creados
		private Bank bank;
		private Cashier cajero1;
		private Cashier cajero2;
		
		//Hilos para hacer el deposito y los retiros
		private DepositoRunnable tDepositoRunnable;
		private RetiroRunnable tRetiroRunnable1;
		private RetiroRunnable tRetiroRunnable2;
		
		//Hilo de la pantalla del cajero
		private PantallaRunnable tPantallaRunnable;
		
		//Para hacer referencia a  estos objetos creados en ControlAll
		private JTextField tCuenta;
		private JTextField tRetiro;
		private JTextField tDeposito;
	
		private String ncuenta;
		private String retiro;
		private String deposito;
		
		
		
		public ControlAllListener(Cashier cajero1, Cashier cajero2, Bank bank,
		JTextField tCuenta,JTextField tRetiro,JTextField tDeposito){
			
			this.cajero1= cajero1;
			this.cajero2 = cajero2;
			this.bank = bank;
			
			this.tCuenta=tCuenta;
			this.tRetiro=tRetiro;
			this.tDeposito=tDeposito;
			
		}
	
		public void actionPerformed(ActionEvent e){
				
				 ncuenta = tCuenta.getText();
				 retiro = tRetiro.getText();
				 deposito = tDeposito.getText();
			
				//Validando entrada de datos
				if(ncuenta.length()==0||retiro.length()==0||deposito.length()==0){
						
						mensajeDeError(EMPTY_TEXTFIELD);
				
				}
					
				else if(!ncuenta.matches(("([1-9]\\d{3})"))){
						
						
						mensajeDeError(INCORRECT_ACCOUNT);
									
				}
				
				else if(!retiro.matches(("([0-9]+[.][0-9]+)"))){
					
					mensajeDeError(INCORRECT_WITHDRAW);
					
				}
				
				else if(!deposito.matches(("([0-9]+[.][0-9]+)"))){
					
					mensajeDeError(INCORRECT_DEPOSIT );
					
				}
				
				
				else{
					
				
					if(bank.encuentraCliente(Integer.parseInt(ncuenta))){//Si se encuentra el clinete
						
						tRetiroRunnable1 = new RetiroRunnable(cajero1.getImage(),bank,bank.getIndiceCliente(),Double.parseDouble(retiro),"Cajero1",
						cajero1.getPantallaRunnable(),1);
						tRetiroRunnable2 = new RetiroRunnable(cajero2.getImage(),bank,bank.getIndiceCliente(),Double.parseDouble(retiro),"Cajero2",
						cajero2.getPantallaRunnable(),1);
						tDepositoRunnable = new DepositoRunnable(bank,bank.getIndiceCliente(),Double.parseDouble(deposito));
						
						
						tDepositoRunnable.setPriority(Thread.MIN_PRIORITY);//Variando las prioridades de los hilos
						tRetiroRunnable1.setPriority(Thread.MAX_PRIORITY);
						tRetiroRunnable2.setPriority(Thread.MIN_PRIORITY);
						
						tDepositoRunnable.start();
						tRetiroRunnable1.start(); 
						tRetiroRunnable2.start(); 
						
					}
					
					else {//no econtramos el cliente
						
						mensajeDeError(NOT_REGISTERED );	
						
					}
					
				}
		
		}
			
	public void mensajeDeError(String mensaje){
				
			JOptionPane.showMessageDialog(null,mensaje,"Error",
			JOptionPane.INFORMATION_MESSAGE);
				
	}
	
	

}