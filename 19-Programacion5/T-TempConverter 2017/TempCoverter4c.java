/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 31/05/2017
 *Fecha: 01/06/2017
 *Fecha: 07/06/2017
 *Fecha: 09/06/2017
 * ActionListener para JButton y JMenuItem; 
 * KeyListener para KeyEvent.VK_ENTER
 */

import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;

public class TempCoverter4c extends JApplet
              implements ActionListener, KeyListener
{
	private int x= 150, y= 100, gap = 5, w = 25, h = 70;

	private JButton jbCelsius, jbFarenheit,jbClear, jbExit ;
	private  JLabel  jlCel, jlFar;
	private  JTextField jtextCel, jtextFar;
	
	private String cadena;
	private	double grados;
	private JButton jb;
	private JTextField jtf;
	private JMenuItem jmi;
	
// Menu items "Celsius To Farenheit", "Farenheit to Celsius", "Multiply","Divide" and "Close"
  private JMenuItem jmiCelToFar, jmiFarToCel, 
                    jmiClose,jmiLimpiar;

	public  void init()
	{
	//	super(title);
//this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
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
		
	       

    // Set keyboard accelerators
    jmiCelToFar.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    jmiFarToCel.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
    
    jmiLimpiar.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    

		//register the event listener

		jbCelsius.addActionListener(this);
		jbFarenheit.addActionListener(this);
		jbClear.addActionListener(this);
		jbExit.addActionListener(this);
		jtextCel.addKeyListener(this);
		jtextFar.addKeyListener(this);
		
	jmiCelToFar.addActionListener(this);
    jmiFarToCel.addActionListener(this);
    
    jmiClose.addActionListener(this);
    jmiLimpiar.addActionListener(this);
	}
	
	
	public void paint(Graphics g)
{
 	Font font = new Font("SansSerif",Font.BOLD,22);
	g.setFont(font);
	
	g.setColor(Color.white);
	
	String text ="  ";
	
	g.drawString(text,x-100, y - 60);
	

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
	
	public void actionPerformed(ActionEvent a)
	{   
						
		conActionYKeyEvent(a);
		
	}
	
	public void conActionYKeyEvent(Object obj)
	{   
				
	if( obj instanceof ActionEvent )
	   {
	   	         
        ActionEvent action = (ActionEvent)obj;
        
       if (action.getSource() instanceof JButton) 
       {
                  
	    jb = (JButton)action.getSource();
	      	      
		if( jb.equals(jbCelsius)  )
		{
	        cadena=jtextCel.getText().trim();
			procesoCelTF(jbCelsius);			
		}
		else if(jb.equals(jbFarenheit))
			{	
			cadena=jtextFar.getText().trim();
			procesoCelTF(jbFarenheit);
			}
	    	else if(jb.equals(jbClear))
		        {
			     clearText();
		        }
		       else if(jb.equals(jbExit))
		           {
			       System.exit(0);
		           }
		// Handle menu item events
		           
   }    else if (action.getSource() instanceof JMenuItem)
    {
      
      
      jmi = (JMenuItem)action.getSource();
      
      if ( jmi.equals(jmiCelToFar) )
        { 
         cadena=jtextCel.getText().trim();
         procesoCelTF(jmiCelToFar);
        }
        
      else if (jmi.equals(jmiFarToCel))
        {
        cadena=jtextFar.getText().trim();
        procesoCelTF(jmiFarToCel) ;
         
        }
        else if (jmi.equals(jmiLimpiar))
                     clearText(); 
            else  if (jmi.equals(jmiClose))
                     System.exit(0);
   		           
  	 }
	}// fin del if del ActionEvent
   
   else  // Handle Key events
    if ( obj instanceof  KeyEvent )
	     {
	      KeyEvent key = (KeyEvent)obj;
	         
	      jtf = (JTextField)key.getSource();
	         
	      switch (key.getKeyCode()){
   	
            case KeyEvent.VK_ENTER:
      
       		if(jtf.equals(jtextCel))
             {
       	       cadena=jtextCel.getText().trim();
               procesoCelTF(jtextCel);
       	  
	         }else if(jtf.equals(jtextFar))
			      {	
			        cadena=jtextFar.getText().trim();
		         	procesoCelTF(jtextFar); 
	              }
	              break;
	              default: break;	    
	         }  // fin del switch	     
	   }// fin del if KeyEvent
	 
   }
   	
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
       
  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}

  public void keyPressed(KeyEvent e) {
  	
  	conActionYKeyEvent(e); 	 
  }

	public static void main(String [] args)
	{
 /*	JFrame frame = new TempCoverter4c("Celsius-Farenheit-Celsius 4b " +
	         "\n ActionListener-JButton y JMenuItem;" +
             "\n KeyListener-KeyEvent.VK_ENTER ");
	*/
	
	TempCoverter4c applet = new TempCoverter4c();
	
	JFrame  frame = new  JFrame();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Convertidor de temperatura");
/*	Color fondo =  new Color(0,192,255);
	applet.setBackground(fondo);
 */
	frame.getContentPane().add(applet, BorderLayout.CENTER);
	applet.init();
	
	//frame.setSize(600,400);
	
	frame.pack();
	
	frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
		
	}
		
}