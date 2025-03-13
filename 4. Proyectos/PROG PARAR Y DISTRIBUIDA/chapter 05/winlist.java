import java.awt.*;
import java.awt.event.*;

class p22 extends Frame implements WindowListener
{
	TextArea ta;
	
	p22(String s)	
	{
	setTitle(s);
	setSize(300,300);
	setLayout(new FlowLayout());
	ta=new TextArea(10,10);
	addWindowListener(this);
	add(ta);
	setVisible(true);
	}
	
	public void windowOpened(WindowEvent we)
	{
	System.out.println("window opened");
	}
	public void windowClosing(WindowEvent we1)
	{
	System.out.println("Window Closing");
	}
	public void windowClosed(WindowEvent we2)
	{
	System.exit(0);
	System.out.println("Window Closed");
	}
	public void windowIconified(WindowEvent we3)
	{
	System.out.println("Window Iconified");
	}
	public void windowDeiconified(WindowEvent we4)
	{
	System.out.println("Window Deiconified");
	}
	public void windowActivated(WindowEvent we5)
	{
	System.out.println("Window Activated");
	}
	public void windowDeactivated(WindowEvent we6)
	{
	System.out.println("Window DeActivated");
	}

public static void main(String arg[])
{
	new p22("Window Listener");
}
}
	