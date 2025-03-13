import java.rmi.*;
import java.io.*;

public class Cliente 
{
	public static void main(String [] args)
	{
	//	String mensaje="";
		
		try{
			
		BufferedReader entrada =
 new BufferedReader(new InputStreamReader(System.in));	
		System.out.println("Introduce radio: ");
		String cadena = entrada.readLine();
		InterfaceArea obj = (InterfaceArea)Naming.lookup("//127.0.0.1/ObjetoArea");
	/*	mensaje = obj.saluda(nombre);
		
		System.out.println(mensaje);
	*/
	    double radio = Double.parseDouble(cadena);
	    obj.calcArea(radio);
			
		}catch (Exception e)
		{
		System.out.println("Exception: " + e.getMessage());
 		
 		e.printStackTrace();	
		}
		
	}
	
}