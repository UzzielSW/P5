/**
 * @(#)Banco.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/29
 */
package esqueleto;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**The class <code>Banco</code> represents a bank.
 *It only has one fields called clientes that holds the list of all the <code>Customers</code> of the <code>Banco</code>. 
 *It also has all the methods required to manipulate the customers.
 **/
	public class Banco 
	{

/**Representa la lista de los clientes
 **/	
private LinkedList<Customer> clientes;


/**
     * Contructs an instance of <code>Banco</code> 
     */
    public Banco() {
    	 try  {
    	 	
         cargaLista(); //Call to methods which will load the fiel
       
        }catch (Exception ex) {
              System.out.print("Size : "+clientes.size());
        }
      }
    
	/**
     * This method handles the addition of a new <code>Customer</code> to the <code>Banco</code> by
     *adding to the <code>Linkedlist</code> (in this case call <code>clientes</code>) a new <code>Customer</code> with the necesary data.
     *@param firstName represents the first name of a <code>Customer</code>.
     *@param lastName represents the last name of a <code>Customer</code>.
     *@param id represents the id of a <code>Customer</code>.
     *@param password represents the password of a <code>Customer</code>.
     *@param tipo represents the type of account of a <code>Customer</code>.
     *@param balance represents the balance  used to create an <code>Account</code> instance of a <code>Customer</code>.
     */
    public void addCustomer(String firstName, String lastName,String id,String password,String tipo,double balance)
    {
    	clientes.add(clientes.size(),new Customer(firstName,lastName,id,password,tipo,balance));
    	try{
    		guardaLista();
    	}catch(Exception ex){}
    	
     }
    
    
	/**
     * This method give a new way of adding a new <code>Customer</code> to the <code>Linkedlist</code>.
     *@param position represents the position in which the new <code>Customer</code> is going to be added into the <code>Linkedlist</code>.
     *@param client represents the new <code>Customer</code>that is goint to be added to the <code>Linkedlist</code>.
     */
     public void addCustomer(int position,Customer client)
    {    	
    	clientes.add(position,client); //It save the Customer that has been created some where else
    }
    
    /**
     * This method give a way of of enabling / disabling a <code>Customer</code> by changing his / her state.
     *@param position represents the position in which the new <code>Customer</code> is going to be added into the <code>Linkedlist</code>.
     *@param state represents the new <code>state</code> of a <code>Customer</code>.
     */
    public void ActivateCustomer(int position,boolean state){
    	clientes.get(position).setState(state);    	
    }
    
     /**
     * This method returns the respective <code>Customer</code> by reciving the <code>position</code> it has into the <code>Linkedlist</code>.
     *@param position represents the position in which the new <code>Customer</code> is going to be added into the <code>Linkedlist</code>.
     */      
    public Customer getCustomer(int posicion){
    	return clientes.get(posicion);    	
    }
    
     /**
     * This method returns the <code>position</code> of a <code>Customer</code> by checking the first name ,last name and password 
     *of the <code>Customer</code> that are stored into the <code>Linkedlist</code>.It olse serves as an indicator,cause it returns <code>-1</code> if the user is not found.
     *@param startFrom It give a way of avoiding the problem that is cause when creating multiples <code>Customer</code>s with the same first name and last name.
     *@param firstName It representd the first name captured that is going to be compared with the first names of the <code>Customer</code>
     * that are int the <code>Linkedlist</code>.
     *@param lastName It representd the last name captured that is going to be compared with the last names of the <code>Customer</code>
     * that are int the <code>Linkedlist</code>.
     *@param password It representd the password captured that is going to be compared with the passwords of the <code>Customer</code>
     * that are int the <code>Linkedlist</code>.
     */  
    public int  checkCustomer(int startFrom,String firstName,String lastName,String password){
    	String nombre,apellido;
    	for(int i=startFrom;i<clientes.size();i++)
    	{   
    		//The first name of the Customer # i is given to the m
    		nombre=clientes.get(i).getFirstName();
    		apellido=clientes.get(i).getLastName();
    		 if(nombre.equals(firstName)&&apellido.equals(lastName))
    		 {
    		 	String clave=clientes.get(i).getPasswordCustomer();
    		 	if(password.equals(clave))
    		 	return i;
    		 	
    		 	else
    		 	return -1; /*A way of knowing if the data given to this method is not equivalent
    				 to the data of any of the Customers stored into the Linkedlist*/
    		 }
    	   	
    	}
    	return -1; /*A way of knowing if the data given to this method is not equivalent
    				 to the data of any of the Customers stored into the Linkedlist*/
    	
    	
    }
     /**
     * This method returns the number of <code>Customer</code>s that are stored in the <code>Linkedlist</code>
     */  
    public int getNumOfCustomers()
    {
        	return clientes.size();
    }
    
        
    
    /**This method is responsable for loading the <code>LinkedList</code> stored into the file <code>"archivoLista.matc"</code>*/
     static int y=0;
      public void cargaLista() throws IOException{
    	
        
           try  {
           	y++;
            ObjectInputStream lista=new ObjectInputStream(new FileInputStream("archivoLista.matc"));
            clientes=(LinkedList<Customer> )lista.readObject();
           lista.close();
           clientes.size();
           
	
        }catch (IOException ex) {
       	System.out.print("catch ");
       	if(y<5){
       	System.out.print(""+ex.getMessage());
           guardaLista();
           cargaLista();
       	}
          
        }catch (Exception ex) {
        	if(y<5){
            System.out.println(ex.getMessage());
            guardaLista();
           cargaLista();
                   }/**/
        }
    }
   
    
    /**This method is responsable for storing the <code>LinkedList</code> into the file <code>"archivoLista.matc"</code>*/
    
    public void  guardaLista() throws IOException{
    	
    	    	ObjectOutputStream lista=new ObjectOutputStream(new FileOutputStream("archivoLista.matc"));
    	try{
    	     clientes.size();    
    	
    	      	lista.writeObject(clientes);
    	              }
    catch(Exception ex){
    	System.out.print(""+ex.getMessage());
    	   	lista.writeObject(new LinkedList());
    	
        
    }
    finally{
 
    	   lista.close();
    }
    }
}