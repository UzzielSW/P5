import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class AppActList extends Applet implements ActionListener{
   public void init() {
	    setVisible(true);
	    Button b=new Button("Press me");
	    b.addActionListener(this);
	    add(b);  
	    }
   public void actionPerformed(ActionEvent ae){
    	String s;
    	s=ae.getActionCommand();
        if(s.equals("Press me"))
    		setBackground(Color.green);
      } 
 }
