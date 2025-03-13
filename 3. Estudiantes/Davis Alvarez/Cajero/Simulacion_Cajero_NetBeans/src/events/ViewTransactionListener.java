package events;

import view.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


/**
 * Esta clase maneja los eventos de los componentes de  la interfaz gráfica de ViewTransaction.
 */
public class ViewTransactionListener implements ActionListener{
	
	//Para hacer referencia  a tMuestraTransaccion creada en ViewTransaccion
	private JTextArea tMuestraTransaccion;
	
        
	/**El campo mensaje almacena la transacción realizada.*/
	public String mensaje;
        
	/**Crea un nuevo ViewTransactionListener.
         @param tMuestraTransaccion Área de texto donde se muestran las transacciones realizadas. */
	public ViewTransactionListener (JTextArea tMuestraTransaccion){
		
		this.tMuestraTransaccion=tMuestraTransaccion;
		mensaje="";
		
	}
	
        /**Método sobrescrito, que nos permite manejar el funcionamiento de la clase ViewTransaction.
        *@param e ActionListener a ser escuchado.
        */
	public void actionPerformed(ActionEvent e){
		
		//Si hemos precionado el boton limpiar 
		tMuestraTransaccion.setText("");
		mensaje="";
	}
	/**Método que pone el texto de las transacciones realizadas en el área de texto.
         @param transaccion Transación realizada.*/
	public void setText(String transaccion){
		
		//adicionando las transacciones realizadas
		mensaje+=transaccion+"\n";
		tMuestraTransaccion.setText(mensaje);
	}
}