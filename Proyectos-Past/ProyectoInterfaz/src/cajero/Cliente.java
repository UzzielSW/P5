package cajero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import JButton;
import JOptionPane;
public class Cliente {
    private Socket socket;
//    private DataInputStream bufferDeEntrada = null;
//    private DataOutputStream bufferDeSalida = null;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    InicioGUI gui;
    JButton btnInicioSesion;

    public Cliente() {
        gui = new InicioGUI();
        gui.setVisible(true);
        
        btnInicioSesion = gui.getBtnInicio();
        btnInicioSesion.addActionListener(new Login());
    }
    
//    Scanner teclado = new Scanner(System.in);
//    final String COMANDO_TERMINACION = "salir()";

    public void levantarConexion(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            mostrarTexto("Conectado a :" + socket.getInetAddress().getHostName());
        } catch (Exception e) {
            mostrarTexto("Excepción al levantar conexión: " + e.getMessage());
//            System.exit(0);
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public void abrirFlujos() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
//            out.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void enviar(Cuenta obj) {
        try {
            if(obj != null)
                out.writeObject(obj);
            else
                System.out.println("obj null");
            
//            out.flush();
//            bufferDeSalida.writeUTF(s);
//            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en enviar(): " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            in.close();
            out.close();
            socket.close();
            mostrarTexto("Conexión terminada");
        } catch (IOException e) {
            mostrarTexto("IOException on cerrarConexion()");
        }finally{
//            System.exit(0);
        }
    }

    public void ejecutarConexion(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    levantarConexion(ip, puerto);
                    abrirFlujos();
                    recibirDatos();
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }

    public void recibirDatos() {
        Cuenta temp;
        try {
            do {
                temp = (Cuenta) in.readObject();
//                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n [Servidor] => " + temp.toString());
                mostrarTexto("\n [Cliente] => ");
//            } while (!st.equals(COMANDO_TERMINACION));
            } while (temp != null);
        } catch (IOException e) {
            cerrarConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    public void escribirDatos() {
        String entrada = "";
        while (true) {
            System.out.print("\n [Cliente] => ");
            entrada = teclado.nextLine();
            if(entrada.length() > 0)
                enviar(entrada);
        }
    }*/
    
    class Login implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(gui.Validar()){
                Cuenta temp = gui.getDataClient();
                System.out.println(temp.toString());
                if(temp != null)
                    enviar(temp);
            }else
                JOptionPane.showMessageDialog(null, "Llene todos los datos para poder iniciar sesion", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] argumentos) {
        Cliente cliente = new Cliente();
        
        
        
        cliente.ejecutarConexion("localhost", 20000);
//        cliente.escribirDatos();
        
        
    }
}
