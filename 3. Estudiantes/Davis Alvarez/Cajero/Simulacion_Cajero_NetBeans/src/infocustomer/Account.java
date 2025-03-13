package infocustomer;

import view.*;

import javax.swing.*;
/**Esta clase contiene la información de la cuenta de un cliente.*/
public class Account{
	
	/**El campo balance almacena la cantidad de dinero disponible
         en la cuenta.*/
	public double balance;
        /**El campo numeroDeCuenta almacena el número de la cuenta.*/
	public int numeroDeCuenta;

	
	private ViewTransaction viewTransaction;
	
	/**Crea un nuevo Account con un balance inicial, número de cuenta
         y un viewTransaction.
         @param init_balance Balance inicial de la cuenta .
         @param numeroDeCuenta Número de la cuenta.
         @param viewTransaction Para poder ver las transacciones realizadas en la cuenta.*/
        public Account(double init_balance,int numeroDeCuenta,ViewTransaction viewTransaction){
		
		this.numeroDeCuenta=numeroDeCuenta;
		this.viewTransaction=viewTransaction;
		balance = init_balance;
	}
	
        /**Método que retorna el número de cuenta de la cuenta.
         @return Número de cuenta de un cliente.*/
	public int getNumeroDeCuenta(){
		
		return numeroDeCuenta;
	}
	
        /**Método que retorna el balance de la cuenta.
         @return balnce Balance de la cuenta*/
	public double getBalance(){
		
		return balance;
	}
	
	/**Método que realiza un deposito a la cuenta
         @param dep Deposito de la cuenta*/
	public synchronized void deposit(double dep){
		
		balance+=dep;
		viewTransaction.setText("El "+Thread.currentThread().getName()+" esta haciendo deposito de  :"+dep
			+"\n"+"Nuevo balance es :"+getBalance());	
	
	}
	
	/**Método que reliza un retiro de la cuenta.
         @param withdraw Retiro a realizar.
         @return True si no se realiza el retiro false en caso contrario. */
	public synchronized boolean withdraw(double withdraw){
		
		
		if(withdraw>balance){
			
			viewTransaction.setText("El "+Thread.currentThread().getName()+" no puede hacer el retiro "+
			"\n"+"El balance es :"+getBalance());
			return(true);
			
		}
		
		else{
		
	
			balance-=withdraw;	
			viewTransaction.setText("El "+Thread.currentThread().getName()+" esta haciendo retiro de :"+withdraw
			+"\n"+"Nuevo balance es :"+getBalance());
			return(false);
		}
		
	
		
	
	}
}