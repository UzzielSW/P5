/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 31/05/2017
 *Fecha: 01/06/2017
 *
 */

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class TempCoverter4 extends JFrame
              implements ActionListener, KeyListener
{
	private JButton jbCelsius, jbFarenheit,jbClear, jbExit ;
	private  JLabel  jlCel, jlFar;
	private  JTextField jtextCel, jtextFar;
	
	private String cadena;
	private	double grados;

	public  TempCoverter4(String title)
	{
		super(title);
this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
        Container contentPane = this.getContentPane();
		
		jbCelsius = new JButton("To Farenheit");
		jbFarenheit = new JButton("To Celsius");
		jbClear = new JButton("Clear");
		jbExit = new JButton("Exit");

        jlFar= new JLabel("Farenheit");
        jlCel= new JLabel("Celsius");
          
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

		jbCelsius.addActionListener(this);
		jbFarenheit.addActionListener(this);
		jbClear.addActionListener(this);
		jbExit.addActionListener(this);
		
		jtextCel.addKeyListener(this);
		jtextFar.addKeyListener(this);
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
	
	public void actionPerformed(ActionEvent a)
	{   
				
		String label = a.getActionCommand();
		
		if(label.equals("To Farenheit"))
		{
			cadena=jtextCel.getText().trim();
			try
			{
			
			grados = Double.parseDouble(cadena);
			
			}catch(NumberFormatException e)
	        {
	   // Display the result in a message dialog box
 JOptionPane.showMessageDialog(this, 
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
			cadena=jtextFar.getText().trim();
			
		try
			{
			grados = Double.parseDouble(cadena);
			}catch(NumberFormatException e)
	        {
	   // Display the result in a message dialog box
       JOptionPane.showMessageDialog(this, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clearText();
             return; 
	        }
			grados = farenheitToCelsius(grados);
 	        jtextCel.setText(String.valueOf(grados));
	
			this.setBackground(Color.BLUE);
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
	
// fin del metodo action performed
	
	 public void keyReleased(KeyEvent e) {
  }

  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
  	
  	
   switch (e.getKeyCode()){
   	
      case KeyEvent.VK_ENTER:
      
        double grados;
        String cadena;
       	JTextField j = (JTextField)e.getSource();
       	
       	if(j.equals(jtextCel))
       	{
       	
       	cadena=jtextCel.getText().trim();
       	
			try
			{
			
			grados = Double.parseDouble(cadena);
			
			}catch(NumberFormatException a)
	        {
	   // Display the result in a message dialog box
       JOptionPane.showMessageDialog(this, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clearText();
             return; 
	        }
	        
			grados = celsiusToFarenheit(grados);
 	        jtextFar.setText(String.valueOf(grados));
 	   
		}
		else if(j.equals(jtextFar))
			{	
			cadena=jtextFar.getText().trim();
			
		try
			{
			grados = Double.parseDouble(cadena);
			}catch(NumberFormatException b)
	        {
	   // Display the result in a message dialog box
       JOptionPane.showMessageDialog(this, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clearText();
             return; 
	        }
			grados = farenheitToCelsius(grados);
 	        jtextCel.setText(String.valueOf(grados));
	
			this.setBackground(Color.BLUE);
		}
		break;
     
      //default: keyChar = e.getKeyChar();
    }
        
   
  }

	public static void main(String [] args)
	{
		JFrame frame = new TempCoverter4("Convertir Celsius To Farenheit To Celsius");
	
	frame.pack();
	frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
		
	}
	
	
}