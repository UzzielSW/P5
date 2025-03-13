/**
 *Programa del semaforo con menu
 *Creado por :
 *Manuel Tejada
 *8-818-1801
 */
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Semaforo {
    
    public static void main(String[] args) {
    	
    	// TODO, add your application code
    //	System.out.println("Hello World!");
    	RadioButtonDemo jframe=new RadioButtonDemo();
   
       
      jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jframe.pintame();
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	jframe.setLocation((d.width - jframe.getSize().width) / 2, (d.height - jframe.getSize().height)/2);
	jframe.setVisible(true); 
      
    }
}
