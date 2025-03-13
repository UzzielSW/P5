
/**
 * @(#)OverdraftException.java
 *
 *
 * @author Manuel Tejada
 * @version 1.00 2009/11/28
 */
package esqueleto;


public class OverdraftException extends java.lang.Exception implements java.io.Serializable {
    /**The amount of money that causes the OverdraftException */    
    private double deficit;
    
    /**The OverdraftException Information*/
	private String message;
    /**
     * Contructs an instance of <code>OverdraftException</code> with the specified
     *detail.
     *
     *@param message The OverdraftException information
     *@param deficit The amount that causes the Overdraft
     */
    public OverdraftException(String message, double deficit) {
    	this.deficit = deficit;
    	this.message=message;
    }
    
    /**
     * Returns the amount of money that causes the Overdraft
     */
    public double getDeficit() {
    	return deficit;
    }
    
    /**
     * Returns the  <code>OverdraftException</code> information.
     *
     *@param message The OverdraftException information
     *@param deficit The amount that causes the Overdraft
     */
    public String getMessage() {
    	return message;
    }
    
    
}