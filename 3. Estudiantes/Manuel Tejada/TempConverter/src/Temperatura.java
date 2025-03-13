/**
 *Programa del Temperature Converter
 *Creado por...
 *Nombre : Manuel Tejada
 *Cedula : 8-818-1801
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
public class Temperatura extends JFrame implements ActionListener,KeyListener,MouseListener{

private JTextField jtf_Celsius,jtf_Fahrenheit;
private JLabel jl_Celsius,jl_Farenheit;
private JPanel jp_Este,jp_Oeste;
private ConvertTemp obj_convert;

    public Temperatura() {
    	super("TempConverter");
    	     	
    	obj_convert=new ConvertTemp();
    
    	setLayout(null);
    	jl_Celsius=new JLabel("Celsius");
    	jl_Farenheit=new JLabel("Farenheit");
    	
    	jtf_Celsius =new JTextField(5);
    	jtf_Fahrenheit=new JTextField(5);

		jtf_Celsius.setActionCommand("Celcius");
		jtf_Fahrenheit.setActionCommand("Farenheit");
		
		jtf_Celsius.addActionListener(this);
		jtf_Fahrenheit.addActionListener(this);
		
		jtf_Celsius.addKeyListener(this);
		jtf_Fahrenheit.addKeyListener(this);
    	
    	jtf_Celsius.addMouseListener(this);
		jtf_Fahrenheit.addMouseListener(this);
    	
    	jp_Este=new JPanel(new GridLayout(2,1));
    	jp_Oeste=new JPanel(new GridLayout(2,1,0,5));
    	
    }
    
    
      
      
    public void  Pintame(){
    
    	
    	jp_Este.add(jl_Celsius);
    	jp_Oeste.add(jtf_Celsius);
    	
    	jp_Este.add(jl_Farenheit);
    	jp_Oeste.add(jtf_Fahrenheit);
    	
    	jp_Este.setBounds(2,5,70,60);
    	jp_Oeste.setBounds(72,10,100,50);
    	
    	add(jp_Este);
    	add(jp_Oeste);
    	setSize(210,100);
       
    }
    
   
    //Action listener
    public void actionPerformed(ActionEvent e){
    	System.out.print(""+e.getActionCommand());
    	try
    	{
    	
    	if(e.getActionCommand().equals("Celcius")){
    		jtf_Fahrenheit.setText("");
    		jtf_Fahrenheit.setText(""+obj_convert.celsiusToFarenheit(Double.parseDouble(jtf_Celsius.getText())));
    	}
    	else if(e.getActionCommand().equals("Farenheit")){
    		jtf_Celsius.setText("" +obj_convert.farenheitToCelsius(Double.parseDouble(jtf_Fahrenheit.getText())));
    		
    	}
    	}
    	catch(Exception ex){
     	 	if(e.getSource().equals(jtf_Celsius)){
     	 		jtf_Fahrenheit.setText("");
     	 		     	 	}
     	 else if(e.getSource().equals(jtf_Fahrenheit)){
     	 	jtf_Celsius.setText("");
     	 }
     	 }
    		
    }
    
    //Key listener
    
     public void keyPressed(KeyEvent e) { }
     public void keyTyped(KeyEvent e)   { }
     public void keyReleased(KeyEvent e){ 
     	try
     	{
     	 if(e.getSource().equals(jtf_Celsius)){
     	 	jtf_Fahrenheit.setText(""+obj_convert.celsiusToFarenheit(Double.parseDouble(jtf_Celsius.getText())));
     	  }
     		else if(e.getSource().equals(jtf_Fahrenheit)){
     	    jtf_Celsius.setText("" +obj_convert.farenheitToCelsius(Double.parseDouble(jtf_Fahrenheit.getText())));
     		}
     }
     catch(Exception ex){
     	 	if(e.getSource().equals(jtf_Celsius)){
     	 		jtf_Fahrenheit.setText("");
     	 		     	 	}
     	 else if(e.getSource().equals(jtf_Fahrenheit)){
     	 	jtf_Celsius.setText("");
     	 }
     	 }
     
     }
     
     //MouseListener
     public void mouseClicked(MouseEvent e){
     	try
     	{
     	
     	if(e.getSource().equals(jtf_Celsius)){
     		jtf_Celsius.setText("");
     	}
     	else if(e.getSource().equals(jtf_Fahrenheit)){
     		jtf_Fahrenheit.setText("");
     	 }
     	 }
     	 catch(Exception ex){
     	 	if(e.getSource().equals(jtf_Celsius)){
     	 		jtf_Fahrenheit.setText("");
     	 		     	 	}
     	 else if(e.getSource().equals(jtf_Fahrenheit)){
     	 	jtf_Celsius.setText("");
     	 }
     	 }
     	 }
     public void mousePressed(MouseEvent e){ }
     public void mouseReleased(MouseEvent e){ }
     public void mouseEntered(MouseEvent e) {  }
     public void mouseExited(MouseEvent e){ }
     
    
    
  

}