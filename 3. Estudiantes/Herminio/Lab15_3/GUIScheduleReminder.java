/**
 * @(#)GUIScheduleReminder.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/9/22
 * @version 2.00 2010/10/01
 */
import java.awt.*;
import java.util.*;

/**
 * <code>GUIScheduleReminder</code> es una clase generada para manejar el Timer, permitiendole
 * producir recordatorios
 *
 * @see GUIReminder
 * @see GUITestReminder
 * @see AppletTestReminder
 */
public class GUIScheduleReminder 
{
	private Timer timer;
	private Component parent;
	
	/**
 	* Constructor por default de la clase
 	*/
	public GUIScheduleReminder()
	{
		this(null);
	}
	
	/**
 	* Constructor de la clase
 	*
 	* @param p El componente que genera los mensajes
 	* @see GUIReminder
 	*/
	public GUIScheduleReminder(Component p)
	{
		timer = new Timer();
		parent = p;
	}
	
	/**
 	* Agrega recordatorios al Timer los cuales seran desplegados en el numero de milisegundos establecido
 	* @param msg El mensaje que mostrara el recordatorio
 	* @param milis El tiempo en que el mensaje sera mostrado (en milisegundos)
 	*/
	public void addReminder(String msg, long milis)
	{
		timer.schedule(new GUIReminder(msg, parent), milis);
	}
	
	/**
 	* Agrega recordatorios al Timer los cuales seran desplegados en la fecha establecida
 	* @param msg El mensaje que mostrara el recordatorio
 	* @param date la fecha en que el mensaje sera mostrado
 	*/
	public void addReminder(String msg, Date date)
	{
		timer.schedule(new GUIReminder(msg, parent), date);
	}
}