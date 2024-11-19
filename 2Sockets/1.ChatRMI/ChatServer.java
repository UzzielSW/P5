
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer extends UnicastRemoteObject implements IChatServer {

    ServerUI gui;
    ConcurrentHashMap<String, IChatClient> chatters = new ConcurrentHashMap<>();

    public ChatServer() throws RemoteException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            gui = new ServerUI();
            
            gui.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    gui.getjButtonFinalizar().doClick();
                }
            });
            
            gui.getjButtonFinalizar().addActionListener(e -> {
                String[] nameUsers = chatters.keySet().toArray(new String[0]);
                
                for (String nameUser : nameUsers) {
                    try {
                        logout(nameUser);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                System.exit(0);
            });
            
            gui.getjButtonDesconectar().addActionListener(e -> {
                String user = gui.getjFieldName().getText();
                
                if (!user.equals("") && chatters.containsKey(user)) {
                    gui.getjFieldName().setText("");
                    
                    try {
                        logout(user);
                    } catch (RemoteException ex) {
                        System.out.println("error desconectando usuario");
                    }
                }
            });
            
            gui.getjTextChat().addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        try {
                            send(new Message("Server", gui.getjTextChat().getText()));
                        } catch (RemoteException ex) {
                            System.out.println("Problemas al enviar chat del servidor");
                        }
                        
                        gui.getjTextChat().setText("");
                    }
                }
            });
            
            gui.setVisible(true);
        });
    }

    public synchronized void login(String name, IChatClient newClient) throws RemoteException {

        chatters.put(name, newClient);

        for (IChatClient client : chatters.values()) {
            client.receiveEnter(name);
        }

        String[] nameUsers = chatters.keySet().toArray(new String[0]);
        gui.setjListUsers(nameUsers); //actualizando lista de usuarios al Jlist

        gui.setMessageChat(new Message("Server", "Usuario <b>" + name + "</b> inicio sesion"));
    }

    public synchronized void logout(String name) throws RemoteException {

        gui.removeUser(name);
        gui.setMessageChat(new Message("Server", "Usuario <b>" + name + "</b> cerro sesion"));

        IChatClient user = chatters.get(name);
        chatters.remove(name);
        user.exitFrame();

        for (IChatClient client : chatters.values()) {
            client.receiveExit(name);
        }
    }

    public synchronized void send(Message message) throws RemoteException {

        for (IChatClient client : chatters.values()) {
            client.receiveMessage(message);
        }

        gui.setMessageChat(message);
    }

    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            // importante que el servidor se llame: ChatServer
            Naming.rebind("ChatServer", server);
        } catch (MalformedURLException | RemoteException ex) {
        }
    }
}
