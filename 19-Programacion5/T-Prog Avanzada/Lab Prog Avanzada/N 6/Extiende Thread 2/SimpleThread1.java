/**
 * @(#)SimpleThread1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Creación de un thread simple heredando de la clase Thread
 **/
public class SimpleThread1 extends Thread {

    public SimpleThread1(String nombre) {
    	super(nombre);
    }

    public void run()
    {
    	for(int i = 0; i < 10; i++)
    		System.out.println(i+"  " +getName());
        System.out.println("Fin! " +getName());
    }


}

