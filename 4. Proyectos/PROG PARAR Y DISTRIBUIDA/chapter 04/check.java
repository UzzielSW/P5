import java.awt.*;

 class p9 extends Frame {

   p9(String s) {
  	  super(s);
      setTitle(s);
      setSize(600,600);
      setVisible(true);
    
        
          GridLayout f=new GridLayout(2,2);
        setLayout(f) ;
   	   
    add(new Checkbox("High Performance Computing"));
    add(new Checkbox("High Performance Networking"));
    add(new Checkbox("Parallel Programming"));
    add(new Checkbox("Distributed Programming", null, true));
    add(new Checkbox("Concurrent Programming"));


    }
    public static void main(String bpd[]){
 	new p9("CheckBox Component");
 }

}

