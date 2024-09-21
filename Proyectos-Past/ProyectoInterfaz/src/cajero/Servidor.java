package cajero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import JButton;
import JFrame;
import JPanel;
import JScrollPane;
import JTextArea;
import ScrollPaneConstants;
import text.DefaultCaret;

public class Servidor extends JFrame {

    private Socket socket;
    private ServerSocket serverSocket;
//    private DataInputStream bufferDeEntrada = null;
//    private DataOutputStream bufferDeSalida = null;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    Scanner escaner = new Scanner(System.in);
//    final String COMANDO_TERMINACION = "salir()";
    ConcurrentHashMap usuarios;
    JPanel panel;
    JButton btn;
    JTextArea consola;

    public Servidor() {
        super("Servidor");
        iniciarGUI();
        cargarData();
    }

    private void iniciarGUI() {
        setSize(500, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());

        consola = new JTextArea();
        consola.setEditable(false);
        JScrollPane scrol = new JScrollPane(consola);
        scrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultCaret caret = (DefaultCaret) consola.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        panel.add(scrol, BorderLayout.CENTER);

        btn = new JButton("Desconectar");
        btn.setForeground(Color.BLACK);
        Color colorbtn = Color.decode("#eb0002");
        btn.setBackground(colorbtn);
        panel.add(btn, BorderLayout.SOUTH);
        btn.addActionListener((ActionEvent e) -> {
            cerrarConexion();
        });

        add(panel);
        setVisible(true);
    }

    private void cargarData() {
        mostrarTexto("Cargando datos:");
        usuarios = new ConcurrentHashMap();

        try {
            Scanner input = new Scanner(new File("src/cajero/proyecto1_lista.txt"));
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split(", ");
//                Miguel, López, 5-5555-5555, Masculino, 6159, 55, 2100, 4000
                Cuenta temp = new Cuenta(line[0], line[1], line[2], line[3], line[4], line[5], Double.parseDouble(line[6]), Double.parseDouble(line[7]));
//                mostrarTexto(temp.toString());
                usuarios.put(temp.getClave(), temp);
            }

            input.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void levantarConexion(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            mostrarTexto("Esperando conexión entrante en el puerto " + String.valueOf(puerto) + "...");
            socket = serverSocket.accept();
            mostrarTexto("Conexión establecida con: " + socket.getInetAddress().getHostName() + "\n\n");
        } catch (Exception e) {
            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
            System.exit(0);
        }
    }

    public void flujos() {
        try {
//            bufferDeEntrada = new DataInputStream(socket.getInputStream());
//            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void recibirDatos() {
        try {
            do {
                Cuenta temp = (Cuenta) in.readObject();
//                st = (String) bufferDeEntrada.readUTF();

//                mostrarTexto("\n [Cliente] => " + temp.toString() + "");
                mostrarTexto("\n Validando => " + temp.toString() + "");
                if (usuarios.containsKey(temp.getClave())) {
                    mostrarTexto("\n [Servidor] => El usuario inicio sesion");
                } else {
                    mostrarTexto("\n [Servidor] => El usuario no se encuentra registrado");
                }

//            } while (!st.equals(COMANDO_TERMINACION));
            } while (true);
        } catch (IOException e) {
            cerrarConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviar(Cuenta obj) {
        try {
            out.writeObject(obj);
            out.flush();
//            bufferDeSalida.writeUTF(s);
//            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en enviar(): " + e.getMessage());
        }
    }

    public void mostrarTexto(String s) {
        consola.append("\n [Servidor] => " + s);
    }

    /*
    public void escribirDatos() {
//        while (true) {
            System.out.print("[Usted] => ");
            enviar(escaner.nextLine());
//        }
    }
     */
    public void cerrarConexion() {
        try {
//            bufferDeEntrada.close();
//            bufferDeSalida.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
        } finally {
            mostrarTexto("[Servidor] => Conversación finalizada....");
            System.exit(0);
        }
    }

    public void ejecutarConexion(int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        levantarConexion(puerto);
                        flujos();
                        recibirDatos();
                    } finally {
                        cerrarConexion();
                    }
                }
            }
        });
        hilo.start();
    }

    public static void main(String[] args) throws IOException {
        Servidor s = new Servidor();
        s.ejecutarConexion(20000); //estableciendo conexion
//        s.escribirDatos();

    }
}
