
package runnables;

import view.*;
import javax.swing.*;
import java.awt.*;


/**
 * Clase que nos permite hacer un retiro.
 */
public class RetiroRunnable extends Thread{
	
        /**El campo indice almacena el indice en que se encuentra un cliente dentro del arreglo de objetos 
         Customer o el de cuentas Account.*/
	public int indice;
        
         /**El campo cantidad almacena la cantidad a retirar.*/
	public double cantidad;
        
        /**El campo tPantallaRunnable cambia el estado de la pantalla del cajero. */ 
	public PantallaRunnable tPantallaRunnable;
        
	/**El campo bank hace referencia al objeto bank creado en la clase Simulación Cajero.*/
	public Bank bank;
	
	/**El campo DELAY almacena el tiempo que dormira el Thread.*/
	public  final int DELAY =3000;
        
        //Hacer referencia al JLabel de la pantalla del cajero
	private JLabel showImage;
        /**El párametro estado guia de donde fue instanciada esta clase*/
        public int estado;

        /**Crea un nuevo RetiroRunnable.
         @param showImage JLabel que muestra la pantalla del cajero.
         @param bank Banco de la simulación.
         @param indice Indice de la cuenta del cliente en el arreglo de objetos Account.
         @param cantidad Cantidad a retirar.
         @param nombre Nombre del cajero de donde se realiza el retiro.
         @param tPantallaRunnable Thread que da inicio al funcionamiento de la pantalla del cajero.
         @param estado Lugar de donde fue invocada la clase.*/
	public  RetiroRunnable(JLabel showImage,Bank bank, int indice,double cantidad,String nombre,PantallaRunnable tPantallaRunnable,int estado){
	
		super(nombre);
		this.tPantallaRunnable=tPantallaRunnable;
		this.showImage=showImage;
		this.bank =bank;
		this.indice =indice;
		this.cantidad=cantidad;
		this.estado=estado;
		
	}
	
	
        /**
     * Método sobreescrito donde se da el retiro de dinero de la cuenta de un cliente.
     */
	public synchronized void run(){
					
	
		
			if(bank.getAccounts(indice).withdraw(cantidad)){
				
				//si no se pudo hacer el retiro
				try{
			
					showImage.setIcon(new javax.swing.ImageIcon("Images\\image8.jpg"));
			
					Thread.sleep(DELAY);
			
			
				}catch(InterruptedException e){
			
					e.printStackTrace();
				}
					
			
			}
			
			
			else{
				
					try{
					
					//si se pudo hacer el retiro
			
					showImage.setIcon(new javax.swing.ImageIcon("Images\\image9.jpg"));
			
					Thread.sleep(DELAY);
			
			
					}catch(InterruptedException e){
			
						e.printStackTrace();
					}
					
				
				
			}
		
		if(estado==0){
			
			tPantallaRunnable.start();
		}
		 
	
		}
		
		
	}
	
	
	
