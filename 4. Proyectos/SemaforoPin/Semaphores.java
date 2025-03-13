/**
 * @(#)Semaphores.java
 *
 *
 * @author 
 * @version 1.00 2015/11/24
 */


import java.util.concurrent.*;  
    
   
  public class Semaphores {  
 
 	public static void main(String args[]){  
 
 		Semaphore sem=new Semaphore(3, true);  
 
 String brands[]={"Toyota","Nissan","Chevrolet","Alfa Romeo","Jaguar","Mercedez Benz","Renault","Ford","Mazda"};  
 
 		Car carros[]=new Car[brands.length];  
 
  		for(int i=0;i<brands.length;i++){  
 		
 			carros[i]=new Car(sem,brands[i]);  
  			  
  			new Thread(carros[i]).start();  
  		}  
  	}  
  }  


        
    
    
