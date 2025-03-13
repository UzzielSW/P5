/**
 * @(#)Termina23Thread.java
 *
 *
 * @author
 * @version 1.00 2010/9/3
 */


public class Termina23Thread extends Thread{

    public Termina23Thread(String nombre) {
    	super(nombre);
    }

 public void run()
    {
    	int x=0 , i;
    	for( i=0; i< 100; i++)
    	{
    		if( ( (i-2) % 10  == 0 )  || ( (i-3) %10 == 0) )
    		{
    			x = x + 1;
    			System.out.print("Termina23  " +x);
    		}

    	}

    	System.out.println("\n\nFin Termina23, resultado:  " +x);
    }

}