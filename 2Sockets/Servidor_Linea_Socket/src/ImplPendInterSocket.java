/**
 * @(#)ImplPenInterSocket.java
 *
 *
 * @author  por Prof. Alvaro Pino N.
 * @version 1.00 2018/11/21,25
 *
 * Clase que implementa la interfaz en donde se definen los metodos
 */




public class ImplPendInterSocket  
           implements IntPenInterSocket{
           	
           	

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
    
    
    
 public double calculaB(Punto p1,double m) 
  {
  	return(p1.y - m*p1.x );
  }
  
 public Punto calIntersecEjeX(Punto p1,double b,double m) 
 {
 	Punto temp;
 	
 	String infinitom =String.valueOf(m);
    String infinitob =String.valueOf(b);
        
    if( ( infinitom.equals("Infinity") && infinitob.equals("Infinity"))) 
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
  public Punto calIntersecEjeY(double b) 
 {
 	
 	
 	double y= b; 
 	
 	Punto temp = new Punto(0.0, y);
 	
 	return (temp);
 	
 	
 	
 } 
 
    
  /*  public Punto calcula_interseccion(Linea a,Linea b) throws java.rmi.RemoteException
    {
    Punto temp=new Punto();
		temp.y=(-(a.p2.x-a.p1.x)*((-(b.p2.y-b.p1.y)-b.m)/(b.p2.x-b.p1.x))-a.m)/(a.p2.y-a.p1.y);
		temp.x=(-(a.p2.y-a.p1.y)*((-(b.p2.x-b.p1.x)-b.m)/(b.p2.y-b.p1.y))-a.m)/(a.p2.x-a.p1.x);
		return(temp);	
    }
    */
 
}