/**
 * @(#)HiloHijo.java
 *
 *
 * @author
 * @version 1.00 2010/9/5
 */

import java.util.*;

public class HiloHijo extends Thread{

	private int numHijo;
	private HiloHijo hiloCreado;
	private Random aleat = new Random(45);

    public HiloHijo(int nH) {
    	super();
    	numHijo = nH;
    }

    public void run()
    {
    	System.out.println("Soy el hilo número: " + numHijo + " - Inicio.");

    	if(numHijo > 1)
    	{
    		hiloCreado = new HiloHijo(numHijo -1);
    		hiloCreado.start();

    	}

    	try {
    		for ( int i=0; i < 5; i++)
    		{
    			    System.out.println("Soy el hilo número:  " + numHijo + " - Procesando. . . " + (i+1));

    			    this.sleep(aleat.nextInt(500)  + 100);
    		}
    			    if(numHijo > 1)
    			    	hiloCreado.join();

    	}catch( InterruptedException e)
    	{
    		System.out.println("Error: " + e.toString());
    	}
    	System.out.println("Soy el hilo número:  " + numHijo + " - Fin.");
    }
}