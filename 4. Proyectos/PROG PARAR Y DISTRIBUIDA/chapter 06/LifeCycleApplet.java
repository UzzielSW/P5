import java.applet.*;
import java.awt.*;

public class LifeCycleApplet extends Applet{
  public void paint(Graphics g)  {
        g.drawString("Hello", 5, 30); 
  }
  public void init(){
   		showStatus("The applet is initializing!"); 
  }
  public void start()  {
  		showStatus("The applet is starting!"); 
  }
  public void stop()  {
  		showStatus("The applet is stopping!"); 
  }
  public void destroy()  {
 	   showStatus("The applet is being destroyed!"); 
  }} 
