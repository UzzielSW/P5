/*
 *
 * @author: Prof. Alvaro Pino N.
 * @date: 22/12/2010
 * @version: 2
 **/

import java.io.*;

public class Fabrica2 extends Thread
{
    	boolean  done;
		Caja cajita;
		Thread [] thread;
		Persona persona [];
		ThreadGroup g1;
		Supervisor supervisor;
		Thread consumer2;
		int cantPapel=0;
		int cantCajas=0;

		public Fabrica2()
		{
	    try{

		System.out.print("Enter la cantidad de Cajas a fabricar:  ");
		String	cantCa = capturaEntero();
		cantCajas = new Integer(cantCa).intValue();
	    valida(cantCajas);

	    System.out.print("Enter la cantidad de Papel Por Caja:  ");
		String	papel = capturaEntero();

		cantPapel = new Integer(papel).intValue();
	    valida(cantPapel);

		cajita = new Caja(cantCajas,cantPapel);
		g1 = new ThreadGroup("t");
		thread = new Thread[3];
		persona  = new  Persona[3];
		supervisor = new Supervisor(cajita, 4);
		consumer2 = new Thread(g1,supervisor ,"t");
        consumer2.setDaemon(true);
		consumer2.start();

    }catch(IOException e){ return;}
	 catch(NumberFormatException e)
	 {
	  System.out.println("Tiene que ingresar un valor entero");
	  System.exit(0);
      }catch(MayorQueCeroException e){}
	}

	public void run()
	{
		try{
            for (int i= 0; i < 3; i++)
              {
               persona[i] = new  Persona(cajita,i + 1);
		       thread[i] = new Thread (g1,persona[i],"t");
		       thread[i].start();
		       thread[i].join(20);
              }

		}catch(InterruptedException e){}
	}
















	public static void main(String [] args)
	{

       Fabrica2 fabr = new Fabrica2();

       fabr.start();

       	try{
            sleep(1000*Math.max(fabr.cantPapel,fabr.cantCajas));
		    fabr.join();
		}catch(InterruptedException e){}

       	System.out.println("Caja Actual tiene:  "+ fabr.cajita.getCantPapelActual());
       	System.out.println("Cantidad de cajas llenas:  "+ fabr.cajita.getCantCajaActual());
        System.out.println("Cantidad Maxima de cajas:  "+ fabr.cajita.getMaxCantCajas());

	 while (!fabr.done )
       {
       	if (fabr.g1.activeGroupCount() == 0)
       		fabr.done = true;
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

