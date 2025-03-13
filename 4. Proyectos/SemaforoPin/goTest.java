/**
 * @(#)goTest.java
 * http://mmengineer.blogspot.com/2007/10/java-semaphores-productor-consumidor.html
 * adaptado por Alvaro Pino N.
 * @author 
 * @version 1.00 2015/11/23
 */

import java.util.concurrent.Semaphore;

public class goTest {
	
	protected static Semaphore oFinP1,oFinP3;
        
    /**
     * Creates a new instance of <code>goTest</code>.
     */
    public goTest() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        oFinP1 = new Semaphore(0,true);
        oFinP3 = new Semaphore(0,true);
        
        ( new Thread ( new Proceso1(oFinP1))).start();
        ( new Thread ( new Proceso2(oFinP1,oFinP3))).start();
        ( new Thread ( new Proceso3(oFinP3))).start();
        ( new Thread ( new Proceso4(oFinP1,oFinP3))).start();
    }
}
