/**
 * @(#)SupervisorMessage.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/31
 */
 
import javax.swing.*;

/**
 * <code>SupervisorMessage</code> es un mensaje generado por la clase <code>Supervisor</code> el cual
 * cambiara la caja de ser necesario
 *
 * @see Supervisor
 * @see Fabrica
 */
public class SupervisorMessage extends ActionMessage
{
    private boolean reset;
    private int CajaNumero;
    
    /**
     * Constructor de la clase
     *
     * @param reset <code>true</code> si la caja debe ser cambiada
     * @param number El numero de caja
     */
    public SupervisorMessage(boolean reset, int number)
    {
    	this.reset = reset;
    	this.CajaNumero = number;
    }
    
    /**
	 * Sobreescrito de la clase padre
	 *
	 * @see ActionMessage
	 * @param caja La caja que se cambiara al llegar a 100 paginas
	 * @param jtArea El area de texto donde se despliegan los mensajes
	 */
	 
    public void doAction(Caja caja, JTextArea jtArea)
    {
    	if(reset)
    	{
    		try
    		{
    			caja.setRetired(true);
    			jtArea.append("La caja #"+CajaNumero+" esta llena, procediendo a cambiarla...\n");
    			jtArea.setCaretPosition(jtArea.getDocument().getLength());
    			caja.setNumberOfPages(0);
    			Thread.sleep(20);
    			caja.setRetired(false);
    			caja.setFull(false);
    		}
    		catch(InterruptedException ie){}
    	}
    }
}