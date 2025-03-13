/**
 * @(#)ImparesThread.java
 *
 *
 * @author
 * @version 1.00 2010/9/3
 */


public class ImparesThread extends Thread{

    public ImparesThread(String nombre) {
    	super(nombre);
    }
     public void run()
    {
    	int x=0 , i;
    	for( i=0; i< 100; i++)
    	{
    		if( i % 2 != 0 )
    		{
    			x = x + 1;
    			System.out.print("Impares  " +x);
    		}

    	}

    	System.out.println("\n\nFin impares, resultado:  " +x);
    }


}