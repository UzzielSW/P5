import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame
{
	private JButton [] buttons;

	public GridLayoutDemo(String title)
	{
		super(title);
Container contentPane = this.getContentPane();
contentPane.setLayout(new GridLayout(2,3,10,15));

		buttons = new JButton[6];

		for(int i = 0; i < buttons.length; i++)
		{
	buttons[i] = new JButton("A " + (i + 1));
			contentPane.add(buttons[i]);
		}
	}

	public static void main(String [] args)
	{
		JFrame jf = new GridLayoutDemo("GridLayoutDemo");
jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setSize(300,200);
 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
 jf.setLocation((d.width - jf.getSize().width) / 2, (d.height - jf.getSize().height)/2);
		jf.setVisible(true);
	}
}