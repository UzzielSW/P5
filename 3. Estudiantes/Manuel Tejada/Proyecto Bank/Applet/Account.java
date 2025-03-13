
/**
 * @(#)Account.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/28
 */


package esqueleto;

/** This class represents the account that any customer of a bank has.
 *
 **/
public class Account {
	
	/**balance Holds the amount of money a <code>Customer</code> has in his/her <code>Account</code>.*/
protected  double balance;

	/**
     * Contructs an instance of <code>Account</code> with the specified
     *detail.
     *
     *@param balance Holds the balance of the <code>Account</code>.
     */
    public Account(double balance){
		this.balance=balance;
	}


	 /** This method returns the <code>balance</code>
	  */
    public double getBalance(){
    	return balance;
    }
    
    /**
     * Makes the deposit by adding to <code>balance</code> the <code>amount</code>
     *
     *@param amount The quantity that represents the deposit made to the <code>balance</code> of the <code>Account</code> class.
     */
    public void deposit (double amount) {
    	balance=balance+amount;
    }
    
    /**
     * Makes the withdraw by subtracting to <code>balance</code> the <code>amount</code>
     *
     *@param amount The quantity that represents the withdraw made to the <code>balance</code> of the <code>Account</code> class.
     *@throws OverdraftException If the <code>amount</code> is bigger than <code>balance</code>
     */    
   public void withdraw(double amount) throws OverdraftException
    	{
    	double aux=balance-amount;
    	
    	if(aux<0){
    		throw new OverdraftException("Don`t have enought money",aux);
    	}
    	else
    		balance=aux;
    }
    
}