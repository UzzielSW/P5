package events;


import view.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Esta clase es la encargada de manejar los eventos de los componentes de  la interfaz gráfica de Selection.
 */
public  class SelectionListener implements ActionListener{
	
	/**El campo bank hace referencia al objeto Bank creado en la clase Simulacioncajero.*/
        public  Bank bank; 
        /**El campo control hace referencia al objeto ControlAll creado en la clase Simulacioncajero.*/
	public ControlAll control;
        
	private JButton bvisitBank;
	private JButton buseBothCashier;
	
	
	/**Crea un nuevo SelectionListener
         @param bank Objeto Bank creado en la clase SimulacionCajero.
         @param control Objeto ControlAll creado en la  clase SimulacionCajero.
         @param bvisitBank Botón que permite utilizar el banco.
         @param buseBothCashier Boton que permite utilizar el control.
         */
	public 	SelectionListener(Bank bank, ControlAll control,JButton bvisitBank,JButton buseBothCashier ){
		
		this.bank = bank;
		this.control = control;
		this.bvisitBank =bvisitBank;
		this.buseBothCashier=buseBothCashier;
		
	}
        /**Método sobrescrito, que nos permite manejar el funcionamiento de la clase Selection.
        *@param e ActionListener a ser escuchado.
        */
	public void actionPerformed(ActionEvent e){
		
			if(e.getSource()==bvisitBank){
				
				bank.setVisible(true);
			}
			
			else if(e.getSource()==buseBothCashier){
				
				control.setVisible(true);
			}
		}
	}