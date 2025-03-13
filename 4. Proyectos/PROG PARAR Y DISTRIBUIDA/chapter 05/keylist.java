import java.awt.*;
import java.awt.event.*;

class p18 extends Frame implements KeyListener
{
	TextArea ta;
	
	p18(String s)	
	{
	setTitle(s);
	setSize(300,300);
	setLayout(new FlowLayout());
	ta=new TextArea(10,10);
	ta.addKeyListener(this);
	add(ta);
	setVisible(true);
	}
	
	public void keyPressed(KeyEvent ke)
	{
	System.out.println("Keypressed");
	}
	public void keyReleased(KeyEvent ke1)
	{
	System.out.println("key Releassed");
	}
	public void keyTyped(KeyEvent ke2)
	{
	System.out.println("key typed");
	}
	
public static void main(String arg[])
{
	new p18("Key Listener");
}
}
	