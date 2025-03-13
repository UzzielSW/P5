/**
 * @(#)Contador2.java
 *
 *
 * Recurso compartido por los procesos. Secci�n Critica
 * Sincronizaci�n del m�todo incContador.
 * @author
 * @version 1.00 2010/9/5
 */


public class Contador2 {

    protected int contador= 0;

    public Contador2() {
    }


// Incrementa el valor actual del contador
public syncronized int incContador(int valor)
{
	this.contador += valor;
	try
	{
		Thread.sleep((long) (Math.random() * 100));
	}catch(InterruptedException e)
    		{
    			System.out.println("Interrupci�n del hilo ... ");
    		}

    return this.contador;
}

}