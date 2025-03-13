
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class InfoPanel extends JPanel implements Runnable
{
	private JLabel output;

	public InfoPanel()
	{
		output = new JLabel("Please Click on the Canvas to add Ball");

		//output.setBackground(Color.BLACK);
		output.setOpaque(true);

		output.setFont(new Font("SansSerif",Font.BOLD,14));

		output.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		this.add(output,BorderLayout.WEST);
	}

	public void run()
	{
		while(true)
		{
			output.setForeground(new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random())));

			try{
				Thread.sleep(50);
			}catch(Exception e) {}
		}
	}

	public void setText(String input)
	{
		output.setText(input);
	}
}