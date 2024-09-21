package cajero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import JOptionPane;

public class Cliente {

//    public void enviar(Cuenta obj) {
//        try {
//            if(obj != null)
//                out.writeObject(obj);
//            else
//                System.out.println("obj null");
//            
////            out.flush();
////            bufferDeSalida.writeUTF(s);
////            bufferDeSalida.flush();
//        } catch (IOException e) {
//            mostrarTexto("Error en enviar(): " + e.getMessage());
//        }
//    }
//    public void cerrarConexion() {
//        try {
//            in.close();
//            out.close();
//            socket.close();
//            mostrarTexto("Conexión terminada");
//        } catch (IOException e) {
//            mostrarTexto("IOException on cerrarConexion()");
//        } finally {
////            System.exit(0);
//        }
//    }
//    public void ejecutarConexion(String ip, int puerto) {
//        Thread hilo = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    levantarConexion(ip, puerto);
//                    abrirFlujos();
//                    recibirDatos();
//                } finally {
//                    cerrarConexion();
//                }
//            }
//        });
//        hilo.start();
//    }
//    public void recibirDatos() {
//        try {
//            do {
//                Cuenta temp = (Cuenta) in.readObject();
////                st = (String) bufferDeEntrada.readUTF();
//                mostrarTexto("\n [Servidor] => " + temp.toString());
//                mostrarTexto("\n [Cliente] => ");
////            } while (!st.equals(COMANDO_TERMINACION));
//            } while (true);
//        } catch (IOException e) {
//            cerrarConexion();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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
//    class Login implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            
//            if(gui.Validar()){
//                Cuenta temp = gui.getDataClient();
//                System.out.println(temp.toString());
//                if(temp != null)
//                    enviar(temp);
//            }else
//                JOptionPane.showMessageDialog(null, "Llene todos los datos para poder iniciar sesion", "Aviso", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    public static void main(String[] args) {
        
        try {
//            Scanner input = new Scanner(System.in);
            Socket socket = new Socket("localhost", 9999);
//            System.out.println("Conectado a: " + socket.getInetAddress().getHostName());
            System.out.println("\nConectado a:" + socket.getRemoteSocketAddress());

//            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
//            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
            String opc = "Valida";
            out.writeUTF(opc);
            System.out.println("Se envio String");
//        do {
//                Cuenta temp = new Cuenta("a", "a", "0", "admin", "0000", "0", 0.00, 1000000000);
//                System.out.print("\033[H\033[2J");
//                System.out.flush();
//                System.out.println("\n\nBanco x");
//                
//                System.out.println("Ingrese su nombre: ");
//                temp.setNombre(input.nextLine());
//                System.out.println("Ingrese su apellido: ");
//                temp.setApellido(input.nextLine());
//                System.out.println("Ingrese su cedula: ");
//                temp.setCedula(input.nextLine());
//                System.out.println("Ingrese su clave: ");
//                temp.setClave(input.nextLine());
//        } while (!cliente.sesionIniciada);
//        cliente.escribirDatos();
//        cliente.cerrarConexion();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

//        } while (!cliente.sesionIniciada);
//        cliente.escribirDatos();
//        cliente.cerrarConexion();
    }
}
