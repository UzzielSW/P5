
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.DefaultCaret;

public class FabricaPapelGui extends JFrame {
    private JLabel labelCajas;
    private JTextField inputCajas;
    private JLabel labelPapel;
    private JTextField inputPapel;
    private JButton start;
    private JButton clear;

    private JTextArea txArea1, txArea2;

    private Caja caja;
    private Persona[] personas;
    private Supervisor supervisor;

    public FabricaPapelGui() {
        setTitle("Simulación de Fábrica de Papel");
        setSize(800, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        labelCajas = new JLabel("Ingrese la cantidad de Cajas a fabricar:");
        inputCajas = new JTextField(10);
        labelPapel = new JLabel("Ingrese la cantidad de Papel por Caja:");
        inputPapel = new JTextField(10);
        start = new JButton("Comenzar");
        clear = new JButton("Limpiar");

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2));
        
        topPanel.add(labelCajas);
        topPanel.add(inputCajas);
        topPanel.add(labelPapel);
        topPanel.add(inputPapel);
        topPanel.add(start);
        topPanel.add(clear);
        
        txArea1 = new JTextArea(15, 30);
        txArea1.setEditable(false);
        JScrollPane scrol1 = new JScrollPane(txArea1);
        scrol1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultCaret caret = (DefaultCaret) txArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        txArea2 = new JTextArea(15, 30);
        txArea2.setEditable(false);
        JScrollPane scrol2 = new JScrollPane(txArea2);
        scrol2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultCaret caret2 = (DefaultCaret) txArea2.getCaret();
        caret2.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(0, 5));
        
        centerPanel.add(scrol1, BorderLayout.WEST);
        centerPanel.add(scrol2, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        pack();

        start.setEnabled(true);
        clear.setEnabled(false);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txArea1.setText("");
                txArea2.setText("");
                int cantCajas = Integer.parseInt(inputCajas.getText().trim());
                int cantPapel = Integer.parseInt(inputPapel.getText().trim());
                
                caja = new Caja(cantCajas, cantPapel);
                personas = new Persona[3];
                supervisor = new Supervisor(caja, 4, txArea2);
                
                for (int i = 0; i < 3; i++) {
                    personas[i] = new Persona(caja, i + 1, txArea1);
                }

                start.setEnabled(false);
                clear.setEnabled(false);
                
                new Thread(() -> {
                    for (int i = 0; i < 3; i++) {
                        personas[i].start();
                    }
                    supervisor.start();
                    
                    try {
                        Thread.sleep(1000 * Math.max(cantPapel, cantCajas));
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    
                    txArea2.append("\n\nCaja Actual tiene: " + caja.getCantPapelActual() + "\n");
                    txArea2.append("Cantidad de cajas llenas: " + caja.getCantCajaActual() + "\n");
                    txArea2.append("Cantidad Máxima de cajas: " + caja.getMaxCantCajas() + "\n");
                    
                    start.setEnabled(false);
                    clear.setEnabled(true);
                }).start();
            }
        });

        clear.addActionListener(e -> {
            start.setEnabled(true);
            clear.setEnabled(false);
            inputCajas.setText("");
            inputPapel.setText("");
            txArea1.setText("");
            txArea2.setText("");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FabricaPapelGui().setVisible(true));
    }
}
