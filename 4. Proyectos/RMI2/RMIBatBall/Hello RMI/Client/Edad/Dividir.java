import java.io.*;

public class Dividir
{
	public static void main(String[] args)
	{
	
		try{
	
	    System.out.print("Enter numerador:  ");		
		String	text1 = captura();
      		
		int	numerador = new Integer(text1).intValue();
		System.out.print("Enter denominador:  ");
	    String	text2 = captura();
      		
		int	denominador = new Integer(text2).intValue();
		        
	   int resultado = cociente(numerador,denominador);
	   
	    System.out.println("Numerador:  " + numerador);
	    System.out.println("Denominador: " + denominador);	
	    System.out.println("Division: " + resultado);
		    
		
		
	     }catch(IOException e){ return;}
	      catch(NumberFormatException e)
		       {
			    System.out.println("Tiene que ingresar un valor entero");
			    return;
		       } 
	      catch(DividirCeroException e){}   
		
	}
	
	public static String captura() throws IOException
		{
		
		 InputStreamReader reader = new InputStreamReader(System.in);
		 BufferedReader input = new BufferedReader(reader);
	
		 
		 String  text  = input.readLine();
		
		 return (text);
		}
		
	public static int cociente( int numerador, int denominador ) throws DividirCeroException
	 {
	 	if ( denominador == 0  )	
	 	  throw new DividirCeroException(denominador);
	 	else 
	 		 return( (numerador/denominador));  
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