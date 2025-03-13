import java.awt.*;
 class p13 extends Frame {
   p13(String s) {
      super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      setLayout(null) ;
        	   
   TextField t=new TextField();
   add(t);
   t.setBounds(50,50,150,25);
      }
    public static void main(String bpd[]){
 	new p13("TextField Component");
    }
}
