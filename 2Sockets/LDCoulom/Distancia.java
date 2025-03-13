/**
 * @(#)Distancia.java
 *
 *
 * @author 
 * @version 1.00 2021/9/6
 */


public class Distancia{
    
    private Punto p1;
    private Punto p2;
    
    private double dis;
    
   public  Distancia(Punto p1, Punto p2){
        this.p1 = p1;
        this.p2 = p2;
        calcDistancia();
    }
    
    public void calcDistancia(){
        
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        dis = (Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }
    
    public double getDistancia(){
        return dis;
    }
    
    public String getDetails(){
        return ("La Distancia entre los puntos\n" + "P1" + p1.getDetails() + " y " + 
        	"P2" + p2.getDetails() + "\n" + "Distancia: " + dis + " ms.\n"
        );
    }
    
}