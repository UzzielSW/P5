import java.awt.*;
import javax.swing.*;

import javax.swing.event.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener
{
	private JButton [] botones;
	private JTextField campo;
	private String previousValue;
	private char operador;
	boolean first = true;

	public Calculadora(String title)
	{
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Crear_Botones();
		Crear_Panel();
	}

	private void Crear_Botones()
	{
		JPanel calculadora = new JPanel(new GridLayout(4, 4, 10, 10));

		botones = new JButton[16];
		
		for(int i = 0; i <= 9; i++)
		{
			botones[i] = new JButton("" + i);
			botones[i].setBorder(BorderFactory.createLineBorder(Color.black));
		}

		botones[10] = new JButton("/");
		botones[11] = new JButton("*");
		botones[12] = new JButton("-");
		botones[13] = new JButton("+");
		botones[14] = new JButton("=");
		botones[15] = new JButton(".");
		
		for(int i = 10; i <= 15; i++)
		{
			botones[i].setBorder(BorderFactory.createLineBorder(Color.black));
		}

		for(int i = 7; i <= 10; i++)
		{
			calculadora.add(botones[i]);
		}

		for(int i = 4; i <= 6; i++)
		{
			calculadora.add(botones[i]);
		}

		calculadora.add(botones[11]);

		for(int i = 1; i <= 3; i++)
		{
			calculadora.add(botones[i]);
		}
		
		calculadora.add(botones[12]);
		
		calculadora.add(botones[0]);
		
		calculadora.add(botones[15]);
		
		calculadora.add(botones[14]);
		
		calculadora.add(botones[13]);
		
		for(int i = 0; i < botones.length; i++)
		{
			botones[i].addActionListener(this);
		}

		calculadora.setBackground(new Color(248,248,255));

		this.getContentPane().add(calculadora, BorderLayout.CENTER);
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
		
		JPanel south = new JPanel();
		
		south.setBackground(new Color(230,230,250));
		
		JButton clear = new JButton("Limpiar");
		
		clear.addActionListener(this);
		
		south.add(clear);
		
		this.getContentPane().add(south,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String boton = a.getActionCommand();
		
		if(first)
		{
			campo.setText("");
		}

		if(boton.equals("0") || 
			boton.equals("0") ||
			boton.equals("1") ||
			boton.equals("2") ||
			boton.equals("3") ||
			boton.equals("4") ||
			boton.equals("5") ||
			boton.equals("6") ||
			boton.equals("7") ||
			boton.equals("8") ||
			boton.equals("9") ||
			boton.equals("."))
		{
			campo.setText(campo.getText() + boton);
			first = false;
		}
		else if(boton.equals("/") ||
			boton.equals("*") ||
			boton.equals("-") ||
			boton.equals("+"))
		{
			operador = boton.charAt(0);
			previousValue = campo.getText();
			first = true;
		}
		
		else if(boton.equals("Limpiar")){campo.setText("");}
		else if(boton.equals("="))
		{
			double current = Double.parseDouble(campo.getText());
			double previous = Double.parseDouble(previousValue);
			double result = 0.0;
			switch(operador)
			{
				case '*' : 
					result = current * previous;
					break;
				case '/' :
					result = previous / current;
					break;
				case '+' :
					result = current + previous;
					break;
				case '-' :
					result = previous - current;
			}
			campo.setText(result + "");
			first = true;
		}
	}

	public static void main(String [] args)
	{
		Calculadora calc = new Calculadora("Mi Calculadora");
		calc.setLocationRelativeTo(null);
		calc.setSize(250,200);
		calc.setVisible(true);
	}
}