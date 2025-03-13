/**
 * @(#)GuiPrint.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/9/22
 * @version 2.00 2010/9/24
 */
 
 import javax.swing.*;
import java.io.*;


public class GuiPrin2Pint 
{

	public static void valida(int i) throws MenorQueCeroException
	{
		if(i < 0) throw new MenorQueCeroException(i);
	}
    public static void main (String[] args) 
    {
    	GUIPrintsNumbers2Pin PNumbers = new GUIPrintsNumbers2Pin();
    	Thread t1 = new Thread(PNumbers);
    	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String captura;
    	int tiempo;
    	try
    	{
    		//System.out.println("Introduzca numero de milisegundos durante los cuales main dormira: ");
    		//captura = br.readLine();
    		captura = JOptionPane.showInputDialog(PNumbers, "Introduzca el numero de milisegundos durante los cuales main dormira:", "GUIPrint",
    											  JOptionPane.QUESTION_MESSAGE);
    		tiempo = Integer.parseInt(captura);
    		GuiPrint.valida(tiempo);
    		t1.start();
    		try
    		{
    		
    		Thread.sleep(tiempo);
    		}catch(InterruptedException e){
    		}
    		PNumbers.stopPrinting();
    		try
    		{
    		
    		Thread.sleep(4000);
    		}catch(InterruptedException e){
    		}
    		JOptionPane.showMessageDialog(PNumbers, "Main is ending...", "GUIPrint", JOptionPane.INFORMATION_MESSAGE);
    		
    	}
    	catch(NumberFormatException nfe)
    	{
    		JOptionPane.showMessageDialog(PNumbers, "Debe introducir un numero entero", "Error", JOptionPane.WARNING_MESSAGE);
    	}
    	catch(MenorQueCeroException mqce)
    	{
    		JOptionPane.showMessageDialog(PNumbers, "El numero introducido debe ser mayor que cero", "Error", JOptionPane.WARNING_MESSAGE);
    	}
    
    	System.exit(0);
	}    
}

class MenorQueCeroException extends Exception
{
  private int i;

  MenorQueCeroException( int i)
   {
	this.i = i;
	System.out.println("Su Entrada es incorrecta! ");
   }
}