//Clase que nos permite hacer un retiro

package runnables;

import view.*;
import javax.swing.*;
import java.awt.*;


public class RetiroRunnable extends Thread{
	
	//Hacer referencia al JLabel de la pantalla del cajero
	private JLabel showImage;

	private int indice;//Ubicación del cliente 
	private double cantidad;//Cantidad a retirar
	private int estado;//Lugar de donde fue invicado
	//Para hacer referencia a un nuevo objeto PantallaRunnable
	private PantallaRunnable tPantallaRunnable;
	
	//Hacer referencia al banco creado en Bank
	private Bank bank;
	
	//Tiempo que dormira el Thread
	private  final int DELAY =3000;
	
	public  RetiroRunnable(JLabel showImage,Bank bank, int indice,double cantidad,String nombre,PantallaRunnable tPantallaRunnable,int estado){
	
		super(nombre);
		this.tPantallaRunnable=tPantallaRunnable;
		
		
		this.showImage=showImage;
		
		this.bank =bank;
		this.indice =indice;
		this.cantidad=cantidad;
		this.estado=estado;
		
	}
	
	
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
	
	
	
