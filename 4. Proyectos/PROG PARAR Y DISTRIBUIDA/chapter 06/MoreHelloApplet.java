import java.applet.*;
public class MoreHelloApplet extends java.applet.Applet {
	String name;
	public void init() {	
	         name = getParameter("name");
	     }
	public void paint(Graphics g) {
	              g.drawString(name, 5, 40);
	    } }
