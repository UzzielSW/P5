/**
 * @(#)ImplEmpleadoRemote.java
 *
 *
 * @author 
 * Modificado por Prof. Alvaro Pino N.
 * @version 1.00 18/11/2017
 *
 * Clase que implementa la interfaz en donde se define
 * los  metodos remotos
 */
import java.rmi.*;
import java.rmi.server.*;


public class ImplEmpleadoRemote
             extends UnicastRemoteObject 
                   implements InterfaceEmpleadoRemote{

private String DNI;
private String nombre;
private String departamento;
private double sueldo;
	      
/** Creaa una instancia de ImplpleadoRemote */

    public ImplEmpleadoRemote(String DNI, String nombre, String departamento, double sueldo)
            throws RemoteException {
    	super();
    	this.DNI = DNI;
    	this.nombre = nombre;
    	this.departamento = departamento;
    	this.sueldo = sueldo;
    	
    }
    
    public String getDNI()
	          throws java.rmi.RemoteException
	  {
	  	return this.DNI;
	  }        
	          
    public String getNombre()
	          throws java.rmi.RemoteException
	  {
	  	return this.nombre;
	  }
	  
    public String getDepartamento()
	          throws java.rmi.RemoteException
	  {
	  	return this.departamento;
	  }  
	        
    public double getSueldo()
	          throws java.rmi.RemoteException
	  {
	  	return this.sueldo;
	  }
	          
    public void setSueldo(double s)
	          throws java.rmi.RemoteException
	  {
	  	this.sueldo = s;
	  }
	  
// Imprimir informacion del Empleado
	  
    public String info()
	          throws java.rmi.RemoteException
	  {
	  	return( getDNI() + " - " + getNombre());
	  }
    	
}