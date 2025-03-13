import java.awt.*;

 class p7 extends Frame {

   p7(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
    
        
    setLayout(new GridLayout(3,1));
    add(new Label("aligned left", Label.LEFT));
    add(new Label("aligned center", Label.CENTER));
    add(new Label("aligned right", Label.RIGHT));

    }
    public static void main(String bpd[]){
 	new p7("Label Component");
 }

}

