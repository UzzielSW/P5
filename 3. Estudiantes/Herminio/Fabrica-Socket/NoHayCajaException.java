/**
 * @(#)NoHayCajaException.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/17
 */

/**
 * <code>NoHayCajaException</code> representa una excepcion lanzada cuando se intenta colocar
 * paginas en una caja que ha sido retirada por un Supervisor
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