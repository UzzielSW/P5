import java.applet.*;
import java.awt.*;

public class MyFirstApplet extends Applet
{
	private String name;

	public void paint(Graphics g)
	{
		g.drawString(name, 20, 20);
	}

	public void init()
	{
		name = getParameter("username");
		
		if(name == null)
		{
			name = "Bienvenido";
		}
	}
}