
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChatClient extends UnicastRemoteObject implements IChatClient {

    ChatFrame gui;
    String name;

    private final java.util.concurrent.ConcurrentLinkedQueue<String> messages = new java.util.concurrent.ConcurrentLinkedQueue<>();
    IChatServer server;
    String serverUrl;

    public ChatClient(String name, String url) throws RemoteException {
        this.name = name;
        serverUrl = url;

        gui = new ChatFrame("Chat RMI - Session: " + name);

        gui.input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendTextToChat(gui.input.getText());
                    gui.input.setText("");
                }
            }
        });

        gui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disconnect();
            }
        });

        connect();
    }

    private void connect() {
        try {
            server = (IChatServer) java.rmi.Naming.lookup("ChatServer");
            server.login(name, this);
        } catch (Exception e) {
            gui.output.setText("No se puedo conectar al Servidor");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }

            System.exit(0);
        }
    }

    protected void sendTextToChat(String text) {
        try {
            server.send(new Message(name, text));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    protected void disconnect() {
        try {
            server.logout(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitFrame() {
        gui.dispose();
        System.exit(0);
    }

    public void displayMessages() {
        StringBuilder sb = new StringBuilder("<html><body>");

        for (String message : messages) {
            sb.append(message);
        }

        sb.append("</body></html>");
        gui.output.setText(sb.toString());
    }

    public void receiveEnter(String name) {
        messages.add("<div style='border:1px solid #ccc; padding:2px; margin:1px; border-radius:10px; text-align:center; background:#f5f5f5; color:#383838; font-family:arial;'>"
                + "<b>" + name + "</b> entro al chat"
                + "</div>");
        displayMessages();
    }

    public void receiveExit(String name) {
        messages.add("<div style='border:1px solid #ccc; padding:2px; margin:1px; border-radius:10px; text-align:center; background:#f5f5f5; color:#383838; font-family:arial;'>"
                + "<b> User: " + name + "</b> salio del chat"
                + "</div>");
        displayMessages();
    }

    public void receiveMessage(Message message) {
        messages.add("<div style='border:1px solid #ccc; padding:5px; margin:3px; border-radius:10px; font-family:arial;'>"
                + "<b style='color:#0066cc;'>" + message.name + "</b><br/>"
                + "<span style='color:#333;'>" + message.text + "</span>"
                + "</div>");
        displayMessages();
    }

    public static void main(String[] args) {
        String name = "";

        JTextField textField = new JTextField(10);
        textField.setFocusable(true);

        Object[] message = {
            "¿Cual es tu nombre?", textField
        };

        Object[] options = {"Login"};

        try {
            do {
                int result = JOptionPane.showOptionDialog(null, message, "Input Dialog",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);
                textField.requestFocus();
                textField.requestFocusInWindow();

                if (result == JOptionPane.OK_OPTION) {
                    name = textField.getText();
                } else {
                    System.exit(0);
                }
            } while (name.equals(""));

            new ChatClient(name, "localhost");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
