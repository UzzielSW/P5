/**
 * @(#)Fuerza.java
 *
 *
 * @author 
 * @version 1.00 2021/9/6
 */



public class Fuerza{
   
    private Carga q1;
    private Carga q2;
    
    private double f12;
    
    public static final double K = 8.99*Math.pow(10.0,9);
    
    private double dis;
    
    Fuerza(Carga q1, Carga q2){
        this.q1 = q1;
        this.q2 = q2;
        
        this.dis = q1.getPunto().calcDistancia(q2.getPunto());
        calcFuerza();
    }
    
    public void calcFuerza(){
        f12 = K * (q1.getCarga() * q2.getCarga() / Math.pow(dis,2.0)) ;
    }
    
    
    
    public double getK(){
        return K;
    }
    
    public String getDetails(){
        return ("Fuerza: " + f12+"N");
    }
    
    
}


