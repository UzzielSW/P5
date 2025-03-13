import java.awt.*; 
import javax.swing.*; 

@SuppressWarnings("serial")
public class L_Imagen extends JPanel { 
Camion[] a;

Image  rest=Toolkit.getDefaultToolkit().getImage("Map-arte-City-sin-2.jpg");
Image  gato=Toolkit.getDefaultToolkit().getImage("GatoG.gif");
Image  est=Toolkit.getDefaultToolkit().getImage("Barco asesino.gif");
 
public L_Imagen(Camion[] autos){ 
a = autos; 
} 
 
public void paintComponent( Graphics g ) { 
super.paintComponent(g); 


g.drawImage(rest,0,0,null);
g.drawImage(gato,400,600,75,75,null);
g.drawImage(est,755,150,50,50,null);
for(int i=0;i<10;i++){
if( a[i] != null) {
a[i].paint(g); 
} 
}  
}	
} 
