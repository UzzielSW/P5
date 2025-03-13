/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 25/05/2017
 *
 */

import javax.swing.*;

public class TemConvert 
{
	private double gradCelsius;
	private double gradFarenheit;
	
public 	TemConvert()
	{
		gradCelsius=0.0;
		gradFarenheit=32.0;
	}
	
	public void farenheitToCelsius(double gradosFar)
	{
	   gradCelsius	= ( gradosFar - 32.0 )*5.0/9.0;
	   gradFarenheit= gradosFar;
	}
	
	public void celsiusToFarenheit(double gradosCel)
	{
	gradFarenheit	= ( gradosCel )*9.0/5.0 + 32.0;
	gradCelsius	 = gradosCel;
	}
	
	public String getCelToFaren()
	{
	
	return ("\n Celsius: " + gradCelsius +
	        "\n Farenheit: " + gradFarenheit );
	}
	
   public String getFarenToCels()
	{
	
	return ("\n Farenheit: " + gradFarenheit+
	        "\n Celsius: " + gradCelsius );
	}
	
	
	
	public static void main(String [] args)
	{
		
		TemConvert tconv = new TemConvert();
		
		String respuesta;
		double grados=0;
		
		int opcion = 0;
		
		
		do
		{
			respuesta = JOptionPane.showInputDialog(null,
				"\n [1] Farenheit to Celsius \n "+
				"\n [2] Celsius to Fareenheit \n "+
				"\n [3] Desplegar \n" +
				"\n [4] Salir \n",
				"Menu de Convertir Grados",
				JOptionPane.QUESTION_MESSAGE);
				
			if (respuesta == null ) break;	
	try
	 {
			 	
		opcion= Integer.parseInt(respuesta);
		
	 }catch(NumberFormatException e)
	  {
	       // Display the result in a message dialog box
JOptionPane.showMessageDialog(null, 
"Tiene que ingresar un valor entero",
" Esto es un ERROR" ,
 JOptionPane.ERROR_MESSAGE); 
 opcion= 0;
 continue;     
 	
	 
	 }
			
switch(opcion)
 {
   case	1: respuesta = JOptionPane.showInputDialog( " " +
		"\n Ingrese los grados Farenheit");
		
		if (respuesta == null ) break;	
		
		try
	    {
	    	
	 	 grados = Double.parseDouble(respuesta);
	 	
	 }catch(NumberFormatException e)
	  {
	       // Display the result in a message dialog box
JOptionPane.showMessageDialog(null, 
"Tiene que ingresar un valor double",
" Esto es un ERROR" ,
 JOptionPane.ERROR_MESSAGE); 
 opcion= 0;
 continue;     
 	}
 	
  tconv.farenheitToCelsius(grados);
 
 
 // Display the result in a message dialog box
 JOptionPane.showMessageDialog(null,
             tconv.getFarenToCels(),
 "Convertidor de Farenheit To Celsius", 
 JOptionPane.INFORMATION_MESSAGE);
 break;

   case 2: respuesta = JOptionPane.showInputDialog(" " +
		   "\n Ingrese los grados Celsius");
		   
		   if (respuesta == null ) break;	
	try{
		
	
		grados = Double.parseDouble(respuesta);
		
	 }catch(NumberFormatException e)
	  {
	       // Display the result in a message dialog box
JOptionPane.showMessageDialog(null, 
"Tiene que ingresar un valor double",
" Esto es un ERROR" ,
 JOptionPane.ERROR_MESSAGE); 
 opcion= 0;
 continue;     
 	}
		
tconv.celsiusToFarenheit(grados);
  
// Display the result in a message dialog box
JOptionPane.showMessageDialog(null, 
tconv.getCelToFaren(),
"Convertidor de Celsius To Farenheit", JOptionPane.INFORMATION_MESSAGE);          	
break;

case  3:  
            // Display the result in a message dialog box
JOptionPane.showMessageDialog(null, 
tconv.getCelToFaren(),
"Convertidor de Celsius To Farenheit", JOptionPane.INFORMATION_MESSAGE);        
              break;
              
 case 4: break;
              
 default:
         // Display the result in a message dialog box
JOptionPane.showMessageDialog(null, 
"Esto es un ERROR",
"Opcion Incorrecta", JOptionPane.ERROR_MESSAGE);      
           opcion= 0;
         break;
             		
			}		
 
		 				
}while (opcion >= 0 && opcion <= 3 && opcion != 4); 
	}
	
}