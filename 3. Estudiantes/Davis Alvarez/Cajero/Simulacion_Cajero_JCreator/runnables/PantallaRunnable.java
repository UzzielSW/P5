//Esta clase muestra los mensajes de vienvenida del  cajero
package runnables;

import javax.swing.*;
import java.awt.*;


public class PantallaRunnable extends Thread{
	
	//Hacer referencia al JLabel de la pantalla del cajero
	private JLabel showImage;
	
	//parametro cuyo estado dictara la vida del Thread
	private int bandera;
	
	//Tiempo que dormira el Thread
	private  final int DELAY =3000;
	
	public PantallaRunnable(JLabel showImage){
	
		this.showImage=showImage;
		bandera =0;
	
	
			
	}
	
	
	public synchronized void run(){
		
		
		while(bandera!=1){
			
			
				try{
				
					
				
					showImage.setIcon(new javax.swing.ImageIcon("Images\\image1.jpg"));
					Thread.sleep(DELAY);
									
					if(bandera==1){
						break;
				
					}
					
					
					showImage.setIcon(new javax.swing.ImageIcon("Images\\image2.jpg"));
		
					Thread.sleep(DELAY);
					
			
				}catch(InterruptedException e){
			
				e.printStackTrace();
				}
				
							
		
		}
	
		
		
	}
	
	public void setBandera(int bandera){//Cambiamos el estado de bandera a 1 
										//y el threads muere
		
			this.bandera=bandera;
	}
	
}