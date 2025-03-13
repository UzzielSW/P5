package runnables;
import view.*;
import infocustomer.*;
import javax.swing.*;
import java.awt.*;


/**
 * Clase que realiza un deposito cuando controlamos a los dos cajeros y el banco a la vez.
 */
public class DepositoRunnable extends Thread{
	
	
	/**El campo bank hace referencia al objeto bank creado en la clase Simulación Cajero.*/
	public Bank bank;
	
        /**El campo indice almacena el indice en que se encuentra un cliente dentro del arreglo de objetos 
        Customer o el de cuentas Account.*/
	public int indice;
        
        /**El campo deposito almacena el deposito a realizar.*/
	public double deposito;
        
        /**El campo DELAY almacena el tiempo que dormira el Thread.*/
	public  final int DELAY =3000;
	
        /**Crea una nueva instancia de DepositoRunnable.
         @param bank Banco de la simulación.
         @param indice Indice de la cuenta del cliente en el arreglo de objetos Account.
         @param deposito Deposito que haga e cliente. 
        */
	public  DepositoRunnable(Bank bank,int indice, double deposito){
	
		super("Banco");//Dandole nombre de Banco al Thread
		this.deposito = deposito;
		this.bank = bank;
		this.indice = indice;
	
		
	}
	
    /**
     * Método sobreescrito donde se da el deposito a la cuenta de un cliente.
     */
	public synchronized void run(){
		
		
		try{
			
				bank.getAccounts(indice).deposit(deposito);
			
			
				Thread.sleep(DELAY);
			
			
				}catch(InterruptedException e){
			
					e.printStackTrace();
				}
					
			
			}
			
			
		}
		
		
	