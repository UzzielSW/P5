/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 1/06/2017
 *inner class Temp2CTFListener 
 */

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class TempCoverter6 extends JFrame 
{
	private JButton jbCelsius, jbFarenheit,jbClear, jbExit ;
	public  JLabel  jlCel, jlFar;
	public  JTextField jtextCel, jtextFar;

	public  TempCoverter6(String title)
	{
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
		
		jbCelsius = new JButton("To Farenheit");
		jbFarenheit = new JButton("To Celsius");
		jbClear = new JButton("Clear");
		jbExit = new JButton("Exit");

        jlCel= new JLabel("Celsius");
        jlFar= new JLabel("Farenheit");
          
	    jtextCel= new JTextField(20);
	    jtextFar= new JTextField(20);
	   
	   //add the Jlabels and TextFields  to the frame
	   
		JPanel north = new JPanel();
		north.add(jlCel);
		north.add(jtextCel);
		north.add(jlFar);
        north.add(jtextFar);
        contentPane.add(north, BorderLayout.NORTH);
        
		//add the buttons to the frame
		JPanel south = new JPanel();
		south.add(jbCelsius);
		south.add(jbFarenheit);
		south.add(jbClear);
		south.add(jbExit);

		contentPane.add(south, BorderLayout.SOUTH);
		
		//register the event listener
		
Temp2CTFListener CTFListener = new Temp2CTFListener( );

		jbCelsius.addActionListener(CTFListener);
		jbFarenheit.addActionListener(CTFListener);
		jbClear.addActionListener(CTFListener);
		jbExit.addActionListener(CTFListener);
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
		String cadCel="";
	    String cadFar="";
	    jtextCel.setText(cadFar);
	    jtextFar.setText(cadCel); 


	}
	
	public static void main(String [] args)
	{
		JFrame frame = new TempCoverter6("Convertir Celsius To Farenheit To Celsius");
	
	frame.pack();
	frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
		
	}

public class Temp2CTFListener implements ActionListener
{
	
	
	
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
       JOptionPane.showMessageDialog(null, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clearText();
             return; 
	        }
			grados = celsiusToFarenheit(grados);
 	        jtextFar.setText(String.valueOf(grados));
 	        
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
       JOptionPane.showMessageDialog(null, 
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

	
	
}