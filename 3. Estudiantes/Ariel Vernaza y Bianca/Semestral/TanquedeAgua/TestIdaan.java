
import javax.swing.*;
import java.awt.*;

/** 
 * La Clase TestIdaan sirve como controlador para el grupo 
 * de tanques. Posee tambien el control de su interfaz y
 * de sus escuchas. Implementa la interfaz Runnable para 
 * asi ser tratado como un hilo durante su ejecucion.	
*   @author  Bianca Gonzalez (8-789-1920) - Ariel Vernaza (8-795-2332) 
*	@version 6.01
*/

public class TestIdaan implements Runnable 
{
	/**
	*  El JFrame ventana representa la pantalla principal que
	*  se observa al iniciar la aplicacion.	
	*/	
 private JFrame ventana;
 /** El arreglo de JButton real representa el conjunto de 
  * elementos que se encuentran en pantalla. Para abrir las llaves y cerrarlas.
  * Tambien para realizar las operaciones de llenado y vaciado de los tanques.*/
 private  JButton []real;
 /** Los Idaan Tanque1 y Tanque2 son los dos tanques que se dibujaran en el centro
  * de la aplicacion y sobre los cuakes se realizaran las operaciones de llenado 
  * y vaciado.*/
 private Idaan Tanque1,Tanque2;
 /** ActionTanque ej es una clase que implementa ActionListener la cual permite
  * que los botones tengan sus acciones correspondientes.*/
 private ActionTanque ej;

 /** El constructor por defecto, inicializa ventana dandole 
  * el nombre de "CONTROLADOR DE TANQUES". Tambien prepara 
  * el espacio en memoria para los botones que controlaran al tanque.
  * El constructor permite que tanque1 tenga una capacidad de 240 galones, 
  * que al iniciar tenga en su interior 50 galones, y que su posicion de dibujo
  * en y sea de 140. 
  * EL Tanque2 por su partetenga una capacidad de 200 galones, 
  * que al iniciar tenga en su interior 20 galones, y que su posicion de dibujo
  * en y sea de 180.
  * En el constructor tamibien se instancian los botones del panel y se 
  * les asigna el ActionTanque correspondiente*/ 
 public TestIdaan()
 {	 
  ventana=new JFrame("Controlador de Tanques");
  real=new JButton[4];   
  	Tanque1=new Idaan(240,50,140); 
  	Tanque2=new Idaan(200,20,180); 
  ej=new ActionTanque(Tanque1,Tanque2);
  real[0]=new JButton("LLENAR TANQUE");	
  real[0].setBackground(Color.blue);
  real[1]=new JButton("VACIAR TANQUE");
  real[1].setBackground(Color.RED);
  real[2]=new JButton("LLAVE DE ARRIBA");	  
  real[3]=new JButton("LLAVE DE ABAJO");		  
  for(int i=0;i<4;i++)
  {
  	real[i].addActionListener(ej);
  }
  ventana.setResizable(false);
 } 
 
 /** El metodo run debe la clase runnable es implementado, como el lanzador de 
  * la ventana. Configura el administrador de vista, y coloca todo en su lugar
  * @return void*/
public void run()
{
 Container vet=this.ventana.getContentPane();
 vet.setLayout(new BorderLayout()); 
 JPanel vistaso=new JPanel();
 vistaso.setLayout(new GridLayout(3,2));
 vistaso.add(Tanque1.getVolumen());
 vistaso.add(Tanque2.getVolumen()); 
 for(int i=0;i<4;i++)
 {
 vistaso.add(real[i]);	
 }
 
 JButton tre=new JButton(); 
 JTextArea q=new JTextArea();
 q.setEditable(false);
 q.setLayout(new GridLayout(1,2));
 q.add(Tanque1.getTanque(1));
 q.add(Tanque2.getTanque(2)); 
 tre.add(q);
 vet.add(tre,BorderLayout.CENTER);
 vet.add(vistaso,BorderLayout.SOUTH); 
 this.ventana.setSize(600,600);
 this.ventana.setVisible(true);
 this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


	public static void main(String[] Args)
	{
		TestIdaan t = new TestIdaan();
		Thread a=new Thread(t);		
		a.start();
	}	
}