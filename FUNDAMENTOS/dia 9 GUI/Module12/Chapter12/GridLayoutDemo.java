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
			buttons[i] = new JButton("Click " + (i + 1));
			contentPane.add(buttons[i]);
		}
	}

	public static void main(String [] args)
	{
		JFrame f = new GridLayoutDemo("GridLayoutDemo");
		f.setSize(300,200);
		f.setVisible(true);
	}
}