/**
 * @(#)CadaHilo.java
 *
 *
 * @author
 * @version 1.00 2010/9/5
 */


public class CadaHilo extends Thread{

	protected int num;


    public CadaHilo(int n) {

    	num =n;

    }

    public void run()
    {
    	for( int i=0; i < 10; i++)
    	{
    		synchronized (System.out)
    		{
    			System.out.print("[");
    			for(int j=0; j < num; j++)
    			{
    				System.out.print("-");
    			}
    			System.out.println("] priority= " + this.getPriority());
    		}
    	}
    }

}