/**
 * @(#)Fabrica.java
 *
 *
 * @author
 * @version 1.00 2011/1/2
 */

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <p><code>Fabrica</code> se encarga de montar un servidor aal cual se conectan las personas
 * encargadas de colocar los papeles en la caja, asi como el supervisor.</p>
 *
 * <p>Fabrica provee de una interfaz grafica de usuario que permite ver el proceso interno de
 * los clientes con la caja (que se encuentra en el servidor).</p>
 *
 * @see Persona
 * @see Supervisor
 */
public class Fabrica extends JFrame implements ActionListener, Runnable
{

    /**
     * El numero maximo de personas que pueden estar conectadas a la vez (no incluye al supervisor)
     */
    public static final int CAPACIDAD = 3;

    /**
     * Determina que la conexion ha sido establecida satisfactoriamente
     */
    public static final int CORRECTO = 0;

    /**
     * Determina que hubo un error en la conexion debido a que se llego a un limite de conexiones
     */
    public static final int ERROR_MAX = 1;

    /**
     * Determina que hay un supervisor conectado (el sistema solo permite un supervisor conectado a la vez)
     */
    public static final int ERROR_SUPERVISOR = 2;

    private Container contenedor;
    private JTextArea jtArea;
    private JScrollPane scroll;
    private JButton start, stop;
    private JPanel jpNorte, jpCentro, jpSur;
    private JLabel jlMensaje;
    private JProgressBar jpBar;

    private int cantidad;
    private boolean supervisorConectado = false;
    private boolean stopped = false;
    private Caja caja;
    private ManejaConexiones[] conexiones;
    private ServerSocket server;
    private Thread hilo;

















    /**
     * Constructor de la clase
     *
     * @param title El encabezado del frame
     */
    public Fabrica(String title)
    {
    	super(title);
    	contenedor = getContentPane();

    	jpNorte = new JPanel();
    	jtArea = new JTextArea(10, 20);
    	scroll = new JScrollPane(jtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	jpNorte.add(scroll);
    	contenedor.add(scroll, BorderLayout.NORTH);

    	jpCentro = new JPanel();
    	jlMensaje = new JLabel("Caja actual (0/100)  ");
    	jpBar = new JProgressBar(0, 100);
    	jpCentro.add(jlMensaje);
    	jpCentro.add(jpBar);
    	contenedor.add(jpCentro, BorderLayout.CENTER);

    	jpSur = new JPanel();
    	start = new JButton("Start Server");
    	start.addActionListener(this);
    	jpSur.add(start);
    	stop = new JButton("Stop Server");
    	stop.setEnabled(false);
    	stop.addActionListener(this);
    	jpSur.add(stop);
    	contenedor.add(jpSur, BorderLayout.SOUTH);

    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.pack();
    	this.setResizable(false);
    	this.setVisible(true);

    }




































   /**
     * Sobreescrito de la clase padre, se encarga de la ejecucion del hilo
     */
    public void run()
    {
    	stopped = false;
    	try
    	{
    		server = new ServerSocket(12345);
    	}
    	catch(IOException ioe)
    	{
    		jtArea.append("Ocurrio un error: "+ioe.getMessage()+"\n");
    		jtArea.setCaretPosition(jtArea.getDocument().getLength());
    	}
    	supervisorConectado = false;
    	int contador = 0;
    	for(int i = 0; i < conexiones.length; i++)
    	{
    		if(stopped) break;
    		try
    		{
    			Socket cliente = server.accept();
    			ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
    			DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
    			boolean isSupervisor = in.readBoolean();
    			if(isSupervisor)
    			{
    				if(supervisorConectado) out.writeInt(ERROR_SUPERVISOR);
    				else
    				{
    					supervisorConectado = true;
    					out.writeInt(CORRECTO);
    					conexiones[i] = new ManejaConexiones(in, out, caja, jtArea, isSupervisor);
    					conexiones[i].start();
    					jtArea.append("Se ha conectado un supervisor\n");
    					jtArea.setCaretPosition(jtArea.getDocument().getLength());
    				}
    			}
    			else
    			{
    				if(cantidad < 3)
    				{
    					out.writeInt(CORRECTO);
    					cantidad++;
    					out.writeInt(cantidad);
    					conexiones[i] = new ManejaConexiones(in, out, caja, jtArea, isSupervisor);
    					conexiones[i].start();
    					jtArea.append("Se ha conectado una persona, es la numero: "+(cantidad+1)+"\n");
    					jtArea.setCaretPosition(jtArea.getDocument().getLength());
    				}
    				else
    				{
    					out.writeInt(ERROR_MAX);
    				}
    			}
    		}
    		catch(Exception e)
    		{
    			jtArea.append("Ocurrio un error: "+e.getMessage()+"\n");
    			jtArea.setCaretPosition(jtArea.getDocument().getLength());
    		}
    	}
    }
















   /**
     * Sobreescrito del metodo <code>actionPerformed</code> de la interfaz ActionListener, maneja
     * los eventos generados cuando un boton es pulsado.
     *
     * @param ae El Evento generado al pulsar el boton (ActionEvent)
     * @see <a href="http://java.sun.com/docs/books/tutorial/post1.0/ui/eventmodel.html">Tutorial: Java 1.1 Event Model</a>
     * @see ActionEvent
     */
    public void actionPerformed(ActionEvent ae)
    {
    	String accion = ae.getActionCommand();
    	if(accion.equals("Start Server"))
    	{
    		jtArea.append("Iniciando servidor...\n");
    		caja = new Caja();
    		cantidad = -1;
    		conexiones = new ManejaConexiones[4];
    		hilo = new Thread(this);
    		start.setEnabled(false);
    		stop.setEnabled(true);
    		hilo.start();
    		jpBarManager manager = new jpBarManager();
    		manager.start();
    	}
    	else if(accion.equals("Stop Server"))
    	{
    		stopped = true;
    		caja = null;
    		for(int i = 0; i < conexiones.length; i++)
    		{
    			conexiones[i].detener();
    		}
    		conexiones = null;
    		hilo = null;
    		try
    		{
    			server.close();
    		}
    		catch(IOException ioe)
    		{
    			jtArea.append("Error al cerrar el servidor: "+ioe.getMessage()+"\n");
    			jtArea.setCaretPosition(jtArea.getDocument().getLength());
    		}
    		server = null;
    		start.setEnabled(true);
    		stop.setEnabled(false);
    	}
    }




























    /**
     * Clase interna encargada de mostrar el progreso tanto en una etiqueta como en la barra
     */
    class jpBarManager extends Thread
    {
    		/**
    		 * Sobreescrito de la clase padre
    		 */
    		public void run()
    		{
    			while(true)
    			{
    				if(stopped) break;
    				jpBar.setValue(caja.getNumberOfPages());
    				jpBar.repaint();
    				jlMensaje.setText("Caja actual ("+caja.getNumberOfPages()+"/100)");
    				try
    				{
    					Thread.sleep(100);
    				}
    				catch(InterruptedException ie)
    				{
    					jtArea.append("Ocurrio un error: "+ie.getMessage()+"\n");
    				}
    			}
    		}
    }

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args)
    {
    	Fabrica fabrica = new Fabrica("Servidor");
	}
}