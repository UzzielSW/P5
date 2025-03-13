/**
 * @(#)Persona.java
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
 * <code>Pesona</code> representa a una persona que coloca paginas en una caja, su unica funcion continuar colocando
 * paginas en la caja hasta que termine la ejecucion del hilo generado por esta clase, para esta
 * version se considero que la persona que coloca las paginas se encuentra en otra computadora
 *
 * @see Caja
 * @see Fabrica
 */
public class Persona extends JFrame implements ActionListener, Runnable
{

    /**
     * Determina que la conexion ha sido establecida satisfactoriamente
     */
    public static final int CORRECTO = 0;

    /**
     * Determina que hubo un error en la conexion debido a que se llego a un limite de conexiones
     */
    public static final int ERROR_MAX = 1;

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
    private int id;
    private String ip = "localhost";




























    /**
     * Constructor de la clase
     * @param title El encabezado del frame
     */
    public Persona(String title)
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
    			id = in.readInt();
    			id++;
    			jtArea.append("El id del empleado es: "+id+"\n");
    			jtArea.setCaretPosition(jtArea.getDocument().getLength());
    			while(true)
    			{
    				Thread.sleep(500);
    				if(stopped) break;
    				synchronized(this)
    				{
    					while(suspended) wait();
    				}
    				out.writeObject(new PersonaMessage(id));
    				jtArea.append("Empleado "+id+" envia una pagina a la fabrica\n");
    				jtArea.setCaretPosition(jtArea.getDocument().getLength());
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
    	new Persona("Cliente: Persona");
	}
}