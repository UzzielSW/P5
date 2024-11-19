/**
 * @(#)TempConverterR.java
 *  TempConverter application
 *  Ronnie Rodriguez
 *  6-713-1244
 *  @version 1.00 2009/9/21
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TempConverterR extends JFrame implements ActionListener
 {
 	private JPanel JPa1,JPa2,JPa3;
    private JTextField jtfCelcius, jtfFahrenheit;
    private JLabel jlCelcius, jlFahrenheit;
    
    
    public TempConverterR() 
    {
    	JPa1=new JPanel(new FlowLayout());
    	JPa2=new JPanel(new FlowLayout());
    	JPa3=new JPanel(new BorderLayout(2,1));
    	
    	jtfCelcius=new JTextField(10);
    	jtfCelcius.addActionListener(this);
    	jtfCelcius.setActionCommand("c");
    	
    	
    	    	
    	jtfFahrenheit=new JTextField(10);
    	jtfFahrenheit.addActionListener(this);
    	jtfFahrenheit.setActionCommand("f");
    	
    	
    	jlCelcius=new JLabel ("Celcius");
    	jlFahrenheit=new JLabel("Fahrenheit");
    	
    	JPa1.add(jlCelcius);
    	JPa1.add(jtfCelcius);
    	
    	
    	JPa2.add(jlFahrenheit);
    	JPa2.add(jtfFahrenheit);
    	
    	JPa3.add(JPa1,BorderLayout.NORTH);    	
    	JPa3.add(JPa2,BorderLayout.SOUTH);
    	
    	this.add(JPa3,BorderLayout.CENTER);
    }
    
    public  void actionPerformed(ActionEvent e)
    {    
    	double  Temp;
    	
		try{
		
			 		
		if(e.getSource()==jtfCelcius)/*e.getActionCommand().equals("c")*/
		{			
			
			
			Temp=((Double.parseDouble(jtfCelcius.getText()))*1.8)+32;	    
			jtfFahrenheit.setText(""+Temp);
		}
		
		else if(e.getSource()==jtfFahrenheit)/*e.getActionCommand().equals("f")*/
	    	{
	    		Temp=((Double.parseDouble(jtfFahrenheit.getText()))-32)/1.8;
	    		jtfCelcius.setText(" "+Temp);
			}  
		
		}
		catch(NumberFormatException g)
		
			{
			    System.out.println("Tiene que ingresar un valor numerico");
			   	JOptionPane.showMessageDialog(this,"Ingrese un valor Numerico");
  	        }
		
		 
    }

}

