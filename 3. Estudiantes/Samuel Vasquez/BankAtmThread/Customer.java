/**
 * @(#)Customer.java
 *
 *
 * @author Samuel Vásquez 9-720-1392
 * @version 1.00 2009/10/7
 */

public class Customer
{
// variables globales, especifican los datos del cliente
private String firstName;
private String lastName;
private String T_cuenta;
private Account account;

private int idCustomer;

	/**
	 * Constructor de la Clase Customer trae como referncia el
	 * nombre y apellido del cliente
	 */
    public Customer(String f, String l, String T_c) 
    {
    	firstName = f;
    	lastName = l;
    	T_cuenta = T_c;
    }
    
    /*
     *  Metodo que retorna el nombre del cliente
     */
    public String getFirstName(){
    	return firstName;
    }
    
    /*
     *  Metodo que retorna el apellido del cliente
     */
    public String getLastName(){
    	return lastName;
    }
    
    /*
     *  Metodo que agrega el nombre del cliente
     */
    public void setFirstName(String first){
    	firstName = first;
    }
    
    /*
     *  Metodo que agrega el apellido del cliente
     */
    public void setLastName(String last){
    	lastName= last;
    }
    
    /*
     *  Metodo que retorna la Clave del cliente
     */
    public int getIdCustomer(){
    	return idCustomer;
    }
    
    /*
     *  Metodo que agrega la clave del cliente
     */
     public void setIdCustomer(int id){
    	idCustomer = id;
    }
    
    /*
     *  Metodo que retorna Account el contiene metodos como getBalance()
     */
    public Account getAccount()
    {
    	return account;
    }
    
    /*
     *  Metodo que agrega Account
     */
     public void setAccount(Account acct)
    {
    	account = acct;
    }
    
    /**
     * Metodo que agrega el tipo de cuenta
     */
     public void setT_cuenta(String T_cuenta)
    {
    	T_cuenta = T_cuenta;
    }
    
    /**
     * Metodo que retorna el tipo de cuenta
     */
     public String getT_cuenta()
    {
    	return T_cuenta;
    }
}