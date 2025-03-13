/**
 * @(#)Animal.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Asignación de prioridades a los threads:
 * Mediante el método setPriority(int prioridad)
 * se puede establecer una prioridad a un hilo,
 * esta prioridad es un entero comprendido en
 * el rango 1-10.
 **/
public class Animal extends Thread {

     public String nombre;

    public Animal(int prioridad,String nombre) {
    	this.nombre=nombre;
    	setPriority(prioridad);
    }

    public void run()
    {
    	for(int i = 0; i < 30; i++)
    	{

    		System.out.print(nombre);
    		yield();
    	}
        System.out.println("\n Llega " + nombre+ "\n");
    }


}

