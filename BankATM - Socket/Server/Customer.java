
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @(#)Customer.java
 *
 *
 * @author  Ronnie Rodr�guez
 * @version 1.00 2009/10/16
 */
 
public class Customer implements Serializable 
{

private String firstName;
private String lastName;
private String tipoCuenta;
private Account account;
private long idCustomer;

 //* Constructor*/
   public Customer() 
   	{
   
    }
   //* Metodo para Retornar el primer nombre*/ 
    public String getFirstName(){
    	return firstName;
    }
    
   //* Metodo para Retornar el apellido*/ 
    public String getLastName(){
    	return lastName;
    }
    
   //* Metodo para guardar el primer nombre*/ 
    public void setFirstName(String first){
    	firstName = first;
    }
    
   //* Metodo para guardar el apellido*/ 
    public void setLastName(String last){
    	lastName= last;
    }
    
   //* Metodo para retornar el ID del usuario*/ 
    public long  getIdCustomer(){
    	return idCustomer;
    }
   
   //* Metodo para incorporar el ID del usuario*/  
     public void setIdCustomer(Long id){
    	idCustomer = id;
    }
 
   //* Metodo para configurar el tipo de cuenta del usuario*/ 
    public void setTCuenta(String h)
    {
    	tipoCuenta=h;
    }
   
   //* Metodo para retornar el tipo de cuenta del usuario*/ 
    public String getTCuenta()
    {
    	return tipoCuenta;
    }
   //* Metodo para retornar el balance*/  
    public Account getAccount()
    {
    	return account;
    }
    
   //* Metodo para configurar el balance*/  
    public void setAccount(Account acct)
    {
    	account = acct;
    }
    
}