import java.awt.*;

 class p11 extends Frame {

   p11(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      setLayout(null) ;
   	     	   
    Choice c = new Choice();
    c.addItem("High Performance Computing");
    c.addItem("High Performance Networking");
    c.addItem("Parallel Programming");
    c.addItem("Distributed Programming");
    c.addItem("Concurrent Programming");
    add(c);
	c.setBounds(50,50,200,50);
      }
    public static void main(String bpd[]){
 	new p11("Choice Component");
 }

}

