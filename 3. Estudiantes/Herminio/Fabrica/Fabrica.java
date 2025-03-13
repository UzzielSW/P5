/**
 * @(#)Fabrica.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/17
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * <p><code>Fabrica</code> es la clase principal de la solucion del sistema concurrente, esta
 * clase es la encargada de producir la interfaz grafica, asi como tambien de inicializar los
 * hilos.</p>
 * <p>Fabrica provee de una interfaz grafica de usuario que permite ver el progreso de los
 * hilos, asi como la capacidad de detenerlos, suspenderlos o reiniciarlos, en caso tal que
 * el usuario asi lo desee.</p>
 *
 * @see Persona
 * @see Supervisor
 */
public class Fabrica extends JFrame implements ActionListener
{

    private Container contenedor;
    private JTextArea jtaMensajes;
    private JProgressBar jpbCantidad;
    private JLabel jlCajas;
    private JScrollPane scroll;
    private JPanel jpNorte, jpCentro, jpSur;
    private JButton jbtStart, jbtStop, jbtSuspend, jbtResume;
    private Caja caja;
    private Persona[] empleados;
    private Supervisor supervisor;













































    /**
     * Constructor de la clase
     *
     * @param title El encabezado del Frame que se genera
     */
    public Fabrica(String title)
    {
    	super(title);
    	contenedor = getContentPane();

        jpNorte = new JPanel();
        jtaMensajes = new JTextArea(10, 25);
        scroll = new JScrollPane(jtaMensajes);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jpNorte.add(scroll);
        contenedor.add(jpNorte, BorderLayout.NORTH);

        jpCentro = new JPanel();
        jlCajas = new JLabel("Caja #1         ");
        jpCentro.add(jlCajas);
        jpbCantidad = new JProgressBar(0, 100);
        jpCentro.add(jpbCantidad);
        contenedor.add(jpCentro, BorderLayout.CENTER);

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

        contenedor.add(jpSur, BorderLayout.SOUTH);
        estadoInicial();
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

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
    		if(supervisor != null ||caja != null || empleados != null)
    		{
    			caja = null;
    			empleados[0] = null;
    			empleados[1] = null;
    			empleados[2] = null;
    			supervisor = null;
    		}
    		inicia();
    		jbtStart.setEnabled(false);
    		jbtStop.setEnabled(true);
    		jbtSuspend.setEnabled(true);
    		jbtResume.setEnabled(false);
    	}
    	else if(accion.equals("Stop"))
    	{
    		empleados[0].detener();
    		empleados[1].detener();
    		empleados[2].detener();
    		supervisor.detener();
    		estadoInicial();
    	}
    	else if(accion.equals("Suspend"))
    	{

    		empleados[0].suspender();
    		empleados[1].suspender();
    		empleados[2].suspender();
    		supervisor.suspender();
    		jbtSuspend.setEnabled(false);
    		jbtResume.setEnabled(true);
    	}
    	else if(accion.equals("Resume"))
    	{
    		empleados[0].reanudar();
    		empleados[1].reanudar();
    		empleados[2].reanudar();
    		supervisor.reanudar();
    		jbtSuspend.setEnabled(true);
    		jbtResume.setEnabled(false);
    	}
    }


















    /**
     * Inicializa los hilos, asi como tambien limpia el area de texto
     */
    public void inicia()
    {
    	jtaMensajes.setText("");
    	caja = new Caja();
        empleados = new Persona[3];
        for(int i = 0; i < empleados.length; i++)
        {
        	empleados[i] = new Persona(caja, i+1, jtaMensajes);
        	empleados[i].start();
        }
        supervisor = new Supervisor(caja, jtaMensajes, jpbCantidad, jlCajas, empleados, this);
        supervisor.start();
    }

    /**
     * Inicializa los botones
     */
    public void estadoInicial()
    {
    	jbtStart.setEnabled(true);
    	jbtSuspend.setEnabled(false);
    	jbtResume.setEnabled(false);
    	jbtStop.setEnabled(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Fabrica fabrica = new Fabrica("Examen Semestral");
    }
}
