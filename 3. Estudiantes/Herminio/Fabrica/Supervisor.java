/**
 * @(#)Supervisor.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/17
 */

import javax.swing.*;

/**
 * <p><code>Supervisor</code> representa a un hilo
 * que verifica el estado de la caja y la cambia cuando
 * esta se encuentra llena, al llegar a las tres cajas
 * detiene su ejecucion</p>
 *
 * @see Caja
 * @see Fabrica
 * @see Persona
 */
public class Supervisor extends Thread
{

    private Caja caja;
    private int puntero;
    private boolean suspended;
    private boolean stopped;
    private JTextArea jtArea;
    private JProgressBar jpBar;
    private JLabel label;
    private Persona[] empleados;
    private Fabrica fabrica;

    /**
     * Constructor de la clase, todos los campos son obligatorios
     *
     * @param caja La caja que supervisara
     * @param jtArea Un area de texto en el que se muestran mensajes
     * @param jpBar Una barra de progreso que simula la entrada de paginas en la caja
     * @param empleados Un grupo de personas que colocan paginas en la caja
     * @param fabrica La clase principal, usado para resetear los botones al finalizar la ejecucion del hilo
     */
    public Supervisor(Caja caja, JTextArea jtArea, JProgressBar jpBar, JLabel label, Persona[] empleados, Fabrica fabrica)
    {
    	this.caja = caja;
    	this.jtArea = jtArea;
    	this.jpBar = jpBar;
    	this.label = label;
    	this.empleados = empleados;
    	this.fabrica = fabrica;
    	this.puntero = 0;
    	this.suspended = false;
    	this.stopped = false;
    }


























    /**
     * Sobreescrito de la clase padre, se encarga de la ejecucion del hilo
     */
    public void run()
    {
    	while(puntero < 3)
    	{
    		if(stopped) break;
    		try
    		{
    			synchronized(this)
    			{
    				while(suspended) wait();
    			}

    			Thread.sleep(50);

    			if(caja.getFull())
    			{
    				puntero++;
    				caja.setRetired(true);
    				jtArea.append("La caja #"+puntero+" esta llena, procediendo a cambiarla...\n");
    				jtArea.setCaretPosition(jtArea.getDocument().getLength());
    				Thread.sleep(20);
    				caja.setNumberOfPages(0);
    				caja.setRetired(false);
    				caja.setFull(false);
    			}
    			if(puntero<3) label.setText("Caja #"+(puntero+1)+" ("+caja.getNumberOfPages()+"/100)");
    			else label.setText("Proceso Completado");
    			jpBar.setValue(caja.getNumberOfPages());
    			jpBar.repaint();
    		}
    		catch(InterruptedException ie){}
    	}

    	caja.setRetired(true);

    	for(int i = 0; i < empleados.length; i++) empleados[i].detener();
    	fabrica.estadoInicial();
    	if(!(stopped)) stopped = true;
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
     * Detiene completamente la ejecucion del hilo, de ser usado no se puede reiniciar el hilo, este debe ser instanciado nuevamente
     */
    public void detener()
    {
    	if(!(stopped)) stopped = true;
    }
}