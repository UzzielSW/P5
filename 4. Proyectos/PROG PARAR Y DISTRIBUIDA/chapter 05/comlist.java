import java.awt.*;
import java.awt.event.*;
class p3 extends Frame implements ComponentListener, ActionListener{
   Button b1;
   p3(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
	  setLayout(null);

     b1=new Button("resize");

      b1.addActionListener(this);
	  
      add(b1);  b1.setBounds(50,50,70,50);    
      b1.addComponentListener(this);
      
      
    addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent me3)	{
		b1.setVisible(true); 
	}});

      
      }
      
public void actionPerformed(ActionEvent ae){
		String s;
    	s=ae.getActionCommand();
    	
	if(s.equals("resize")){
				b1.setBounds(50,50,100,100); 
				b1.setLabel("move");}
	else if (s.equals("move")){
				b1.setBounds(100,100,100,100); 
				b1.setLabel("hidden");}
	else if (s.equals("hidden")){
				b1.setVisible(false); 
				b1.setLabel("shown");}
	
	else if (s.equals("shown")){
				b1.setBounds(100,100,100,100); 
				b1.setLabel("resize");}

	}

public void componentResized(ComponentEvent ce) {
	System.out.println("resized");
}
public void componentMoved(ComponentEvent ce){
	System.out.println("move");
}
public void componentShown(ComponentEvent ce){
	System.out.println("shown");
}
public void componentHidden(ComponentEvent ce){
	System.out.println("hidden");
}

      
    public static void main(String bpd[]){
 	new p3("Component Listener");
 	}
}

