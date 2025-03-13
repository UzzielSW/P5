/**
 * @(#)PersonaMessage.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/31
 */
 
import javax.swing.*;

/**
 * <code>PersonaMessage</code> es un mensaje generado por la clase <code>Persona</code> cuya funcion
 * es decirle al servidor que agregue una pagina a la caja
 *
 * @see Fabrica
 * @see Persona
 */
public class PersonaMessage extends ActionMessage
{
	private int id;
	
	/**
	 * Costructor de la clase
	 *
	 * @param id El numero de identificacion de la persona (generado por el servidor al conectarse)
	 */
	public PersonaMessage(int id)
	{
		this.id = id;
	}
	
	/**
	 * Sobreescrito de la clase padre
	 *
	 * @see ActionMessage
	 * @param caja La caja a la que se le agregara una pagina
	 * @param jtArea El area de texto donde se despliegan los mensajes
	 */
	public void doAction(Caja caja, JTextArea jtArea)
	{
		try
		{
			Caja.addAPage(caja);
    		jtArea.append("Empleado "+id+" agrego una pagina a la caja\n");
    		jtArea.setCaretPosition(jtArea.getDocument().getLength());
    	}
    	catch(Exception e)
    	{
    		jtArea.append("No se pudo efectuar la operacion: "+e.getMessage()+"\n");
    		jtArea.setCaretPosition(jtArea.getDocument().getLength());
    	}
	}
}