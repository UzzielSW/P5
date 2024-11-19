public interface IChatClient extends java.rmi.Remote {

   public void receiveEnter(String name)
         throws java.rmi.RemoteException;

   public void receiveExit(String name)
         throws java.rmi.RemoteException;

   public void receiveMessage(Message message)
         throws java.rmi.RemoteException;
   
   public void exitFrame() throws java.rmi.RemoteException;
}
