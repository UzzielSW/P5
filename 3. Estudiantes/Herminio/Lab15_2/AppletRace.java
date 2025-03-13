/**
 * @(#)AppletRace.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/10/27
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * AppletRace es un simulador de una carrera utilizando hilos, para este ejemplo se utiliza la clase
 * AppletRaceCar que extiende a Thread. Cada auto señala su progreso mediante una JProgressBar y al
 * terminar muestra el orden de llegada, esto se logra mediante la creacion de una seccion critica
 * que maneja de forma exclusiva la variable posicion. Los nombres de los autos pueden ser modificados
 * por el usuario uno a uno (mediante el menu) o todos a la vez (mediante el boton Set Name).
 *
 * @see AppletRaceCar
 */
public class AppletRace extends JApplet implements ActionListener
{

    private JProgressBar jpBar[] = new JProgressBar[5];
    private JLabel jlCarName[] = new JLabel[5];
    private JTextField jtfSalida[] = new JTextField[5];
    private JPanel panel[] = new JPanel[6];
    private JMenuBar jmb;
    private JMenu menu, jmSetName;
    private JMenuItem jmiStart, jmiExit;
    private JMenuItem[] jmiSetName = new JMenuItem[5];
    private JButton jbtStart, jbtSetName;
    private AppletRaceCar[] cars = new AppletRaceCar[5];
    private String[] stName = {"Car# 1", "Car# 2", "Car# 3", "Car# 4", "Car# 5",};
    private Container contenedor;
    private int posicion = 0;
    
    /**
     * Sobreescritura del metodo <i>init()</i> el cual es llamado por el navegador al 
     * iniciarse el applet
     */
    public void init()
    {
    	//super(title);
    	contenedor = getContentPane();
    	jmb = new JMenuBar();
    	this.setJMenuBar(jmb);
    	contenedor.setLayout(new GridLayout(6, 0));
    	
    	menu = new JMenu("Menu");
    	jmiStart = new JMenuItem("Start");
    	jmiStart.addActionListener(this);
    	menu.add(jmiStart);
    	jmSetName = new JMenu("Set Name...");
    	for(int i = 0; i<jmiSetName.length; i++)
    	{
    		jmiSetName[i] = new JMenuItem("Car#"+(i+1)+": "+stName[i]);
    		jmiSetName[i].addActionListener(this);
    		jmSetName.add(jmiSetName[i]);
    	}
    	menu.add(jmSetName);
    	jmiExit = new JMenuItem("Exit");
    	jmiExit.addActionListener(this);
    	menu.add(jmiExit);
    	jmb.add(menu);
    	
    	for(int i = 0; i < 5; i++)
    	{
    		panel[i] = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    		jlCarName[i] = new JLabel(stName[i]);
    		panel[i].add(jlCarName[i]);
    		jpBar[i] = new JProgressBar(0, 100);
    		panel[i].add(jpBar[i]);
    		jtfSalida[i] = new JTextField(10);
    		jtfSalida[i].setEditable(false);
    		panel[i].add(jtfSalida[i]);
    		contenedor.add(panel[i]);
    	}
    	
    	jbtStart = new JButton("Start");
    	jbtStart.addActionListener(this);
    	jbtSetName = new JButton("Set Name");
    	jbtSetName.addActionListener(this);
    	panel[5] = new JPanel();
    	panel[5].add(jbtStart);
    	panel[5].add(jbtSetName);
    	contenedor.add(panel[5]);
    	
    	/*setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(380, 300);
    	setVisible(true);*/
    }
    
    /**
     * Sobreescritura del metodo de la interfase ActionListener, permite el manejo de eventos cuando
     * un boton es pulsado o un elemento del menu es seleccionado. Los hilos que manejan los autos son
     * generados en este punto.
     */
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getActionCommand().equals("Start"))
    	{
    		for(int i = 0; i < 5; i++)
    		{
    			posicion = 0;
    			if(cars[i] != null) 
    			{
    				cars[i].para();
    				cars[i] = null;
    			}
    			jpBar[i].setForeground(colorAleatorio());
    			cars[i] = new AppletRaceCar(stName[i], jpBar[i], jtfSalida[i], this);
    			cars[i].start();
    		}
    	}
    	else if(ae.getActionCommand().equals("Exit"))
    	{
    		System.exit(0);
    	}
    	else if(ae.getActionCommand().equals("Set Name"))
    	{
    		for(int i = 0; i < 5; i++)
    		{
    			String captura = JOptionPane.showInputDialog(this, "Car# "+(i+1), "Set Name", JOptionPane.QUESTION_MESSAGE);
    			setCarName(i, captura);
    		}
    	}
    	else
    	{
    		for(int i = 0; i < 5; i++)
    		{
    			if((JMenuItem)ae.getSource() == jmiSetName[i])
    			{
    				String captura = JOptionPane.showInputDialog(this, "Car# "+(i+1), "Set Name", JOptionPane.QUESTION_MESSAGE);
    				setCarName(i, captura);
    			}
    		}
    	}
    }
    
     /**
     * Cambia el nombre del auto, este metodo fue hecho para reducir espacio dado que existen varias
     * formas de cambiar el nombre del auto dentro del frame (vease informacion de la clase para mas detalles).
     */
    public void setCarName(int i, String name)
    {
    	stName[i] = name;
    	jlCarName[i].setText(stName[i]);
    	jmiSetName[i].setText("Car#"+(i+1)+": "+stName[i]);
    }
    
    /**
     * Obtiene el valor de la variable posicion, este metodo es usado en la seccion critica del programa.
     *
     * @return la posicion del auto una vez que este ha llegado a la meta
     */
    public int getPosition()
    {
    	return(posicion);
    }
    
     /**
     * Cambia el valor de la variable critica posicion
     *
     * @param i La posicion del auto
     */
    public void setPosition(int i)
    {
    	posicion = i;
    }
    
    /**
     * Produce colores de manera aleatoria, notese que existe la posibilidad que genere el mismo
     * color repetidas veces dado que no existe control en la forma en que los colores son generados
     *
     * @return Un color aleatorio
     */
    public Color colorAleatorio()
    {
    	int[] color = new int[3];
    	for(int i = 0; i < color.length; i++)
    	{
    		color[i] = (int)(Math.random()*255);
    	}
    	return new Color(color[0], color[1], color[2]);
    }
    
    /*public static void main (String[] args) 
    {
    	GUIRace race = new GUIRace("Race");
	}*/
}