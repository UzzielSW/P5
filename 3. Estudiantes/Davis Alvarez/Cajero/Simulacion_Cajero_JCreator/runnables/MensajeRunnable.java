package runnables;

import javax.swing.*;
import java.awt.*;


public class MensajeRunnable extends Thread{
	
	//Hacer referencia al JLabel de la pantalla del cajero
	private JLabel showImage;
	
	
	//Para hacer referencia a un nuevo objeto PantallaRunnable
	private PantallaRunnable tPantallaRunnable;
	
	private  final int DELAY =2000;//tiempo que dormira el Thread
	
	public MensajeRunnable(JLabel showImage,PantallaRunnable tPantallaRunnable ){
		
		this.tPantallaRunnable= tPantallaRunnable;
		this.showImage=showImage;
		
	}
	
	public synchronized void run(){
		
		
		
			try{
				//Muestra que la cuenta no existe
				showImage.setIcon(new javax.swing.ImageIcon("Images\\image6.jpg"));
			
				Thread.sleep(DELAY);
			
			
			}catch(InterruptedException e){
			
				e.printStackTrace();
			}
			
			
	//Iniciamos nuevamente a pantallaRunnable
	tPantallaRunnable.start(); 
		}
		
	}
		
		
	