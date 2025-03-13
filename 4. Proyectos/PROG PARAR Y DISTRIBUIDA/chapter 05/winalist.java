import java.awt.*;
import java.awt.event.*;
class p23 extends Frame {
  p23(String s){
    setTitle(s);
	setSize(300,300);
	setVisible(true);
     
     
   addWindowListener(new WindowAdapter()
   {
   	
   	public void windowClosing(WindowEvent we2)
	{
	System.exit(0);
	} 
	
	});
	
  }
 
public static void main(String a[]){
	new p23("WindowAdapter");
} 
 }






