import java.awt.*;
import java.awt.event.*;
 class p11 extends Frame implements ItemListener{
Choice c;
   p11(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      setLayout(null) ;
   	     	   
    c = new Choice();
    c.addItem("High Performance Computing");
    c.addItem("High Performance Networking");
    c.addItem("Parallel Programming");
    c.addItem("Distributed Programming");
    c.addItem("Concurrent Programming");
    c.addItemListener(this);
    add(c);
	c.setBounds(50,50,200,50);
    }
    public void itemStateChanged(ItemEvent ie){
      	if(ie.getSource()==c)
      		setTitle(c.getSelectedItem());
      	
    }
    public static void main(String bpd[]){
 	new p11("Choice Component");
 }

}

