import java.awt.*;

 class p8 extends Frame {

   p8(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
    
        
    setLayout(new GridLayout(3,1));
    add(new Button("First"));
    add(new Button("Second"));
    add(new Button("Third"));
    add(new Button("Fourth"));

    }
    public static void main(String bpd[]){
 	new p8("Button Component");
 }

}

