import javax.swing.*;

public class JFrameDemo
{
	public static void main(String [] args)
	{
		JFrame f = new JFrame("My first JFrame");
		f.setSize(400, 300);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}