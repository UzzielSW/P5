/**
 * @(#)AppletGame2.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/11/22
 */
 
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

/**
 * <code>AppletGame</code> despliega un panel de juego, el objetivo del juego es hacer click con
 * el mouse sobre la bola para ir acumulando puntos, los cuales son desplegados en el panel del fondo.
 * A cada acierto el sistema anota diez puntos.
 *
 * <br>
 * <br>
 *
 * <b>Nota del Autor:</b> A pesar de parecer sencillo no es tan facil darle a la bola, requiere de mucha
 * concentracion y buen tino, si desea probar que el juego funciona correctamente vaya al constructor y comente la 
 * ultima linea (<code>panelJuego.cicloPrincipalJuego();</code>) para evitar que inicie el hilo que mueve la
 * bola y notara que puede hacer click sobre cualquier punto de la bola y los puntos se sumaran
 */
public class AppletGame2 extends JApplet
{

    private Demo2 panelJuego;
    private Puntuacion puntuacion;
    private JPanel panelSur;
    private Container contenedor;
    
    /**
     * Sobreescrito de la clase padre, es llamado por el navegador al cargar el applet
     */
    public void init()
    {
    	//super(title);
    	contenedor = getContentPane();
    	
    	panelJuego = new Demo2();
    	contenedor.add(panelJuego, BorderLayout.CENTER);
    	
    	panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	puntuacion = new Puntuacion();
    	panelSur.add(puntuacion);
    	contenedor.add(panelSur, BorderLayout.SOUTH);
    	
    	panelJuego.addMouseListener(new MouseAdapter()
    	{
    		public void mouseClicked(MouseEvent me)
    		{
    			
    			Point referencia = panelJuego.getBallCoordinates();
    			Point mouse = me.getPoint();
    			if(mouse.getX() >= referencia.getX() && mouse.getX() <= referencia.getX()+panelJuego.DIAMETRO)
    			{
    				if(mouse.getY() >= referencia.getY() && mouse.getY() <= referencia.getY()+panelJuego.DIAMETRO)
    				{
    					puntuacion.scorePoints(10);
    				}
    			}
    		}
    	});
    	
    	/*this.setResizable(false);
    	this.setBackground(Color.BLACK);
    	this.pack();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);*/
    	panelJuego.cicloPrincipalJuego();
    }
    
    /*public static void main (String[] args) 
    {
    	new AppletGame("Applet Game Demo");
	}*/
}