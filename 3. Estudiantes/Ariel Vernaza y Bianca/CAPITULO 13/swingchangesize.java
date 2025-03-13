import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingChangeSize implements ItemListener
{
	private Component component;

	public SwingChangeSize(Component c)
	{
		component = c;
	}

	public void itemStateChanged(ItemEvent e)
	{
		JRadioButton source = (JRadioButton) e.getItem();
		String size = (String) source.getText();

		if(size.equals("small"))
		{
			component.setSize(75,20);
		}
		else if(size.equals("medium"))
		{
			component.setSize(100,50);
		}
		else if(size.equals("large"))
		{
			component.setSize(150, 75);
		}
	}
}

//un label es una cadena o un icono que se despliega dentro de un contenedor.
//Los label generan los evenetos que producen los componentes, tales como focos, y eventos del raton.
//pero no generan action o ItemEvent.
//La clase que represen a los label en awt, es java.awt.Label
//Label.CENTER,Label.RIGHT,Label.Left. Un label de awt, solo puede representar un texto.
//Y los label de swing, representan un texto o un icono
