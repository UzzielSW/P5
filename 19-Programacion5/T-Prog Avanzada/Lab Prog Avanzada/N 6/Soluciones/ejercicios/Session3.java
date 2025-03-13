/**
 * @(#)Session3.java
 *
 *
 * @author
 * @version 1.00 2010/9/5
 */
import java.util.*;

public class Session3 {

  static final int MAX_HILOS = 5;
 // protected CadaHilo hilos [];
 public CadaHilo hilos [];

    public Session3() {
    	//objeto para generacion de números aleatorios

    	Random ra = new Random();

    	hilos = new CadaHilo[MAX_HILOS];

    	System.out.println("PRINCIPAL: inicio");

    	//Creo los hilos y les  asigno prioridad

    	for( int i=0; i < MAX_HILOS; i++)
    	{
    		hilos[i] = new CadaHilo(i+1);

    		// cálculo y asignación de la prioridad

    		hilos[i].setPriority(ra.nextInt(10) == 9 ? 7 : 6);
    	}

    	//inicio los hilos

    	for( int i=0; i < MAX_HILOS; i++)
    	{
    		hilos[i].start();
    	}

    	//Espero a que terminen los hilos

    	for (int i = 0; i < MAX_HILOS; i++)
    	{
    		try{
    			hilos[i].join();
    		}catch(InterruptedException e)
    		{
    			System.out.println("Join Interrumpido");
    		}
    	}
    	System.out.println("PRNCIPAL: Hilos Terminados ");
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here

        Session3 ejemplo3 = new Session3();

     }

}