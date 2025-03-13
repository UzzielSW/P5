/**
 * @(#)Contador2.java
 *
 *
 * Recurso compartido por los procesos. Sección Critica
 * Sincronización del método incContador.
 * @author
 * @version 1.00 2010/9/5
 */


public class Contador {

    protected int contador= 0;

    public Contador() {
    }


// Incrementa el valor actual del contador
public synchronized int incContador(int valor)
{
	this.contador += valor;
	try
	{
		Thread.sleep((long) (Math.random() * 100));
	}catch(InterruptedException e)
    		{
    			System.out.println("Interrupción del hilo ... ");
    		}

    return this.contador;
}

}