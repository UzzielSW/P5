/**
 * @(#)NoHayCajaException.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/17
 */

/**
 * <code>NoHayCajaException</code> es una excepcion lanzada cuando la caja ha sido retirada
 *
 * @see Caja
 */
public class NoHayCajaException extends Exception
{

    /**
     * Constructor de la clase
     */
    public NoHayCajaException() 
    {
    	super("No hay caja");
    }
    
    
}