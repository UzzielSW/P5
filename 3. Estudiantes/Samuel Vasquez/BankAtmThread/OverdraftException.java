/**
 * @(#)OverdraftException.java
 *
 *
 * @author Samuel Vásquez 9-720-1392
 * @version 1.00 2009/10/7
 */
public class OverdraftException extends Exception{

private double deficit;
private String message;
	
	/**
	 *  Constructor de la clase OverdraftException, recibe dos parametros
	 */
    public OverdraftException(String message, double deficit) {
    	this.deficit = deficit;
    	this.message=message;
    }
    
    /**
     * Metodo que retorna la diferencia del valor a retirar menos el balance actual
     */
    public double getDeficit() {
    	return deficit;
    }
    
    /**
     * Metodo que retorna un mensaje de error cuando el valor a retirar es mayor
     * que el balance actual
     */
    public String getMessage() {
    	return message;
    }
}

