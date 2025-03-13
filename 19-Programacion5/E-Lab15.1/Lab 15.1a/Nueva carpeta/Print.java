/*
 * Modificado por Prof. Alvaro Pino N.
 * Date: 23/09/2010
 * Date: 29/09/2019
 */

import java.io.*;

public class Print
{
	public static void main(String [] args)
	{
		int time= 0;
		String	text;
		String resp="true";
 do
        {

       try{
           System.out.print("Ingrese un numero entero positivo en milisegundos: ");
		   text = captura();
		   time = Integer.parseInt(text);

           valida( time);

	//	int time = Integer.parseInt(args[0]);



	    PrintNumbers printNumbers = new PrintNumbers();
	//	Thread t1 = new Thread(printNumbers);
		printNumbers.start();

		try
		{
			Thread.sleep(time);
		}catch(InterruptedException m) 	{}

		printNumbers.stopPrinting();

        System.out.print("Desea Continuar: (true/false)? ");
    	resp = captura();

          }catch(IOException e){ 
          System.out.println("Su Entrada es incorrecta! ");
          //return;
          }
	      catch(NumberFormatException e)
		       {
		       	System.out.println("Su Entrada es incorrecta! ");
			    System.out.println("Tiene que ingresar un numero entero en milisegundos");
			  //  return;
		       }
	      catch(MenorQueCeroException e){}

	}while (resp.equals("true"));

	System.out.println("main() is ending");

	}

public static void valida( int i ) throws MenorQueCeroException
	 {
	 	if (  i < 0 )
	 	  throw new MenorQueCeroException(i);

	 }

public static String captura() throws IOException
		{

		 InputStreamReader reader = new InputStreamReader(System.in);
		 BufferedReader input = new BufferedReader(reader);

		 //System.out.print("Enter your age:  ");
		 String  text  = input.readLine();

		 return (text);
		}
}

class MenorQueCeroException extends Exception
{
  private int i;

  MenorQueCeroException( int i)
   {
	this.i = i;
	System.out.println("Su Entrada es incorrecta! ");
	System.out.println("Ingrese un numero entero positivo en milisegundos ");
 //	System.exit(0);
   }
}