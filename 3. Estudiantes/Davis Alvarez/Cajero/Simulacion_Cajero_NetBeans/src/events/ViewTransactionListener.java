package events;

import view.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 * Esta clase maneja los eventos de los componentes de  la interfaz gr�fica de ViewTransaction.
 */
public class ViewTransactionListener implements ActionListener{
	
	//Para hacer referencia  a tMuestraTransaccion creada en ViewTransaccion
	private JTextArea tMuestraTransaccion;
	
        
	/**El campo mensaje almacena la transacci�n realizada.*/
	public String mensaje;
        
	/**Crea un nuevo ViewTransactionListener.
         @param tMuestraTransaccion �rea de texto donde se muestran las transacciones realizadas. */
	public ViewTransactionListener (JTextArea tMuestraTransaccion){
		
		this.tMuestraTransaccion=tMuestraTransaccion;
		mensaje="";
		
	}
	
        /**M�todo sobrescrito, que nos permite manejar el funcionamiento de la clase ViewTransaction.
        *@param e ActionListener a ser escuchado.
        */
	public void actionPerformed(ActionEvent e){
		
		//Si hemos precionado el boton limpiar 
		tMuestraTransaccion.setText("");
		mensaje="";
	}
	/**M�todo que pone el texto de las transacciones realizadas en el �rea de texto.
         @param transaccion Transaci�n realizada.*/
	public void setText(String transaccion){
		
		//adicionando las transacciones realizadas
		mensaje+=transaccion+"\n";
		tMuestraTransaccion.setText(mensaje);
	}
}