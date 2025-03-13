import java.rmi.*;
import java.io.*;


public class ClienteEmpleados 
{
	
static InterfaceEmpleadoRemote emp; //***** referencia al empleado remoto
static String empleados[] ; //***** array con todos los empleados remotos
	
static String dni, nombre, fcont;
	
 static	BufferedReader entrada =
 new BufferedReader(new InputStreamReader(System.in));	

	public static void main(String [] args)
	{
		String res;	
		int num;

while(true)
   {
   	 	
 	try{
 		
 	   do {
 	        System.out.println("\n\n--- Cliente ---");
 	        System.out.println(" 1. -  Sueldo de Empleaados. ");
 	        System.out.println(" 2. -  Salir. ");
 	        System.out.println(" Seleccione: (1,2): ");
 	        res= entrada.readLine();
 	      }while ( !res.equals("1") && !res.equals("2"));
 	 
 	 // sueldo de empleados
 	      
 	   if ( res.equals("1"))
 	     {
 System.out.println("\n -- Establecer sueldo de Empleados desde el Cliente -- ");
 	
 	// Presentamos a todos los empleados
 	     	
 	System.out.println("\nEmpleados: ");
 	     	
    consultarTodo();

System.out.print("\nIntroduzca el numero del Empleado: ");
num = Integer.parseInt(entrada.readLine());
 
 // Presentamos el empleado
 
 emp = (InterfaceEmpleadoRemote) Naming.lookup(empleados[num]);
 
 if ( emp != null)
  {
  	 // presenta la informacion del empleado
  	 
  	presenta(emp);
  	
  }
  else {
  	
  	    System.out.println("\nEl empleado no existe. ");
       }
 	     	
 } // Salir
 
  if ( res.equals("2"))
 	
 	    System.exit(0);
 			
  }catch(Exception e)
     	{
     	System.out.println("ERROR en cliente: " + e.toString());
 		
     	}
     }
  } //  fin del metodo main()

  //presentamos todos los metodos
  
  public static void consultarTodo()
  {
  	
  try{
  
  // Cargamos todas las referencias de objetos de empleados
  // remotos en un array
  
  	empleados = Naming.list("//127.0.0.1");
  	
  	// Si no hay empleados ...
  	
  	if (empleados.length < 1)
  	  {
  	  	System.out.println("\n No hay empleados ... ");
  	  	return;
  	
  	  } else {
  	  	
  	  	for (int i = 0; i < empleados.length; i++)
  	  	  {
  	  	  	emp = (InterfaceEmpleadoRemote )Naming.lookup(empleados[i]);
  	  	  	System.out.println("Empleado:  " +i+": "+ emp.info());
     	  }
  	  }
 	}catch (Exception e)
	{
	System.out.println("Error en Consulta: " + e.toString());
 		
 		return;	
	}
	
  } // fin consultaTodo
  
  
// presenta la informacion del empeado

public static void presenta(InterfaceEmpleadoRemote emp)
{
	try
	  {
	  	System.out.println("\nDatos del empleado:");
	  	
	  	//Invocacion de metodos remotos
	  	
	  	System.out.println("DNI: " + emp.getDNI());
	  	System.out.println("Nombre: "  + emp.getNombre());
	  	System.out.println("Departamento: " + emp.getDepartamento());
	  	System.out.println("Sueldo: " + emp.getSueldo());
	  	System.out.print("\nIntroduce el nuevo sueldo: ");
	  	double sueldo = Double.parseDouble(entrada.readLine());
	  	
	  	//Comprobar si el sueldo es mayor que 0
	  	
	  	if ( sueldo <= 0)
	  	  {
	  	  	System.out.println("Sueldo incorrecto.");
	  	  	return;
	  	  }
	  	  
	  	  // Registramos el sueldo en el objeto remoto...
	  	  
	  	  emp.setSueldo(sueldo);
	  	  
	  	  System.out.println("Sueldo actualizado.");
	  
	  }catch (Exception e)
	   {
	   System.out.println("Error en Presenta: " + e.toString());
 		
 		return;	
	   }
    } // fin de presenta
	
}// fin de la clase