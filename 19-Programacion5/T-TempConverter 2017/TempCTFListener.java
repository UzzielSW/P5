/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 1/06/2017
 *
 */

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class TempCTFListener implements ActionListener
{
	Container container;
	private JButton jbCelsius, jbFarenheit,jbClear, jbExit ;
	public  JLabel  jlCel, jlFar;
	public  JTextField jtextCel, jtextFar;

  public TempCTFListener(JFrame jframe, JButton [] jb, 
  	                    JTextField [] jt)
  {
  	container = jframe;
  	jbCelsius = jb[0];
  	jbFarenheit = jb[1];
  	jbClear = jb[2];
  	jbExit = jb[3];
  	jtextCel = jt[0];
  	jtextFar = jt[1];
  }
  
  public double celsiusToFarenheit(double gradosCel)
	{
	
	return( ( gradosCel )*9.0/5.0 + 32.0);
	
	}
	public double farenheitToCelsius(double gradosFar)
	{
	   return(( gradosFar - 32.0 )*5.0/9.0);
	  
	}
	
	public void clearText()
	{
		String cadCel="                    ";
	    String cadFar="                    ";
	    jtextCel.setText(cadFar);
	    jtextFar.setText(cadCel); 


	}
	
public void actionPerformed(ActionEvent a)
	{   
		String cadena;
		double grados;
		
		String label = a.getActionCommand();
		if(label.equals("To Farenheit"))
		{
			cadena=jtextCel.getText();
			try
			{
			
			grados = Double.parseDouble(cadena);
			
			}catch(NumberFormatException e)
	        {
	   // Display the result in a message dialog box
       JOptionPane.showMessageDialog(container, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clearText();
             return; 
	        }
			grados = celsiusToFarenheit(grados);
 	        jtextFar.setText(String.valueOf(grados));
 	        
		//	this.setBackground(Color.RED);
		}
		else if(label.equals("To Celsius"))
			{	
			cadena=jtextFar.getText();
			
		try
			{
			grados = Double.parseDouble(cadena);
			}catch(NumberFormatException e)
	        {
	   // Display the result in a message dialog box
       JOptionPane.showMessageDialog(container, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clearText();
             return; 
	        }
			grados = farenheitToCelsius(grados);
 	        jtextCel.setText(String.valueOf(grados));
	
		
		}
		else if(label.equals("Clear"))
		{
			clearText();
		}
		else if(label.equals("Exit"))
		{
			System.exit(0);
		}
	}
	
}