import java.awt.event.*;

public class SimpleWindowsClose extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}

}