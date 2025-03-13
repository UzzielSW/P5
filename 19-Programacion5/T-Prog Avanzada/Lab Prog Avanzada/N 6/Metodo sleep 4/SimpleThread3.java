/**
 * @(#)SimpleThread1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Utilizaci�n del m�todo sleep(): El m�todo sleep(long millis) sirve para detener
 * y dormir el thread actual el n�mero de milisegundos que se especifique como par�metro.
 */
public class SimpleThread3 extends Thread {

    public SimpleThread3(String nombre) {
    	super(nombre);
    }

    public void run()
    {
    	for(int i = 0; i < 10; i++)
    	{	System.out.println(i+"  " +getName());
    	    try{
    	    	sleep((long) (Math.random() * 1000));
    	    }catch(InterruptedException e){ }
    	}
        System.out.println("Fin! " +getName());
    }


}

