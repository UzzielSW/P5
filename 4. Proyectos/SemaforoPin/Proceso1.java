/**
 * @(#)Proceso1.java
 * http://mmengineer.blogspot.com/2007/10/java-semaphores-productor-consumidor.html
 * adaptado por Alvaro Pino N.
 * @author 
 * @version 1.00 2015/11/23
 */
 
import java.util.concurrent.Semaphore;


public class Proceso1 extends Thread{
	
	protected Semaphore oFinP1;
	

    public Proceso1(Semaphore oFinP1) {
    	
    	this.oFinP1 = oFinP1;
    }
    
    
    public void run()
    {
    	
    	try{
    		sleep((int) Math.round( 500* Math.random() - 0.5 ));
    	}catch (InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    	
    	System.out.println("P1");
    	this.oFinP1.release(2);
    }
    
    
    
}