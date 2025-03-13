/*
 * Modificado por Prof. Alvaro Pino N.
 * Date: 23/09/2010
 */

import java.io.*;
import javax.swing.*;
import java.awt.*;

public class PrintGUI
{
	public static void main(String [] args)
	{
		int time= 0;
		String	text;
		int resp=0;
		Clrscr limpia = new Clrscr();
 do
        {
            limpia.clrscr();
       try{

		   text = (String) JOptionPane.showInputDialog(null,"Ingrese un numero entero positivo en milisegundos: ",
                     "Laboratorio 15.1GUI",JOptionPane.QUESTION_MESSAGE );

                 //sale si se escoje cancelar o cerrar

       if(text == null ) System.exit(0);

		   time = Integer.parseInt(text);

           valida( time);

	//	int time = Integer.parseInt(args[0]);



	    PrintNumbers printNumbers = new PrintNumbers();
		Thread t1 = new Thread(printNumbers);
		t1.start();

		try
		{
			Thread.sleep(time);
		}catch(InterruptedException m) 	{}

		printNumbers.stopPrinting();

     // Display  a message dialog box

      resp= JOptionPane.showConfirmDialog(null,
      "Desea Continuar: confirme?",
      "YES_NO_OPTION", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);


          }catch(NumberFormatException e)
		       {
		       	JOptionPane.showMessageDialog(null,"Su Entrada es incorrecta !","Ejemplo de Output ERROR",
                                   JOptionPane.ERROR_MESSAGE);

			    return;
		       }
	      catch(GUIMenorQueCeroException e){}

	}while (resp == 0);

	System.out.println("main() is ending");

	}

public static void valida( int i ) throws GUIMenorQueCeroException
	 {
	 	if (  i < 0 )
	 	  throw new GUIMenorQueCeroException(i);

	 }


}

class GUIMenorQueCeroException extends Exception
{
  private int i;

  GUIMenorQueCeroException( int i)
   {
	this.i = i;
	JOptionPane.showMessageDialog(null,"Ingrese Numeros positivos en milisegundos!",
	"Ejemplo de Output ERROR ",JOptionPane.ERROR_MESSAGE );
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
	System.exit(0);
   }
}