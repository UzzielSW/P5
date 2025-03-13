package view;

import events.*;
import java.awt.event.*;
import javax.swing.*;



public class Selection extends JPanel{
	
	
	private JButton bVisitBank;
	private JButton bUseBothCashier;
	
	
	private Bank banco; 
	private ControlAll control;
	private SelectionListener manejador;
	public Selection(Bank banco, ControlAll control){
		

		this.banco=banco;
		this.control =control;
		
		addButons();
		
		//Creando escucha de la clase
		manejador = new SelectionListener(banco,control,bVisitBank,bUseBothCashier);
		bVisitBank.addActionListener(manejador);
		bUseBothCashier.addActionListener(manejador);
		
	}
	
	
	private void addButons(){
		
	
		bUseBothCashier = new JButton("Usar Ambos Cajero");	
		bVisitBank = new JButton("Visitar Banco");
		
		this.add(bUseBothCashier);
		this.add(bVisitBank);
	
		
	}
	
	
	
}