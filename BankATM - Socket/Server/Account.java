
/**
 * @(#)Account.java
 *
 *
 * @author  Ronnie Rodríguez
 * @version 1.00 2009/10/16
 */

public class Account implements java.io.Serializable
{

protected double balance;

    public Account(double bal) {
    	balance = bal;
    }
    // retorna el balance
    public double getBalance()
    {
    	return balance;
    }
    // relaiza la operacion de  deposito
    public double deposit (double amount) 
    {
    	balance = balance + amount;
    	return amount;
    }
    // realiza la operacion de retiro
    public void withdraw( double amount ) throws OverdraftException
    {
    	if ( balance < amount )
    	{
    		throw new OverdraftException("Insufficient funds  ", amount - balance);
    	}
    	else
    	{
    		balance = balance - amount;
    	}
    }
}