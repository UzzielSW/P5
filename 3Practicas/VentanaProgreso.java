import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;

public class VentanaProgreso extends JFrame {

    public static void main(String[] args) {
        VentanaProgreso ventana = new VentanaProgreso();
        ventana.setVisible(true);
    }

    private Container panelPrincipal = null;
    private JButton botonEmpezar, botonParar;
    private JTextField campoEntrada, campoResultado;
    private ProgressMonitor pMonitor = null;
    private Timer reloj = null;

    private int suma, contador;

    public VentanaProgreso() {
        suma = contador = 0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 100);

        panelPrincipal = this.getContentPane();
        panelPrincipal.setLayout(new GridLayout(2, 1));

        Box caja = Box.createHorizontalBox();
        panelPrincipal.add(caja);

        caja.add(Box.createHorizontalGlue());
        JLabel etiq1 = new JLabel("Suma del 1 al ", JLabel.LEFT);
        etiq1.setFont(new Font("Dialog", Font.PLAIN, 15));
        caja.add(etiq1);

        campoEntrada = new JTextField("100", 4);
        caja.add(campoEntrada);

        JLabel etiq2 = new JLabel(" Resultado: ", JLabel.LEFT);
        etiq2.setFont(new Font("Dialog", Font.PLAIN, 15));
        caja.add(etiq2);

        campoResultado = new JTextField(10);
        caja.add(campoResultado);
        caja.add(Box.createHorizontalGlue());

        // 4. Otra caja horizontal

        Box caja2 = Box.createHorizontalBox();
        panelPrincipal.add(caja2);

        // 5. Botones de empezar y acabar

        botonEmpezar = new JButton("Empezar");
        botonEmpezar.addActionListener(new EscuchaBoton());
        caja2.add(Box.createHorizontalGlue());
        caja2.add(botonEmpezar);
        caja2.add(Box.createHorizontalGlue());

        // botn para parar la suma
        botonParar = new JButton("Parar");
        botonParar.addActionListener(new EscuchaBoton());
        caja2.add(Box.createHorizontalGlue());
        caja2.add(botonParar);
        caja2.add(Box.createHorizontalGlue());

        // 6. creamos un reloj
        // el primer parmetros es el nm. de milisegundos
        // que pasa entre cada llamada a la escucha
        // 10 significa llamar constantemente
        reloj = new Timer(100, new EscuchaReloj());
    }

    // 7. Aqu se hace todo

    class EscuchaReloj implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (Integer.parseInt(campoEntrada.getText()) > 0) {
                contador++;
                suma += contador;
                pMonitor.setProgress(contador);
                pMonitor.setNote("Sumando " + contador);
                campoResultado.setText(Integer.toString(suma));
            } else {
                campoResultado.setText("0");
            }

            if (contador >= Integer.parseInt(campoEntrada.getText())) {
                reloj.stop();
                botonEmpezar.setEnabled(true);
            }
        }
    }

    // 8. Escucha de los botones

    class EscuchaBoton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            if (button.getText() == "Empezar") {
                botonEmpezar.setEnabled(false);

                // 9. Crear una barra de progreso
                pMonitor = new ProgressMonitor(null,
                        "suma en progreso...",
                        "Nota", 0, 100);

                // tiempo que pasa hasta que se muestra en ms
                // si no se pone no aparece la barra de progreso
                pMonitor.setMillisToPopup(0);

                campoResultado.setText("");
                if (campoEntrada.getText() != " ") {
                    // tamao de la barra
                    pMonitor.setMaximum(Integer.parseInt(
                            campoEntrada.getText()));
                    suma = contador = 0;
                    // empezar a utilizar el reloj
                    reloj.start();
                }
            } else if (button.getText() == "Parar") {
                botonEmpezar.setEnabled(true);
                // paramos el reloj y cerramos el monitor
                reloj.stop();
                pMonitor.close();
                campoResultado.setText("");
                suma = contador = 0;
            }
        }
    }
}
