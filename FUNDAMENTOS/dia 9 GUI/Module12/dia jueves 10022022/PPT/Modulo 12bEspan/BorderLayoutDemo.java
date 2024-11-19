import java.awt.*;

public class BorderLayoutDemo extends Frame
{
	private Button btNorth, btSouth, btEast, btWest, btCenter;

	public BorderLayoutDemo(String title)
	{
		super(title);
		btNorth = new Button("North");
		btSouth = new Button("South");
		btEast = new Button("East");
		btWest = new Button("West");
		btCenter = new Button("Center");

		this.add(btNorth, BorderLayout.NORTH);
		this.add(btSouth, BorderLayout.SOUTH);
		this.add(btEast, BorderLayout.EAST);
		this.add(btWest, BorderLayout.WEST);
		this.add(btCenter, BorderLayout.CENTER);
	}

	public static void main(String [] args)
	{
		Frame f = new BorderLayoutDemo("BorderLayout demo");
		
		f.setSize(400,400);
	//	f.pack();
	//	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	 // f.setLocation((d.width - f.getSize().width) / 2, (d.height - f.getSize().height)/2);
	   // f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}