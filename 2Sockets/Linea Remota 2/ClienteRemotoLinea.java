/**
 * @(#)Bat.java
 *
 *
 * @author Prof. Alvaro Pino N.
 * @version 1.00 2018/11/9
 * Programa Servidor que genera el objeto remoto y 
 * lo ofrece a traves de RMI.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

import javax.swing.JOptionPane;

public class ClienteRemotoLinea extends JFrame implements ActionListener
{
	
	private JButton jbtPend,jbtB,jbtExit,jbtClear;
	
	public Punto p1;
	public Punto p2;
	
	public Punto interX;
	public Punto interY;
	public double m;
	public double b;
	public boolean existe;
	
	String infinito;
	
	// Text fields for Number 1, Number 2, Result and jtfB
  private JTextField jtfNum1, jtfNum2, jtfResult,jtfB;
  private JTextField jtfNum12, jtfNum22, jtfResult2,jtfB2;	


	public ClienteRemotoLinea(){
	//	this.p1=new Punto(2.0,0.0);
	//	this.p2=new Punto(2.0,2.0);
	
	
	 // Panel p1 to hold text fields and labels
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new JLabel("Punto 1"));
    p1.add(new JLabel("Coordenada x"));
    p1.add(jtfNum1 = new JTextField(3));
    p1.add(new JLabel("Coordenada y"));
    p1.add(jtfNum2 = new JTextField(3));
    
    p1.add(new JLabel("Punto 2"));
    p1.add(new JLabel("Coordenada x"));
    p1.add(jtfNum12 = new JTextField(3));
    p1.add(new JLabel("Coordenada y"));
    p1.add(jtfNum22 = new JTextField(3));
    
    p1.add(new JLabel("pendiente"));
    p1.add(jtfResult = new JTextField(10));
    p1.add(new JLabel("b "));
    p1.add(jtfB = new JTextField(10));
    jtfResult.setEditable(false);
    jtfB.setEditable(false);
    
   // Panel p3 to hold text fields and labels 
 /*   JPanel p3 = new JPanel();
    p3.setLayout(new FlowLayout());
    p3.add(new JLabel("Punto 2"));
    p3.add(new JLabel("Coordenada x"));
    p3.add(jtfNum12 = new JTextField(3));
    p3.add(new JLabel("Coordenada y"));
    p3.add(jtfNum22 = new JTextField(3));
    p3.add(new JLabel("pendiente"));
    p3.add(jtfResult2 = new JTextField(3));
    p3.add(new JLabel("b "));
    p3.add(jtfB2 = new JTextField(3));
    jtfResult2.setEditable(false);
    jtfB2.setEditable(false);
*/	
		// Panel p2 to hold buttons
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout());
    p2.add(jbtPend = new JButton("Pendiente"));
    p2.add(jbtB = new JButton("B"));
     
    p2.add(jbtClear = new JButton("Clear"));
    p2.add(jbtExit = new JButton("Exit"));
    
    
    
    // Add panels to the frame
    JPanel p4 = new JPanel(new GridLayout(2,1));
    p4.add(p1);
   // p4.add(p3);
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p4, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);
    
    
    

    // Register listeners
    jbtPend.addActionListener(this);
    jbtExit.addActionListener(this);
    jbtClear.addActionListener(this);
    jbtB.addActionListener(this);
	 //	existe=false;
	//	m=calcula_pendiente();				
	}
	
	public ClienteRemotoLinea(Punto p1,double m){
	 this.p1=p1;
	 this.m=m;
	// existe=true;	
	
	
	} 
	
	/** Handle ActionEvent from buttons and menu items */
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
 
    // Handle button events
    if (e.getSource() instanceof JButton)
     {
    	
      if ("Pendiente".equals(actionCommand))
        calculate('m');
     /* else if ("b".equals(actionCommand))
        calculate('b');
      else if ("Multiply".equals(actionCommand))
        calculate('*');
      else if ("Divide".equals(actionCommand))
        calculate('/');
      */
      else if ("Clear".equals(actionCommand))
               clear();  
           else if ("Exit".equals(actionCommand))
                   System.exit(0);
    }
   }  
  
  
  
  
  /** Calculate and show the result in jtfResult */
   
   private void calculate(char operator)
   {
     
    
    // Obtain Number 1 and Number 2
    try{
   
 
   
IntPenInterRemota  objcalc = 
(IntPenInterRemota)Naming.lookup("//127.0.0.1/ImplObjeRemoto");

    double num1 = (Double.parseDouble(jtfNum1.getText().trim()));
    double num2 = (Double.parseDouble(jtfNum2.getText().trim()));
   // double m1 = 0.0;
    p1 = new Punto(num1,num2);
    double num11 = (Double.parseDouble(jtfNum12.getText().trim()));
    double num22 = (Double.parseDouble(jtfNum22.getText().trim()));
   // double m = 0.0;
    p2 = new Punto(num11,num22);
    // Perform selected operation
       switch (operator) {
            case 'm': //result = num1 + num2;
                      //result = objcalc.suma(num1,num2);
                      m = objcalc.calcula_pendiente(p1,p2);
                      b = objcalc.calculaB(p1,m);
                      interX = objcalc.calIntersecEjeX(p1,b,m);  
                      interY = objcalc.calIntersecEjeY(b);    
                      break;
            case 'b': //result = num1 - num2;
                      b = objcalc.calculaB(p1,m);
                      break;
           /* case '*':  // result = num1 * num2;
                      result = objcalc.multiplica(num1,num2);
                      break;
            case '/': //result = num1 / num2;
                      result = objcalc.divide(num1,num2);
	      */
    }

    // Set result in jtfResult
    
     infinito =String.valueOf(m);
   
    if( ! infinito.equals("Infinity")) 
 {
 
 jtfResult.setText(infinito);
 infinito =String.valueOf(b);
 jtfB.setText(infinito);
 JOptionPane.showMessageDialog(this,"La linea es de: "+this.imprime_linea()+
                               "\n Interseccion Eje x: " + interX.display()+
                               "\n Interseccion Eje y: " + interY.display());
 
    
  
  
  }
    else 
        {
        interX = objcalc.calIntersecEjeX(p1,b,m);
        jtfResult.setText(infinito);
        infinito =String.valueOf(b);
        jtfB.setText(infinito);	
     	JOptionPane.showMessageDialog(this,"La Pendiente No Existe"," ",JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(this,"La linea es de: "+this.imprime_linea2()+
                                  "\n Interseccion Eje x: " + interX.display() );
    	
    //	clear();
       }
    }
    catch( RuntimeException  ex)
     {
     	JOptionPane.showMessageDialog(this, ex.getMessage(),"Operation error",JOptionPane.ERROR_MESSAGE);
    //	jtfResult.setText("La pendiente no existe");
    //	clear();
     }catch (Exception e2)
		{
		System.out.println("Exception: " + e2.getMessage());
 		
 		e2.printStackTrace();	
		}
    
   }
     
    
 private  void clear()
   {
   	jtfNum1.setText("");
   	jtfNum2.setText("");
   	jtfResult.setText("");
   	jtfB.setText("");
   	jtfNum12.setText("");
   	jtfNum22.setText("");
   //	jtfResult2.setText("");
   //	jtfB2.setText("");
   } 	

	


public	 String imprime_linea()
{
	String s=null;
	
 if (b >= 0.0)
  s="y = "+this.m+"x " + "+ "+ b + " :" +p1.display()+"-"+p2.display();
 else if ( b < 0)
  s= "y = "+this.m+"x " + b + " :" +p1.display()+"-"+p2.display();	
 return(s);   
}

public	 String imprime_linea2(){
		return("x = "+p1.getx() + " : "+p1.display()+" - "+p2.display());
	}	

	public String simprime_linea(){
		return("y = "+this.m+"x + b :"+p1.display());
	}
	
	
/*	public Punto calcula_interseccion(Linea a){
Punto temp=new Punto();
temp.y=(-(a.p2.x-a.p1.x)*((-(this.p2.y-this.p1.y)-this.m)/(this.p2.x-this.p1.x))-a.m)/(a.p2.y-a.p1.y);
temp.x=(-(a.p2.y-a.p1.y)*((-(this.p2.x-this.p1.x)-this.m)/(this.p2.y-this.p1.y))-a.m)/(a.p2.x-a.p1.x);
return(temp);
	}
*/

/** Main method */
  public static void main(String[] args) {
  	
  	
    ClienteRemotoLinea frame = new ClienteRemotoLinea();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
 //   frame.setResizable(false);
    
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	
    frame.setVisible(true);
    
  }

	
/*	public static void main(String arg[])
	{
				
	//	Linea la=new Linea();
		ClienteRemotoLinea frame = new ClienteRemotoLinea();
		
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setResizable(false);
    
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	
    frame.setVisible(true);
		
	//	Linea lb=new Linea(new Punto(0.0,0.0),new Punto(-1.0,1.0));
			try{
 //System.setSecurityManager( new RMISecurityManager() );
 		
 	
 		IntPenInterRemota inpi =
 		 (IntPenInterRemota)Naming.lookup("//localhost:2005/ImplPenInter");
 		
 		
 		la.play(inpi);
 		System.out.println("la pendiente m ha sido calculada ");
 		
     	}catch(Exception e)
     	{
     		System.out.println(e);
     	}
		
		 JOptionPane.showMessageDialog(null,"La linea es de: "+la.imprime_linea());
	/*	 JOptionPane.showMessageDialog(null,"nLa linea es de: "+lb.imprime_linea());
		 Punto c=new Punto();
		 c=la.calcula_interseccion(lb);
		 JOptionPane.showMessageDialog(null,"La intereseccion es: "+c.display());
    */	
     }

