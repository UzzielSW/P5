/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 1/06/2017
 *Fecha: 9/06/2017
 *Anonimus class  
 */

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class TempCoverter7 extends JFrame 
{
	private JButton jbCelsius, jbFarenheit,jbClear, jbExit ;
	public  JLabel  jlCel, jlFar;
	public  JTextField jtextCel, jtextFar;
	
	private String cadena;
	private double grados;

	public  TempCoverter7(String title)
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
		

jbCelsius.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent a)
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
	}// fin del metodo actionPerformed()
  }	// fin de la clase anonima ActionListener
 ); // fin del metodo addActionListener()
			 
			 
jbFarenheit.addActionListener( new ActionListener(){
		public void actionPerformed(ActionEvent a)
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
	
		} // fin del metodo actionPerformed()
	     
       }  // fin de la clase anonima
    );   // fin del metodo addActioListener()
		

jbClear.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent a)
	     {   		
			clearText();
	     } // fin del metodo actionPerformed()
		} // fin de la clase anonima
	);// fin del metodo addActioListener()
		
		
jbExit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent a)
	     {   		
			System.exit(0);
		 }// fin del metodo actionPerformed()
	  }// fin de la clase anonima
    );// fin del metodo addActioListener()
	
	} // fin del Constructor de la clase TempCoverter7
		
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
String cad="";
String sjtextC, sjtextF;
sjtextC=jtextCel.getText().trim();
sjtextF=jtextFar.getText().trim();
	
	                    
if ( !(sjtextC.equals("") || sjtextF.equals("")) ||
     ( sjtextC.length() != 0  || sjtextF.length()  != 0))    
  {
   jtextCel.setText(cad);
   jtextFar.setText(cad);
	   	
  }
else
	{
	   	 // Display the result in a message dialog box
     JOptionPane.showMessageDialog(this, 
                 "Los campos  estan limpios",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            
      return; 
	}
 }	
	
	public static void main(String [] args)
	{
JFrame frame;
frame = new TempCoverter7("Annonimus class Celsius-Farenheit-Celsius ");
	
	frame.pack();
	frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
		
	}
	
}

	
	
