import java.awt.*;

 class p5 extends Frame {

   p5(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      
      GridLayout f=new GridLayout(2,2);
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
 	new p5("Grid Layout");
 }

}

