/**
 * @(#)Bat.java
 *
 *
 * @author Prof. Alvaro Pino N.
 * @version 1.00 2018/11/9
 * Programa Servidor que genera el objeto remoto y 
 * lo ofrece a traves de RMI.
 *
 */


import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Linea{
	
	public ImplPendInter ipi;
	
	Punto p1;
	Punto p2;
	public double m;
	public boolean existe;
	public Linea(){
		this.p1=new Punto(0.0,0.0);
		this.p2=new Punto(1.0,1.0);
	 //	existe=false;
	//	m=calcula_pendiente();				
	}
	
	public Linea(Punto p1,double m){
	 this.p1=p1;
	 this.m=m;
	// existe=true;	
	} 
	
/*	public void play(IntPenInter ipi ) 
    {
	try{
		m=ipi.calcula_pendiente(p1, p2);
	}catch(RemoteException e)
	{
		System.out.println(e);
	}
	
}
*/	
	
/*	public double calcula_pendiente(){
		if(p1.equals(p2)!=true){
		 existe=true;
		 return((p2.y-p1.y)/(p2.x-p1.y));	
		}
	    else
	    {
	    System.out.println("No existe la pendiente");	
	    return(0);	
	    } 
		
	}
*/

public	 String imprime_linea(){
		return("y = "+this.m+"x + b : "+p1.display()+" - "+p2.display());
	}
	
	public String simprime_linea(){
		return("y = "+this.m+"x + b :"+p1.display());
	}
/*	public Punto calcula_interseccion(Linea a){
		Punto temp=new Punto();
		temp.y=(-(a.p2.x-a.p1.x)*((-(this.p2.y-this.p1.y)-this.m)/(this.p2.x-this.p1.x))-a.m)/(a.p2.y-a.p1.y);
		temp.x=(-(a.p2.y-a.p1.y)*((-(this.p2.x-this.p1.x)-this.m)/(this.p2.y-this.p1.y))-a.m)/(a.p2.x-a.p1.x);
		return(temp);
	}
*/	
	public static void main(String arg[])
	{
				
		Linea la=new Linea();
	//	Linea lb=new Linea(new Punto(0.0,0.0),new Punto(-1.0,1.0));
			try{
 //System.setSecurityManager( new RMISecurityManager() );
 		
 	
 		IntPenInterRemota inpi =
 		 (IntPenInterRemota)Naming.lookup("//localhost:2005/ImplPenInter");
 		
 		
 		la.play(inpi);
 		System.out.println("la pendiente m ha sido calculada ");
 		
     	}catch(Exception e)
     	{
     		System.out.println(e);
     	}
		
		 JOptionPane.showMessageDialog(null,"La linea es de: "+la.imprime_linea());
	/*	 JOptionPane.showMessageDialog(null,"nLa linea es de: "+lb.imprime_linea());
		 Punto c=new Punto();
		 c=la.calcula_interseccion(lb);
		 JOptionPane.showMessageDialog(null,"La intereseccion es: "+c.display());
    */	
}

}