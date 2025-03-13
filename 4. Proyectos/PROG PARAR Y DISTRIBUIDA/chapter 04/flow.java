import java.awt.*;

 class p2 extends Frame {

   p2(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      
      FlowLayout f=new FlowLayout();
        setLayout(f) ;

       Button b1=new Button("One");
       Button b2=new Button("Two");
       Button b3=new Button("Three");
       Button b4=new Button("Four");
       
       add(b1);      
       add(b2);
       add(b3);
       add(b4);
        
    }
    public static void main(String bpd[]){
 	new p2("Flow Layout");
 }

}

