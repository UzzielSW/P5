package events;

import view.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class ViewTransactionListener implements ActionListener{
	
	//Para hacer referencia  a tMuestraTransaccion creada en ViewTransaccion
	private JTextArea tMuestraTransaccion;
	
	//Mensaje de la transaacción realizada
	private String mensaje;
	
	
	public ViewTransactionListener (JTextArea tMuestraTransaccion){
		
		this.tMuestraTransaccion=tMuestraTransaccion;
		mensaje="";
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		//Si hemos precionado el boton limpiar 
		tMuestraTransaccion.setText("");
		mensaje="";
	}
	
	public void setText(String transaccion){
		
		//adicionando las transacciones realizadas
		mensaje+=transaccion+"\n";
		tMuestraTransaccion.setText(mensaje);
	}
}