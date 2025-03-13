package view;

import events.*;
import java.awt.*;
import javax.swing.*;

public class ViewTransaction extends JPanel{
	
	private JTextArea tMuestraTransaccion;//Area donde se mostraran las transacciones
	private JButton bLimpiar;//botton para limpiar las transacciones que estene en tMuestraTransaccion
	
	//Panel principal y subpanel
	private JPanel pPrincipal;
	private JPanel pPanelSouth;
	
	//Para hacer una instancia del escucha de la clase
	private ViewTransactionListener  manejador;
	
	
	public ViewTransaction(){
		
		pPrincipal = new JPanel(new BorderLayout());
		
		addPantalla();
		addBoton();
				
		this.add(pPrincipal);
		
		 
		manejador = new ViewTransactionListener(tMuestraTransaccion);
		bLimpiar.addActionListener(manejador);
	}	


	private void addPantalla(){//adicionando tMuestraTransaccion
		
		tMuestraTransaccion = new JTextArea(6,75);
		pPrincipal.add(new JScrollPane(tMuestraTransaccion), BorderLayout.NORTH);
		
	}
	
	
	
	private void addBoton(){//adicionando bLimpiar
		
		pPanelSouth = new JPanel(new BorderLayout());
		
		bLimpiar=new JButton("Limpiar");
		
		pPanelSouth.add(bLimpiar, BorderLayout.EAST);
		
		pPrincipal.add(pPanelSouth, BorderLayout.SOUTH);
	}
	
	
	public void setText(String transaccion){
		
		manejador.setText(transaccion);
		
	}
	
}