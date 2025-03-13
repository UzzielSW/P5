
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 *Clase que guarda toda la informacion de cada  cliente en un archivo
 *
 *
 */
 
public class Customer_R
{
	private String firstName;
	private String lastName;
	private String contra; 
	private String account;
	private String Taccount;
	public Customer customer;
	
		private static LinkedList customer_list = new LinkedList();
		private static LinkedList carga 		= new LinkedList();	
		private static File customer_file 		= new File("Usuario.txt");

		/**
		 *@param f El nombre del Cliente
		 *@param l El apellido del Cliente
		 *@param cd Saldo del Cliente
		 *@param c Contraseña del Cliente
		 *@param ta Tipo de cuenta del cliente
		 */
		 
	public Customer_R (String f, String l,String cd,String c , String ta) throws Exception
	{
		this.firstName  = f;
		this.lastName   = l;
		this.contra		= c;
		this.account    = cd;
		this.Taccount   = ta;
		
		
		try{
			if (customer_file.exists())
			{
				 
				ObjectInputStream saca = new ObjectInputStream(new FileInputStream (new File ( "Usuario.txt" )));
				carga = (LinkedList) saca.readObject();
				customer = new Customer (firstName,lastName,contra,account,Taccount);
				carga.add(customer);
				ObjectOutput escribir = new ObjectOutputStream( new FileOutputStream( "Usuario.txt" ));
								escribir.writeObject(carga);
					 
			}
			else
			{
				customer_file.createNewFile();
				customer = new Customer (firstName,lastName,contra,account,Taccount);
				customer_list.add(customer);
				ObjectOutput escribir = new ObjectOutputStream ( new FileOutputStream("Usuario.txt"));
				escribir.writeObject(customer_list);
			}
		}catch (Exception k) {}
		
	}
	
	
}


