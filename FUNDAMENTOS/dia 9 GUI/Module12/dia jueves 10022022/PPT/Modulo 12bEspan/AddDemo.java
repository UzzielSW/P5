import java.awt.*;

public class AddDemo
{
	public static void main(String [] args)
	{
		Frame f = new Frame("A simple window");
		Button btCancel = new Button("Cancel");

		f.add(btCancel);	//add the Button to the Frame

		f.setSize(100,100);
		f.setVisible(true);
	}
}
