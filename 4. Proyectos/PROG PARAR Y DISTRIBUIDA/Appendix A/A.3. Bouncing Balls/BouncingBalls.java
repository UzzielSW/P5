
import java.awt.*;
import java.util.*;

import javax.swing.*;

public class BouncingBalls extends JFrame
{
	public BouncingBalls()
	{
		super("Bouncing Balls");

		CanvasPanel canvasPanel 	= new CanvasPanel();
		InfoPanel infoPanel			= new InfoPanel();
		infoPanel.setSize(600,250);

		ToolPanel toolPanel			= new ToolPanel(canvasPanel,infoPanel);

		Thread canvasThread 		= new Thread(canvasPanel);
			canvasThread.start();
		Thread infoThread			= new Thread(infoPanel);
			infoThread.start();

		Container kontainer = getContentPane();

		kontainer.add(toolPanel,BorderLayout.NORTH);
		kontainer.add(canvasPanel,BorderLayout.CENTER);
		kontainer.add(infoPanel, BorderLayout.SOUTH);

		this.setResizable(false);
		setSize(600,500);
		setVisible(true);

	}
	public static void main(String args[])
	{
		BouncingBalls application = new BouncingBalls();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}