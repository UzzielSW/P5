import java.awt.*;

 class p3 extends Frame {

   p3(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      
      BorderLayout f=new BorderLayout();
        setLayout(f) ;
   	   
   	   Button b1=new Button("One");
       Button b2=new Button("Two");
       Button b3=new Button("Three");
       Button b4=new Button("Four");
       
       add(b1,BorderLayout.NORTH);      
       add(b2,BorderLayout.SOUTH);
       add(b3,BorderLayout.WEST);
       add(b4,BorderLayout.EAST);
        
    }
    public static void main(String bpd[]){
 	new p3("Border Layout");
 }

}

