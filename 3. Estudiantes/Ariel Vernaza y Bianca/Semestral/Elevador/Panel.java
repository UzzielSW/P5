import java.awt.*;
import javax.swing.*;
/** Esta clase define el panel que controla al elevador desde adentro
 * @author Bianca, Ariel
 * @version 1.1*/

public class Panel implements Runnable
{ 
 private JButton imagen,botones[];
 private JButton Piso;
 public ActionPanel temp;
 public JFrame ventana;
 private int cambio;
 
 public Panel(int a, Elevador elevador)
 {   	
  ventana=new JFrame("PANEL DE CONTROL. "+elevador.hashCode());
  this.Piso=new JButton(Integer.toString(a));
  this.cambio=a;
  this.Piso.setBackground(Color.BLACK);
  this.Piso.setForeground(Color.RED);
  this.botones=new JButton[8];
  temp=new ActionPanel(elevador);  
  this.botones[0]=new JButton("PB");
  this.botones[0].addActionListener(temp);
  this.botones[1]=new JButton("1");
  this.botones[1].addActionListener(temp);
  this.botones[2]=new JButton("2");
  this.botones[2].addActionListener(temp);  
  this.botones[3]=new JButton("CERRAR");
  this.botones[3].setSize(50,50);
  this.botones[3].addActionListener(temp);
  this.botones[4]=new JButton("ABRIR");
  this.botones[4].addActionListener(temp);
  this.botones[4].setSize(50,50);
  this.botones[5]=new JButton("HELP",new ImageIcon("alert.jpg"));
  this.botones[5].addActionListener(temp);
  this.botones[6]=new JButton("SALIR");
  this.botones[6].addActionListener(temp);
  this.botones[5].setSize(50,50);  
  imagen=new JButton(new ImageIcon("digicharat03.gif"));
  this.imagen.setBackground(Color.BLACK);  
  for(int i=0;i<6;i++)
  {
	this.botones[i].setForeground(Color.WHITE);
	this.botones[i].setBackground(Color.orange);
  }  
 }
 
 public void openWindows()
 {	 
  ventana.setVisible(true);  
 }
 
 public void run(){	
 	JButton u=new JButton(new ImageIcon("3d_384.jpg")); 	
 	u.setLayout(new GridLayout(1,2)); 	 	
 	JPanel derecho=new JPanel();     	 	
 	JPanel ups2=new JPanel(); 
 	ups2.setLayout(new BorderLayout());
 	derecho.setLayout(new BorderLayout());
 	JButton ups=new JButton(new ImageIcon("3d_384.jpg")); 	
    ups.setLayout(new GridLayout(6,2));
            
    ups.add(botones[5]); 
 	ups.add(botones[2]);  
 	ups.add(botones[3]); 	
 	ups.add(botones[1]);  	
 	ups.add(botones[4]);  		 	
 	ups.add(botones[0]);
 	ups.add(botones[6]);
 	derecho.add(Piso,BorderLayout.NORTH);
 	derecho.add(ups,BorderLayout.CENTER); 	
 	ups2.add(imagen,BorderLayout.NORTH); 	
 	u.add(ups2);
 	u.add(derecho);
 	Container ven=ventana.getContentPane();
 	ven.add(u); 	
 	ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 	ventana.setSize(320,100);  		 	 	 	 
 	ventana.setBounds(320,100,400,300);  		 	 	 	 
 }
 
 public void setPiso(int a)
 {	 
	 if(this.cambio!=a){
		 this.cambio=a;
		 this.Piso.setText(Integer.toString(a));
	 }
 }
   
}
