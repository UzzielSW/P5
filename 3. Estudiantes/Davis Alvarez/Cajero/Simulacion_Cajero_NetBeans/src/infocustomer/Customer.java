package infocustomer;


import java.awt.*;
import javax.swing.*;


/**Esta clase contiene toda la informaci�n de un cliente.*/
public class Customer{
	
        /**El campo name almacena el nombre del cliente.*/
	public String name;
	
        /**El campo id almacena el n�mero de identificaci�n personal de un cliente.*/
	public String id;
	/**El campo direccion almacena la direcci�n de un cliente. */
	public String direccion ;
	
        /**El campo account almacena toda la informaci�n de la cuenta de un cliente.*/
	public Account account;
	
        /**
     * Crea un nuevo Customer con un nombre, un n�mero de identificaci�n personal, una direcci�n
     * y una cuenta.
     * @param name Nombre del cliente.
     * @param id N�mero de identificaci�n personal del cliente.
     * @param direccion Direcci�n residencial del cliente.
       @param account Cuenta del cliente.
     */
	public Customer(String name, String id,String direccion, Account account){
		
		
		this.name = name;
		this.id=id;	
		this.direccion= direccion;
		this.account= account;
		
	}
	
	
    /**
     * M�todo que retorna la direcci�n residencial del cliente.
     * @return Direcci�n residencial del cliente.
     */
	public String getDireccion(){
		
		return direccion;
	}
	
	
    /**
     * M�todo que retorna el nombre del cliente.
     * @return Nombre del cliente.
     */
	public String getName(){
		
		return name;
	}
	
	
	
    /**
     * M�todo que retorna la cuenta del cliente
     * @return Cuenta del cliente
     */
	public Account getAccount(){
		
		return account;
	}
		
	
	
    /**
     * M�todo que retorna la identificaci�n personal del cliente
     * @return Identificaci�n personal del cliente
     */
	public String getId(){
		
		return id;
	}
    /**
     * M�todo que le asigna una cuenta al cliente
     * @param acct Cuenta del cliente
     */
	public void setAccount(Account acct){
		
		account = acct;
	}
}