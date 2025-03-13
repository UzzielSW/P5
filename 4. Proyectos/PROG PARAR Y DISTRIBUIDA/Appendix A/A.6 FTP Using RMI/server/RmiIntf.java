import java.rmi.*;

interface RmiIntf extends Remote {
public String connect(String ip)throws RemoteException;
public String disconnect(String ip)throws RemoteException;
public void upload(String fn, String fdata, String ip)throws RemoteException;
public String download(String fn,String ip)throws RemoteException;
}