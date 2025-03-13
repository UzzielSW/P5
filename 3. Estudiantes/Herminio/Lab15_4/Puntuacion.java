/**
 * @(#)Puntuacion.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/11/11
 */

import javax.swing.*;
import java.awt.*;

/**
 * <code>Puntuacion</code> es la clase encargada de mostrar el puntaje del juego al usuario, asi como
 * de almacenar información sobre el puntaje
 */
public class Puntuacion extends JPanel
{

	/**
	 * Ancho del panel
	 */
	public static final int ANCHO = 160;
	/**
	 * Alto del panel
	 */
	public static final int ALTO = 40;
	private int puntos;
	
    /**
     * Constructor por default de la clase, inicializa el contador en 0
     */
    public Puntuacion() 
    {
    	this(0);
    }
    
    /**
     * Constructor de la clase, inicializa el contador basado en la puntuacion dada
     *
     * @param puntos La puntuación inicial
     */
    public Puntuacion(int puntos)
    {
   		super();
   		setPreferredSize(new Dimension(ANCHO, ALTO));
    	this.puntos = puntos;
    	repaint();
    }
    
    /**
     * Sobreescrito de la clase padre, redibuja el panel
     *
     * @param g los graficos especificados
     */
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	String puntajes = new Integer(puntos).toString();
    	this.setBackground(Color.black);
    	this.setForeground(Color.GREEN);
    	g.setFont(new Font("Times New Roman", Font.BOLD, 30));
    	g.drawString(puntajes, 20, 30);
    }
    
    /**
     * Coloca el contador en una posicion dada por el usuario
     *
     * param ptos El puntaje que se desea colocar
     */
    public void setScore(int ptos)
    {
    	puntos = ptos;
    	repaint();
    }
    
    /**
     * Retorna el puntaje acumulado
     *
     * @return El puntaje actual
     */
    public int getScore()
    {
    	return puntos;
    }
    
    /**
     * Agrega puntos al contador, la puntuacion enviada sera agragada a la ya existente
     *
     * @param cant La cantidad que sera sumada al contador
     */
    public void scorePoints(int cant)
    {
    	puntos = puntos+cant;
    	repaint();
    }
}