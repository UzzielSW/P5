/**
 * @(#)SimpleThread1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Utilización del método yield(): El método yield() sirve para detener el thread actual
 * y dejar paso a la ejecución de otro ( se cede la cpu a un thread que esté esperando a utilizarla
 */
public class SimpleThread2 extends Thread {

    public SimpleThread2(String nombre) {
    	super(nombre);
    }

    public void run()
    {
    	for(int i = 0; i < 10; i++)
    	{	System.out.println(i+"  " +getName());
    	    yield();
    	}
        System.out.println("Fin! " +getName());
    }


}

