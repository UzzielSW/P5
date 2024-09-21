package chatrmi;

import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import *;
import java.awt.*;

public class ChatClient extends UnicastRemoteObject implements IChatClient {

    ChatFrame gui;
    String name;
    IChatServer server;
    String serverUrl;

    public ChatClient(String name, String url) throws RemoteException {
        this.name = name;
        serverUrl = url;

        // GUI erzeugen und Events behandeln:
        // Nach Texteingaben wird sendTextToChat(),
        // bei Schlie�en des Fensters wird disconnect() aufgerufen.
        gui = new ChatFrame("Chat mit RMI");
        gui.input.addKeyListener(new EnterListener(this, gui));
        gui.addWindowListener(new ExitListener(this));

        connect();
    }

    private void connect() {
        try {
            //server = (IChatServer) java.rmi.Naming.lookup("rmi://"+serverUrl+ "/ChatServer");
            //  server = (IChatServer) java.rmi.Naming.lookup("//alvaro-h2ux8wow/ChatServer");
            //server = (IChatServer) java.rmi.Naming.lookup("//HP-173575/ChatServer");
            server = (IChatServer) java.rmi.Naming.lookup("//" + serverUrl + "/ChatServer");
            server.login(name, this);
        } catch (Exception e) {
            e.printStackTrace();
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

    public void receiveEnter(String name) {
        gui.output.append(name + " entered \n");
    }

    public void receiveExit(String name) {
        gui.output.append(name + " left \n");
    }

    public void receiveMessage(Message message) {
        gui.output.append(message.name + ": " + message.text + "\n");
    }

    public static void main(String[] args) {

        String nombre = (String) JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario: ",
                "Ingreso del Usuario", JOptionPane.QUESTION_MESSAGE);
        String host = (String) JOptionPane.showInputDialog(null, "Ingrese el nombre del host ",
                "Ingreso del Usuario", JOptionPane.QUESTION_MESSAGE);
        // if (args.length==2) {
        if (nombre.length() != 0 && host.length() != 0) {
            try {

                new ChatClient(nombre, host);
                // new ChatClient(args[0],args[1]);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Su Entrada es incorrecta !", "Usage: java ChatClient <server> <port>",
                    JOptionPane.ERROR_MESSAGE);
            //System.out.println("Usage: java ChatClient <server> <port>");
            System.exit(0);

        }

    }
}
