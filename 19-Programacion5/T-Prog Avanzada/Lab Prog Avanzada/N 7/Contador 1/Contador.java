/**
 * @(#)Contador.java
 *
 *
 *Recurso compartido por los procesos. Sección Critica
 * @author
 * @version 1.00 2010/9/5
 */


public class Contador {

    protected int contador= 0;

    public Contador() {
    }

    public int getContador()
    {
    	// Devuelve el valor actual del contador

    	return(this.contador);
    }

     public void setContador(int valor)
    {
    	// Establece el valor actual del contador

    	this.contador= valor;
    }
}