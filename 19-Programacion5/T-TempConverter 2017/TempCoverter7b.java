/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 1/06/2017
 *Fecha: 9/06/2017
 *Anonimus class  
 */

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class TempCoverter7b extends JFrame 
{
	private JButton jbCelsius, jbFarenheit,jbClear, jbExit ;
	public  JLabel  jlCel, jlFar;
	public  JTextField jtextCel, jtextFar;
	
	private String cadena;
	private double grados;
	private JButton jb;
	private JTextField jtf;
	private JMenuItem jmi;
	
// Menu items "Celsius To Farenheit", "Farenheit to Celsius", "Multiply","Divide" and "Close"
  private JMenuItem jmiCelToFar, jmiFarToCel, 
                    jmiClose,jmiLimpiar;

	public  TempCoverter7b(String title)
	{
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
            
      	// Create menu bar
    JMenuBar jmb = new JMenuBar();

    // Set menu bar to the frame
    setJMenuBar(jmb);

    // Add menu "Operation" to menu bar
    JMenu operationMenu = new JMenu("Operation");
    operationMenu.setMnemonic('O');
    jmb.add(operationMenu);

    // Add menu "Exit" in menu bar
    JMenu exitMenu = new JMenu("Exit");
    exitMenu.setMnemonic('E');
    jmb.add(exitMenu);
    
    // Add menu Limpiar in menu bar
    JMenu limpiarMenu = new JMenu("Limpiar");
    limpiarMenu.setMnemonic('L');
    jmb.add(limpiarMenu);

    // Add menu items with mnemonics to menu "Operation"
    operationMenu.add(jmiCelToFar= new JMenuItem("Celsius To Farenheit", 'F'));
    operationMenu.add(jmiFarToCel = new JMenuItem("Farenheit To Celsius", 'G'));
   
    
    exitMenu.add(jmiClose = new JMenuItem("Stop", 'S'));
    limpiarMenu.add(jmiLimpiar = new JMenuItem("Limpiar", 'L'));
      
       
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
		
		// Set keyboard accelerators
    jmiCelToFar.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    jmiFarToCel.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
    
    jmiLimpiar.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    
		
		//register the event listener
		
 		
jtextCel.addKeyListener(new KeyListener ()
	{
		 // Handle Key events
  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}	 
 
  public void keyPressed(KeyEvent key) {
  	  				 	         
	      switch (key.getKeyCode()){
   	
            case KeyEvent.VK_ENTER:
      
       	       cadena=jtextCel.getText().trim();
               procesoCelTF(jtextCel);
    
	              break;
	              default: break;	    
	         }  // fin del switch	     
	   }// fin del if KeyPressed
	}// fin del de la clase anonima KeyListener  
     );	// fin del metodo addKeyListener
	
jtextFar.addKeyListener(new KeyListener ()
	{
		 // Handle Key events
  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}	 
 
  public void keyPressed(KeyEvent key) 
      {
	         
	      switch (key.getKeyCode()){
   	
            case KeyEvent.VK_ENTER:
     
			        cadena=jtextFar.getText().trim();
		         	procesoCelTF(jtextFar); 
	         
	         break;
	              default: break;	    
	         }     // fin del switch	     
	  }  // fin del Metodo KeyPressed
	} // fin de la clase Anonima KeyEventListener
	);	// fin del metodo addKeyListener
		
	jmiCelToFar.addActionListener(new ActionListener() 
	{
	  public void actionPerformed(ActionEvent a)
	    {   				
		 cadena=jtextCel.getText().trim();
         procesoCelTF(jmiCelToFar);
	    } // fin del metodo ActionPerformed	
	}     // fin de la clase anonima AcctionListener
	 );   // fin del metodo addActionListener
		
	jmiFarToCel.addActionListener(new ActionListener() 
	    {
	      public void actionPerformed(ActionEvent a)
	      {   
			cadena=jtextFar.getText().trim();
            procesoCelTF(jmiFarToCel);
		  }	
	    }
	  );	
	
	jmiLimpiar.addActionListener(new ActionListener() 
	{
    	public void actionPerformed(ActionEvent a)
	    {   						
	    	clearText();
		}	
	}
	  );
	
	jmiClose.addActionListener(new ActionListener() 
	{
	   public void actionPerformed(ActionEvent a)
	   {   					
	    System.exit(0);
	   }	
	}
	  );
                     
   		           	

jbCelsius.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent a)
	{   
			cadena=jtextCel.getText();
			procesoCelTF(jbCelsius);
			
	}// fin del metodo actionPerformed()
  }	// fin de la clase anonima ActionListener
 ); // fin del metodo addActionListener()
			 
			 
jbFarenheit.addActionListener( new ActionListener(){
		public void actionPerformed(ActionEvent a)
	     {   	
			cadena=jtextFar.getText();
			procesoCelTF(jbFarenheit);
	
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

public void procesoCelTF(Object jbo)
	{					
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
	       	      
	  if(  jbo.equals(jbCelsius) || jbo.equals(jtextCel) ||
	             jbo.equals(jmiCelToFar))
	   {
		grados = celsiusToFarenheit(grados);	
 	    jtextFar.setText(String.valueOf(grados));
 	   }
  else 
 	 if( jbo.equals(jbFarenheit) ||jbo.equals(jtextFar) ||
 	         jbo.equals(jmiFarToCel) )
 	      {
 	          grados = farenheitToCelsius(grados);
 	          jtextCel.setText(String.valueOf(grados));
 	      }
 	              	        
     }	// fin del metodo procesoCelTF


		
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
frame = new TempCoverter7b("Annonimus class Celsius-Farenheit-Celsius ");
	
	frame.pack();
	frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
		
	}
	
}

	
	
