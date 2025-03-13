/**
 * @(#)CajaLlenaException.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/20
 */

/**
 * <code>CajaLlenaException</code> representa una excepcion lanzada cuando una caja esta llena,
 * esto ocurre al llegar al maximo de su capacidad (100 paginas)
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