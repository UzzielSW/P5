/**
 * @(#)RemoteBall.java
 *
 *
 * @author Alvaro Pino N.
 * 
 * @version 1.00 2018/11/19
 *               2018/11/21,22
 *  
 *
 * Interfaz en donde se declaran los metodos remotos
 */


public interface IntPenInterSocket {
	
	public double calcula_pendiente(Punto p1,Punto p2); 
  
  public double calculaB(Punto p1,double m); 
  public Punto calIntersecEjeX(Punto p1, double b,double m);
  public Punto calIntersecEjeY(double b) ;
  //  public Punto calcula_interseccion(Linea a, Linea b);
}