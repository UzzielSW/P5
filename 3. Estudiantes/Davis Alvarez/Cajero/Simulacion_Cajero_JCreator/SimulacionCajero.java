import view.*;
import media.*;
import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class SimulacionCajero extends JFrame{
	
	private Bank bank;
	private Cashier cajero1;
	private Cashier cajero2;
	private ViewTransaction transaccion;
	private Selection seleccion;
	private ControlAll control;
	
	
	private JPanel north ;
	private JPanel center;
	private JPanel south;
	
	  
	
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
	
	
      
	public static void main(String [] args){
		
		SimulacionCajero simulacion = new SimulacionCajero();
		
		simulacion.setSize(950,700);
		simulacion.setResizable(false);
		simulacion.setVisible(true);
		simulacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}