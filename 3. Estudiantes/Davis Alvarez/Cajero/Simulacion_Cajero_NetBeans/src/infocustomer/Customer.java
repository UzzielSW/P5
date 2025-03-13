package infocustomer;


import java.awt.*;
import javax.swing.*;


/**Esta clase contiene toda la información de un cliente.*/
public class Customer{
	
        /**El campo name almacena el nombre del cliente.*/
	public String name;
	
        /**El campo id almacena el número de identificación personal de un cliente.*/
	public String id;
	/**El campo direccion almacena la dirección de un cliente. */
	public String direccion ;
	
        /**El campo account almacena toda la información de la cuenta de un cliente.*/
	public Account account;
	
        /**
     * Crea un nuevo Customer con un nombre, un número de identificación personal, una dirección
     * y una cuenta.
     * @param name Nombre del cliente.
     * @param id Número de identificación personal del cliente.
     * @param direccion Dirección residencial del cliente.
       @param account Cuenta del cliente.
     */
	public Customer(String name, String id,String direccion, Account account){
		
		
		this.name = name;
		this.id=id;	
		this.direccion= direccion;
		this.account= account;
		
	}
	
	
    /**
     * Método que retorna la dirección residencial del cliente.
     * @return Dirección residencial del cliente.
     */
	public String getDireccion(){
		
		return direccion;
	}
	
	
    /**
     * Método que retorna el nombre del cliente.
     * @return Nombre del cliente.
     */
	public String getName(){
		
		return name;
	}
	
	
	
    /**
     * Método que retorna la cuenta del cliente
     * @return Cuenta del cliente
     */
	public Account getAccount(){
		
		return account;
	}
		
	
	
    /**
     * Método que retorna la identificación personal del cliente
     * @return Identificación personal del cliente
     */
	public String getId(){
		
		return id;
	}
    /**
     * Método que le asigna una cuenta al cliente
     * @param acct Cuenta del cliente
     */
	public void setAccount(Account acct){
		
		account = acct;
	}
}