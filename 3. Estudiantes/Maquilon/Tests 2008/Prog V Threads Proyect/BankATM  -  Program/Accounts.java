
/**
 * @(#)Accounts.java
 *
 * @author Maquilón S.
 * @version 3.00 2008/12/18
 */

package clases;

import java.awt.*;

import java.io.*;

import java.util.*;

     /**
	 *Esta es La Clase Accounts
	 *En ella se llevará a cabo el registro de cada usuario que desee ser parte del programa.
	 *@version 1.0
	 */

public class Accounts implements java.io.Serializable
{
	String nombre, apellido, cedula, contrasena;
	
	double monto;
	
	public static LinkedList cliente = new LinkedList();
	
	public static File clientes = new File("clientes.txt");
	
	public static LinkedList cargado = new LinkedList();
	
	public static LinkedList agregar = new LinkedList(); 
	
	/**
	 *Constructor de la Clase Accounts
	 *Mediante un archivo específico se controla la inserción de cada cliente que desee ser parte del programa.
	 *@param n trae la referencia del nombre del cliente que desee registrarse.
	 *@param a trae la referencia del apellido del cliente que desee registrarse.
	 *@param c trae la referencia del cedula del cliente que desee registrarse.
	 *@param p trae la referencia de la contraseña del cliente que desee registrarse.
	 *@param m trae la referencia del monto inicial, con que el usuario iniciará su cuenta.
	 *@version 1.0
	 */
	
	public Accounts(String n, String a, String c, String p, double m)  throws Exception
	{
				this.nombre = n;
		
				this.apellido = a;
				
				this.cedula = c;
				
				this.contrasena = p;
				
				this.monto = m;
			
			try{
			
				if(clientes.exists())
				{		
			
			ObjectInputStream sacar = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 
										
        	cargado = (LinkedList) sacar.readObject();
						
					Vector otro = new Vector(5);
						
						for(int g = 0; g<1;g++)
						{
							otro.add(g,monto);
				
							otro.add(g,contrasena);
					
							otro.add(g,cedula);
					
							otro.add(g,apellido);
					
							otro.add(g,nombre);
						}
				
				agregar = (LinkedList) cargado;
				
				agregar.add(otro);
        
   ObjectOutput escribir = new ObjectOutputStream(new FileOutputStream("clientes.txt"));
        
        		escribir.writeObject(agregar);
				
			Imprimir();
				
				}
				
				else
				{
					System.out.println("Creando archivo...");

						clientes.createNewFile(); 
						
					Vector nuevo = new Vector(5);
						
						for(int g = 0; g<1;g++)
						{
							nuevo.add(g,monto);
				
							nuevo.add(g,contrasena);
					
							nuevo.add(g,cedula);
					
							nuevo.add(g,apellido);
					
							nuevo.add(g,nombre);
						}
							cliente.add(nuevo);
        
        ObjectOutput escribir = new ObjectOutputStream(new FileOutputStream("clientes.txt"));
        
        escribir.writeObject(cliente);
        
        Imprimir();

				}
				
				}  catch(Exception k){}
		}
		
		/**
		 *(#) Referencia
		 *Método que tiene la función de imprimir en consola cada cliente agregado(referencia).
		 *@version 1.0
		 */
		
		public void Imprimir()
		{		
			try{
			
			ObjectInputStream sacar = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 
						
        	cargado = (LinkedList) sacar.readObject();
        	
        	LinkedList recorrido = new LinkedList();
        	
        	recorrido = cargado;
			
				int f = 0;
				
				while(f < recorrido.size())
				{							
						System.out.println(recorrido.get(f));  
							
						System.out.println("\n");
						
						f++;
				}
				
				} catch(Exception k){}
		}
		
	}	
