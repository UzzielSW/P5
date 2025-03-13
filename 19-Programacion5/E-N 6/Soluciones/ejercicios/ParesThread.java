/**
 * @(#)ParesThread.java
 *
 *
 * @author
 * @version 1.00 2010/9/3
 */


public class ParesThread extends Thread {

    public ParesThread(String nombre) {
    	super(nombre);
    }

    public void run()
    {
    	int x=0 , i;
    	for( i=0; i< 100; i++)
    	{
    		if( i % 2 == 0 )
    		{
    			x = x + 1;
    			System.out.print("pares  " +x);
    		}

    	}

    	System.out.println("\n\nFin pares, resultado:  " +x);
    }
}