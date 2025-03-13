/**
 * @(#)Account.java
 *
 *
 * @author Samuel Vásquez 9-720-1392
 * @version 1.00 2009/10/7
 */
public class Account{

protected double balance;
	
	/**
	 * Constructor de la clase Account
	 */
    public Account(double bal) {
    	balance = bal;
    }
    
    /**
     * Metodo que retorna el balance del cliente
     */
    public double getBalance()
    {
    	return balance;
    }
    
    /**
     * Metodo que realiza un deposito y retorna el nuevo balance
     */
    public double deposit (double amount) 
    {
    	synchronized(this)
    	{
    		try
    		{
    		balance = balance + amount;
    		Thread.sleep(5000);
    		}catch(Exception e)
    		{
    		
    		}    
    	}	
    	return amount;
    }
    
    /**
     * Metodo que verifica si el valor a retirar es mayor o menor que 
     * el balance actual
     */
    public void withdraw( double amount ) throws OverdraftException
    {
    	if ( balance < amount )
    	{
    		/* Si el balance es menor que el valor a retirar
    		 se llama al constructor de la clase OverdraftException
    		 pasandole un mensaje y la diferencia del resultado*/
    		throw new OverdraftException("Insufficient funds  ", amount - balance);
    	}
    	else
    	{
    		// se realiza la oeracion normal
    		synchronized(this)
    		{
	    		try
	    		{
	    			balance = balance - amount;
	    			Thread.sleep(5000);
	    		}catch(Exception e)
	    		{
	    			
	    		}
    		}
    	}
    }
}

