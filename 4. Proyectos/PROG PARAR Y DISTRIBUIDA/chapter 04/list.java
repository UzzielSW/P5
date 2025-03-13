import java.awt.*;

 class p12 extends Frame {

   p12(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      setLayout(null) ;
   	     	   
    List l = new List();
    l.add("High Performance Computing");
    l.add("High Performance Networking");
    l.add("Parallel Programming");
    l.add("Distributed Programming");
    l.add("Concurrent Programming");
    add(l);
	l.setBounds(50,50,200,200);
      }
    public static void main(String bpd[]){
 	new p12("List Component");
 }

}

