import java.awt.*;

public class FlowLayoutDemo
{
	public static void main(String [] args)
	{
		Frame f = new Frame("FlowLayout demo");

		f.setLayout(new FlowLayout());

		f.add(new Button("Red"));
		f.add(new Button("Blue"));
		f.add(new Button("White"));
		
		String [] nombres = {"Lunes","Martes","Miercoles",
		                     "Jueves","Viernes"
		                    };

		List list = new List();
		for(int i = 0; i < nombres.length; i++)
		{
			list.add(nombres[i]);
		}
		f.add(list);

		f.add(new Checkbox("Pick me", true));
		f.add(new Label("Enter name here:"));
		f.add(new TextField(20));

		f.pack();
		f.setVisible(true);
	}
}