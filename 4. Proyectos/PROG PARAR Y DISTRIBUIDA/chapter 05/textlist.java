import java.awt.*;
import java.awt.event.*;

 class p21 extends Frame implements TextListener{
 	TextField t;
   p21(String s) {
      super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
      setLayout(null) ;
        	   
   t=new TextField();
   t.addTextListener(this);
   add(t);
   t.setBounds(50,50,150,25);
   }
   public void textValueChanged(TextEvent te){
   	
   	if(te.getSource()==t)
   	setTitle(t.getText());
   }
   
    public static void main(String bpd[]){
 	new p21("TextField Component");
    }
}
