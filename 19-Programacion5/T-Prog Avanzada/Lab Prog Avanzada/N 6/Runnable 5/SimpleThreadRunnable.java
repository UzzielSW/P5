/**
 * @(#)SimpleThread1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Creación de unthread simple implementando la interfaz Runnable
 */
public class SimpleThreadRunnable implements Runnable {

     public String nombre;

    public SimpleThreadRunnable(String nombre) {
    	this.nombre=nombre;
    }

    public void run()
    {
    	for(int i = 0; i < 10; i++)
    	{	System.out.println(i+"  " +nombre);

    	}
        System.out.println("Fin! " + nombre);
    }


}

