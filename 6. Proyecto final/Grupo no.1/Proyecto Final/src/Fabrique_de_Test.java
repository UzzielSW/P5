import javax.swing.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class Fabrique_de_Test extends JFrame  implements ActionListener{
L_Imagen l; 

Camion[] truck; 
JButton demarrage;
Pont p;
boolean de_stationnement[], ressorts[],de_stationnementf[];
public Thread courir;
public JTextArea J;
public void actionPerformed(final ActionEvent e){
		if(e.getSource().equals(demarrage)){
			demarrage.setEnabled(false);
	for( int i=0;i<10;i++ ){
     truck[i] = new Camion( (byte)(Math.random()*1) ,p, (byte)i,this.de_stationnement,this.ressorts,this.de_stationnementf);
     truck[i].setId((byte)i);
     courir = new Thread(truck[i]);
     courir.start();
	}
		} 
	}
public Fabrique_de_Test() { 
super("Fabrica");
this.de_stationnement=new boolean[3];
for(int i=0;i<3;i++){
	this.de_stationnement[i]=true;	
}
this.ressorts=new boolean[4];
for(int i=0;i<4;i++){
	this.ressorts[i]=true;
}
this.de_stationnementf=new boolean[10];
for(int i=0;i<10;i++){
	this.de_stationnementf[i]=true;
}
truck = new Camion[20];
p = new Pont();
demarrage = new JButton("START");
demarrage.addActionListener(this);
p.setCamion(truck);
l = new L_Imagen(truck);
p.setL_Imagen(l); 
setContentPane(l);
add(demarrage);
setSize(1400,760); 
setVisible(true); 
setResizable(true);
} 

public static void main(final String[] args) {
        final Fabrique_de_Test proyecto = new Fabrique_de_Test();
 	proyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
} 
