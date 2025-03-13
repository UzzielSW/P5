package view;

import events.*;
import java.awt.event.*;
import javax.swing.*;


/**Clase encargada de crear la interfaz gráfica para poder seleccionar y utilizar al banco 
 * o controlar a los dos cajeros y el banco por medio de ControlAll. */
public class Selection extends JPanel{
	
	
	private JButton bVisitBank;
	private JButton bUseBothCashier;
	
	/**El parametro bank hara referencia al objeto Bank creado en la clase SimulacionCajero.*/
	public Bank bank; 
        /**El parametro control hara referencia al objeto ControlAll creado en la clase SimulacionCajero.*/
	public ControlAll control;
        /**El parametro manejador hara una instancia de la clase SelectionListener.*/
	public SelectionListener manejador;
        
        /**Crea un nuevo Selection haciendo referencia a los objetos a seleccioar bank y control.
         @param bank Objeto Bank.
         @param control Objeto ControlAll.*/
	public Selection(Bank bank, ControlAll control){
		

		this.bank=bank;
		this.control =control;
		
		addButons();
		
		//Creando escucha de la clase
		manejador = new SelectionListener(bank,control,bVisitBank,bUseBothCashier);
		bVisitBank.addActionListener(manejador);
		bUseBothCashier.addActionListener(manejador);
		
	}
	
	/**Método que adiciona los botones de Selection.*/
	public void addButons(){
		
	
		bUseBothCashier = new JButton("Usar Ambos Cajero");	
		bVisitBank = new JButton("Visitar Banco");
		
		this.add(bUseBothCashier);
		this.add(bVisitBank);
	
		
	}
	
	
	
}