/**
 * @(#)Proceso4.java
 * http://mmengineer.blogspot.com/2007/10/java-semaphores-productor-consumidor.html
 * adaptado por Alvaro Pino N.
 *
 * @author 
 * @version 1.00 2015/11/23
 */

import java.util.concurrent.Semaphore;


public class Proceso4 extends Thread{
	
	protected Semaphore oFinP1;
	protected Semaphore oFinP3;

  
  public Proceso4(Semaphore oFinP1,Semaphore oFinP3 ) {
    	
    	this.oFinP3 = oFinP3;
    	this.oFinP1 = oFinP1;
    }
    
    public void run()
    {
    	
    	try{
    		
    		this.oFinP1.acquire();
    		this.oFinP3.acquire();
    		
    	}catch (InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    	
    	try{
    		sleep((int) Math.round( 500* Math.random() - 0.5 ));
    	}catch (InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    	
    	System.out.println("P4");
    	
    } 
       
    
}
