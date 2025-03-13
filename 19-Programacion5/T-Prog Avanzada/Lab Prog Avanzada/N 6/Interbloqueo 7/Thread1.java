/**
 * @(#)Thread1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */


public class Thread1 extends Thread {

    Thread t = new Thread();
    public Thread1(String nombre)
    {
    	super(nombre);

    }


    public void espera(Thread t)
    {
    	this.t = t;
    }

    public void run()
    {
    	try
    	{

    	for(int i = 0; i < 10; i++)
    	{

    		System.out.println(i + "  " + getName());
    		Thread.sleep((long) (Math.random() * 1000));
    	}
    	t.join();

    	for(int i = 10; i < 20; i++)
    	{

    		System.out.println(i + "  " + getName());
    		Thread.sleep((long) (Math.random() * 1000));
    	}

    	}catch(InterruptedException e) {}

    	System.out.println("Fin!  " +getName());

    }

}