// ClientObjectTriangulo.java: 
//The client sends the input to the server and receives
// result back from the server  
/*
 * @author: MSc. Álvaro Pino N.
 *  Date: 26/10/2021
 *  Version 2
 *  Prueba Formativa
 */
 
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientObjectTriangulo extends JFrame
 implements ActionListener,  KeyListener{

  private JTextField jtf = new JTextField(10); 
  private JTextField jtf2 = new JTextField(10); 
  private JTextField jtfArea = new JTextField(10);
  // Text area to display contents
  private JTextArea jta = new JTextArea(); 
  private JButton  jbCalcular = new JButton("Calcular");
  private JButton jbLimpiar = new JButton("Limpiar");
  private JButton jbSalir = new JButton("Salir");
   public  Triangulo trianguloCliente;
   public Triangulo trianguloServer;
  // IO streams
  private  ObjectOutputStream toServer;
  private ObjectInputStream fromServer;
  private Socket socket;

  public static void main(String[] args) {
    new ClientObjectTriangulo();
    
  }

  public ClientObjectTriangulo() {
    // Panel p to hold the label and text field
    JPanel p = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new FlowLayout());
   // p.setLayout(new Border());
    p2.add(new JLabel("Base"));
     p2.add(jtf2);
    p2.add(new JLabel("Altura "));
    p2.add(jtf);  
    p2.add(new JLabel("Area "));
     p2.add(jtfArea);  
     jtfArea.setEditable(false);
   // JPanel p1 = new JPanel(new BorderLayout());
    p.add(p2,BorderLayout.NORTH);
    JPanel p3 = new JPanel();
    p3.add(jbCalcular);
    p3.add(jbLimpiar);
    p3.add(jbSalir);
    
    jtf.setHorizontalAlignment(JTextField.RIGHT);
    jtf2.setHorizontalAlignment(JTextField.RIGHT);
    
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p, BorderLayout.NORTH);
    getContentPane().add(p3, BorderLayout.SOUTH);
    getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

   // jtf.addActionListener(this); // Register listener
  //  jtf2.addActionListener(this); 
   jbCalcular.addActionListener(this); 
   jbLimpiar.addActionListener(this);
   jbSalir.addActionListener(this);
   
   	jtf.addKeyListener(this);
    jtf2.addKeyListener(this);
   
    setTitle("Client  Triangulo Object");
    setSize(500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setLocation((d.width - getSize().width) / 2, (d.height - getSize().height)/2);
    setVisible(true); // It is necessary to show the frame here!

    try {
      // Create a socket to connect to the server
       socket = new Socket("127.0.0.1", 8000);
        
        toServer = new ObjectOutputStream(socket.getOutputStream());
        fromServer = new ObjectInputStream(socket.getInputStream());
       
    }catch (IOException ex) {
      jta.append(ex.toString() + '\n');
    }
  }
  
  public void clean()
  {
  	    	jtf.setText("");
    		jtf2.setText("");
    		jta.setText("");
    		jtfArea.setText("");
  }

  public void actionPerformed(ActionEvent e) {
   
    String actionCommand = e.getActionCommand();
    if (actionCommand.equals("Calcular")) 
    	{
      try {
        // Get  data from the text field
             
        double base = Double.parseDouble(jtf.getText().trim());
        double altura = Double.parseDouble(jtf2.getText().trim());
        // Send the base y altura to the server
         jta.append("\nEl Cliente envia el Triangulo al Servidor");
       
      trianguloCliente = new Triangulo(base,altura);
       System.out.println("Tringulo de Base " +
       	 trianguloCliente.getBase() +" y altura "+
       	 	trianguloCliente.getAltura());
       
      toServer.writeObject(trianguloCliente);
          toServer.flush();  
            
  jta.append("\nEl Cliente recibe el Triangulo"); 
         	try{
         		
     trianguloServer = (Triangulo )fromServer.readObject();
     	 // Display to the text area
        jta.append("\nTringulo de Base " + 
        	trianguloServer.getBase() +
        	" y altura "+trianguloServer.getAltura());
        jta.append("\nSu area es " +
        	 trianguloServer.getArea()+"\n");
        	 
        jtfArea.setText(String.valueOf(trianguloServer.getArea()));
    
  	}catch(ClassNotFoundException ex){
      	}
       
      }catch (IOException ex) {
        System.err.println(ex);
      }catch( RuntimeException  ex)
     {
     		jta.setText("Error! Ingrese numeros de doble presicion");
     	JOptionPane.showMessageDialog(this, ex.getMessage(),
     	"Operation error",JOptionPane.ERROR_MESSAGE); 
    	clean();
     }
           
    }else  if (actionCommand.equals("Limpiar")) 
    	{
    		clean(); 
    			 		
    	}else  if (actionCommand.equals("Salir")) 
    	{
    		try
			{
    		socket.close();
    		System.exit(0);
			}catch(IOException io){
			}
    	}
  }
  
  public void disconnect()
  {
  	try
			{
    		socket.close();
    		System.exit(0);
			}catch(IOException io){
			}
  }
  
  // fin del metodo action performed
	
  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}

  public void keyPressed(KeyEvent e) 
  	{
  		
   switch (e.getKeyCode())
   	{
   	
      case KeyEvent.VK_ENTER:
      
        double base;
        double altura;
        String cadena1;
        String cadena2;
       	JTextField j = (JTextField)e.getSource();
       	
       	if(j.equals(jtf) || j.equals(jtf2) )
       	{
       	
       	cadena1=jtf.getText().trim();
       	cadena2 =jtf2.getText().trim();
       	
			try
			{
			
			 base = Double.parseDouble(cadena1);
			 altura = Double.parseDouble(cadena2);
			
			}catch(NumberFormatException a)
	        {
	   // Display the result in a message dialog box
       JOptionPane.showMessageDialog(this, 
                 "Tiene que ingresar un valor double",
                 " Esto es un ERROR" ,
                 JOptionPane.ERROR_MESSAGE); 
            clean();
             return; 
	        }
	        
	        // Send the base y altura to the server
         jta.append("\nEl Cliente envia el Triangulo al Servidor");
       
      trianguloCliente = new Triangulo(base,altura);
       System.out.println("Tringulo de Base " +
       	 trianguloCliente.getBase() +
       	" y altura "+trianguloCliente.getAltura());

       	try{ 
      toServer.writeObject(trianguloCliente);
          toServer.flush();  
            
  jta.append("\nEl Cliente recibe el Triangulo"); 
                		
     trianguloServer = (Triangulo )fromServer.readObject();
     	 
     	 // Display to the text area
    jta.append("\nTringulo de Base " +
    	 trianguloServer.getBase() +
    	" y altura "+trianguloServer.getAltura());
    jta.append("\nSu area es " +
     trianguloServer.getArea()+"\n");
     jtfArea.setText(String.valueOf(trianguloServer.getArea()));
         	
  	}catch(ClassNotFoundException ex){}
       
      catch (IOException ex) {
        System.err.println(ex);
      }catch( RuntimeException  ex)
     {
     	jta.setText("Error! Ingrese numeros de doble presicion");
     	JOptionPane.showMessageDialog(this, ex.getMessage(),
     	"Operation error",JOptionPane.ERROR_MESSAGE);
    
    	clean();
     }
      		
		break;
     
      //default: keyChar = e.getKeyChar();
    }
  } // fin del switch
} // fin del metodo keyPressed
} // fin de la clase