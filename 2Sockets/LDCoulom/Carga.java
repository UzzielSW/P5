/**
 * @(#)Carga.java
 *
 *
 * @author 
 * @version 1.00 2021/9/6
 */


public class Carga{
    
    private double q;
    private Punto p;
    
   public  Carga(double carga, Punto p){
    	
        this.q = carga;
        this.p = p;
    }
    
    public double getCarga(){
        return (q);
    }
    
    public Punto getPunto(){
        return p;
    }
    
    public String getDetails(){
        return ("Carga: " + q + " C\n" + "esta en el Punto" + p.getDetails());
    }
}
