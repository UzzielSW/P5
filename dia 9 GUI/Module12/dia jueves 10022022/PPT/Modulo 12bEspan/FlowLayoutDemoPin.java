import java.awt.*;

public class FlowLayoutDemoPin
{
	public static void main(String [] args)
	{
		Frame f = new Frame("FlowLayout demo Pin");

	//	f.setLayout(new FlowLayout());

       Panel panelSur = new Panel();
       
		panelSur.add(new Button("Red"));
		panelSur.add(new Button("Blue"));
		panelSur.add(new Button("White"));
		
		f.add(panelSur,BorderLayout.SOUTH);
	
		String [] nombres = {"Lunes","Martes","Miercoles",
		                     "Jueves","Viernes"
		                    };

		List list = new List();
		for(int i = 0; i < nombres.length; i++)
		{
			list.add(nombres[i]);
		}
		f.add(list,BorderLayout.CENTER);

        Panel panelNorte = new Panel();
        
		panelNorte.add(new Checkbox("Pick me", true));
		panelNorte.add(new Label("Enter name here:"));
		panelNorte.add(new TextField(20));
        
        f.add(panelNorte,BorderLayout.NORTH);
		f.pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	  f.setLocation((d.width - f.getSize().width) / 2, (d.height - f.getSize().height)/2);
		f.setVisible(true);
	}
}