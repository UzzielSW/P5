import javax.swing.*;
import java.awt.*;

public class CalculatorExample extends JFrame{
	private JFrame f;
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
	private Panel AreaDeBotones;
	private Panel ContenidoPanel;

	private JTextField resp;
	public CalculatorExample(){
		f= new JFrame("CALCULADORA");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		AreaDeBotones= new Panel();
		ContenidoPanel= new Panel();
		b1= new JButton("7");
		b2= new JButton("8");
		b3= new JButton("9");
		b4= new JButton("+");
		b5= new JButton("4");
		b6= new JButton("5");
		b7= new JButton("6");
		b8= new JButton("-");
		b9= new JButton("1");
		b10= new JButton("2");
		b11= new JButton("3");
		b12= new JButton("*");
		b13= new JButton("0");
		b14= new JButton(".");
		b15= new JButton("=");
		b16= new JButton("/");
		
		resp= new JTextField("0.0",20);
		//Permite poner 0.0 a la derecha
		resp.setHorizontalAlignment(JTextField.RIGHT);
		}
	public void launchFrame(){
		AreaDeBotones.add(b1);
		AreaDeBotones.add(b2);
		AreaDeBotones.add(b3);
		AreaDeBotones.add(b4);
		AreaDeBotones.add(b5);
		AreaDeBotones.add(b6);
		AreaDeBotones.add(b7);
		AreaDeBotones.add(b8);
		AreaDeBotones.add(b9);
		AreaDeBotones.add(b10);
		AreaDeBotones.add(b11);
		AreaDeBotones.add(b12);
		AreaDeBotones.add(b13);
		AreaDeBotones.add(b14);
		AreaDeBotones.add(b15);
		AreaDeBotones.add(b16);
		AreaDeBotones.setLayout(new GridLayout(4,4));
		ContenidoPanel.setLayout(new BorderLayout());
		ContenidoPanel.add(AreaDeBotones,BorderLayout.SOUTH);
		ContenidoPanel.add(resp,BorderLayout.NORTH);
		f.getContentPane().add(ContenidoPanel,BorderLayout.SOUTH);
		
		f.setSize(300,300);
		f.setResizable(false);
		f.setVisible(true);
 
		}
	public static void main(String[] args){
		CalculatorExample g= new CalculatorExample();
		g.launchFrame();
		}


}
