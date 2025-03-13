import java.awt.event.*;
import javax.swing.*;

public class CalculatorListener implements ActionListener
{
	private JTextField textField;
	
	private String previousValue;
	
	private char operator;
	
	private boolean Flag;


	/* El Constructor de esta clase recibe a una variable tipo JTextField, 
	   
	   que proviene de la Clase Calculator */
	   

	public CalculatorListener(JTextField tf)
	{
		textField = tf;
		
		Flag = true;
	}

	
	// Método del ActionListener

	public void actionPerformed(ActionEvent e)
	{
		String button = e.getActionCommand();
		
		if(Flag)
		{
			textField.setText("");
		}

		if(	button.equals("0") ||
			button.equals("1") ||
			button.equals("2") ||
			button.equals("3") ||
			button.equals("4") ||
			button.equals("5") ||
			button.equals("6") ||
			button.equals("7") ||
			button.equals("8") ||
			button.equals("9") ||
			button.equals("."))
		{
			textField.setText(textField.getText() + button);
			
			Flag = false;
		}
		else if(button.equals("/") ||
			    button.equals("*") ||
			    button.equals("-") ||
			    button.equals("+"))
		{
			operator = button.charAt(0);
		
			previousValue = textField.getText();
			
			Flag = true;
		}
		
		// Operaciones
		
		else if(button.equals("="))
		{
			double current = Double.parseDouble(textField.getText());
		
			double previous = Double.parseDouble(previousValue);
			
			double result = 0.0;
			
			switch(operator)
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
			
			textField.setText(result + "");
			
			Flag = true;
		}
	}
}