import java.io.*;
import java.io.Serializable;
/**
 *La clase Account es la clase Utilizada para obtener el balance actual de los Usuarios 
 *del Banco y realizar las operaciones de deposito, retiro y mostrar Balance.
 */
public class Account implements Serializable
{
protected double balance;//Variale para obtener el Balance de una cuenta.

    /**
     *Contructor de la Clase.
     *Inicializando en el constructor la variable Balance.
     */
    public Account(double bal) 
    {
    	balance = bal;
    }
    
    /**
     *Metodo donde se obtiene el balance de las cuentas de los usuarios
     *@return retorna el balnce actual.
     */
     
    public double getBalance()
    {
    	return balance;
    }
    
    /**
     *Metodo donde inicializo y actualizo el deposito mediante balance anteriores 
     *y realizo operaciones de deposito del Banco.
     *@return retorna del nuevo balance despues de depositar.
     */
    public double deposit(double amount) 
    {
    	balance = balance + amount;
    	return amount;
    }
    
    /**
     *Metodo donde inicializo y actualizo el retiro mediante balance anteriores 
     *y realizo operaciones de retiro del Banco. El dinero a retirar es mayor que 
     *Balance no se podra realizar la Transaccion.
     *@throws excepcion si el dinero a retirar es mayor que el balance disponible.
     */
    public void withdraw( double amount ) throws OverdraftException
    {
    	if ( balance < amount )
    	{
    		throw new OverdraftException("FONDOS insuficientes", amount - balance);
    	}
    	else
    	{
    		balance = balance - amount;
    	}
    }
}