import java.awt.*;
import java.awt.event.*;

class p15 extends Frame implements AdjustmentListener
{   
    static int i;
	Scrollbar sc;
	
	p15(String s)
	{ 
	  super(s);
	  setTitle(s);
      setSize(300,300);
      setVisible(true);
      setLayout(null) ;
		
	sc=new Scrollbar();
	sc.addAdjustmentListener(this);
	add(sc);
 	sc.setBounds(50,50,100,200);
 	sc.setBackground(Color.BLUE);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent ae)
	{
	if(ae.getSource()==sc){
		i=i+1;
		String s,s1="";
		s=s1.valueOf(i);
	setTitle(s);	
	}
	}
public static void main(String arg[])
{
	new p15("Adjustment Listener");
}
}