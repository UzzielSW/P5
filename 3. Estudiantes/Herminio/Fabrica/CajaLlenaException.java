/**
 * @(#)CajaLlenaException.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/20
 */


/**
 * <code>CajaLlenaException</code> es una excepcion lanzada cuando la caja se encuentra llena
 *
 * @see Caja
 */
public class CajaLlenaException extends Exception
{

    /**
     * Constructor de la clase
     */
    public CajaLlenaException() 
    {
    	super("La caja esta llena");
    }
    
    
}