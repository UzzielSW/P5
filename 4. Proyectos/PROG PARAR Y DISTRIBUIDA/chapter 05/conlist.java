import java.awt.*;
import java.awt.event.*;
class p4 extends Frame implements ActionListener, ContainerListener{
   Button b1,b2;
   p4(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
	  setLayout(null);

     b1=new Button("add");

      b1.addActionListener(this);
	  addContainerListener(this);
      add(b1);  b1.setBounds(50,50,70,50);    
 
      
      
        
      }
      
public void actionPerformed(ActionEvent ae){
		String s;
    	s=ae.getActionCommand();
    	
	if(s.equals("add")){
			b2=new Button("New");
	        add(b2);  
	        b2.setBounds(200,50,70,50); 
	           
				b1.setLabel("remove");
			}
	else {
		    remove(b2);
			b1.setLabel("add");		
				
				}
	
	}
      
public void componentAdded(ContainerEvent ce){
	
	System.out.println("component added");
	
}
public void componentRemoved(ContainerEvent ce){
	
	System.out.println("component removed");
	
}

      
      
    public static void main(String bpd[]){
 	new p4("Component Listener");
 	}
}

