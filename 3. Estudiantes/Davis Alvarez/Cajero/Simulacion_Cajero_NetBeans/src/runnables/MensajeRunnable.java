package runnables;

import javax.swing.*;
import java.awt.*;


/**
 * Clase que nos muestra solamente que una cuenta no existe.
 */
public class MensajeRunnable extends Thread{
	
         /**El campo tPantallaRunnable cambia el estado de la pantalla del cajero. */
	public PantallaRunnable tPantallaRunnable;
	
        /**El campo DELAY almacena el tiempo que dormira el Thread.*/
	public  final int DELAY =2000;
        
	//Hacer referencia al JLabel de la pantalla del cajero
	private JLabel showImage;
	
        /**Crea una nueva instancia de MensajeRunnable.
         @param showImage JLabel que muestra la pantalla del cajero.
         @param tPantallaRunnable Thread que da inicio al funcionamiento de la pantalla del cajero.
         */
	public MensajeRunnable(JLabel showImage,PantallaRunnable tPantallaRunnable ){
		
		this.tPantallaRunnable= tPantallaRunnable;
		this.showImage=showImage;
		
	}
	
        /**
     * Método sobreescrito que nos muestra que una cuenta no existe.
     */
	public synchronized void run(){
		
		
		
			try{
				//Muestra que la cuenta no existe
				showImage.setIcon(new javax.swing.ImageIcon("Images\\image6.jpg"));
			
				Thread.sleep(DELAY);
			
			
			}catch(InterruptedException e){
			
				e.printStackTrace();
			}
			
			
	//Iniciamos nuevamente a tPantallaRunnable.
	tPantallaRunnable.start(); 
		}
		
	}
		
		
	
