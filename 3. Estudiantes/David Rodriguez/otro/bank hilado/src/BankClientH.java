import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Esta clase genera la subventana perteneciente a los clientes
 * @author David Rodríguez
 * */
public class BankClientH extends JFrame implements ActionListener, Runnable{

	private static final long serialVersionUID = 1L;

	private JPanel teclado = new JPanel(new GridLayout(4,3));
	private JPanel calculadora = new JPanel(new GridLayout(2,1));
	private JPanel lateralizq = new JPanel(new GridLayout(2,1));
	private JPanel lateralder = new JPanel(new GridLayout(2,1));
	private JPanel pantallasup = new JPanel(new BorderLayout());
	private JPanel pantalladon = new JPanel(new BorderLayout());
	private JPanel pantallacen = new JPanel(new BorderLayout());
	private JTextField calculos = new JTextField();
	private JTextArea pantallaS = new JTextArea();
	private JTextArea pantalla = new JTextArea();
	private JScrollPane pantalascr = new JScrollPane(pantalla);
	private JPanel pantallaM = new JPanel(new BorderLayout());
	private JButton Nbutton[];
	private JButton aceptar = new 	JButton("Enter");
	private JButton retiro = new 	JButton("Retiro");
	private JButton ingreso = new 	JButton("Ingreso");
	public JButton balance = new 	JButton("Balance");
	private JButton salir = new 	JButton("Salir");
	private static int opcion=0;
	
	public void run(){
		//super ("Cliente");
		/**
		 * creasion del teclado
		 */
		Nbutton = new JButton[12];
		for(int i=0;i<9;i++){
			Nbutton[i]= new 	JButton(""+(1+i));
		}
		Nbutton[9]= new 	JButton("0");
		Nbutton[10]= new 	JButton(".");
		Nbutton[11]= new 	JButton("Delete");
		for(int r=0;r<12;r++){
			teclado.add(Nbutton[r]);
		}
		Font font = new Font("Times New Roman", Font.BOLD, 14);
		pantallaS.setFont(font);
		pantallaS.setBackground(Color.BLACK);
		pantallaS.setForeground(Color.WHITE);
		pantallaS.setText("**Bienvenido**\n"+envio.nombre+" "+envio.apellido);
		pantallaS.setEditable(false);
		pantallaS.setEnabled(false);
		pantalla.setFont(font);
		pantalla.setBackground(Color.BLACK);
		pantalla.setForeground(Color.WHITE);
		pantalla.setText("Reguistro de actividad actual:");
		pantalla.setEditable(false);
		pantalla.setEnabled(false);
		calculos.setEnabled(false);
		calculos.setBackground(Color.BLACK);
		calculos.setForeground(Color.WHITE);
		calculos.setHorizontalAlignment(JTextField.RIGHT);
		/**
		 * costruye la pantalla principal
		 */
		pantallaM.add(pantallaS,BorderLayout.NORTH);
		pantallaM.add(pantalascr,BorderLayout.CENTER);
		pantallasup.add(pantallaM,BorderLayout.CENTER);
		pantallasup.add(calculos,BorderLayout.SOUTH);
		pantalladon.add(teclado,BorderLayout.CENTER);
		pantalladon.add(aceptar,BorderLayout.SOUTH);
		calculadora.add(pantallasup);
		calculadora.add(pantalladon);
		lateralizq.add(retiro);
		lateralizq.add(ingreso);
		lateralder.add(balance);
		lateralder.add(salir);
		pantallacen.add(calculadora,BorderLayout.CENTER);
		pantallacen.add(lateralizq,BorderLayout.WEST);
		pantallacen.add(lateralder,BorderLayout.EAST);
				
		for(int r=0;r<12;r++){
			Nbutton[r].addActionListener(this);
		}
		aceptar.addActionListener(this);
		retiro.addActionListener(this);
		balance.addActionListener(this);
		ingreso.addActionListener(this);
		salir.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(pantallacen,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void textos(){
		aceptar.setText("Enter");
		retiro.setText("Retiro");
		ingreso.setText("Ingreso");
		balance.setText("Balance");
		salir.setText("Salir");
	}
	
	public void actividad(String activo){
			calculos.setText("");
			retiro.setText("50");
			ingreso.setText("100");
			balance.setText("150");
			salir.setText("Cancelar");
	}
	
	public void operacion(int valor){
		if(valor ==1){
			pantalla.setText(""+pantalla.getText()+"\n"+envio.R_Cu(Double.parseDouble(calculos.getText())));
			}
		if(valor ==2){
			pantalla.setText(""+pantalla.getText()+"\n"+envio.I_Cu(Double.parseDouble(calculos.getText())));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().compareTo("Balance")==0){
			
			pantalla.setText(""+pantalla.getText()+"\n"+e.getActionCommand()+": "+envio.balance());	
		}
		else if(e.getActionCommand().compareTo("Retiro")==0){
			pantalla.setText(""+pantalla.getText()+"\n"+e.getActionCommand());
			opcion=1;
			actividad(e.getActionCommand());
		}
		else if(e.getActionCommand().compareTo("Ingreso")==0){
			pantalla.setText(""+pantalla.getText()+"\n"+e.getActionCommand());
			opcion=2;
			actividad(e.getActionCommand());	
		}
		else if(e.getActionCommand().compareTo("Salir")==0){
			System.exit(0);	
		}
		else if(e.getActionCommand().compareTo("Enter")==0){
			if(calculos.getText().compareTo("")!=0){
				if(calculos.getText().compareTo(".")!=0){
					pantalla.setText(""+pantalla.getText()+"\n"+e.getActionCommand());
					operacion(opcion);
					opcion=0;
					textos();
					calculos.setText("");
					}
				}
			}
		else if(e.getActionCommand().compareTo("Delete")==0){calculos.setText("");}
		else if(e.getActionCommand().compareTo("50")==0){
			calculos.setText("50");
			operacion(opcion);
			opcion=0;
			textos();
			calculos.setText("");
			}
		else if(e.getActionCommand().compareTo("100")==0){
			calculos.setText("100");
			operacion(opcion);
			opcion=0;
			textos();
			calculos.setText("");
			}
		else if(e.getActionCommand().compareTo("150")==0){
			calculos.setText("150");
			operacion(opcion);
			opcion=0;
			textos();
			calculos.setText("");
			}
		else if(e.getActionCommand().compareTo("Cancelar")==0){
			opcion=0;
			textos();
			calculos.setText("");
			}
		else{
			calculos.setText(""+calculos.getText()+e.getActionCommand());
		}
	}
}
