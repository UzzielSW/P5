
import Banco.AdministradorServer;
import Banco.CuentaBancaria;
import Banco.OperacionesCliente;
import Banco.RegistroCuentas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
public class Servidor extends JFrame {

    public static void main(String[] args) {

        Servidor v1 = new Servidor(new Factura());
        v1.setVisible(true);
        final int PUERTO = 9999;

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            v1.txArea.setText("Servidor del Restaurante Iniciado");

            while (true) {
                Socket socket = servidor.accept();

//                v1.txArea.append("\n Se envio pedido del cliente " + socket.getInetAddress().getHostAddress() + "\n");
                v1.txArea.append("\n Se envio pedido del cliente " + "\n");

                new Servidor.PendienteThread(v1.factura, socket, v1.txArea).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(AdministradorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Factura factura;
    private JTextArea txArea;
    private JPanel panel;

    public Servidor(Factura factura) {
        this.factura = factura;

        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Servidor restaurante");
        this.setLocationRelativeTo(null); //centrar frame
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        txArea = new JTextArea(25, 40);
        txArea.setEditable(false);
        JScrollPane scrol = new JScrollPane(txArea);
        scrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrol.setAutoscrolls(true);
        txArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        scrol.setViewportView(txArea);
        DefaultCaret caret = (DefaultCaret) txArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        panel = new JPanel();
        panel.add(scrol);
        this.getContentPane().add(panel);
        this.pack();
    }

    static class PendienteThread extends Thread {

        private Socket socket;
        private Pedido pedido;
        private Factura factura;
        private JTextArea txArea;
        private ObjectInputStream in;
        private ObjectOutputStream out;

        public PendienteThread(Factura factura, Socket socket, JTextArea txArea) {
            this.factura = factura;
            this.socket = socket;
            this.txArea = txArea;

            try {
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println(new Date() + "Error en (in/out) en el Thread \n");
            }
        }

        @Override
        public void run() {
            txArea.append("Thread de factura iniciado\n");
            Object obj = null;
            try {
                obj = in.readObject();
                factura = (Factura) obj;
                
                factura.calcularFactura();
                txArea.append(factura.toString());
                out.writeObject(factura);

                socket.close();
                in.close();
                out.close();

            } catch (ClassCastException | ClassNotFoundException ex) {
                System.out.println("Error de del objeto de envio");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    } // fin de la clase interna PendienteThread
}
