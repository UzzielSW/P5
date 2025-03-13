/**
 * @(#)Punto.java
 *
 *
 * @author 
 * @version 1.00 2021/9/6
 */


public class Punto{
	
    private double x;
    private double y;
    
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
        
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
     public void setX(double x){
        this.x = x;
    }
    
     public void setY(double y){
        this.y = y;
    }
    
    public  String getDetails(){
        return ("(" + x + "," + y + ")");
    } 
    
    public double calcDistancia(Punto p){
        
        double dx = this.getX() - p.getX();
        double dy = this.getY() - p.getY();
        return (Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }
}
