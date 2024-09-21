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

    public static void main(String[] args) {
        try {
            Servidor sv = new Servidor();

            sv.levantarConexion(); //a la escucha para ir estableciendo conexion con los clientes
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private ServerSocket serverSocket;
//    Scanner escaner = new Scanner(System.in);
    ConcurrentHashMap usuarios;
    JPanel panel;
    JButton btn;
    JTextArea consola;
    final int puerto = 9999;
    int nClientes;

    public Servidor() throws IOException {
        super("Servidor");
        iniciarGUI();
        cargarData();

        nClientes = 0;
        serverSocket = new ServerSocket(puerto);
    }

    private void iniciarGUI() {
        setSize(600, 200);
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
        mostrarTexto("Cargando Data de Usuarios...");

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

    public void levantarConexion() {
        try {
            while (true) {
                mostrarTexto("Esperando conexión entrante en el puerto " + puerto + "...\n");

                Socket socketCliente = serverSocket.accept();
                nClientes++;
//                mostrarTexto("Conexión establecida con: " + socketCliente.getInetAddress().getHostName() + "\n");
                mostrarTexto("Conexión establecida con: " + socketCliente.getRemoteSocketAddress() + "\n\n");
//                ObjectInputStream in = new ObjectInputStream(socketCliente.getInputStream());
                DataInputStream in = new DataInputStream(socketCliente.getInputStream());
                String dato = in.readUTF();
                mostrarTexto("Cliente: " + dato);
                mostrarTexto("Se leyo el string");
//                new Sesion(socketCliente, nClientes, usuarios).start();

                mostrarTexto("Cliente # " + nClientes + " se ha conectado con exito...!\n");
            }
        } catch (Exception e) {
            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
//            System.exit(0);
        }
    }

    public void cerrarConexion() {
        mostrarTexto("[Servidor] => Conversación finalizada....");
        System.exit(0);
    }

//
//    public void enviar(Cuenta obj) {
//        try {
//            out.writeObject(obj);
//            out.flush();
////            bufferDeSalida.writeUTF(s);
////            bufferDeSalida.flush();
//        } catch (IOException e) {
//            mostrarTexto("Error en enviar(): " + e.getMessage());
//        }
//    }
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
//    public void ejecutarConexion(int puerto) {
//        Thread hilo = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        levantarConexion();
//                        flujos();
//                        recibirDatos();
//                    } finally {
//                        cerrarConexion();
//                    }
//                }
//            }
//        });
//        hilo.start();
//    }
    static class SesionA extends Thread {

        private Socket client;
        private ObjectInputStream in;
        private ObjectOutputStream out;
        ConcurrentHashMap usuarios;

        int numberC;

        public SesionA(Socket socket, int numberC, ConcurrentHashMap user) {
            client = socket;
            usuarios = user;
            this.numberC = numberC;

            try {
                in = new ObjectInputStream(client.getInputStream());
                out = new ObjectOutputStream(client.getOutputStream());
//            out.flush();
            } catch (IOException e) {
                System.out.println("Error en la apertura de flujos Sesion A");
            }
        }

        @Override
        public void run() {
            try {
                String test = (String) in.readObject();

                System.out.println("Cadena recibida: " + test);
//                cerrarConexion();

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Error leyendo el primer string");
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public void recibirDatos() {
//        try {
//            do {
//                Cuenta temp = (Cuenta) in.readObject();
////                st = (String) bufferDeEntrada.readUTF();
//
////                mostrarTexto("\n [Cliente] => " + temp.toString() + "");
//                System.out.println("\n Validando => " + temp.toString() + "");
//                if (usuarios.containsKey(temp.getClave())) {
//                    System.out.println("\n [Servidor] => El usuario inicio sesion");
//                } else {
//                    mostrarTexto("\n [Servidor] => El usuario no se encuentra registrado");
//                }
//
////            } while (!st.equals(COMANDO_TERMINACION));
//            } while (true);
//        } catch (IOException e) {
//            cerrarConexion();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
        }

        public void cerrarConexion() {
            try {
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
            } finally {
                System.out.println("[Servidor] => Conversación finalizada....");
                System.exit(0);
            }
        }

        public void sesion() {
            try {
                while (true) {
                    Cuenta temp;

//                do {
                    String option = (String) in.readObject();

                    if (option.equals("Valida")) {

                        System.out.println("\nValidando cliente ingresado...");
                        temp = (Cuenta) in.readObject();
                        if (usuarios.containsKey(temp.getClave())) {
                            System.out.println("usuario encontrado");
                        } else {
                            System.out.println("no se encontro el usuario");
                        }
                    }
//
//                    if (option.equals("nuevo Usuario")) {
//                        System.out.println("\ncreacion de nuevo usuario en proceso\n");
//
//                        ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
//
//                        String access = recieveAccess.readObject().toString();
//
//                        if (access.equals("proceso de registro Cancelado")) {
//                            System.out.println("\nregistro Cancelado\n");
//                        } else {
//
//                            System.out.println("\nRegistro en proceso\n");
//
//                            ObjectInputStream recieveRegisterData = new ObjectInputStream(client.getInputStream());
//
//                            String name = recieveRegisterData.readObject().toString();
//
//                            String lastName = recieveRegisterData.readObject().toString();
//
//                            String Id = recieveRegisterData.readObject().toString();
//
//                            String Password = recieveRegisterData.readObject().toString();
//
//                            String M = recieveRegisterData.readObject().toString();
//
//                            Cuenta addClient = new Cuenta(name, lastName, Id, Password);
//
//                            System.out.println("\nFin de Registro\n");
//
//                        }
//                    } /////////////////////////////////////////////////////////////////////
//                    else if (option.equals("iniciar Sesion")) {
//                        System.out.println("\nIniciando Sesion en proceso\n");
//
//                        ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
//
//                        String access = recieveAccess.readObject().toString();
//
//                        if (access.equals("inicio de sesion Cancelado")) {
//                            System.out.println("\nInicio de Sesion cancelado\n");
//                        } else
//					
//				try {
//
//                            ObjectInputStream recieveSesionData = new ObjectInputStream(client.getInputStream());
//
//                            String name = recieveSesionData.readObject().toString();
//
//                            String lastName = recieveSesionData.readObject().toString();
//
//                            sesionData = new Methods();
//
//                            sesionData.sesion(name, lastName);
//
//                            /////////////////////////////////////////////////////////
//                            ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
//
//                            String answer = sesionData.permitir;
//
//                            sendAnswer.writeObject(answer);
//
//                            if (answer.equals("si")) {
//                                ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
//
//                                String Id = sesionData.cedul;
//
//                                String m = sesionData.sald;
//
//                                sendData.writeObject(answer);
//
//                                sendData.writeObject(name);
//
//                                sendData.writeObject(lastName);
//
//                                sendData.writeObject(Id);
//
//                                sendData.writeObject(m);
//                            } else if (answer.equals("no")) {
//                                ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
//
//                                sendData.writeObject(answer);
//                            } else if (answer.equals("no hay clientes")) {
//                                ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
//
//                                sendData.writeObject(answer);
//                            }
//
//                        } catch (Exception e) {
//                        }
//
//                    } //////////////////////////////////////////////////////////////////////
//                    else if (option.equals("realizar un Deposito")) {
//                        System.out.println("Depositar en proceso\n");
//
//                        ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
//
//                        String access = recieveAccess.readObject().toString();
//
//                        if (access.equals("deposito Cancelado")) {
//                            System.out.println("\nDeposito cancelado\n");
//                        } else {
//
//                            ObjectInputStream recieveDeposit = new ObjectInputStream(client.getInputStream());
//
//                            String Deposit = recieveDeposit.readObject().toString();
//
//                            sesionData.Depositar(Deposit);
//
//                            ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
//
//                            sendAnswer.writeObject(sesionData.permitirDepo);
//
//                        }
//                    } //////////////////////////////////////////////////////////////////////
//                    else if (option.equals("realizar un Retiro")) {
//
//                        System.out.println("Retirar en proceso\n");
//
//                        ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
//
//                        String access = recieveAccess.readObject().toString();
//
//                        if (access.equals("retiro Cancelado")) {
//                            System.out.println("\nretiro Cancelado\n");
//                        } else {
//
//                            ObjectInputStream recieveWithdraw = new ObjectInputStream(client.getInputStream());
//
//                            String Withdraw = recieveWithdraw.readObject().toString();
//
//                            sesionData.Retirar(Withdraw);
//
//                            ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
//
//                            sendAnswer.writeObject(sesionData.permitirWith);
//
//                        }
//                    } else if (option.equals("Visualizar Clientes")) {
//                        System.out.println("\nVisualizacion de Clientes en proceso\n");
//
//                        ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
//
//                        LinkedList clientsList = new LinkedList();
//
//                        if (dataFile.exists()) {
//
//                            ObjectInputStream extract = new ObjectInputStream(new FileInputStream(new File("clientes.txt")));
//
//                            clientsList = (LinkedList) extract.readObject();
//
//                            sendData.writeObject(clientsList);
//
//                        } else {
//
//                            sendData.writeObject(clientsList);
//
//                        }
//                    } //////////////////////////////////////////////////////////////////////
//                    else if (option.equals("End Program !")) {
//                        System.out.println("\nFinalizando en proceso\n");
//
//                        try {
//
//                            Thread.sleep(2000);
//
//                        } catch (InterruptedException s) {
//                        }
//                    } else if (option.equals("Consultar Balance")) {
//                        System.out.println("\nConsulta de Balance en proceso\n");
//
//                        ObjectOutputStream sendactualBalance = new ObjectOutputStream(client.getOutputStream());
//
//                        sesionData.seeBalance();
//
//                        sendactualBalance.writeObject(sesionData.Balance);
//                    }
//
//                } while (!option.equals("salir"));
                }

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception d) {
            }
        }
    }
}
