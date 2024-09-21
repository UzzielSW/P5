package Banco;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import Box;
import JButton;
import JFrame;
import JLabel;
import JOptionPane;
import JPanel;
import JScrollPane;
import JTextArea;
import JTextField;
import ScrollPaneConstants;
import SwingConstants;
import text.DefaultCaret;

public class OperacionesCliente extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField tfMonto;
    private JButton btnDepositar, btnRetirar, btnEstado, btnSalir;
    private JTextArea txArea;
    private RegistroCuentas cuentas;
    private int id;
    final String HOST = "localhost";
    final int PUERTO = 9999;

    public OperacionesCliente(RegistroCuentas cuentas, int id) {
        this.id = id;
        this.cuentas = cuentas;

        this.setSize(500, 500);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setTitle("Operaciones(cliente)");
        this.setLocationRelativeTo(null); //centrar frame
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.setLocationByPlatform(true);

        panel = new JPanel(new GridBagLayout());
        panel.setSize(400, 400);

        this.getContentPane().add(panel);
        ComponentesPanel();
        this.pack();
    }

    public void ComponentesPanel() {
        txArea = new JTextArea();
        txArea.setPreferredSize(new Dimension(400, 300));
        txArea.setEditable(false);
        JScrollPane scrol = new JScrollPane(txArea);
        scrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrol.setAutoscrolls(true);
        txArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        scrol.setViewportView(txArea);
        //para hacer auto scroll
        DefaultCaret caret = (DefaultCaret) txArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // Establecer la columna inicial del botón
        constraints.gridy = 0; // Establecer la fila inicial del botón
        constraints.gridwidth = 3; // Establecer el número de columnas que el botón debe abarcar
        constraints.gridheight = 1; // Establecer el número de filas que el botón debe abarcar
        constraints.fill = GridBagConstraints.BOTH; // Establecer el modo de relleno del botón
        panel.add(scrol, constraints);

        //        -----------------------------
        constraints.gridy = 1;
        constraints.weightx = 0.25;
        constraints.gridwidth = 1;
        btnDepositar = new JButton("Depositar");
        btnDepositar.addActionListener(this);
        panel.add(btnDepositar, constraints);

        constraints.gridx = 1;
        btnRetirar = new JButton("Retirar");
        btnRetirar.addActionListener(this);
        panel.add(btnRetirar, constraints);

        constraints.gridx = 2;
        btnEstado = new JButton("Estado");
        btnEstado.addActionListener(this);
        panel.add(btnEstado, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        panel.add(Box.createVerticalStrut(10), constraints); //espaciado
//        -----------------------------
        constraints = new GridBagConstraints();
        constraints.gridheight = 1; // Establecer el número de filas que el botón debe abarcar
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        btnSalir = new JButton("Salir");
        Color colorbtn = Color.decode("#d00101");
        btnSalir.setBackground(colorbtn);
        btnSalir.setForeground(Color.BLACK);
        btnSalir.addActionListener(this);
        panel.add(btnSalir, constraints);

        constraints.gridx = 1;
        constraints.gridwidth = 1;
        JLabel monto = new JLabel("Monto: $");
        monto.setHorizontalAlignment(SwingConstants.CENTER);
        monto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        panel.add(monto, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        tfMonto = new JTextField();
        panel.add(tfMonto, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnEstado) {
            txArea.setText(":::::Estado de cuenta::::::\n");
            txArea.append("nombre\tsaldo\ttipo\n");
            txArea.append(cuentas.arregloCuentas.get(cuentas.getIndice(id)).toString2());
            return;
        }

        if (e.getSource() == btnSalir) {
            txArea.setText("Saliendo...\n");
            try {
                Socket socket = new Socket(HOST, PUERTO);
                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
                toServer.writeObject(cuentas);

                socket.close();
                toServer.close();

                txArea.append("Se enviaron correctamente los datos actualizados\n");

//                Cliente inicio = new Cliente(cuentas);
//                inicio.setVisible(true);
            } catch (IOException ex) {
                txArea.append("error en el envio al servidor");
            }
            
            this.setVisible(false);
            this.dispose();
            return;
        }

        if (tfMonto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un monto para poder relizar la transaccion");
        }

        if (e.getSource() == btnDepositar) {
            Thread hiloDeposita = new Depositar(cuentas, txArea, Double.parseDouble(tfMonto.getText()), id);
            hiloDeposita.start();
            tfMonto.setText("");
        }

        if (e.getSource() == btnRetirar) {
            Thread hiloRetira = new Retirar(cuentas, txArea, Double.parseDouble(tfMonto.getText()), id);
            hiloRetira.start();
            tfMonto.setText("");
        }
    }
}
