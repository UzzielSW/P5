public interface IChatServer extends java.rmi.Remote {

   public void login(String name, IChatClient newClient)
         throws java.rmi.RemoteException;

   public void logout(String name)
         throws java.rmi.RemoteException;

   public void send(Message message)
         throws java.rmi.RemoteException;
}
