// RmiServer.java
import java.rmi.*;
import java.rmi.server.*;
class RmiServer extends UnicastRemoteObject implements RmiIntf{

	RmiServer()throws RemoteException
	  {}
	
	public String call()throws RemoteException	{
	return( "this is my first rmi program");
	
	}
	
public static void main(String args[])	{
	try{
		RmiServer rs=new RmiServer();
	//	Naming.rebind("rmi://10.129.50.20/call",rs);
		Naming.rebind("rmi://127.0.0.1/call",rs);
		System.out.println("Objeto call registrado");
		}catch(Exception e){System.out.println(e);}
	}
}
