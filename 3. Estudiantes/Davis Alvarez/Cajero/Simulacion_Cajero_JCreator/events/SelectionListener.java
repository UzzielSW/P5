//Clase que nos permite utilizar el banco o el control de los dos cajeros y el banco

package events;


import view.*;
import java.awt.event.*;
import javax.swing.*;

public  class SelectionListener implements ActionListener{
	
	Bank banco; 
	ControlAll control;
		
	private JButton bvisitBank;
	private JButton buseBothCashier;
	
	
	
	public 	SelectionListener(Bank banco, ControlAll control,JButton bvisitBank,JButton buseBothCashier ){
		
		this.banco = banco;
		this.control = control;
		this.bvisitBank =bvisitBank;
		this.buseBothCashier=buseBothCashier;
		
	}
	public void actionPerformed(ActionEvent e){
		
			if(e.getSource()==bvisitBank){
				
				banco.setVisible(true);
			}
			
			else if(e.getSource()==buseBothCashier){
				
				control.setVisible(true);
			}
		}
	}