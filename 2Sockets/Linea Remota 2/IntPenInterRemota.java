/**
 * @(#)RemoteBall.java
 *
 *
 * @author Alvaro Pino N.
 * 
 * @version 1.00 2008/11/19
 *
 * Interfaz en donde se declaran los metodos remotos
 */
import java.rmi.*;

public interface IntPenInterRemota extends Remote{
	
	public double calcula_pendiente(Punto p1,Punto p2) throws java.rmi.RemoteException;
  
  public double calculaB(Punto p1,double m) throws java.rmi.RemoteException;
  public Punto calIntersecEjeX(Punto p1, double b,double m) throws java.rmi.RemoteException;
  public Punto calIntersecEjeY(double b) throws java.rmi.RemoteException;
  //  public Punto calcula_interseccion(Linea a, Linea b)throws java.rmi.RemoteException;
}