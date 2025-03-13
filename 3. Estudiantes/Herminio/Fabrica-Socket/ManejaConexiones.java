/**
 * @(#)ManejaConexiones.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2011/1/2
 */

import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 * <code>ManejaConexiones</code> es la clase encargada de controlar las diferentes conexiones
 * que se dan entre los clientes (Persona y Supervisor) y el servidor(Fabrica), en si es esta
 * misma clase quien se encarga de colocar los papeles en la caja, asi como de reemplazarla de
 * ser necesario, sin embargo requiere de una orden especifica de los clientes para ejecutar
 * estas acciones
 *
 * @see Persona
 * @see Supervisor
 * @see ActionMessage
 */
public class ManejaConexiones extends Thread
{

    private Caja caja;
    private boolean supervisor;
    private JTextArea jtArea;
    private ObjectInputStream in;
    private DataOutputStream out;
    private boolean stopped;

    /**
     * Constructor de la clase
     *
     * @param in El flujo de entrada desde el cual se leeran las instrucciones
     * @param out El flujo de salida de los mensajes producidos
     * @param caja La caja donde se depositan los papeles
     * @param jtArea Un area de texto donde se mostraran los mensajes
     */
    public ManejaConexiones(ObjectInputStream in, DataOutputStream out, Caja caja, JTextArea jtArea)
    {
    	this(in, out, caja, jtArea, false);
    }

    /**
     * Constructor de la clase
     *
     * @param in El flujo de entrada desde el cual se leeran las instrucciones
     * @param out El flujo de salida de los mensajes producidos
     * @param caja La caja donde se depositan los papeles
     * @param jtArea Un area de texto donde se mostraran los mensajes
     * @param isSupervisor Le dice al objeto si el cliente que maneja es un supervisor o no
     */
    public ManejaConexiones(ObjectInputStream in, DataOutputStream out, Caja caja, JTextArea jtArea, boolean isSupervisor)
    {
    	this.caja = caja;
    	this.jtArea = jtArea;
    	this.supervisor = isSupervisor;
    	this.stopped = false;
    	this.in = in;
    	this.out = out;

    }
















     /**
     * Sobreescrito de la clase padre, se encarga de la ejecucion del hilo
     */
    public void run()
    {
    	while(true)
    	{
    		if(stopped) break;
    		try
    		{
    			if(supervisor) out.writeInt(caja.getNumberOfPages());
    			ActionMessage am = (ActionMessage)in.readObject();
    			am.doAction(caja, jtArea);
    		}
    		catch(Exception e)
    		{
    			jtArea.append("Error en la conexion: "+e.getMessage()+"\n");
    			jtArea.setCaretPosition(jtArea.getDocument().getLength());
    		}
    	}
    }

     /**
     * Detiene completamente la ejecucion del hilo, de ser usado no se puede reiniciar el hilo, este debe ser
     * instanciado nuevamente
     */
    public void detener()
    {
    	stopped = true;
    }
}