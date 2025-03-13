import java.awt.*;

 class p10 extends Frame {

   p10(String s) {
  	  super(s);
      setTitle(s);
      setSize(300,300);
      setVisible(true);
    
        
          GridLayout f=new GridLayout(2,2);
        setLayout(f) ;
   	   
    CheckboxGroup cbg = new CheckboxGroup();

    add(new Checkbox("Male", cbg, true));
    add(new Checkbox("Female", cbg, false));
  


    }
    public static void main(String bpd[]){
 	new p10("CheckBoxGroup Component");
 }

}

