//Demo2.java
//Modificado por Herminio Vargas 22/Nov/2010

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <code>Demo2</code> es el componente encargado de mostrar el panel sobre el cual se mueve la bola
 * asi como su movimiento. El codigo fuente original fue descargado de <code>http://www.simplej.com/?q=node/38</code>
 * pero algunas modificaciones han sido hechas para poder usarlo en <code>AppletGame</code>. El codigo fuente original (Demo1) 
 * es accesible desde la misma pagina o puede ser visto en la carpeta codigo fuente
 *
 * <hr>
 * <b>Modificaciones:</b>
 * <br>
 * <ul>
 * 	<li>Las constantes fueron cambiadas a publicas para que puedan ser accesibles desde <code>AppletGame</code></li>
 *	<li>Las coordenadas fueron cambiadas a double (ningun motivo en particular, me siento mas comodo trabajando con doble precision)</li>
 *	<li>El ciclo principal del juego fue agregado a un hilo para que su ejecucin no interfiera con la del hilo principal</li>
 *	<li>Una nueva clase interna <code>ManejaGraficos</code> la cual se encarga de el hilo que mueve la bola</li>
 *	<li>La variable <i>isStarted</i> fue incluida para evitar que nuevos hilos fueran creados</li>
 *	<li>Agregado el metodo <i>getBallCoordinates</i> el cual es usado en <code>AppletGame</code></li>
 *	<li>Manejo de excepciones usando el bloque <i>try/catch</i> en lugar de <i>throws</i></li>
 * </ul>
 *
 * @see AppletGame
 */
public class Demo2 extends JComponent
{

    /**
     * Ancho del panel
     */
    public  final static int ANCHO = 512;

    /**
     * Alto del panel
     */
    public final static int ALTO = 384;

    /**
     * Diametro de la bola
     */
    public final static int DIAMETRO = 40;

    private double x, y;

    private double vx, vy;
    
    private boolean isStarted;
    

    /**
     * Constructor de la clase
     */
    public Demo2() 
    {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        x = 20;
        y = 40;
        vx = 300;
        vy = 400;
        isStarted = false;
    }
    
    /**
     * Devuelve las coordenadas de la bola
     *
     * @return El punto donde inicia el dibujo de la bola
     */
    public Point getBallCoordinates()
    {
    	return new Point((int)x, (int)y);
    }

    private void fisica(double dt) {
        x += vx * dt;
        y += vy * dt;
        if (vx < 0 && x <= 0 || vx > 0 && x + DIAMETRO >= ANCHO)
            vx = -vx;
        if (vy < 0 && y < 0 || vy > 0 && y + DIAMETRO >= ALTO)
            vy = -vy;
    }

    /**
     * Sobreescrito del metodo paint de la clase padre, dibuja el panel y la bola
     *
     * @param g Los graficos especificados
     */
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ANCHO, ALTO);
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, DIAMETRO, DIAMETRO);
    }

    /**
     * Actualiza el grafico de la bola con las nuevas coordenadas
     */
    private void dibuja() 
    {
        try
        {
        	SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    paintImmediately(0, 0, ANCHO, ALTO);
                }
            });
        }catch(Exception e){System.out.println(e.getMessage());}
        
    }

    /**
     * Inicia la ejecucin del hilo encargado del proceso de calculo del movimiento de la bola
     * y de actualizar los graficos
     */
    public void cicloPrincipalJuego()
    {
    	if(!(isStarted))
    	{
    		new manejaGraficos().start();
    		isStarted = true;
    	}
    }
    
    /**
     * Clase interna que maneja el movimiento de la bola, asi como los calculos requeridos
     */
    class manejaGraficos extends Thread
    {
        public void run()
        {
        	long tiempoViejo = System.nanoTime();
        	while (true) 
        	{
            	long tiempoNuevo = System.nanoTime();
            	double dt = (tiempoNuevo - tiempoViejo) / 2500000000f;
            	tiempoViejo = tiempoNuevo;
            	try
            	{
            		Thread.sleep(20);
            	}catch(InterruptedException ie){}
            	fisica(dt);
            	dibuja();
        	}
        }
    }

    public static void main(String[] args) 
    {
        JFrame jf = new JFrame("Demo1");
        jf.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        jf.setResizable(false);
        Demo2 demo1 = new Demo2();
        jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
    }
}
