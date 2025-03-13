/**
 * @(#)ThreadJoin2.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Utilización del método join():
 *
 */

public class ThreadJoin2 extends Thread {

    public ThreadJoin2(String nombre) {
    	super(nombre);
    	start();
    }

    public void run()
    {
   	try
  	{
        System.out.println("Inicio - " + getName());

    	for(int i = 1; i <= 5; i++)
    	{

    		System.out.println(getName() + "  " +i);
    		Thread.sleep(1000);
    		yield();
    	}
        System.out.println("Fin -  " +getName());

    	}catch(InterruptedException e) {}
    }


}

