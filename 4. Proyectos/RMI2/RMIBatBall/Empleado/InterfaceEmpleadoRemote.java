/**
 * @(#)IntCalRemote.java
 *
 *
 * @author 
 * 
 * @version 1.00 18/11/2017
 *
 * Interfaz en donde se declaran los metodos remotos
 */
import java.rmi.*;

public interface InterfaceEmpleadoRemote extends Remote{
	
	public String getDNI()
	          throws java.rmi.RemoteException;
    public String getNombre()
	          throws java.rmi.RemoteException;
    public String getDepartamento()
	          throws java.rmi.RemoteException;
    public double getSueldo()
	          throws java.rmi.RemoteException;
    public void setSueldo(double s)
	          throws java.rmi.RemoteException;
    public String info()
	          throws java.rmi.RemoteException;
}