
// Mouse MotionListener

import java.awt.*;
import java.awt.event.*;

class p20 extends Frame implements MouseMotionListener
{
	TextField txt;
	TextArea ta;

	p20(String s)
	{
	setTitle(s);
	setSize(300,300);
	setLayout(new FlowLayout());
	txt=new TextField(10);
	ta=new TextArea(10,10);
	txt.addMouseMotionListener(this);
	ta.addMouseMotionListener(this);
	add(txt);
	add(ta);
	setVisible(true);
	}
	
	public void mouseMoved(MouseEvent me)
	{
	if(me.getSource()==txt)
	System.out.println("txt mousemove");
	else
	System.out.println("ta mousemove");
	}
	
	public void mouseDragged(MouseEvent me1)
	{
	if(me1.getSource()==txt)
	System.out.println("txt mousedragged");
	else
	System.out.println("ta mousedragged");
	}
	
		
public static void main(String arg[])
{
	new p20("MouseMotion Listener");
}
}
	