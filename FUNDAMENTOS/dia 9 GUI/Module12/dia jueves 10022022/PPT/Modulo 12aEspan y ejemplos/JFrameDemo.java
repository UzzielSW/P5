import javax.swing.*;

public class JFrameDemo
{
	public static void main(String [] args)
	{
		JFrame jf = new JFrame("My first JFrame");
		jf.setSize(400, 300);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
}