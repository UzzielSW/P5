/*
 *
 * @author: Prof. Alvaro Pino N.
 * @date: 24/11/2015
 * @version: 2
 **/

import java.io.*;
import java.util.concurrent.*;

public class Fabrica extends Thread
{
	static Semaphore sem = new Semaphore(3,true);
	
	static Semaphore mutex = new Semaphore(1,true);

	
	public static void main(String [] args)
	{
		int cantCajas=0;
		int cantPapel=0;
		boolean done = false;
		
		Fabrica farca = new Fabrica();
		
		try{

		System.out.print("Enter la cantidad de Cajas a fabricar:  ");
		String	cantCa = capturaEntero();
		cantCajas = new Integer(cantCa).intValue();
	    valida(cantCajas);
	    System.out.print("Enter la cantidad de Papel Por Caja:  ");
		String	papel = capturaEntero();
		cantPapel = new Integer(papel).intValue();
	    valida(cantPapel);

	    }catch(IOException e){ return;}
	     catch(NumberFormatException e)
		{
		  System.out.println("Tiene que ingresar un valor entero");
	      return;
		}
	    catch(MayorQueCeroException e){}

		Caja caja = new Caja(cantCajas,cantPapel);

        ThreadGroup g1 = new ThreadGroup("t");
        Thread [] thread = new Thread[3];
        Persona persona [] = new  Persona[3];

       try{

        for (int i= 0; i < 3; i++)
        {
        persona[i] = new  Persona(sem,caja,i + 1);

		thread[i] = new Thread (g1,persona[i],"t");
		thread[i].start();
		thread[i].join(1000);
        }

		}catch(InterruptedException e){}

		Supervisor consumer = new Supervisor(mutex,caja, 4);

		Thread consumer2 = new Thread(g1,consumer ,"t");
        consumer2.setDaemon(true);
		consumer2.start();

       try{
			sleep(100*Math.max(cantPapel,cantCajas));
		    farca.join(1000);
		}catch(InterruptedException e){}

       	System.out.println("Caja Actual tiene:  "+ caja.getCantPapelActual());
       	System.out.println("Cantidad de cajas llenas:  "+ caja.getCantCajaActual());
    	System.out.println("Cantidad Maxima de cajas:  "+ caja.getMaxCantCajas());
        System.out.println("Cantidad Total de Papel :  "+ caja.getCantTotalPapel());
	

	 while (!done )
       {
       	if (g1.activeGroupCount() == 0)
       		done = true;
       }

	}




	public static String capturaEntero() throws IOException
		{
		 InputStreamReader reader = new InputStreamReader(System.in);
		 BufferedReader input = new BufferedReader(reader);
		 String  text  = input.readLine();
		 return (text);
		}

	public static void valida( int cant ) throws MayorQueCeroException
	 {
	 if (  cant <= 0  )
	  throw new MayorQueCeroException(cant);
	 }
}

class MayorQueCeroException extends Exception
{
  private int cant;

  MayorQueCeroException( int cant)
   {
	this.cant = cant;
	System.out.println("La cantidad es incorrecta! ");
	System.out.println("Ingrese una cantidad mayor que cero");
	System.exit(0);
   }
}