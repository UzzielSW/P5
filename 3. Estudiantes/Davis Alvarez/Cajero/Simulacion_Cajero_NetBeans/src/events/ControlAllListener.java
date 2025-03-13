package events;

import messages.*;
import view.*;
import runnables.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
/**
 * Esta clase es la encargada de manejar los eventos de los componentes de  la interfaz gráfica para controlar a losobjetos Cashier y Bank
 * de  la  clase ControlAl
 */
public class ControlAllListener implements ActionListener,Messages{
		
		
		/**El campo bank hace referencia al banco creado en la clase SimulacionCajero.*/
		public Bank bank;
                /**El campo cajero1 hace referencia al primer cajero creado en la clase SimulacionCajero*/
		public Cashier cajero1;
		/**El campo cajero1 hace referencia al segundo cajero creado en la clase SimulacionCajero*/
                public Cashier cajero2;
		
		/**El campo tRetiroRunnable1 permite al banco  hacer un deposito.*/
		public DepositoRunnable tDepositoRunnable;
                /**El campo tRetiroRunnable1 permite al primer cajero hacer un retiro.*/
		public RetiroRunnable tRetiroRunnable1;
                /**El campo tRetiroRunnable2 permite al segundo hacer un retiro.*/
                public RetiroRunnable tRetiroRunnable2;
                /**El campo tPantallaRunnable cambia el estado de la pantalla del cajero. */
		public PantallaRunnable tPantallaRunnable;
                
                /**El campo ncuenta almacena la entrada del número de la cuenta de un cliente. */        
		public String ncuenta;
                /**El campo retiro almacena la entrada del retiro hacer por un cliente.*/
		public String retiro;
                /**El campo deposito almacena la entrada del deposito hacer por un cliente.*/
		public String deposito;
                
                //Para hacer referencia a  estos objetos creados en ControlAll
		private JTextField tCuenta;
		private JTextField tRetiro;
		private JTextField tDeposito;
		
		
		/**Crea un nuevo ControlAllListener.
                 @param cajero1 Primer cajero creado.
                 @param cajero2 Segundo cajero creado.
                 @param bank Banco creado.
                 @param tCuenta Campo de entrada del número de la cuenta de un cliente. 
                 @param tRetiro Campo de entrada para un retiro.
                 @param tDeposito Campo de entrada para un deposito.*/
                
		public ControlAllListener(Cashier cajero1, Cashier cajero2, Bank bank,
		JTextField tCuenta,JTextField tRetiro,JTextField tDeposito){
			
			this.cajero1= cajero1;
			this.cajero2 = cajero2;
			this.bank = bank;
			
			this.tCuenta=tCuenta;
			this.tRetiro=tRetiro;
			this.tDeposito=tDeposito;
			
		}
	
                /**Método sobrescrito, que nos permite manejar el funcionamiento de la clase ControlAll.
                *@param e ActionListener a ser escuchado.
                */
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
		
        /**Método que muestra los mensajes de error más comunes que se puedan dar 
           al tratar de hacer alguna operación en en ControlAll.
           @param mensaje Mensaje de error.*/
	public void mensajeDeError(String mensaje){
				
			JOptionPane.showMessageDialog(null,mensaje,"Error",
			JOptionPane.INFORMATION_MESSAGE);
				
	}
	
	

}