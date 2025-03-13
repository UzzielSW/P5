import java.io.*;

public class Edad0
{
	public static void main(String[] args) throws IOException
	{
		int age;
		
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
	
		System.out.print("Enter your age:  ");
		
		String  text  = input.readLine();
				
		age = new Integer(text).intValue();

	    System.out.println("You are " + age + " years old, now. ");
		
	    int years = 2018 - age;
	
		System.out.println("so you were probably born in " + years);
		
	    
		 	
	}
	
	
}

