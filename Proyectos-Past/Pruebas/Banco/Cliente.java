
// import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Cliente extends JFrame implements ActionListener {

    public static void main(String[] args) {
        // try {
        //     UIManager.setLookAndFeel(new FlatMonokaiProIJTheme());
        // } catch (Exception ex) {
        //     System.err.println("Failed to initialize LaF");
        // }
        Cliente inicio = new Cliente(new RegistroCuentas());
        inicio.setVisible(true);
    }

    final String HOST = "localhost";
    final int PUERTO = 9999;
    private JPanel panel;
    private JTextField tfCuenta;
    private JTextField tfClave;
    private JButton btnIngresar;
    RegistroCuentas cuentas;

    public Cliente(RegistroCuentas cuentas) {

        this.cuentas = cuentas;

        this.setSize(350, 320);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Iniciar Sesion");
        this.setLocationRelativeTo(null); //centrar frame
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.setLocationByPlatform(true);

        panel = new JPanel();
        BoxLayout ly = new BoxLayout(panel, BoxLayout.Y_AXIS);
        EmptyBorder padding = new EmptyBorder(10, 50, 10, 50);
        panel.setBorder(padding);
        panel.setLayout(ly);
        panel.setSize(350, 320);

        this.getContentPane().add(panel);
        ComponentesPanel();
        pack();
    }

    private void ComponentesPanel() {

        JLabel tituloPanel = new JLabel("Banco IA");
        tituloPanel.setFont(tituloPanel.getFont().deriveFont(25f));
        panel.add(tituloPanel);

        panel.add(Box.createVerticalStrut(35)); //espaciado

        JLabel lbNombre = new JLabel("Numero de Cuenta");
        lbNombre.setFont(lbNombre.getFont().deriveFont(16f));
        panel.add(lbNombre);

        tfCuenta = new JTextField();
        panel.add(tfCuenta);

        panel.add(Box.createVerticalStrut(16)); //espaciado

        JLabel lbSaldo = new JLabel("Clave");
        lbSaldo.setFont(lbSaldo.getFont().deriveFont(16f));
        panel.add(lbSaldo);

        tfClave = new JTextField();
        panel.add(tfClave);

        panel.add(Box.createVerticalStrut(30)); //espaciado

        btnIngresar = new JButton("Iniciar Sesion");
        Color colorbtn = Color.decode("#00AF46");
        btnIngresar.setBackground(colorbtn);
        btnIngresar.setForeground(Color.BLACK);
        btnIngresar.setFont(btnIngresar.getFont().deriveFont(16f));
        btnIngresar.addActionListener(this);
        panel.add(btnIngresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnIngresar) {

            if (tfCuenta.getText().length() == 0 || tfClave.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor coloque los campos de manera correcta");
                return;
            }

            String clave = tfClave.getText();
            int id = Integer.parseInt(tfCuenta.getText());

            CuentaBancaria enviar = new CuentaBancaria(id, clave);

//            iniciando coneccion con el servidor
            try {
                Socket socket = new Socket(HOST, PUERTO);
                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

                toServer.writeObject(enviar); //envio cuenta bancaria a verificar al servidor

                enviar = (CuentaBancaria) fromServer.readObject();

                if (enviar.getVerificar()) {
                    JOptionPane.showMessageDialog(null, "sesion iniciada con exito");
                    this.setVisible(false);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "no se pudo iniciar sesion. ingrese correctamente los valores");
                }

                socket.close();
                toServer.close();
                fromServer.close();

            } catch (IOException ex) {
                Logger.getLogger(OperacionesCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
