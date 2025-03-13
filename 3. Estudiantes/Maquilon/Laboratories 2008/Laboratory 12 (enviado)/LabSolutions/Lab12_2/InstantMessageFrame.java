import java.awt.*;
import javax.swing.*;

public class InstantMessageFrame extends JFrame
{
	public InstantMessageFrame(String title)
	{
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String [] args)
	{
		JFrame f = new InstantMessageFrame("My IM Program");
		f.setSize(220,450);
		f.setVisible(true);
	}
}