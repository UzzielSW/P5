
/*No temas, porque yo te redimi; te puse nombre, mío eres tú.
 *Cuando pases por las aguas, yo estaré contigo; y si por los ríos, no te
 *anegará. Cuando pases por el fuego, no te quemarás, ni la llama ardera en ti.
 *Porque yo Jehova, Dios tuyo, el Santo de Israel, soy tu Salvador..
 *No temas, porque yo estoy contigo. Isaias 43*/
 
 /*UNIVERSIDAD DE PANAMA
  *F.I.E.C
  *DAVIS ALVAREZ
  *8-809-405*/  


package simulacion;
import view.*;
import media.*;
import javax.swing.*;
import java.awt.*;
import java.applet.*;

/**
 * Clase que crea la simulación completa del cajero y da inicio a la misma.
 */
public class SimulacionCajero extends JFrame{
	
        /**El campo bank creara una nueva instancia de Bank.*/
	public Bank bank;
	/**El campo cajero1 creara una nueva instancia de Cashier.*/
        public Cashier cajero1;
        /**El campo cajero2 creara una nueva instancia de Cashier.*/
	public Cashier cajero2;
        /**El campo transaccion creara una nueva instancia de ViewTransaction.*/
	public ViewTransaction transaccion;
        /**El campo seleccion creara uan nueva instancia de Selection.*/
	public Selection seleccion;
	/**El campo control creara uan nueva instancia de ControlAll.*/
        public ControlAll control;

	private JPanel north ;
	private JPanel center;
	private JPanel south;
	
	  
	
    /**
     * Crea una nueva instancia de SimulaciónCajero, donde se instanciaran objetos Bank, Cashier, ViewTransaction, Selection, ControllAll.
     */
	public SimulacionCajero(){
	
		super("Simulacion Con Threads");
		
		//Creando los objetos del Frame Principal
		transaccion = new ViewTransaction ();
		bank =new Bank(transaccion);
		cajero1 = new Cashier(bank,"Cajero1");
		cajero2 = new Cashier(bank,"Cajero2");
		control = new ControlAll(cajero1,cajero2,bank);
		
		Selection seleccion = new Selection(bank,control);
		
		//Panel para los objetos
		north= new JPanel(new BorderLayout());
		center = new JPanel(new BorderLayout());
		south = new JPanel();
		
		//Ubicamos los dos cajeros
		north.add(cajero1,BorderLayout.WEST);
		north.add(cajero2,BorderLayout.EAST);
		
		//Nos muestra las transacciones
		center.add(transaccion, BorderLayout.CENTER);
		//Para seleccionar usar el banco, o los dos cajero 
		//y el banco a la vez
		south.add(seleccion);
		
		this.getContentPane().add(north,BorderLayout.NORTH);
		this.getContentPane().add(center,BorderLayout.CENTER);
		this.getContentPane().add(south,BorderLayout.SOUTH);
		
	}
	
	
      
    /**
     * Método estático que da incicio a la simulación con la instanciación de un objeto SimulacionCajero.
     */
	public static void main(String [] args){
		
		SimulacionCajero simulacion = new SimulacionCajero();
		
		simulacion.setSize(950,700);
		simulacion.setResizable(false);
		simulacion.setVisible(true);
		simulacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}