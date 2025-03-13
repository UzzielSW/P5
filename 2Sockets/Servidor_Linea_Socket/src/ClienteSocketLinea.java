/**
 * @(#)ClienteSocketLinea.java
 *
 *
 * @author Prof. Alvaro Pino N.
 * @version 1.00 2018/11/19
 *               2018/11/20,21,22
 *               2018/11/25
 *
 * Programa Cliente que envia  el objeto Linea al Servidor
 *
 */



import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class ClienteSocketLinea extends JFrame implements ActionListener
{
	
	private JButton jbtPend,jbtB,jbtExit,jbtClear;
	
	public Punto punto1;
	public Punto punto2;
    
    Linea lineacliente;
	
/*	public Punto interX;
	public Punto interY;
*/
	public double m;
	public double b;
//	public boolean existe;
	
	public String host = "localhost";
	public String infinito;
	
	// Text fields for Number 1, Number 2, Result and jtfB
  private JTextField jtfNum1, jtfNum2, jtfResult,jtfB;
  private JTextField jtfNum12, jtfNum22, jtfResult2,jtfB2;	


	public ClienteSocketLinea(){
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
	 
	//	m=calcula_pendiente();				
	}
	
	public ClienteSocketLinea(Punto punto1,double m){
	 this.punto1=punto1;
	 this.m=m;
		
	} 
	
	/** Handle ActionEvent from buttons and menu items */
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
 
      double num1;
      double num2;
      double num11;
      double num22;
 // Handle button events
 if (e.getSource() instanceof JButton)
   {
      if ("Pendiente".equals(actionCommand))
        {
        
       	try
       	{
       	
       	
          num1 = (Double.parseDouble(jtfNum1.getText().trim()));
          num2 = (Double.parseDouble(jtfNum2.getText().trim()));
   
       //  punto1 = new Punto(num1,num2);
    
         num11 = (Double.parseDouble(jtfNum12.getText().trim()));
         num22 = (Double.parseDouble(jtfNum22.getText().trim()));
        
      }catch(NumberFormatException m)
      {
      	 // Display the result in a message dialog box
       JOptionPane.showMessageDialog(this, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clearText();
             return; 
      }
    
      //  punto2 = new Punto(num11,num22);
    
     try {
      
        // Establish connection with the server
        
        Socket socket = new Socket(host, 8000);

        // Create an output stream to the server
        
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
       ObjectInputStream fromServer =  new ObjectInputStream(socket.getInputStream());
       
        
		                                
      System.out.println("El Cliente envia la linea");
       
      lineacliente = new Linea(new Punto(num1,num2),new Punto(num11,num22));
        
      toServer.writeObject(lineacliente);
    
      
      System.out.println("El Cliente recibe la linea "); 
       
     lineacliente = (Linea )fromServer.readObject();
  
  
  
  infinito =String.valueOf(lineacliente.getPendiente());
   
  if( ! infinito.equals("Infinity")) 
       {
 
       System.out.println(lineacliente.imprime_linea());
       jtfResult.setText(infinito);
       infinito =String.valueOf(lineacliente.getB());
       jtfB.setText(infinito);
 
      System.out.println("\n Interseccion Eje x: " + lineacliente.ejeX.display());
      System.out.println("\n Interseccion Eje y: " + lineacliente.ejeY.display());
      
JOptionPane.showMessageDialog(this,"La linea es de: "+lineacliente.imprime_linea()+ 
" "+ "\n Interseccion Eje x: " + lineacliente.ejeX.display()+
     "\n Interseccion Eje y: " + lineacliente.ejeY.display());
 
     }  else 
        {
   
        System.out.println(lineacliente.imprime_linea2());
        jtfResult.setText(infinito);
        infinito =String.valueOf(lineacliente.getB());
        jtfB.setText(infinito);
        	
JOptionPane.showMessageDialog(this,"La Pendiente No Existe"," ",JOptionPane.ERROR_MESSAGE);
JOptionPane.showMessageDialog(this,"La linea es de: "+lineacliente.imprime_linea2()+
              "\n Interseccion Eje x: " + lineacliente.ejeX.display() );
    	
  
       }
       //  mover de este lugar
    }catch(NumberFormatException n)
        {
  JOptionPane.showMessageDialog(this, n.getMessage(),"Operation No ha capturado los datos",JOptionPane.ERROR_MESSAGE);      	
        }
  
    
    catch( RuntimeException  ex)
     {
     	JOptionPane.showMessageDialog(this, ex.getMessage(),"Operation error",JOptionPane.ERROR_MESSAGE);
    //	jtfResult.setText("La pendiente no existe");
   
     }catch (Exception e2)
		{
		System.out.println("Exception: " + e2.getMessage());
 		
 		e2.printStackTrace();	
		}
       
        
   
    }  //fin del if pendiente.equals()
    
    else if ("Clear".equals(actionCommand))
               clear();  
         else if ("Exit".equals(actionCommand))
                  System.exit(0);
    
      
     } // fin del if del getSource()
      
     
   } // fin del metodo actionPerformed
     
    
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

public void clearText()
{
String cad="";
String sjtextnum1, sjtextnum2;
String sjtextnum11, sjtextnum22;

sjtextnum1=jtfNum1.getText().trim();
sjtextnum2=jtfNum2.getText().trim();
	
sjtextnum11=jtfNum12.getText().trim();
sjtextnum22=jtfNum22.getText().trim();
	                    
if ( !(sjtextnum1.equals("") || sjtextnum2.equals(""))   ||
     !(sjtextnum11.equals("") || sjtextnum22.equals("")) || 
      ( sjtextnum1.length() != 0  || sjtextnum2.length()  != 0) ||
      ( sjtextnum11.length() != 0  || sjtextnum22.length()  != 0) )    
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
		
/*

public	 String imprime_linea()
{
	String s=null;
	
 if (b > 0.0)
  s="y = "+this.m+"x " + "+ "+ b + " :" +lineacliente.getP1().display()+"-"+lineacliente.getP2().display();
 else if ( b < 0)
  s= "y = "+this.m+"x " + b + " :" +lineacliente.getP2().display()+"-"+lineacliente.getP2().display();	
 else
      s="y = "+this.m+"x " + " :" +lineacliente.getP1().display()+"-"+lineacliente.getP2().display();
 return(s);   
}

*/
/*
	
	
	public Punto calcula_interseccion(Linea a){
Punto temp=new Punto();
temp.y=(-(a.p2.x-a.p1.x)*((-(this.p2.y-this.p1.y)-this.m)/(this.p2.x-this.p1.x))-a.m)/(a.p2.y-a.p1.y);
temp.x=(-(a.p2.y-a.p1.y)*((-(this.p2.x-this.p1.x)-this.m)/(this.p2.y-this.p1.y))-a.m)/(a.p2.x-a.p1.x);
return(temp);
	}
*/

/** Main method */
  public static void main(String[] args) {
  	
  	
    ClienteSocketLinea frame = new ClienteSocketLinea();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
/*	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
*/	
    frame.setVisible(true);
    
  }

	

 } // fin de la clase.

