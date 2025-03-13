import java.rmi.*;

interface RmiIntf extends Remote {
public String connect(String ip)throws RemoteException;
public String disconnect(String ip)throws RemoteException;
public String select(String ip)throws RemoteException;
public String insert(String s,String ip)throws RemoteException;
public String delete(String s,String ip)throws RemoteException;

}