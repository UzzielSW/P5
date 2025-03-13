import javax.swing.*;
import java.awt.*;

/** 
 * La Clase Llave crea las llaves que van a ser manipuladas para permitir el acceso del agua
 * a los tanques.	
*   @author  Bianca Gonzalez (8-789-1920) 
*	@version 1.01
*/

public class Llaves
   {
	/**El boolean estado representa si la llave esta abierta en true y si esta cerrada en false*/
	public boolean estado;//true abierto, false cerrado
	/**El JButton imagen posee la apariencia fisica de la llave*/
	public JButton imagen;	
	
	/**El constructor de Llaves recibe de una imagen q es la apariencia que debe tener la llave.
	 *Esta imagen se coloca dentro del boton para ser enviada como un elemento acoplado a un componente
	 *@param Imagen como icono*/
	public Llaves(ImageIcon a)
	{
	imagen=new JButton(a);	
	estado = false;//llave inicia cerrada
	}
	
	/**returna si la puerta es abierta true, y si esta cerrada false
	 *@return estado de la puerta*/
	public boolean getEstado()
	{
		return estado;
	}
	
	
	/**Returna el boton que contiene la imagen de la llave.
	 *@return JButton apariencia de la llave*/
	public JButton getApariencia()
	{
	 this.imagen.setBounds(0,0,20,20);	
	 return this.imagen;	
    }
	
	/**Funcion que se encarga de abrir la llave*/
	public void abre()
	{
	if(estado){
		
		       JOptionPane.showMessageDialog(null,"Llave abierta");
		      }
	 else{		 
	 	  estado = true;
	 	  imagen.setBackground(Color.blue);
	 	 JOptionPane.showMessageDialog(null,"Llave abierta");
	     }
		
	
	}	
	/**Funcion que se encarga de cerrar la llave*/
	public void cierra()
	{
		if(estado)
		{
			estado = false;
			imagen.setBackground(Color.blue);
			JOptionPane.showMessageDialog(null,"Llave Cerrada");
		}			
		else
			JOptionPane.showMessageDialog(null,"Llave Cerrada");
	}
}
	