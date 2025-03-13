/**
 * @(#)RemoteBall.java
 *
 *
 * @author Marko Boger
 * 
 * @version 1.00 2008/11/19
 *
 * Interfaz en donde se declaran los metodos remotos
 */
import java.rmi.*;

public interface InterfaceSaluda extends Remote{
	
	public void saluda(String nombre) throws java.rmi.RemoteException;
    
    
}