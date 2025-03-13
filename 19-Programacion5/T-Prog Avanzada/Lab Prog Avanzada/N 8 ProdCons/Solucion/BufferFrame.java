
/**
 * @(#)BufferFrame.java
 *
 * Modificado Prof. Alvaro Pino N.
 * 18/10/2010
 * @author
 * @version 1.00 2010/10/5
 */

import java.awt.*;
import java.awt.event.*;

/******************************************************************************
 * Clase BufferFrame
 * Ventana donde mostramos el hilo productor y consumidor en funcionamiento.
 * Creamos un hilo productor y otro consumidor que comparten
 * el recurso de tipo buffer de mensajes Buffer.
 ***************************************************************/

public class BufferFrame extends Frame implements ActionListener {

    // etiquetas
    Label cabecera = new Label("- Productor/Consumidor con Buffer -");
    Label proL = new Label("Productor: ");
    Label conL = new Label("Consumidor: ");
    Label bufL = new Label("Buffer: ");

    // botones
    public static Button iniciarBoton = new Button("Iniciar");
    public static Button suspenderBoton = new Button("Suspender");
    public static Button pararBoton = new Button("Parar");
    public static Button reanudarBoton = new Button("Reanudar");

    // campos de texto
    static TextField textpro = new TextField(25);
    static TextField textcon = new TextField(25);
    static TextField textbuf = new TextField(35);

    // paneles
    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    Panel panel3 = new Panel();
    Panel panel4 = new Panel();

    // objetos
    Buffer buf;
    Productor p1;
    Consumidor c1;

    public static void main(String args[]) {
        BufferFrame bf = new BufferFrame();
        bf.suspenderBoton.setEnabled(false);
        bf.reanudarBoton.setEnabled(false);
        bf.pararBoton.setEnabled(false);
    }

    // Constructor de la clase

    public BufferFrame() {
        super("Buffer Ventana");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });
        setup();
    }

    public void setup() {
        panel1.add(cabecera);
        panel3.add(iniciarBoton);
        panel3.add(pararBoton);
        panel3.add(suspenderBoton);
        panel3.add(reanudarBoton);

        // panel4.setLayout( new GridLayout(2,1));

        panel4.setLayout(new BorderLayout());
        panel4.add(panel1, BorderLayout.NORTH);
        panel4.add(panel3, BorderLayout.CENTER);

        iniciarBoton.addActionListener(this);
        pararBoton.addActionListener(this);
        suspenderBoton.addActionListener(this);
        reanudarBoton.addActionListener(this);

        panel2.setLayout(new GridLayout(3, 2, 15, 15));
        panel2.add(proL);
        panel2.add(textpro);
        panel2.add(bufL);
        panel2.add(textbuf);
        panel2.add(conL);
        panel2.add(textcon);
        // tipo de disposicin
        setLayout(new GridLayout(3, 1, 15, 15));
        add(panel4);
        add(panel3);
        add(panel2);
        pack();
        setVisible(true);// mostramos el frame

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == suspenderBoton) {
            p1.suspender();
            c1.suspender();
            suspenderBoton.setEnabled(false);
            reanudarBoton.setEnabled(true);
        } else if (ae.getSource() == reanudarBoton) {
            p1.reanudar();
            c1.reanudar();
            suspenderBoton.setEnabled(true);
            reanudarBoton.setEnabled(false);
        } else if (ae.getSource() == iniciarBoton) {
            if (p1 == null && c1 == null) {
                pararBoton.setEnabled(true);
                iniciarBoton.setEnabled(false);
                suspenderBoton.setEnabled(true);
                reanudarBoton.setEnabled(false);
                buf = new Buffer();
                p1 = new Productor(buf, 1);
                c1 = new Consumidor(buf, 1);
                p1.start();
                c1.start();
            }
        }
        // Parar
        else if (ae.getSource() == pararBoton) {
            if (p1 != null && c1 != null) {
                p1.iniciar();
                c1.iniciar();

                // campos de texto
                textpro.setText("");
                textcon.setText("");
                textbuf.setText("");

                p1.parar();
                c1.parar();

                p1 = null;
                c1 = null;

                suspenderBoton.setEnabled(false);
                reanudarBoton.setEnabled(false);
                pararBoton.setEnabled(false);
                iniciarBoton.setEnabled(true);
            }
        }
    }
}
