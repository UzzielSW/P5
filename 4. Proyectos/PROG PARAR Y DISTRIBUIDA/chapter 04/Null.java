import java.awt.*;

 class p6 extends Frame {

   p6(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      
       setLayout(null) ;
   	   
   	   Button b1=new Button("One");
       Button b2=new Button("Two");
       Button b3=new Button("Three");
       Button b4=new Button("Four");
       
       add(b1);      
       add(b2);
       add(b3);
       add(b4);
       
       b1.setBounds(50,50,50,50);
       b2.setBounds(50,110,50,50);
       b3.setBounds(50,170,50,50);
       b4.setBounds(50,230,50,50);
        
    }
    public static void main(String bpd[]){
 	new p6("Null Layout");
 }

}

