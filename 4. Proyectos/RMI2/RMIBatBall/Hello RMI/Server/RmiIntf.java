// RmiIntf.java
import java.rmi.*;
interface RmiIntf extends Remote
  {
     public String call() throws RemoteException;
  }
