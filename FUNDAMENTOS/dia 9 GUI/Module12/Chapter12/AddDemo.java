import java.awt.*;

public class AddDemo
{
	public static void main(String [] args)
	{
		Frame f = new Frame("A simple window");
		Button cancel = new Button("Cancel");

		f.add(cancel);	//add the Button to the Frame

		f.setSize(100,100);
		f.setVisible(true);
	}
}
