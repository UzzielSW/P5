/**
 * @(#)ThreadJoin1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Utilización del método join(): En este ejemplo el método main() crea un hilo y espera a que termine,
 * a su vez este hilo crea otro y también espera a que termine.
 */

public class ThreadJoin1 extends Thread {

    public ThreadJoin1(String nombre) {
    	super(nombre);
    	start();
    }

    public void run()
    {
    	try
    	{

        System.out.println("Inicio - " + getName());
        ThreadJoin2 hilo2 = new ThreadJoin2("hilo2");


    	for(int i = 1; i <= 3; i++)
    	{

    		System.out.println(getName() + "  " +i);
    		hilo2.join();
    	}
        System.out.println("Fin -  " +getName());

    	}catch(InterruptedException e) {}
    }


}

