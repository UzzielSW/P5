//my
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import static java.lang.Thread.sleep;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class GUI extends JFrame {

    JPanel panel, panelS;
    JTextArea consola;
    JButton btn;
    JTextField tcajas, tpapel;
    JLabel lcajas, lpapel;

    public GUI() {
        init(); //inicializando componentes del GUI
        ajustes(); //ajustes del Jframe
    }

    private void ajustes() {
        setTitle("Fabrica de Papel");
        setSize(300, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 5));
        panelS = new JPanel(new GridLayout(2, 2, 5, 5));
//            panelS.setBackground(Color.GRAY);
        EmptyBorder padding = new EmptyBorder(5, 5, 5, 5);
        panel.setBorder(padding);

        consola = new JTextArea(20,5);
        ajustConsola();

        lcajas = new JLabel("N° Cajas:", SwingConstants.CENTER);
        lpapel = new JLabel("N° Papeles:", SwingConstants.CENTER);
        ajustLabels();

        tcajas = new JTextField(3);
        tpapel = new JTextField(3);
        ajusText();

        btn = new JButton("Iniciar");
        ajusBtn();
        btn.addActionListener((java.awt.event.ActionEvent evt) -> {
            accionBtn();
        });

        panel.add(panelS, BorderLayout.CENTER);

        add(panel);
    }

    private void ajustConsola() {
        consola.setEditable(false);
        JScrollPane scrol = new JScrollPane(consola);
        scrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        scrol.setAutoscrolls(true);
        DefaultCaret caret = (DefaultCaret) consola.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        panel.add(scrol, BorderLayout.NORTH);
    }

    private void ajustLabels() {
        lcajas.setName("lcajas");
        lcajas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        panelS.add(lcajas);

        lpapel.setName("lpapel");
//        etiqueta.setForeground(Color.red);
        lpapel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        panelS.add(lpapel);
    }

    private void ajusText() {
        tcajas.setHorizontalAlignment(JTextField.CENTER);
        tpapel.setHorizontalAlignment(JTextField.CENTER);

        panelS.add(tcajas);
        panelS.add(tpapel);
    }

    private void ajusBtn() {
        Color colorbtn = Color.decode("#00AF46");
        btn.setBackground(colorbtn);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        panel.add(btn, BorderLayout.SOUTH);
    }

    private void accionBtn() {

        Thread temp = new Thread(() -> {
            consola.setText("");
            btn.setEnabled(false);
            System.out.println("\n\n\nINICIANDO PROCESO");
            if (tcajas.getText().isEmpty() || tpapel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Rellene los campos para avanzar");
                btn.setEnabled(true);
                return;
            }

            if (!tcajas.getText().matches("-?\\d+") || !tpapel.getText().matches("-?\\d+")) {
                JOptionPane.showMessageDialog(null, "Ingrese solo valores enteros");
                btn.setEnabled(true);
                return;
            }

            int ncajas = Integer.parseInt(tcajas.getText());
            int npapel = Integer.parseInt(tpapel.getText());

            if (ncajas <= 0 || npapel <= 0) {
                JOptionPane.showMessageDialog(null, "Ingrese valores mayores que 0 ");
                btn.setEnabled(true);
                return;
            }

            Fabrica fabr = new Fabrica(ncajas, npapel, consola);
            fabr.start();

            try {
                sleep(1000 * Math.max(fabr.cantPapel, fabr.cantCajas));
                fabr.join();
            } catch (InterruptedException e) {
            }

            while (!fabr.done) {
                if (fabr.g1.activeGroupCount() == 0) {
                    fabr.done = true;
                    btn.setEnabled(true);

                    System.out.println("\nCaja Actual tiene:  " + fabr.cajita.getCantPapelActual());
                    System.out.println("Cantidad de cajas llenas:  " + fabr.cajita.getCantCajaActual());
                    System.out.println("Cantidad Maxima de cajas:  " + fabr.cajita.getMaxCantCajas());

                    consola.append("\n\nCaja Actual tiene:  " + fabr.cajita.getCantPapelActual());
                    consola.append("\nCantidad de cajas llenas:  " + fabr.cajita.getCantCajaActual());
                    consola.append("\nCantidad Maxima de cajas:  " + fabr.cajita.getMaxCantCajas());
                }
            }
        });

        temp.start();
    }

    public static void main(String[] args) {
        GUI g = new GUI();
        g.setVisible(true);
    }
}
