/**
 * @(#)ServidorEmpleado
 *
 *
 * @author 
 *Modificado por Prof. Alvaro Pino N.
 * @version 1.00 2008/11/19
 * Programa Servidor que genera el objeto remoto y 
 * lo ofrece a traves de RMI.
 *
 */
import java.rmi.*;

import java.rmi.server.*;
import java.io.*;

public class ServidorEmpleado {
    
 public static void main(String args [])
 {
 
 BufferedReader entrada =
 new BufferedReader(new InputStreamReader(System.in));	


   String dni, nombre, dept, res;
   
   while(true)
   {
   	 	
 	try{
 		
 	   do {
 	        System.out.println("\n\n--- Servidor ---");
 	        System.out.println(" 1. -  Alta de Empleados. ");
 	        System.out.println(" 2. -  Salir. ");
 	        System.out.print(" Seleccione: (1,2): ");
 	        res= entrada.readLine();
 	      }while ( !res.equals("1") && !res.equals("2"));
 	   
 	   // alta de empleados
 	      
 	   if ( res.equals("1"))
 	     {
 	     	System.out.println("\n -- Alta de Empleados en el Servidor -- ");
 	     	
 	     	System.out.print("\nIntroduzca el DNI: ");
 	     	dni=entrada.readLine();
 	     	
 	     	System.out.print("\nIntroduzca el nombre: ");
 	     	nombre=entrada.readLine();
 	     	
 	     	System.out.print("\nIntroduzca el departamento: ");
 	     	dept= entrada.readLine();
 	     	
 	     	//Registramos cada objeto remoto...

ImplEmpleadoRemote emp = new ImplEmpleadoRemote(dni,nombre,dept,0);
 	 
Naming.rebind("//127.0.0.1/" +emp.getDNI(),emp);
System.out.println("\nEmpleado:      " +  emp.info() + "registrado.");

        }
           
else
      // Salir
      
    if ( res.equals("2"))
 	
 	    System.exit(0);
 			
  }catch(Exception e)
     	{
     	System.out.println("ERROR: " + e.toString());
 		
     	}
     }
   }
}