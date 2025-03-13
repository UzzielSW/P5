/**
 * @(#)GUIReminder.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/9/22
 * @version 2.00 2010/10/01
 */
import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

/**
 * <code>GUIReminder</code> es la clase encargada de agregar los mensajes, los cuales son desplegados
 * en pantalla mediante el uso de un timer
 *
 * @see java.util.Timer
 * @see GUIScheduleReminder
 */
public class GUIReminder extends TimerTask
{

    private String message;
    private Component parent;
    
  	/**
 	* Constructor de la clase
 	*
 	* @param msg El mensaje que sera desplegado
 	* @param p El componente que genera el mensaje (usado para mostrar la caja de dialogo dentro del frame)
 	*/
    public GUIReminder(String msg, Component p) 
    {
    	message = msg;
    	parent = p;
    }
    
    /**
 	* Constructor de la clase sin el uso de un componente padre
 	*
 	* @param msg el mensaje que sera desplegado
 	*/
    public GUIReminder(String msg)
    {
    	this(msg, null);
    }
    
    /**
 	* Sobreescrito del metodo <i>run</i>, despliega el mensaje al ser iniciado
 	*/
    public void run()
    {
    	JOptionPane.showMessageDialog(parent, message, "Reminder", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}