//Clase que realiza un deposito cuando controlamos a los dos cajeros y el banco a la vez
package runnables;
import view.*;
import infocustomer.*;
import javax.swing.*;
import java.awt.*;


public class DepositoRunnable extends Thread{
	
	
	//Hacer referencia al banco creado en Bank
	private Bank bank;
	
	private int indice;//Ubicación del cliente
	private double deposito;//Cantidad a depositar
	private  final int DELAY =3000;//Tiempo que dormira el Thread
	
	public  DepositoRunnable(Bank bank,int indice, double deposito){
	
		super("Banco");//Dandole nombre de Banco al Thread
		this.deposito = deposito;
		this.bank = bank;
		this.indice = indice;
	
		
	}
	
	
	public synchronized void run(){
		
		
		try{
			
				bank.getAccounts(indice).deposit(deposito);
			
			
				Thread.sleep(DELAY);
			
			
				}catch(InterruptedException e){
			
					e.printStackTrace();
				}
					
			
			}
			
			
		}
		
		
	