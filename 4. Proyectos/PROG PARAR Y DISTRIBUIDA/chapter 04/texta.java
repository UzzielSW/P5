import java.awt.*;
 class p14 extends Frame {
   p14(String s) {
      super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      setLayout(null) ;
        	   
   TextArea ta=new TextArea();
   add(ta);
   ta.setBounds(50,50,200,200);
      }
    public static void main(String bpd[]){
 	new p14("TextArea Component");
    }
}
