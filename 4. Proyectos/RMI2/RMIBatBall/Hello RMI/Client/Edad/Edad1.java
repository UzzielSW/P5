import java.io.*;

public class Edad1
{
	public static void main(String[] args) throws IOException
	{
		int age;
		
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
	
		System.out.print("Enter your age:  ");
		
		String  text  = input.readLine();
		
		try{
		
      		try{
					
			     age = new Integer(text).intValue();
		    
		       }catch(NumberFormatException e)
		       {
			    System.out.println("Tiene que ingresar un valor entero");
			    return;
		       }
	     
	        valida(age);
	   
	        System.out.println("You are " + age + " years old, now. ");
		
	    	int years = 2018 - age;
	
		    System.out.println("so you were probably born in " + years);
		
	    }catch(EdadException e){}   
		
	 	
	}
	
	public static void valida( int edad ) throws EdadException
	 {
	 	if ( edad > 2018 || edad < 0  )
	 	
	 	  throw new EdadException(edad);
	 	  
	 }
}

class EdadException extends Exception
{
	private int edad;

	EdadException( int edad)
	{
		this.edad = edad;
		System.out.println("Su Edad es incorrecta! ");
		System.out.println("Ingrese una edad mayor que cero y menor de 2018");
		System.exit(0);
	}
}

















