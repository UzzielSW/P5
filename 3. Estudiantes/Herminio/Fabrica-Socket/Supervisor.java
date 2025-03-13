/**
 * @(#)Supervisor.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2011/1/5
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 * <code>Supervisor</code> representa a una persona que cambia las cajas cuando estas llegan a
 * su capacidad maxima (en este caso 100 paginas)
 *
 * @see Caja
 * @see Fabrica
 */
public class Supervisor extends JFrame implements ActionListener, Runnable
{

    /**
     * Determina que la conexion ha sido establecida satisfactoriamente
     */
    public static final int CORRECTO = 0;

    /**
     * Determina que hay un supervisor conectado (el sistema solo permite un supervisor conectado a la vez)
     */
    public static final int ERROR_SUPERVISOR = 2;

    private Container contenedor;
    private JPanel jpNorte, jpSur;
    private JTextArea jtArea;
    private JScrollPane scroll;
    private JButton jbtStart, jbtStop, jbtSuspend, jbtResume, jbtSetIp;
    private Thread hilo;
    private Socket socket;
    private ObjectOutputStream out;
    private DataInputStream in;
    private boolean stopped = false;
    private boolean suspended = false;
    private int cantidad;
    private int numeroCaja = 1;
    private String ip = "localhost";




























    /**
     * Constructor de la clase
     *
     * @param title El encabezado del frame
     */
    public Supervisor(String title)
    {
    	super(title);
    	contenedor = getContentPane();

    	jpNorte = new JPanel();
    	jtArea = new JTextArea(10, 30);
    	scroll = new JScrollPane(jtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	jpNorte.add(scroll);
    	contenedor.add(jpNorte, BorderLayout.NORTH);

    	jpSur = new JPanel();
    	jbtStart = new JButton("Start");
    	jbtStart.addActionListener(this);
    	jpSur.add(jbtStart);
    	jbtStop = new JButton("Stop");
    	jbtStop.addActionListener(this);
    	jpSur.add(jbtStop);
    	jbtSuspend = new JButton("Suspend");
    	jbtSuspend.addActionListener(this);
    	jpSur.add(jbtSuspend);
    	jbtResume = new JButton("Resume");
    	jbtResume.addActionListener(this);
    	jpSur.add(jbtResume);
    	jbtSetIp = new JButton("Select Server");
    	jbtSetIp.addActionListener(this);
    	jpSur.add(jbtSetIp);
    	estadoInicial();
    	contenedor.add(jpSur, BorderLayout.SOUTH);

    	this.pack();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setVisible(true);
    }







































    /**
     * Sobreescrito de la clase padre, se encarga de la ejecucion del hilo
     */
    public void run()
    {
    	try
    	{
    		socket = new Socket(ip, 12345);
    		out = new ObjectOutputStream(socket.getOutputStream());
    		in = new DataInputStream(socket.getInputStream());
    		out.writeBoolean(false);//Comunica al servidor que no es un supervisor
    		if(in.readInt() == CORRECTO)
    		{
    			jtArea.append("Conexion exitosa, preparado para enviar datos...\n");
    			cantidad = in.readInt();
    			while(numeroCaja <= 3)
    			{
    				Thread.sleep(500);
    				if(stopped) break;
    				synchronized(this)
    				{
    					while(suspended) wait();
    				}
    				if(cantidad < 100) out.writeObject(new SupervisorMessage(false, numeroCaja));
    				else
    				{
    					out.writeObject(new SupervisorMessage(true, numeroCaja));
    					jtArea.append("La caja numero : "+numeroCaja+" esta llena, procediendo a cambiarla\n");
    					jtArea.setCaretPosition(jtArea.getDocument().getLength());
    					numeroCaja++;
    				}
    			}
    		}
    		else
    		{
    			jtArea.append("Hubo un error en la conexion...\n");
    			jtArea.setCaretPosition(jtArea.getDocument().getLength());
    		}
    	}
    	catch(Exception e)
    	{
    		jtArea.append("Ha ocurrido un error: "+e.getMessage()+"\n");
    		jtArea.setCaretPosition(jtArea.getDocument().getLength());
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
    	if(accion.equals("Start"))
    	{
    		stopped = false;
    		suspended = false;
    		jbtStart.setEnabled(false);
    		jbtStop.setEnabled(true);
    		jbtSuspend.setEnabled(true);
    		jbtSetIp.setEnabled(false);
    		hilo = new Thread(this);
    		hilo.start();

    	}
    	else if(accion.equals("Stop"))
    	{
    		detener();
    		estadoInicial();
    	}
    	else if(accion.equals("Suspend"))
    	{
    		suspender();
    		jbtSuspend.setEnabled(false);
    		jbtResume.setEnabled(true);
    	}
    	else if(accion.equals("Resume"))
    	{
    		reanudar();
    		jbtSuspend.setEnabled(true);
    		jbtResume.setEnabled(false);
    	}
    	else if(accion.equals("Select Server"))
    	{
    		ip = JOptionPane.showInputDialog(this, "Introduce una ip valida para el servidor", ip);
    	}
    }

    /**
     * Inicializa los botones
     */
    public void estadoInicial()
    {
    	jbtStart.setEnabled(true);
    	jbtStop.setEnabled(false);
    	jbtSuspend.setEnabled(false);
    	jbtResume.setEnabled(false);
    	jbtSetIp.setEnabled(true);
    }

    /**
     * Detiene completamente la ejecucion del hilo, de ser usado no se puede reiniciar el hilo, este debe ser
     * instanciado nuevamente
     */
    public void detener()
    {
    	stopped = true;
    }

    /**
     * suspende la ejecucion del hilo
     */
    public void suspender()
    {
    	suspended = true;
    }











    /**
     * reanuda la ejecucion del hilo una vez que este ha sido suspendido
     */
    public synchronized void reanudar()
    {
    	suspended = false;
    	notify();
    }

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args)
    {
    	new Supervisor("Cliente: Supervisor");
	}
}