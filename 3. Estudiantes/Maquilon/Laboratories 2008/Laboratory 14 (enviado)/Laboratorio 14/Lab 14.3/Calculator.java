import java.awt.*;
import javax.swing.*;

public class Calculator extends JApplet
{
	private JButton [] botones;
	
	private JTextField campo;

	JPanel calculator;
	
	public void init()
	{		
		Crear_Botones();
		
		Crear_Panel();

		CalculatorListener escucha = new CalculatorListener(campo);
		
		for(int x = 0; x < botones.length; x++)
		{
			botones[x].addActionListener(escucha);
		}
	}

	private void Crear_Botones()
	{
		calculator = new JPanel(new GridLayout(4, 4, 10, 10));

		botones = new JButton[16];
		
		for(int i = 0; i <= 9; i++)
		{
			botones[i] = new JButton("" + i);
		}

		botones[10] = new JButton("/");
		botones[11] = new JButton("*");
		botones[12] = new JButton("-");
		botones[13] = new JButton("+");
		botones[14] = new JButton("=");
		botones[15] = new JButton(".");
		

		for(int i = 7; i <= 10; i++)
		{
			calculator.add(botones[i]);
		}

		for(int i = 4; i <= 6; i++)
		{
			calculator.add(botones[i]);
		}

		calculator.add(botones[11]);

		for(int i = 1; i <= 3; i++)
		{
			calculator.add(botones[i]);
		}
		
		calculator.add(botones[12]);
		
		calculator.add(botones[0]);
		
		calculator.add(botones[15]);
		
		calculator.add(botones[14]);
		
		calculator.add(botones[13]);
		
		calculator.setBackground(new Color(135,206,250));
		
		this.getContentPane().add(calculator, BorderLayout.CENTER);
	}

	private void Crear_Panel()
	{
		JPanel Fondo = new JPanel(new BorderLayout());
		
		campo = new JTextField();
		
		campo.setHorizontalAlignment(JTextField.RIGHT); 
		campo.setEditable(false);
		campo.setBackground(Color.white);
		campo.setText("0.0");
		Fondo.add(campo, BorderLayout.CENTER);
		this.getContentPane().add(Fondo, BorderLayout.NORTH);
	}

	/*public static void main(String [] args)
	{
		Calculator calc = new Calculator("Mi Calculadora");
		calc.setSize(250,200);
		calc.setVisible(true);
	}*/
}