/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
/**
 *
 * @author DEC
 */
public class TestPunto 
{


public static void main (String [] args)
{
	double x1,y1;
try{
	
	    System.out.print("Enter Coordenada X1:  ");		
		String	text1 = captura();
      		
			x1= new Double(text1).doubleValue();
		System.out.print("Enter Coordenada Y1  ");
		
	    String	text2 = captura();
      		
		y1 = new Double(text2).doubleValue();
		
	 }catch(IOException e)
	  {
 
			    return;
	  }
	   catch(NumberFormatException e)
		       {
	System.out.println("Tiene que ingresar un valor");
			    return;
		       }


 Punto p1=new Punto(x1,y1);
    
  /*  Punto p1 = new Punto();
          
          p1.setX(x1);
          
          p1.setY(y1);
    */      
System.out.println("la coordenadas (x,y) de p1 son: " + p1.getDetails());
}  

	public static String captura() throws IOException
		{
		
		 InputStreamReader reader = new InputStreamReader(System.in);
		 BufferedReader input = new BufferedReader(reader);
		 String  text  = input.readLine();
		
		 return (text);
		}      
}
