package Banco;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import *;
import static JFrame.EXIT_ON_CLOSE;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import text.DefaultCaret;

public final class AdministradorServer extends JFrame implements ActionListener {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatMonokaiProIJTheme());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        AdministradorServer v1 = new AdministradorServer(new RegistroCuentas());
        v1.setVisible(true);
        final int PUERTO = 9999;
        int count = 1;

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            v1.txArea.setText("Servidor del Administrador Iniciado");

            while (true) {
                Socket socket = servidor.accept();

                v1.txArea.append(new Date() + ": peticion de cliente " + socket.getInetAddress().getHostAddress() + "\n");

                new PendienteThread(v1.cuentas, socket, v1.txArea, count++).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(AdministradorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JPanel panelR, panelL;
    private JTextArea txArea;
    private JButton btnVer, btnLimpiar, btnCrear, btnG;
    private JTextField tfNombre, tfClave, tfSaldo, tfTipo, tfFecha, tfBuscar;
    RegistroCuentas cuentas;

    public AdministradorServer(RegistroCuentas cuentas) {
        this.cuentas = cuentas;

        this.setSize(700, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Administrador (Server)");
        this.setLocationRelativeTo(null); //centrar frame
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        agregarPanel();
        componentesPanelR();
        componentesPanelL();

        this.pack();
    }

    public void agregarPanel() {
        panelR = new JPanel();
        BoxLayout ly = new BoxLayout(panelR, BoxLayout.Y_AXIS);
        panelR.setLayout(ly);
        panelR.setSize(300, 500);
        panelL = new JPanel(new GridBagLayout());
        panelR.setSize(400, 500);

        this.getContentPane().add(panelL);
        this.getContentPane().add(panelR);
    }

    private void componentesPanelR() {

        JLabel tituloPanel1 = new JLabel("crear cuenta bancaria");
        tituloPanel1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        panelR.add(tituloPanel1);

        panelR.add(Box.createVerticalStrut(30)); //espaciado

        JLabel lbNombre = new JLabel("Nombre de Usuario");
        lbNombre.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        panelR.add(lbNombre);

        tfNombre = new JTextField();
        panelR.add(tfNombre);

        JLabel lbSaldo = new JLabel("Saldo Inicial");
        lbSaldo.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        panelR.add(lbSaldo);

        tfSaldo = new JTextField();
        panelR.add(tfSaldo);

        JLabel lbTipo = new JLabel("Tipo de Cuenta");
        lbTipo.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        panelR.add(lbTipo);

        tfTipo = new JTextField();
        panelR.add(tfTipo);

        JLabel lbClave = new JLabel("Clave");
        lbClave.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        panelR.add(lbClave);

        tfClave = new JTextField();
        panelR.add(tfClave);

        JLabel lbFecha = new JLabel("Fecha de creacion");
        lbFecha.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        panelR.add(lbFecha);

        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        tfFecha = new JTextField(fecha.format(formato));
        tfFecha.setEditable(false);
        tfFecha.setName("fecha");
        panelR.add(tfFecha);

        panelR.add(Box.createVerticalStrut(20)); //espaciado

        btnCrear = new JButton("crear cuenta");
        btnCrear.addActionListener(this);
        panelR.add(btnCrear);

        panelR.add(Box.createVerticalStrut(10)); //espaciado

        btnLimpiar = new JButton("limpiar campos");
        btnLimpiar.addActionListener(this);
        panelR.add(btnLimpiar);

        panelR.add(Box.createVerticalStrut(10)); //espaciado

        btnG = new JButton("Generar");
        btnG.addActionListener(this);
        panelR.add(btnG);
    }

    public void componentesPanelL() {
        txArea = new JTextArea();
        txArea.setPreferredSize(new Dimension(400, 400));
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
        constraints.gridwidth = 2; // Establecer el número de columnas que el botón debe abarcar
        constraints.gridheight = 1; // Establecer el número de filas que el botón debe abarcar
        constraints.fill = GridBagConstraints.BOTH; // Establecer el modo de relleno del botón
        panelL.add(scrol, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
//        constraints.fill = GridBagConstraints.BOTH;
        btnVer = new JButton("ver - buscar");
        btnVer.addActionListener(this);
        panelL.add(btnVer, constraints);

        constraints.gridx = 1;
        tfBuscar = new JTextField();
        panelL.add(tfBuscar, constraints);
    }

    public void clear() {
        for (Component c : panelR.getComponents()) {
            // Si el componente es un JTextField lo limpia
            if (c instanceof JTextField) {
                if (((JTextField) c).getName() == "fecha") {
                    continue;
                }
                ((JTextField) c).setText("");
            }
        }

        tfBuscar.setText("");
    }

    public void rellenarCampos() {
        String[] nombres = {"Juan", "Ana", "Carlos", "Maria"};
        double[] saldos = {1000.0, 2000.0, 3000.0, 4000.0};
        String[] tipos = {"Ahorro", "Corriente", "(CDs)", "Inversiones"};
        String[] claves = {"1234", "4567", "7890", "9876"};

        Random rand = new Random();

        tfNombre.setText(nombres[rand.nextInt(nombres.length)]);
        tfSaldo.setText(Double.toString(saldos[rand.nextInt(saldos.length)]));
        tfTipo.setText(tipos[rand.nextInt(tipos.length)]);
        tfClave.setText(claves[rand.nextInt(claves.length)]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCrear) {
            crearCuenta();
        }

        if (e.getSource() == btnLimpiar) {
            clear();
        }

        if (e.getSource() == btnG) {
            rellenarCampos();
        }

        if (e.getSource() == btnVer) {
            if (cuentas.arregloCuentas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay cuentas agregadas");
                return;
            }

            txArea.setText("(i)\tnombre\tIDcuenta\tsaldo\tclave\ttipo\n");

            if (tfBuscar.getText().length() == 5) {
                int id = Integer.parseInt(tfBuscar.getText());
                if (cuentas.buscaCuentaID(id) == true) {
                    txArea.append("(1)\t" + cuentas.obtenerCuenta(id).toString());
                }
                clear();
            } else {
                for (int x = 0; x < cuentas.arregloCuentas.size(); x++) {
                    txArea.append("(" + (x + 1) + ")\t" + cuentas.arregloCuentas.get(x).toString());
                }
            }
        }
    }

    public void crearCuenta() {

        if (tfNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor coloque el nombre");
            return;
        }
        if (tfSaldo.getText().length() == 0 || Double.parseDouble(tfSaldo.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Por favor coloque el saldo inicial correctamente");
            return;
        }
        if (tfTipo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor coloque el tipo de cuenta");
            return;
        }
        if (tfClave.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Por favor coloque la clave");
            return;
        }

        // creacion de ID
        int id = (int) (Math.random() * 90000) + 10000;
//        si no esta vacio el registro verifica que el id creado no coincida con uno existente
        if (!cuentas.vacio()) {
            while (cuentas.buscaCuentaID(id) == true) {
                id = (int) (Math.random() * 90000) + 10000;
            }
        }

        CuentaBancaria cuenta = new CuentaBancaria(tfNombre.getText(), id, Double.parseDouble(tfSaldo.getText()), tfTipo.getText(), tfClave.getText(), tfFecha.getText());
        cuentas.agregarCuenta(cuenta);
        txArea.setText("cuenta creada exitosamente");
        clear();
    }

    static class PendienteThread extends Thread {

        private Socket socket;
        private CuentaBancaria usuario;
        private RegistroCuentas cuentas;
        private int ncliente;
        private JTextArea txArea;
        private ObjectInputStream in;
        private ObjectOutputStream out;

        public PendienteThread(RegistroCuentas cuentas, Socket socket, JTextArea txArea, int clientNo) {
            this.cuentas = cuentas;
            this.socket = socket;
            this.txArea = txArea;
            this.ncliente = clientNo;

            try {
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println(new Date() + "Error en (in/out) en el Thread " + ncliente + "\n");
            }
        }

        @Override
        public void run() {
            txArea.append(new Date() + ": Thread " + ncliente + " iniciado\n");
            Object obj = null;
            try {
                obj = in.readObject();
                usuario = (CuentaBancaria) obj;

                //verificando datos de usuario ingresado
                usuario = cuentas.VerificarCuenta(usuario);

                if (usuario.getVerificar()) {
                    txArea.append("Usuario: " + usuario.getNombre() + " inicio sesion\n");
                    OperacionesCliente vUser = new OperacionesCliente(cuentas, usuario.getCuentaId());
                    vUser.setVisible(true);
                }

                out.writeObject(usuario);

                socket.close();
                in.close();
                out.close();

            } catch (ClassCastException | ClassNotFoundException ex) {
                txArea.append("\nSe actualizo el registro de las cuentas");
                cuentas = (RegistroCuentas) obj;
//                txArea.append("\nregistro actualizado: " + cuentas.toString());
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    } // fin de la clase interna PendienteThread
}
