/**
 * @(#)ImplPenInterSocket.java
 *
 *
 * @author Marco Boger
 * Modificado por Prof. Alvaro Pino N.
 * @version 1.00 2008/11/19
 *
 * Clase que implementa la interfaz en donde se define
 * el metodo remoto
 */
//import java.rmi.*;
//import java.rmi.server.*;



public class ImplPendInterSocket  
           implements IntPenInterRemota{

    public ImplPendInterSocket() {
    	super();
    }
    
   public double calcula_pendiente(Punto p1,Punto p2) 
    {
    if(p1.equals(p2)!=true){
		// existe=true;
		 return((p2.y-p1.y)/(p2.x-p1.x));	
		}
	    else
	    {
	    System.out.println("No existe la pendiente");	
	    return(0);	
	    } 	
    }
 /*   
 public double calculaB(Punto p1,double m) throws java.rmi.RemoteException
  {
  	return(p1.y - m*p1.x );
  }
  
 public Punto calIntersecEjeX(Punto p1,double b,double m) throws java.rmi.RemoteException
 {
 	Punto temp;
 	
 	String infinito =String.valueOf(m);
    
    
    if( ! infinito.equals("Infinity")) 
 	 {
 	 
 	 double x= -b/m; 
 	
 	temp = new Punto(x, 0.0);
 	
 	 }
 	 else
 	     {   
 	     	 temp = new Punto(p1.x,0.0);
 	     }
 	     
 	 
 	 return(temp);    
 	 
 	
 	
 } 
  public Punto calIntersecEjeY(double b) throws java.rmi.RemoteException
 {
 	
 	
 	double y= b; 
 	
 	Punto temp = new Punto(0.0, y);
 	
 	return (temp);
 	
 	
 	
 } 
 */
    
  /*  public Punto calcula_interseccion(Linea a,Linea b) throws java.rmi.RemoteException
    {
    Punto temp=new Punto();
		temp.y=(-(a.p2.x-a.p1.x)*((-(b.p2.y-b.p1.y)-b.m)/(b.p2.x-b.p1.x))-a.m)/(a.p2.y-a.p1.y);
		temp.x=(-(a.p2.y-a.p1.y)*((-(b.p2.x-b.p1.x)-b.m)/(b.p2.y-b.p1.y))-a.m)/(a.p2.x-a.p1.x);
		return(temp);	
    }

  */    
 /*   public static void main(String args[]){
    	
    	try{
    	//	Ball ball = new Ball();
    	
    	ImplPendInter penInter = new ImplPendInter();
    	
    		//Naming.rebind("//alvaro-h2ux8wow:2005/Ball", ball);
    	//	Naming.rebind("//HP-173575:2005/Ball", ball);
    	    Naming.rebind("//localhost:2005/ImplPenInter", penInter);
    		System.out.println("Ready to calculate m and intersecction");
        }catch(Exception e){ e.printStackTrace();
        }
    }
   */ 
}