/**
 * @(#)Proceso3.java
 * http://mmengineer.blogspot.com/2007/10/java-semaphores-productor-consumidor.html
 * adaptado por Alvaro Pino N.
 *
 * @author 
 * @version 1.00 2015/11/23
 */

import java.util.concurrent.Semaphore;


public class Proceso3 extends Thread{
	
	protected Semaphore oFinP3;
	

    public Proceso3(Semaphore oFinP3) {
    	
    	this.oFinP3 = oFinP3;
    }
    
    
    public void run()
    {
    	
    	try{
    		sleep((int) Math.round( 500* Math.random() - 0.5 ));
    	}catch (InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    	
    	System.out.println("P3");
    	this.oFinP3.release(2);
    }
    
    
    
}
