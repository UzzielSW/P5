import java.awt.*;

public class FrameDemo
{
	public static void main(String [] args)
	{
		Frame f = new Frame("My first window");
		f.setBounds(100,100, 400, 300);
		f.setVisible(true);
	}
}