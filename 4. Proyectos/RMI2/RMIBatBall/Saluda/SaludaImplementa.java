/**
 * @(#)Ball.java
 *
 *
 * @author Marco Boger
 * Modificado por Prof. Alvaro Pino N.
 * @version 1.00 2008/11/19
 *
 * Clase que implementa la interfaz en donde se define
 * el metodo remot0
 */
import java.rmi.*;
import java.rmi.server.*;


public class SaludaImplementa extends UnicastRemoteObject 
             implements InterfaceSaluda{

    public SaludaImplementa() throws RemoteException {
    	super();
    }
    
    public void saluda(String nombre)  {
    	
    	System.out.println("Hola  "+ nombre);
    }
    
  
}