/**
 * @(#)ImplementaPresionBuso.java
 *
 *
 * @author 
 * @version 1.00 2021/9/6
 */

import java.io.*;

public class ImplementaPresionBuso implements PresionBusoInterface, Serializable{
   
    private Punto p1;
    
    private double preBuso;
    
    public static final double DENSIDAD= 1025.0;
    
    public static final double GRAVEDAD = 9.8;
    
    private double profundidad;
    
    ImplementaPresionBuso(Punto p1)
    	{
       this.p1 = p1;
        
        this.profundidad = p1.calcProfundidad();
        calcPresionBuso();
    }
    
    public void calcPresionBuso(){
        preBuso = GRAVEDAD*DENSIDAD*profundidad;
    }
    
    public double getPresion(){
        return preBuso;
    }
    
    public double getProfundidad()
    {
    	return (profundidad);
    }
    
    public double getGravedad(){
        return GRAVEDAD;
    }
    
    
    public double getDensidad(){
        return DENSIDAD;
    }
    
    public Punto getPunto()
    {
    	return p1;
    }
    
    public String getDetails(){
        return ("Presion: " + preBuso+"Pa");
    }
    
    
}


