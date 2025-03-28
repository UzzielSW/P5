
/*Eric Chen */import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Date;
import javax.swing.*;

public class RegistrationServerUsingTriangulo extends JFrame {
    private static JTextArea jtaLog;
    Triangulo triangulo;
    private static RandomAccessFile raf = null;
    Socket socket;

    public static void main(String arg[]) {
        RegistrationServerUsingTriangulo server = new RegistrationServerUsingTriangulo();
    }

    public RegistrationServerUsingTriangulo() {
        JScrollPane scrollPane = new JScrollPane(jtaLog = new JTextArea());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setTitle("Registrar Servidor");
        setVisible(true);
        try {
            raf = new RandomAccessFile("Triangulo.dat", "rw");
        } catch (IOException ex) {
            jtaLog.append(new Date() + ": Error " + ex);
            System.exit(0);
        }
        // Estableciendo Coneccion con el Servidor
        try {
            ServerSocket serversocket = new ServerSocket(8000);
            jtaLog.append(new Date() + ": Servidor Iniciado");
            int count = 1;
            while (true) {
                socket = serversocket.accept();
                jtaLog.append(new Date() + ": A Cliente " + socket.getInetAddress().getHostAddress() + " conectado\n");
                new RegistrationThread(socket, count++).start();
            }
        } catch (IOException ex) {
            jtaLog.append(new Date() + ": Error " + ex);
        }
    }

    class RegistrationThread extends Thread {
        private Socket socket1;
        private int clientNo;
        private ObjectInputStream in;
        private ObjectOutputStream toClient;

        public RegistrationThread(Socket socket1, int clientNo) {
            this.socket1 = socket1;
            this.clientNo = clientNo;
            jtaLog.append(new Date() + ": Thread " + clientNo + " Started\n");
            try {
                in = new ObjectInputStream(socket1.getInputStream());
                jtaLog.append("La Siguiente Informacion es Salvada en el Archivo\n");

                toClient = new ObjectOutputStream(socket1.getOutputStream());

            } catch (IOException ex) {
                jtaLog.append(new Date() + ": " + ex);
            }
        }

        public void run() {
            try {
                // recibe informacion del Cliente
                triangulo = (Triangulo) in.readObject();
                triangulo.toArea();
                jtaLog.append(triangulo.toString() + "\n");
                toClient.writeObject(triangulo);
                // writeToFile(triangulo,socket1);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
