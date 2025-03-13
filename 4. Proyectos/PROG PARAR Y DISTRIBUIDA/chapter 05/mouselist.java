import java.awt.*;
import java.awt.event.*;

class p19 extends Frame implements MouseListener
{
	TextField txt;
	TextArea ta;

	p19(String s)
	{
	setTitle(s);
	setSize(300,300);
	setLayout(new FlowLayout());
	txt=new TextField(10);
	ta=new TextArea(10,10);
	txt.addMouseListener(this);
	ta.addMouseListener(this);
	add(txt);
	add(ta);
	setVisible(true);
	}
	
	public void mouseEntered(MouseEvent me)
	{
	if(me.getSource()==txt)
	System.out.println("txt mouseEntered");
	else
	System.out.println("ta mouseEntered");
	}
	
	public void mousePressed(MouseEvent me1)
	{
	if(me1.getSource()==txt)
	System.out.println("txt mousepressed");
	else
	System.out.println("ta mousepressed");
	}
	
	public void mouseReleased(MouseEvent me2)
	{
	if(me2.getSource()==txt)
	System.out.println("txt mouseReleased");
	else
	System.out.println("ta mouseReleased");
	}
	
	public void mouseClicked(MouseEvent me3)
	{
	if(me3.getSource()==txt)
	System.out.println("txt mouseclicked");
	else
	System.out.println("ta mouseclicked");
	}
	
	public void mouseDoubleClicked(MouseEvent me4)
	{
	if(me4.getSource()==txt)
	System.out.println("txt mousedoubleclicked");
	else
	System.out.println("ta mousedoubleclicked");
	}

	public void mouseExited(MouseEvent me5)
	{
	if(me5.getSource()==txt)
	System.out.println("txt mouseexited");
	else
	System.out.println("ta mouseexited");
	}
	
public static void main(String arg[])
{
	new p19("Mouse Listener");
}
}
	