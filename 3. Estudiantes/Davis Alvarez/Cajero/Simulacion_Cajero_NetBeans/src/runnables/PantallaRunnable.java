
package runnables;

import javax.swing.*;
import java.awt.*;


/**
 * Esta clase muestra los mensajes de vienvenida del  cajero.
 */
public class PantallaRunnable extends Thread{
	
	
	/**El campo bandera  dictara la vida del Thread.*/
	public int bandera;
	
	/**El campo DELAY almacena el tiempo que dormira el Thread.*/
	public  final int DELAY =3000;
        
       //Hacer referencia al JLabel de la pantalla del cajero
	private JLabel showImage;
	
	
         /**Crea una nueva instancia de PantallaRunnable.
         @param showImage JLabel que muestra la pantalla del cajero.
         */
	public PantallaRunnable(JLabel showImage){
	
		this.showImage=showImage;
		bandera =0;
	
	
			
	}
	
    /**
     * Método sobreescrito donde se muestran los mensajes de vienvenida del  cajero.
     */
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
	
        /**Método que nos permite finalizar a PantallaRunnable.
         @param bandera Bandera para finalizar la ejecución del Thread.*/
	public void setBandera(int bandera){
		
			this.bandera=bandera;
	}
	
}