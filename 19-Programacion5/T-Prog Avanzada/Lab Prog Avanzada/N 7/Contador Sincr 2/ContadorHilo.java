/**
 * @(#)ContadorHilo.java
 *
 * Cada hilo acceder� 20 veces al recurso compartido Contador
 * y lo incrementar� en 1, durmiendo un tiempo aleatorio en cada iteraci�n.
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

    // M�todo para incrementar el contador

    public void run()
    {
    	for( int i=0; i < 5; i++)
    	{



    			System.out.println(getName() + " - contador: " + cont.incContador(1));


    	}
    	System.out.println("Fin  " + getName() + " ... ");
    }

}