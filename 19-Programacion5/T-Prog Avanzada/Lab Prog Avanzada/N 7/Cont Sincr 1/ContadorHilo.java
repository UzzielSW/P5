/**
 * @(#)ContadorHilo.java
 *
 * Cada hilo accederá 20 veces al recurso compartido Contador
 * y lo incrementará en 1, durmiendo un tiempo aleatorio en cada iteración.
 *
 * @author
 * @version 1.00 2010/9/5
 */


public class ContadorHilo extends Thread{

	Contador cont;


    public ContadorHilo(String p_nombre, Contador p_cont) {
    	super(p_nombre);
    	this.cont = p_cont;
    }

    // Método para incrementar el contador

    public void run()
    {
    	for( int i=0; i < 5; i++)
    	{
    		try
    		{

    			synchronized(cont)
    			{

    			int a = cont.getContador();

    			sleep((long) (Math.random() * 10));

    			cont.setContador(a + 1);
    			System.out.println(getName() + " - contador: " + cont.getContador());

    			sleep((long) (Math.random() * 10));
    			}
    		}catch(InterruptedException e)
    		{
    			System.out.println("Interrupción del hilo ... ");
    		}
    	}
    	System.out.println("Fin  " + getName() + " ... ");
    }

}