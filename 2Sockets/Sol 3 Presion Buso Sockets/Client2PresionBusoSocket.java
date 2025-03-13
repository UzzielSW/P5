/**
 * @(#)Client2PresionBusoSocket.java
 *     Si los valores capturados son correctos, 
 *     el cliente envia un Objeto String y Punto al Servidor
 *     el servidor calcula la presion que se ejerce a un buso
 *     a la profundidad calculada y le responde al cliente
 *     con dos Objetos Double: presion y profundidad.
 *     Si la profundidad no es negativa o no ha sido capturada 
 *    se lanzan las Excepciones.
 *    Tambien se puede calcular la Presion, Limpiar el campo de
 *    la coordenada y salir usando los MenuItems.
 *
 * @ Programacion V
 * @author Prof. Alvaro Pino N.
 * @version 3
 * @Date: 30/11/2021
 * @Date 1/12/2021
 * @Date 2/12/2021
 *
 */
 
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client2PresionBusoSocket extends JFrame 
                 implements ActionListener
{	
	private JButton jbtPresionBuso;
	private JButton jbtExit,jbtClear;
	
	private Punto punto1;

	// Text fields for Point 1
  private JTextField jtfNumx1, jtfNumy1;	


  private JMenuItem jmiPresion,  jmiClear, jmiClose;
// Text fields for the Force and distance
  private JTextField jtfValorPresion, jtfValorProfundidad;
  private JTextField jtfValorGravedad, jtfValorDensidad;
  
private boolean bandera = false;
  private String teclaEnter;
  
     private Double pre;
     private double presion;
     private Double prof;
     private double profundidad;
        
     public String actionCommand;
   
     public String host = "localhost";
  
    private Socket socket;
  
    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;
   
	public Client2PresionBusoSocket(String titulo){	
		super(titulo);
	
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

    // Add menu items with mnemonics to menu "Operation"
    operationMenu.add(jmiPresion= new JMenuItem("Presion", 'P'));
    
    operationMenu.add(jmiClear = new JMenuItem("Limpia", 'L'));
    
    exitMenu.add(jmiClose = new JMenuItem("Close", 'C'));

    // Set keyboard accelerators
    jmiPresion.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

    jmiClear.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

    
	
	 // Panel p1 to hold text fields and labels
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new JLabel("Punto 1: "));
    p1.add(new JLabel("Coordenada x"));
    
    p1.add(jtfNumx1 = new JTextField(5));
     jtfNumx1.setText(String.valueOf(0.0));
     jtfNumx1.setEditable(false);
    p1.add(new JLabel("Coordenada y"));
    p1.add(jtfNumy1 = new JTextField(5));
          
    // Panel p43 to hold text fields and labels 
    JPanel p43 = new JPanel();
    p43.setLayout(new FlowLayout());
     
    p43.add(new JLabel("          Presion:"));
    p43.add(jtfValorPresion = new JTextField(8));
    jtfValorPresion.setEditable(false);
    p43.add(new JLabel("Pa  "));
    p43.add(new JLabel("Profundidad:"));
    p43.add(jtfValorProfundidad = new JTextField(8));
    jtfValorProfundidad.setEditable(false);
    p43.add(new JLabel("ms  "));
    p43.add(new JLabel("Densidad Agua de Mar:"));
    p43.add(jtfValorDensidad = new JTextField(8));
    String s =String.valueOf(ImplementaPresionBuso.DENSIDAD);
    jtfValorDensidad.setText(s);
    p43.add(new JLabel("kg/m3  "));
    jtfValorDensidad.setEditable(false);
    
    p43.add(new JLabel("Gravedad:"));
       
    p43.add(jtfValorGravedad = new JTextField(5));
    jtfValorGravedad.setText(String.valueOf(ImplementaPresionBuso.GRAVEDAD));
    p43.add(new JLabel("m/seg2  "));
    jtfValorGravedad.setEditable(false);
  
	// Panel p2 to hold buttons
    JPanel p2 = new JPanel();
    
    p2.setLayout(new FlowLayout()); 
    p2.add(jbtPresionBuso = new JButton("PresionBuso"));
    
    p2.add(jbtClear = new JButton("Clear"));
    p2.add(jbtExit = new JButton("Exit"));
      
    // Add panels to the frame
    JPanel p4 = new JPanel(new GridLayout(3,1));
    p4.add(p1);
  //  p4.add(p3);
    p4.add(p43);
     
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p4, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);
     
    // Register listeners
   jbtPresionBuso.addActionListener(this);
     escuchaTeclas();
     
     jmiPresion.addActionListener(this);
    
    jmiClear.addActionListener(this);
    jmiClose.addActionListener(this);
    
 //  jtfNumy1.addKeyListener(this);
   
   	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	
   jbtExit.addActionListener(new ActionListener() {
    	
    	public void actionPerformed(ActionEvent e) {
    		String actionCommand = e.getActionCommand();
    	//	if ("Exit".equals(actionCommand))
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
    	} 
    });
    
    jbtClear.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    /*	String actionCommand = e.getActionCommand();	
    		if ("Clear".equals(actionCommand))
      */         
              clearText();  
        
    	}
    });
   }
   
 
    /** Handle ActionEvent from buttons and menu items */
 public void actionPerformed(ActionEvent e)
  	 {
     actionCommand = e.getActionCommand();
      	
 if ("PresionBuso".equals(actionCommand) )
   { 
   	  if( bandera != true)
   	  {
   	  	sacaValores();
   	  	conectar();
   	  }
        
      bandera = false;
          
   }else if (  e.getSource() instanceof JMenuItem)
   {
   	 if ("Presion".equals(actionCommand))
   	 {
   	 	if( bandera != true)
          {
              sacaValores();
              conectar();	 
             }
           bandera = false;
   	 		 	 
   	 }
   	else if ("Limpia".equals(actionCommand)) 	
   	{
   		 clearText(); 
   		 	
      	if (bandera == true)
        	bandera = false;	 
   	}else if ("Close".equals(actionCommand))
        System.exit(0);
     };  // fin del f (  e.getSource() instanceof JMenuItem)
   
   } // fin del metodo actionPerformed
   
   
    private void escuchaTeclas() {
    	
   jtfNumy1.addKeyListener(new KeyListener() {
   
   @Override
   public void keyTyped(KeyEvent ke) { }
   @Override
   public void keyReleased(KeyEvent ke) {}

   @Override        
    public void keyPressed(KeyEvent ke) 
     {
       switch(ke.getKeyCode())
        {
          case KeyEvent.VK_ENTER: 
          	
           // se obtiene el valor String de la teclaEnter =Enter       	
          teclaEnter = KeyEvent.getKeyText(KeyEvent.VK_ENTER);
                   	    
          if( bandera != true)
            {
              sacaValores();
              conectar();                	    	 
             }
          
           bandera = false;
                                                   
           break;
                       
          default: break;
         } // fin del swicth 
     } // fin del KeyPressed

  }); // fin del jtfNumy1.addKeyListener
    } // fin de escuchar Teclas
    	 
    public void sacaValores()
    {   	
      double numx1;
      double numy1;
                
    try
       	{
          numx1 = (Double.parseDouble(jtfNumx1.getText().trim()));
          numy1 = (Double.parseDouble(jtfNumy1.getText().trim()));
         
         valida( numy1 );
         
         if(bandera == false)
              punto1 = new Punto(numx1,numy1);       
           
      }catch(NumberFormatException m)
      {
      	 // Display the result in a message dialog box
       JOptionPane.showMessageDialog(null, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
                 	bandera = true;
            clearText();
             return; 
      }catch(MayorCeroException m)
      {
      	 // Display the result in a message dialog box
       JOptionPane.showMessageDialog(null, 
                 "Tiene que ingresar un valor menor que cero",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
                 	bandera = true;
            clearText();
             return; 
      }
    }
       
    public  void valida( double y ) throws MayorCeroException
	 {
	 	if ( y >= 0  )	
	 	{
	 		 bandera = false;
	 		 throw new MayorCeroException(y);
	 	}
	 	 	 	  
	 }
    
     public void conectar()
	{		
		try {
      
        // Establish connection with the server
        
         socket = new Socket(host, 11000);

        // Create an output stream to the server
        
         toServer =
    new ObjectOutputStream(socket.getOutputStream());
         fromServer = 
    new ObjectInputStream(socket.getInputStream());
       	
   if( bandera == false)
    {                 
     if( "PresionBuso".equals(actionCommand) || 
     	"Presion".equals(actionCommand) )
     {
     System.out.println("El Cliente envia el Objeto String " +
       	actionCommand);	    
       		
       toServer.writeObject(actionCommand);  
       	     		
     }else if("Enter".equals(teclaEnter)    )
     {
     	System.out.println("El Cliente envia el Objeto String " +
       	teclaEnter);
       		
       	toServer.writeObject(teclaEnter); 
     };
     
     System.out.println("El Cliente envia un Punto al servidor");
        
      toServer.writeObject(punto1);
      
      System.out.println("El Cliente recibe la respuesta "); 
     
       pre= (Double)fromServer.readObject(); 
       presion = pre.doubleValue();
       System.out.println("Presion: " + presion); 
       	
     	prof = (Double)fromServer.readObject();	
     	profundidad = prof.doubleValue();	
        System.out.println("Profundidad: " + profundidad);      
     } else 
          {
          	bandera = true;
          	System.out.println("Los campos no fueron enviados");
          	
         };
         
      if( bandera != true)
      {
      	desplegarSolucion(); 
      		
      }else{
      	clear();
      }
       bandera = false;   
      

    }catch(NumberFormatException n)
        {
  JOptionPane.showMessageDialog(null, n.getMessage(),
  "Operation No ha capturado los datos",
  JOptionPane.ERROR_MESSAGE);    
  	 bandera = true;
     clearText();
     return; 
        
        }catch( RuntimeException  ex)
        {
     	JOptionPane.showMessageDialog(null, ex.getMessage(),
     	"Operation error",JOptionPane.ERROR_MESSAGE);
     		bandera = true;
            clearText();
             return; 
       }catch (Exception e2)
		{
		System.out.println("Exception: " + e2.getMessage());		
 		e2.printStackTrace();	
 		bandera = true;
            clearText();
             return; 	
		}        
	}	// fin del metodo conectar
  
  public void desplegarSolucion()
    {
 //   if("CalcularPresionBuso".equals(actionCommand) || 
 //"Enter".equals(teclaEnter) ||
 // "Presion".equals(actionCommand) )
 //   {
          jtfValorPresion.setText(String.valueOf(presion));
          jtfValorProfundidad.setText(String.valueOf(profundidad)); 
   // }     	       
  }
	
/** Main method */
  public static void main(String[] args) {
  	
  Client2PresionBusoSocket frame = 
  	new Client2PresionBusoSocket("Cliente Presion Buso");
      // Establish server socket
    
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
   	jtfNumy1.setText("");	 
   	 jtfValorPresion.setText("");
     jtfValorProfundidad.setText("");  
   } 	
   	
public void clearText()
{
String  sjtextnumy1;

sjtextnumy1=jtfNumy1.getText().trim();
	                
if ( !(sjtextnumy1.equals("")   &&  
      !( sjtextnumy1.length()  != 0) ) )    
  {  
	  clear(); 	
  }else
	{
	   	 // Display the result in a message dialog box
     JOptionPane.showMessageDialog(this, 
                 "Los campos  estan limpios",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            	bandera = true;
          //  clearText();
             return; 
	}
 }	
		
 } // fin de la clase.
 
class MayorCeroException extends Exception
{
  private double y;

  MayorCeroException( double y)
   {
	this.y = y;
	System.out.println("La profundidad es incorrecta! ");
	System.out.println("Ingrese un profundidad menor que cero ");
//	System.exit(0);
return;
   }
}
