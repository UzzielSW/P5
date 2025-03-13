/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package fuerza;

/**
 *
 * @author DEC
 */
public class Punto
{
   public double x;
   public double y;
   public double distancia;
   public Punto (double x ,double y)
   {
   	
       this.x=x;
       this.y=y;    
   }
   
   public Punto()
   {
   	
   }
   public double getx()
   {
       return(x);
   }
   public void setY(double y)
   {
       this.y=y;
   }
   
    public void setX(double x)
   {
       this.x=x;
   }
   public double gety()
   {
       return(y);
   }
   public String getDetails()
   {
       return("(" +x+ "," +y+ ")");
   }    
   
}
