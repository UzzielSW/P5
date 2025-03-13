/**
 * @(#)Persona.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/17
 */

import javax.swing.*;

/**
 * <code>Pesona</code> representa a una persona que coloca paginas en una caja, su unica funcion continuar colocando
 * paginas en la caja hasta que termine la ejecucion del hilo generado por esta clase
 *
 * @see Caja
 * @see Fabrica
 */
public class Persona extends Thread
{

    private Caja caja;
    private int id;
    private boolean suspended;
    private boolean stopped;
    private JTextArea jtArea;

    /**
     * Constructor de la clase
     *
     * @param caja La caja en la cual se depositaran los papeles
     * @param id La identificacion de la persona que deposita los papeles
     * @param jtArea Un area de texto donde se mostraran los mensajes producidos
     */
    public Persona(Caja caja, int id, JTextArea jtArea)
    {
    	this.caja = caja;
    	this.id = id;
    	this.jtArea = jtArea;
    	this.suspended = false;
    	this.stopped = false;
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
    			synchronized(this)
    			{
    				while(suspended) wait();
    			}
    			Caja.addAPage(caja);
    			jtArea.append("Empleado "+id+" agrego una pagina a la caja\n");
    			jtArea.setCaretPosition(jtArea.getDocument().getLength());
    		}
    		catch(Exception e)
    		{
    			jtArea.append("No se pudo efectuar la operacion: "+e.getMessage()+"\n");
    			jtArea.setCaretPosition(jtArea.getDocument().getLength());
    		}
    		try
    		{
    			Thread.sleep(100);
    		}
    		catch(InterruptedException ie)
    		{
    			ie.printStackTrace();
    		}
    	}
    }






    /**
     * suspende la ejecucion del hilo
     */
    public void suspender()
    {
    	if(!(suspended)) suspended = true;
    }

    /**
     * reanuda la ejecucion del hilo una vez que este ha sido suspendido
     */
    public synchronized void reanudar()
    {
    	if(suspended) suspended = false;
    	notify();
    }

    /**
     * Detiene completamente la ejecucion del hilo, de ser usado no se puede reiniciar el hilo, este debe ser
     * instanciado nuevamente
     */
    public void detener()
    {
    	if(!(stopped)) stopped = true;
    }

}