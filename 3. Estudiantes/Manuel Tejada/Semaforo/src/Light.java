/**
 *Programa del semaforo
 *Creado por :
 *Manuel Tejada
 *8-818-1801
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Light extends JPanel{

private boolean red;
private boolean yellow;
private boolean green;

/**Default constructor**/
    public Light() {
    	turnOnGreen();
    }
    
    /** set red light on**/
    public void turnOnRed(){
    	red=true;
    	yellow=false;
    	green=false;
    	repaint();
    }
    
    /**Set yellow light on**/
    public void turnOnYellow(){
    	red=false;
    	yellow=true;
    	green=false;
    	repaint();
    }
    
    /**Set green light on**/
    public void turnOnGreen(){
    	red=false;
    	yellow=false;
    	green=true;
    	repaint();
    }
    
    /**Display light**/
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	if(red){
    		g.setColor(Color.red);
    		g.fillOval(10,10,20,20);
    		g.setColor(Color.black);
    		g.drawOval(10,35,20,20);
    		g.drawOval(10,60,20,20);
    		g.drawRect(5,5,30,80);
    	}
    	else if(yellow){
    		g.setColor(Color.yellow);
    		g.fillOval(10,35,20,20);
    		g.setColor(Color.black);
    		g.drawRect(5,5,30,80);
    		g.drawOval(10,10,20,20);
    		g.drawOval(10,60,20,20);
    	
    	}
    	else if(green){
    	    g.setColor(Color.green);
    		g.fillOval(10,60,20,20);
    		g.setColor(Color.black);
    		g.drawRect(5,5,30,80);
    		g.drawOval(10,10,20,20);
    		g.drawOval(10,35,20,20);	
    	}
    	else{
    	  	g.setColor(Color.black);
    		g.drawRect(5,5,30,80);
    		g.drawOval(10,10,20,20);
    		g.drawOval(10,35,20,20);	
    		g.drawOval(10,60,20,20);
    	}
    }
    /**Set preferred size**/
    public Dimension getPreferredSize(){
    	return new Dimension(40,90);
    }
    
}