import java.io.*;

public class Dividir3
{
	public static void main(String[] args) throws IOException
	{
		double resultado;
		int numerador;
		int denominador;
		
		System.out.print("Ingresar Numerador: ");
		String text1= captura();
		System.out.print("Ingresar Denominador: ");
		String text2= captura(); 
		try{
		
      		try{
					
			 numerador = new Integer(text1).intValue();
		     denominador = new Integer(text2).intValue();
		       }catch(NumberFormatException e)
		       {
			    System.out.println("Tiene que ingresar un valor entero");
			    return;
		       }
	     
	     resultado = cociente(numerador,denominador);
	   
	    System.out.println("Numerador:  " + numerador);
	    System.out.println("Denominador: " + denominador);	
	    System.out.println("Division: " + resultado);
	
	 
		
		
	    }catch(DividirCeroException e){}   
		
	}
	
	public static String captura() throws IOException
		{
		
		 InputStreamReader reader = new InputStreamReader(System.in);
		 BufferedReader input = new BufferedReader(reader);
		 String  text  = input.readLine();
		
		 return (text);
		}
		
	public static double cociente( int numerador, int denominador ) throws DividirCeroException
	 {
	 	if ( denominador == 0  )	
	 	  throw new DividirCeroException(denominador);
	 	else 
	 		 return( (double) (numerador/denominador));  
	 }
}

class DividirCeroException extends Exception
{
  private int denominador;

  DividirCeroException( int denominador)
   {
	this.denominador = denominador;
	System.out.println("error! ");
	System.out.println("No se puede dividir entre:  "+ denominador);
	System.exit(0);
   }

}