import java.awt.*;
import java.awt.event.*;

class p16 extends Frame implements FocusListener
{
	TextField txt;
	Choice ch;
	List l1;
	
	
	p16(String s)
	{
	setTitle(s);
	setSize(300,300);
	setLayout(new GridLayout(2,2));
	txt=new TextField(10);
	l1=new List(2);
	l1.add("Parallel");
	l1.add("Distributed");
	ch=new Choice();
	ch.add("Parallel");
	ch.add("Distributed");
	txt.addFocusListener(this);
	l1.addFocusListener(this);
	ch.addFocusListener(this);
	add(txt);
	add(l1);
	add(ch);
	setVisible(true);
	}
	
	public void focusGained(FocusEvent fe)
	{
	if(fe.getSource()==txt)
	System.out.println("TextField  focusGained");
	else if(fe.getSource()==l1)
	System.out.println("List  focusGained");
	else
	System.out.println("choice  focusGained");
	}
	
	public void focusLost(FocusEvent fe)
	{
	if(fe.getSource()==txt)
	System.out.println("TextField  focusLost");
	else if(fe.getSource()==l1)
	System.out.println("List  focusLost");
	else
	System.out.println("choice  focusLost");
	}

	
public static void main(String arg[])
{
	new p16("Focuse Listener");
}
}