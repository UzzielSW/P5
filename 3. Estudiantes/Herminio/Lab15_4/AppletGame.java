
/**
 * @(#)AppletGame.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/11/22
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <code>AppletGame</code> despliega un panel de juego, el objetivo del juego es
 * hacer click con el mouse sobre la bola para ir acumulando puntos, los cuales
 * son desplegados en el panel del fondo. A cada acierto el sistema anota diez
 * puntos.
 *
 * <br>
 * <br>
 *
 * <b>Nota del Autor:</b> A pesar de parecer sencillo no es tan facil darle a la
 * bola, requiere de mucha concentracion y buen tino, si desea probar que el
 * juego funciona correctamente vaya al constructor y comente la ultima linea
 * (<code>panelJuego.cicloPrincipalJuego();</code>) para evitar que inicie el
 * hilo que mueve la bola y notara que puede hacer click sobre cualquier punto
 * de la bola y los puntos se sumaran
 */
public class AppletGame extends JFrame {

    private Demo2 panelJuego;
    private Puntuacion puntuacion;
    private JPanel panelSur;
    private Container contenedor;

    /**
     * Constructor de la clase
     *
     * @param title El titulo del frame
     */
    public AppletGame(String title) {
        super(title);
        contenedor = getContentPane();

        panelJuego = new Demo2();
        contenedor.add(panelJuego, BorderLayout.CENTER);

        panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
        puntuacion = new Puntuacion();
        panelSur.add(puntuacion);
        contenedor.add(panelSur, BorderLayout.SOUTH);

        panelJuego.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                // Point referencia = panelJuego.getBallCoordinates();
                // Point mouse = me.getPoint();
                // if (mouse.getX() >= referencia.getX() && mouse.getX() <= referencia.getX() + panelJuego.DIAMETRO) {
                //     if (mouse.getY() >= referencia.getY() && mouse.getY() <= referencia.getY() + panelJuego.DIAMETRO) {
                //         puntuacion.scorePoints(10);
                //     }
                // }

                Point ballPos = panelJuego.getBallCoordinates();
                Point mousePos = me.getPoint();

                // Calculamos el centro de la bola
	double ballCenterX = ballPos.getX() + panelJuego.DIAMETRO / 2;
                double ballCenterY = ballPos.getY() + panelJuego.DIAMETRO / 2;

                // Calculamos la distancia entre el punto del clic y el centro de la bola
                double distancia = Math.sqrt(
                        Math.pow(mousePos.getX() - ballCenterX, 2)
                        + Math.pow(mousePos.getY() - ballCenterY, 2)
                );

                // Si la distancia es menor que el radio, el clic está dentro de la bola
                if (distancia <= panelJuego.DIAMETRO / 2) {
                    puntuacion.scorePoints(10);
                }
            }
        });

        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        panelJuego.cicloPrincipalJuego();
    }

    /**
     * Metodo principal (main), los parametros de la linea de comandos son
     * ignorados
     *
     * @param args Parametros de la linea de comandos (no son usados dentro del
     * programa)
     */
    public static void main(String[] args) {
        new AppletGame("Applet Game Demo");
    }
}
