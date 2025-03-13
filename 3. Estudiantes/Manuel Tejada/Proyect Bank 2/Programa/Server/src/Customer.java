/**
 * @(#)Customer.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/29
 */

package esqueleto;

import javax.swing.*;

/**The class <code>Customer</code> represents the customers of a bank.
 *It has all the necessary fields such as firstName , lastName,etc that holds the first name and last name 
 *respectively.
 *It also has all the methods required to manipulate all the fields
 **/
public class Customer implements java.io.Serializable{
/**@param firstName Represents the first name of a customer*/
private String firstName;
/**Represents the middle name of a customer*/
private String middleName;
/**Represents the last name of a customer*/
private String lastName;
/**Represents the mother`s name of a customer*/
private String moName;
/**Represents the Identification Document of a customer*/
private String id;
/**Represents the e-Mail of a customer*/
private String eMail;
/**Represents the account of a customer
 *@see Account*/
private Account account;
/**Represents the password that any customer of a bank has*/
private String password;
/**Represents the type of account of a customer
 *@see Account*/
private String accountType;
/**Represents the state of a customer.
 *In other words it indicates if a customer is Enable/ Disable*/
private boolean state;


/**
     * Contructs an instance of <code>Customer</code> with the specified
     *detail.
     *
     *@param firstName represents the first name of a <code>Customer</code>.
     *@param lastName represents the last name of a <code>Customer</code>.
     *@param id represents the id of a <code>Customer</code>.
     *@param password represents the password of a <code>Customer</code>.
     *@param tipo represents the type of account of a <code>Customer</code>.
     *@param balance represents the balance  used to create an <code>Account</code> instance of a <code>Customer</code>.
     */
    public Customer(String firstName, String lastName,String id,String password,String tipo,double balance) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.middleName="Not define";
    	this.moName="Not define";
    	
    	this.id=id;
    	this.eMail="Not define";
    	 this.accountType=tipo;   	   	    	    	  	
		this.password=password;    	    	   	    	    	  	
    	account=new Account(balance);
    	state=true;
    	
    }
    
    /**
     *This method set the first name of a customer,by changung the previous value of <code>firstName</code>
     *@param first it is the argument that recives the new first name that will be asigned to <code>firstName</code>
     */
    public void setFirstName(String first){
    	firstName = first;
    }
   
   /**
     *This method set the Middle name of a customer,by changung the previous value of <code>middleName</code>
     *@param middle it is the argument that recives the new middle name that will be asigned to <code>middleName</code>
     */
    public void setMiddleName(String middle){
    	middleName = middle;
    }
    
   /**
     *This method set the last name of a customer,by changung the previous value of <code>lastName</code>
     *@param last it is the argument that recives the new last name that will be asigned to <code>lastName</code>
     */
     public void setLastName(String last){
    	lastName= last;
    }
   
   /**
     *This method set the Mother`s name of a customer,by changung the previous value of <code>motherName</code>
     *@param mother`s it is the argument that recives the new mother`s name that will be asigned to <code>motherName</code>
     */ 
     public void setMothersName(String mother){
    	moName = mother;
    }
   /**
     *This method set the password of a customer,by changung the previous value of <code>password</code>
     *@param password it is the argument that recives the new password that will be asigned to <code>password</code>
     */     
     public void setPasswordCustomer(String password){
    	this.password=password;
    }
    
    /**
     *This method set the ID of a customer,by changung the previous value of <code>id</code>
     *@param id the is the argument that recives the new ID that will be asigned to <code>id</code>
     */ 
    public void setId(String id){
    	this.id=id;
    }     
    
    /**
     *This method set the e-Mail of a customer,by changung the previous value of <code>eMail</code>
     *@param eMail the is the argument that recives the new e-Mail that will be asigned to <code>eMail</code>
     */ 
    public void setEmail(String eMail){
    	this.eMail=eMail;
    }
    
    /**
     *This method set the Type of Account of a customer,by changung the previous value of <code>accountType</code>
     *@param type the is the argument that recives the new Type of Account that will be asigned to <code>accountType</code>
     */ 
    public void setAccountType(String type){
    	this.accountType=type;
    }
    /**
     *This method set the state of a customer,by changung the previous value of <code>state</code>
     *@param state the is the argument that recives the new state that will be asigned to <code>state</code>
     */ 
    public void setState(boolean state){
    	this.state=state;
    }
    
    /**
     *This method returns the first name of a customer.
     */
    public String getFirstName(){
    	return firstName;
    }
    
    /**
     *This method returns the middle name of a customer.
     */
    public String getMiddleName(){
    	return middleName;
    }
    
    /**
     *This method returns the last name of a customer.
     */
    public String getLastName(){
    	return lastName;
    }
       
    /**
     *This method returns the Mother`s name of a customer.
     */
      public String getMothersName(){
    	return moName;
    }
    
    /**
     *This method returns the id of a customer.
     */
    public String getId(){
    	return id;
    }     
    
    /**
     *This method returns the e-Mail of a customer.
     */
    public String getEmail(){
    	return eMail;
    }
       
       /**
     *This method returns the password of a customer.
     */
    public String getPasswordCustomer(){
    	return password;
    }
    
    /**
     *This method returns the state of a customer.
     */
    public boolean getState(){
    	return state;
    }
    
	/**
     *This method returns the balance of a customer by calling the <code>Account public double getBalance()</code> method .
     */            
       public double getBalance()
    {
    	return account.getBalance();
    }
    
    /**
     *This method returns the account type of a customer.
     */
    public String getAccountType(){
    	return this.accountType;
    }
    
    /**
     *This method is called to make a deposit and then calling the <code>Account public void deposit (double amount) </code> method .
     *@param amount Represents the quantity of money that is going to me added to the balance of a customer
     */
    public synchronized void deposit (double amount) 
    {
       	account.deposit(amount);
    }
    
    /**
     *This method is called to make a withdraw and then calling the <code>Account public void withdraw( double amount ) </code> method .
     *@param amount Represents the quantity of money that is going to me subtract to the balance of a customer
     *@throws OverdraftException If the <code>amount</code> is bigger than <code>balance</code>
     */
   public synchronized void withdraw( double amount ) throws OverdraftException
    {
    	
    account.withdraw(amount);
    }
    
    
}