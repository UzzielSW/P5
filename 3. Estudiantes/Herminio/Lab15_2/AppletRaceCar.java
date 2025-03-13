/**
 * @(#)AppletRaceCar.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/9/22
 */

import javax.swing.*;

/**
 * <code>AppletRaceCar</code> es una clase que extiende a <code>Thread</code> la cual se encarga de
 * el manejo de los autos de carreras. Todos los objetos creados a partir de <code>AppletRaceCar</code>
 * tienen las mismas posibilidades de llegar primero a la meta y a su vez obtienen su posicion de la
 * seccion critica la cual es manejada dentro de esta misma clase por el metodo estatico <i>getPosition</i>
 *
 * @see AppletRace
 */
public class AppletRaceCar extends Thread
{
	//private int finish;
	private String name;
	private JProgressBar jpBar;
	private JTextField jtField;
	private AppletRace race;
	private boolean stop = false;
	
    /**
     * Constructor de la clase, todos los campos son obligatorios
     *
     * @param n El nombre del auto
     * @param jpb La barra de progreso que muestra el avance del auto
     * @param f El campo de texto donde se mostraran los mensajes
     * @param r El GUIRace donde se guarda la seccion critica
     */
    public AppletRaceCar(String n, JProgressBar jpb, JTextField f, AppletRace r) 
    {
    	jpBar = jpb;
    	name = n;
    	jtField = f;
    	race = r;
    }
    
    /**
     * Sobreescrito de <code>Thread</code>. Se encarga del procesamiento del hilo
     */
    public void run()
    {
    	int i;
    	double j;
    	for(i=0; i<=100; i++)
    	{
    		if(stop) return;
    		j = i/10.0;
    		jtField.setText(name+": lap "+(int)j);
    		jpBar.setValue(i);
    		jpBar.repaint();
    		try
    		{
    			Thread.sleep((int)(200*Math.random()));
    		}catch(InterruptedException ie){}
    		
    	}
    	jtField.setText(" finished "+getPosition(race)+"!");
    	
    }
    
    /**
     * Metodo estatico que proporciona acceso a la seccion critica, en este caso la variable
     * que guarda las posiciones de llegada
     * 
     * @param race El objeto que guarda la seccion critica del programa (GUIRace)
     * @return La posicion de llegada del auto
     */
    public static synchronized String getPosition(AppletRace race)
    {
    	int position = race.getPosition();
    	position = position+1;
    	race.setPosition(position);
    	if(position == 1) return "First";
    	else if(position == 2) return "Second";
    	else if(position == 3) return "Third";
    	else return position+"th";
    	
    }
    
    /**
     * Detiene el procesamiento del hilo
     */
    public void para()
    {
    	stop = true;
    }
}