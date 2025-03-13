/**
 *La clase OverdraftException es la clase utilizada para manejar
 *las excepciones de las operaciones de deposito, retiro y balance.
 */


public class OverdraftException extends Exception{

private double deficit;
private String message;


    public OverdraftException(String message, double deficit) 
    {
    	this.deficit = deficit;
    	this.message=message;
    }
    
    public double getDeficit() 
    {
    	return deficit;
    }
  
    public String getMessage() 
    {
    	return message;
    }
    
   
}