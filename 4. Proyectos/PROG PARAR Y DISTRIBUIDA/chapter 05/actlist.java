import java.awt.*;
import java.awt.event.*;
class p14 extends Frame implements ActionListener{
   p14(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
	  setLayout(null) ;

      Button b1=new Button("Yes");
      Button b2=new Button("No");
      
      b1.addActionListener(this);
      b2.addActionListener(this);
	  
      add(b1);  b1.setBounds(50,50,50,50);    
      add(b2);	 b2.setBounds(50,150,50,50);
      }
      
    public void actionPerformed(ActionEvent ae){
    	String s;
    	s=ae.getActionCommand();
    	
    	if(s.equals("Yes"))
    		setTitle("Yes Button Pressed");
    	else
    		setTitle("No Button Pressed");
    }  
      
    public static void main(String bpd[]){
 	new p14("Action Listener");
 	}
}

