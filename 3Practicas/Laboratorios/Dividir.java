import java.io.*;

public class Dividir
{
	public static void main(String[] args)
	{
		double numerador, denominador, resultado;
			    	
		String text1,text2;
	
		try{
			
			System.out.print("Introduzca el numerador");
			text1 = captura();
			
			System.out.print("Introduzca el denominador");
			text2 = captura();
		
      		try{
				
				 numerador= new Double(text1).doubleValue();	
				 denominador= new Double(text2).doubleValue();
				 
			    
		    
		       }catch(NumberFormatException e)
		       {
			    System.out.println("Tiene que ingresar un valor numérico");
			    return;
		       }
		       
	        resultado=cociente(numerador,denominador) ;    
	        
	   
	        System.out.println("La Division entre"+numerador+"/"+denominador+"="+resultado);
	    	
		    
		
	    }catch(IOException e)  {return;	    } 
	     catch(DivideByZeroException e){}   
}
	
	public static String captura() throws IOException
		{
		
		 InputStreamReader reader = new InputStreamReader(System.in);
		 BufferedReader input = new BufferedReader(reader);	
		 String  text  = input.readLine();
		 return (text);
		}
		
	public static double cociente( double numerador, double denominador ) throws DivideByZeroException
	 {
	 	if ( denominador == 0  )	
	 	  throw new DivideByZeroException(denominador);
	 	  
	 	return(numerador/denominador);
	 }
}

class DivideByZeroException extends Exception
{
  private double denominador;

  DivideByZeroException( double denominador)
   {
	this.denominador = denominador;
	System.out.println("No se puede Dividir entre "+denominador);
	System.exit(0);
   }
}