/**
 * @(#)FuerzaEntre2CargasPuntuales.java
 *
 * @ Programacion III
 * @author Prof. Alvaro Pino N.
 * @version 1
 * @Date: 22/11/2021
 *  
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FuerzaCargasPuntuales2 extends JFrame 
                // implements ActionListener
{
	
	private JButton jbtCalcularFuerza;
	private JButton jbtExit,jbtClear;
	
	private Punto punto1;
	private Punto punto2;
 	
	// Text fields for Point 1
  private JTextField jtfNumx1, jtfNumy1;	

// Text fields for Point 2
  private JTextField jtfNumx2, jtfNumy2;
 
// Text fields for the Force and distance
  private JTextField jtfValorFuerza, jtfValorDistancia;

// Text fields for Carga
  private JTextField  jtfCarga1,  jtfCarga2, jtfK;
  
  private Carga cargaUno, cargaDos;
  
  private Fuerza f;
   
  private double carga1, carga2;
  
    
   public String actionCommand;
   
	public FuerzaCargasPuntuales2(){	
	
	 // Panel p1 to hold text fields and labels
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new JLabel("Punto 1: "));
    p1.add(new JLabel("Coordenada x"));
    p1.add(jtfNumx1 = new JTextField(5));
    p1.add(new JLabel("Coordenada y"));
    p1.add(jtfNumy1 = new JTextField(5));
   
    p1.add(new JLabel("Carga 1: "));
    p1.add(jtfCarga1 = new JTextField(5));
   
   // Panel p3 to hold text fields and labels 
    JPanel p3 = new JPanel();
    p3.setLayout(new FlowLayout());
    p3.add(new JLabel("Punto 2: "));
    p3.add(new JLabel("Coordenada x"));
    p3.add(jtfNumx2 = new JTextField(5));
    p3.add(new JLabel("Coordenada y"));
    p3.add(jtfNumy2 = new JTextField(5));
  
    p3.add(new JLabel("Carga 2:"));
    p3.add(jtfCarga2 = new JTextField(5));
         
    // Panel p43 to hold text fields and labels 
    JPanel p43 = new JPanel();
    p43.setLayout(new FlowLayout());
     
    p43.add(new JLabel("          Fuerza:"));
   p43.add(new JLabel("  "));
    p43.add(jtfValorFuerza = new JTextField(8));
    jtfValorFuerza.setEditable(false);
    
    p43.add(new JLabel("Distancia:"));
    
    p43.add(jtfValorDistancia = new JTextField(8));
    
    jtfValorDistancia.setEditable(false);
    
    p43.add(new JLabel("K:"));
       
    p43.add(jtfK = new JTextField(5));
    jtfK.setText(String.valueOf(Fuerza.K));
    jtfK.setEditable(false);
  
	// Panel p2 to hold buttons
    JPanel p2 = new JPanel();
    
    p2.setLayout(new FlowLayout()); 
    p2.add(jbtCalcularFuerza = new JButton("CalcularFuerza"));
    
    p2.add(jbtClear = new JButton("Clear"));
    p2.add(jbtExit = new JButton("Exit"));
      
    // Add panels to the frame
    JPanel p4 = new JPanel(new GridLayout(4,1));
    p4.add(p1);
    p4.add(p3);
    p4.add(p43);
     
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p4, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);
     
    // Register listeners
   jbtCalcularFuerza.addActionListener(new ActionListener()
   {
   	  /** Handle ActionEvent from buttons and menu items */
 public void actionPerformed(ActionEvent e)
  	 {
     actionCommand = e.getActionCommand();
      	
 if ("CalcularFuerza".equals(actionCommand))
   { 
     sacaValores();
     realizarCalculos();   
     desplegarSolucion();  
   }
     
   } // fin del metodo actionPerformed
   });
   
   	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	
   jbtExit.addActionListener(new ActionListener() {
    	
    	public void actionPerformed(ActionEvent e) {
    		String actionCommand = e.getActionCommand();
    	//	if ("Exit".equals(actionCommand))
    	 
                System.exit(0);
    	} 
    });
    
    jbtClear.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    /*	String actionCommand = e.getActionCommand();	
    		if ("Clear".equals(actionCommand))
      */         
              clear();  
        
    	}
    });
   }
   
 
  
  	 
    public void sacaValores()
    {   	
      double numx1;
      double numy1;
      double numx2;
      double numy2;
             
    try
       	{
          numx1 = (Double.parseDouble(jtfNumx1.getText().trim()));
          numy1 = (Double.parseDouble(jtfNumy1.getText().trim()));
   
         punto1 = new Punto(numx1,numy1);
    
         numx2 = (Double.parseDouble(jtfNumx2.getText().trim()));
         numy2 = (Double.parseDouble(jtfNumy2.getText().trim()));
         
         punto2 = new Punto(numx2,numy2);
           
        carga1 = (Double.parseDouble(jtfCarga1.getText().trim()));
        carga2 = (Double.parseDouble(jtfCarga2.getText().trim()));
         
        cargaUno = new Carga(carga1,punto1);
        cargaDos = new Carga(carga2,punto2);
           
      }catch(NumberFormatException m)
      {
      	 // Display the result in a message dialog box
       JOptionPane.showMessageDialog(null, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clearText();
             return; 
      }
    }
    
   public void realizarCalculos()
   {
   		System.out.println("Distancia:" + punto1.calcDistancia(punto2));
	
		System.out.println("Punto 1" + punto1.getDetails());
		System.out.println("Punto 2" + punto2.getDetails());
		
		Distancia d = new Distancia(punto1, punto2);
		System.out.println(d.getDetails());
		
		System.out.println(cargaUno.getDetails());
		System.out.println(cargaDos.getDetails());
		
		System.out.println(" K = " +Fuerza.K);
		
		 f = new Fuerza(cargaUno, cargaDos);
		 
		
		System.out.println(" K = " +f.getK());
		
		System.out.println(" Fuerza = " + f.getDetails());
     
   }
   
  public void desplegarSolucion()
    {
    if("CalcularFuerza".equals(actionCommand) )
    {
          jtfValorFuerza.setText(String.valueOf(f.getFuerza()));
          jtfValorDistancia.setText(String.valueOf(f.getDistancia()));
       //   jtfK.setText(String.valueOf(f.getK()));
       //jtfK.setText(String.valueOf(Fuerza.K));
    }     	       
  }
	
/** Main method */
  public static void main(String[] args) {
  	
  FuerzaCargasPuntuales2 frame = new FuerzaCargasPuntuales2();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
/*	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) 
	/ 2, (d.height - frame.getSize().height)/2);
*/	
    frame.setVisible(true);   
  }
  
  
 private  void clear()
   {
   	jtfNumx1.setText("");
   	jtfNumy1.setText("");	
   	jtfNumx2.setText("");
   	jtfNumy2.setText("");
  
   	jtfCarga1.setText("");
   	jtfCarga2.setText("");
   	 jtfValorFuerza.setText("");
     jtfValorDistancia.setText("");
   
   } 	
   	
public void clearText()
{
String cad="";
String sjtextnumx1, sjtextnumy1;
String sjtextnumx2, sjtextnumy2;
String sjtextnumx3, sjtextnumy3;

sjtextnumx1=jtfNumx1.getText().trim();
sjtextnumy1=jtfNumy1.getText().trim();
	
sjtextnumx2=jtfNumx2.getText().trim();
sjtextnumy2=jtfNumy2.getText().trim();

                  
if ( !(sjtextnumx1.equals("") || sjtextnumy1.equals(""))   ||
     !(sjtextnumx2.equals("") || sjtextnumy2.equals("")) || 
    
      ( sjtextnumx1.length() != 0  || sjtextnumy1.length()  != 0) ||
      ( sjtextnumx2.length() != 0  || sjtextnumy2.length()  != 0) 
       )    
  {
   
	  clear(); 	
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
		
 } // fin de la clase.

