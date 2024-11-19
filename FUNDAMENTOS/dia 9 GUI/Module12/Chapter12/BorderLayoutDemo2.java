import java.awt.*;

public class BorderLayoutDemo2
{
	private Button north, south, east, west, center;
    private Frame f;
    
	public BorderLayoutDemo2()
	{
		
		
		f = new Frame("BorderLayout demo");
	//	
		north = new Button("North");
		south = new Button("South");
		east = new Button("East");
		west = new Button("West");
		center = new Button("Center");

		f.add(north, BorderLayout.NORTH);
		f.add(south, BorderLayout.SOUTH);
		f.add(east, BorderLayout.EAST);
		f.add(west, BorderLayout.WEST);
		f.add(center, BorderLayout.CENTER);
		
		f.pack();
    	f.setVisible(true);
	}

	public static void main(String [] args)
	{
		BorderLayoutDemo2 f = new BorderLayoutDemo2();
		
	
	}
}