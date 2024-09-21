import java.io.*;


public class Linea implements Serializable{
	Punto p1;
	Punto p2;
	public double m;
	public boolean existe;
	public double b;
	public Punto ejeX;
	public Punto ejeY;
	
	public Linea(Punto p1, Punto p2){
		this.p1=p1;
		this.p2=p2;
		
	//	existe=false;
	//	m=calcula_pendiente();				
	}
	
	public Linea(Punto p1,double m){
	 this.p1=p1;
	 this.m=m;
	// existe=true;	
	} 
	
	public double calcula_pendiente(){
		if(p1.equals(p2)!=true){
	 // existe=true;
	  
		 m = (p2.y-p1.y)/(p2.x-p1.x);
		 return(m);	
		}
	    else
	    {
	    System.out.println("No existe la pendiente");	
	    return(0);	
	    } 
	    
		
	}
	public String imprime_linea(){
		return("y = "+this.m+"*x +"+ this.b + ": "+p1.display()+" - "+p2.display()+
		       "\n Interseccion ejeX: " + ejeX.display() +
		       "\n Interseccion ejeY: " + ejeY.display() );
	}
	
	public String simprime_linea(){
		return("y = "+this.m+"x + b :"+p1.display());
	}
	public Punto calcula_interseccion(Linea a){
		Punto temp=new Punto();
		temp.y=(-(a.p2.x-a.p1.x)*((-(this.p2.y-this.p1.y)-this.m)/(this.p2.x-this.p1.x))-a.m)/(a.p2.y-a.p1.y);
		temp.x=(-(a.p2.y-a.p1.y)*((-(this.p2.x-this.p1.x)-this.m)/(this.p2.y-this.p1.y))-a.m)/(a.p2.x-a.p1.x);
		return(temp);
	}
	
	
    public void setPendiente(double m)	
    {
    	this.m = m;
    }
    
    public double getPendiente()	
    {
    	return (m);
    }
    
    public void setB(double b)
    {
    	this.b = b;
    }
    
    public double getB()
    {
    	return(b);
    }
    
    public void setEjeX(Punto p)
    {
    	this.ejeX = p;
    }
    
    public Punto getX()
    {
    	return(ejeX);
    }
    

    
    public void setEjeY(Punto p)
    {
    	this.ejeY = p;
    }
    
    public Punto getY()
    {
    	return(ejeY);
    }
}