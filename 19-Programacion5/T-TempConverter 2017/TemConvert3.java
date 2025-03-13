/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 25/05/2017
 *
 */

import javax.swing.*;
import java.awt.*;



public class TemConvert3 
{
	private double gradCelsius;
	private double gradFarenheit;
	private Frame frame;
	private Panel panWest;
	private Panel panEast;
	private Panel panNorth;
	private Panel panSouth;
	
	
public 	TemConvert3(String title)
	{
	  frame    = new  Frame(title);
	  panWest  = new Panel();
	  panEast  = new Panel();
	  panNorth = new Panel();
	  panSouth = new Panel();
	  
		gradCelsius=0.0;
		gradFarenheit=32.0;
		
	}
	
	public void launchFrame()
	{
		
    Color c1 = new Color(255,165,0);
	frame.setBackground(c1);
 
 	frame.setSize(500,500);
 	frame.setResizable(false);
 	
	
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);

    panNorth.setSize(100,100);
	panNorth.setBackground(Color.yellow);
	frame.add(panNorth,BorderLayout.NORTH);
	
	panSouth.setSize(100,100);
	panSouth.setBackground(Color.yellow);
	frame.add(panSouth,BorderLayout.SOUTH);
	
	panWest.setSize(100,100);
	panWest.setBackground(Color.yellow);
	frame.add(panWest,BorderLayout.WEST);
	
	panEast.setSize(100,100);
	panEast.setBackground(Color.yellow);
	frame.add(panEast,BorderLayout.EAST);
	
	frame.setVisible(true);
		
		
	}
	
	public Frame getFrame()
	{
		return (frame);
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
		
	TemConvert3 tconv = new TemConvert3("Convertidor de Temperatura ");
		
		tconv.launchFrame();
		
		String respuesta;
		double grados=0;
		
		int opcion = 0;
			
		do
		
		{  
   	respuesta = JOptionPane.showInputDialog(tconv.getFrame(),
				"\n [1] Farenheit to Celsius \n "+
				"\n [2] Celsius to Fareenheit \n "+
				"\n [3] Desplegar \n" +
				"\n [4] Salir \n",
				"Menu de Convertir Grados",
				JOptionPane.QUESTION_MESSAGE);
				
	if (respuesta == null ) { tconv.getFrame().dispose();
				              break;	
				            }
	try
	 {
			 	
		opcion= Integer.parseInt(respuesta);
		
	 }catch(NumberFormatException e)
	  {
	  // Display the result in a message dialog box
JOptionPane.showMessageDialog(tconv.getFrame(), 
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
       JOptionPane.showMessageDialog(tconv.getFrame(), 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
       opcion= 0;
       continue;     
 	  }
 	
   tconv.farenheitToCelsius(grados);
 
 
 // Display the result in a message dialog box
 JOptionPane.showMessageDialog(tconv.getFrame(),
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
       JOptionPane.showMessageDialog(tconv.getFrame(), 
       "Tiene que ingresar un valor double",
       " Esto es un ERROR" ,
       JOptionPane.ERROR_MESSAGE);
        
       opcion= 0;
       continue;     
 	  }
		
    tconv.celsiusToFarenheit(grados);
  
// Display the result in a message dialog box
JOptionPane.showMessageDialog(tconv.getFrame(), 
                         tconv.getCelToFaren(),
         "Convertidor de Celsius To Farenheit",
          JOptionPane.INFORMATION_MESSAGE);          	
         break;

case  3:  
     
// Display the result in a message dialog box
JOptionPane.showMessageDialog(tconv.getFrame(), 
                         tconv.getCelToFaren(),
         "Convertidor de Celsius To Farenheit",
              JOptionPane.INFORMATION_MESSAGE);        
              break;
              
 case 4: tconv.getFrame().dispose();
    break;
              
 default:
         // Display the result in a message dialog box
JOptionPane.showMessageDialog(tconv.getFrame(), 
                            "Esto es un ERROR",
                           "Opcion Incorrecta",
                           JOptionPane.ERROR_MESSAGE);      
         opcion= 0;
         break;
             		
	}  // fin del switch		
 
		 				
	}while (opcion >= 0 && opcion <= 3 && opcion != 4); 

 } // fin del main
	
}