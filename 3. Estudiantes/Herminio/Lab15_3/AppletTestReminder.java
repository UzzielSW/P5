/**
 * @(#)AppletTestReminder.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/9/22
 * @version 2.00 2010/10/01
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <code>AppletTestReminder</code> es la version en applet de <code>GUITestReminder</code>, el cual es
 * un ejemplo del manejo de hilos usando las clases <code>Timer</code> y <code>TimerTask</code>
 *
 * @see GUITestReminder
 * @see GUIScheduleReminder
 */
public class AppletTestReminder extends JApplet implements ActionListener
{

    //private Calendar calendario;
    private Container contenedor;
    private JPanel panel;
    private JScrollPane scroll;
    private JTextArea textArea;
    private JButton jbtCreate, jbtClear;
    private GUIScheduleReminder recordatorio;
    
    /**
 	* Sobreescrito del metodo <i>init</i> de la clase <code>Applet</code>, se encarga de la ejecucion del
 	* applet al ser invocado por el navegador
 	*/
    public void init()
    {
    	//super(title);
    	
    	recordatorio = new GUIScheduleReminder(this);
    	
    	contenedor = getContentPane();
    	textArea = new JTextArea(10,20);
    	scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	contenedor.add(scroll, BorderLayout.CENTER);
    	
    	panel = new JPanel();
    	
    	jbtCreate = new JButton("Create Reminder");
    	jbtCreate.addActionListener(this);
    	panel.add(jbtCreate);
    	
    	jbtClear = new JButton("Clear");
    	jbtClear.addActionListener(this);
    	panel.add(jbtClear);
    	contenedor.add(panel, BorderLayout.SOUTH);
    }
    
    /**
 	* Parte de la clase que se encarga de el manejo de los eventos
 	*
 	* @param ae el evento generado al pulsar un boton
 	*/
    public void actionPerformed(ActionEvent ae)
    {
    	String source = ae.getActionCommand();
    	String message;
    	if(source.equals("Create Reminder"))
    	{
    		try
    		{
    			message = JOptionPane.showInputDialog(this, "Enter time (in miliseconds)", "Reminder", JOptionPane.QUESTION_MESSAGE);
    			long milis = Long.parseLong(message);
    			int acepta = JOptionPane.showConfirmDialog(this, "¿Confirma el recordatorio?", "Reminder", JOptionPane.YES_NO_OPTION);
    			if(acepta == JOptionPane.YES_OPTION)
    			{
    				recordatorio.addReminder(textArea.getText(), milis);
    			}
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(this, e.getMessage());
    		}
    	}
    	else if(source.equals("Clear")) textArea.setText("");
    }
    
    /*public static void main (String[] args) 
    {
    	GUITestReminder frame = new GUITestReminder("Reminder");
    	frame.pack();
    	frame.setResizable(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	
    	//System.exit(0);
	}*/
    
}