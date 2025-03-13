import java.awt.*;
import java.applet.*;
public class Movingtext extends Applet implements Runnable{ 
	Thread t;
	int i;
	public void init(){
	   t=new Thread (this);
	   t.start();
	   setVisible(true);
	  }
	public void run(){
	  try{
	  	while(true){
	     setBackground(Color.green);
	     setForeground(Color.red);
	     for(i=0;i<getSize().height;i++){
	      repaint();
	      t.sleep(100);} }
	     }catch(Exception e){ }
	   }
	 public void paint(Graphics g){
	 	 g.drawString("W E L C O M E  To  CONCURRENT PROGRAMMING",i,i);
	  }
}
		