import java.awt.*;
import javax.swing.*;

class Calculadora extends JFrame
{
	private JButton [] botones;
	private JTextField campo;

	public Calculadora(String title)
	{
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Crear_Botones();
		Crear_Fondo();
	}

	private void Crear_Botones()
	{
		JPanel calculator = new JPanel(new GridLayout(5, 4, 10, 10));

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

		calculator.setBackground(Color.white);

		this.getContentPane().add(calculator, BorderLayout.CENTER);
	}

	private void Crear_Fondo()
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

	public static void main(String [] args)
	{
		Calculadora calc = new Calculadora("The Calculator");
		calc.setLocationRelativeTo(null);
		calc.pack();
		calc.setVisible(true);
	}
}