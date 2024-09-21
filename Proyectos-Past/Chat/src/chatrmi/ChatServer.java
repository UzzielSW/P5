package chatrmi;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ChatServer extends UnicastRemoteObject implements IChatServer {

   Hashtable chatters = new Hashtable();

   public ChatServer() throws RemoteException {
   }

   public synchronized void login(String name, IChatClient newClient) throws RemoteException {
      Enumeration enumeracion = chatters.elements();
      chatters.put(name, newClient);
      // anunciar inicio de sesión a todos los clientes
      while (enumeracion.hasMoreElements()) {
         ((IChatClient) enumeracion.nextElement()).receiveEnter(name);
      }
      System.out.println("new client "+name+" is logged in");
   }

   public synchronized void logout(String name) throws RemoteException {
      chatters.remove(name);
      Enumeration enumeracion = chatters.elements();
      // logout allen Clients bekannt geben
      while (enumeracion.hasMoreElements()) {
         ((IChatClient)enumeracion.nextElement()).receiveExit(name);
      }
   }

   public synchronized void send(Message message) throws RemoteException {
      Enumeration enumeracion = chatters.elements();
      while (enumeracion.hasMoreElements()) {
         ((IChatClient)enumeracion.nextElement()).receiveMessage(message);
      }
   }

   public static void main(String[] args) {
      try {

	 ChatServer server = new ChatServer();
	 Naming.rebind("ChatServer", server);
	 System.out.println("Start Up Server...");
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
}
