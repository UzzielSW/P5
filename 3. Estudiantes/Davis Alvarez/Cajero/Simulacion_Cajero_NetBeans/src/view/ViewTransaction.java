package view;


import events.*;
import java.awt.*;
import javax.swing.*;

/**Clase que crea la interfaz gr�fica para poder ver las
 * transacciones que realizen los dos cajeros o el banco.*/
public class ViewTransaction extends JPanel{
	
	private JTextArea tMuestraTransaccion;//Area donde se mostraran las transacciones
	private JButton bLimpiar;//botton para limpiar las transacciones que estene en tMuestraTransaccion
	
	//Panel principal y subpanel
	private JPanel pPrincipal;
	private JPanel pPanelSouth;
	
	 /**El parametro manejador hara una instancia de la clase ViewTransactionListener.*/
	private ViewTransactionListener  manejador;
	
	/**Crea un ViewTransaction.*/
	public ViewTransaction(){
		
		pPrincipal = new JPanel(new BorderLayout());
		
		addPantalla();
		addBoton();
				
		this.add(pPrincipal);
		
		 
		manejador = new ViewTransactionListener(tMuestraTransaccion);
		bLimpiar.addActionListener(manejador);
	}	

       /**M�todo que adiciona el �rea de texto donde apareceran las transaciones hechas.*/
	public void addPantalla(){//adicionando tMuestraTransaccion
		
		tMuestraTransaccion = new JTextArea(6,75);
		pPrincipal.add(new JScrollPane(tMuestraTransaccion), BorderLayout.NORTH);
		
	}
	
	
	/**M�todo que adicion el boton para limpiar el �rea de texto donde
         aparecen las transacciones.*/
	public void addBoton(){//adicionando bLimpiar
		
		pPanelSouth = new JPanel(new BorderLayout());
		
		bLimpiar=new JButton("Limpiar");
		
		pPanelSouth.add(bLimpiar, BorderLayout.EAST);
		
		pPrincipal.add(pPanelSouth, BorderLayout.SOUTH);
	}
	
	/**M�todo que pone el texto de las transacciones realizadas en el area de texto.
         @param transaccion Mensaje de la transaccion realizada.*/
	public void setText(String transaccion){
		
		manejador.setText(transaccion);
		
	}
	
}