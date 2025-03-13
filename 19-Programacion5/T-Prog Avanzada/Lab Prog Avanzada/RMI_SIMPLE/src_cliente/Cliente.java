/*
 * Cliente.java
 *
 * Ejemplo de muy simple de rmi
 */

package chuidiang.ejemplos.rmi.suma;

import java.rmi.*;

/**
 * Ejemplo de cliente rmi nocivo, para aprovecharse de un servidor sin
 * SecurityManager.
 * @author  Javier Abellán
 */
public class Cliente {
    
    /** Crea nueva instancia de Cliente */
    public Cliente() 
    {
        try
        {
		// Lugar en el que está el objeto remoto.
		// Debe reemplazarse "localhost" por el nombre o ip donde
		// esté corriendo "rmiregistry".
		// Naming.lookup() obtiene el objeto remoto
            InterfaceRemota objetoRemoto = 
                (InterfaceRemota)Naming.lookup ("//localhost/ObjetoRemoto");
            
            // Se realiza la suma remota.
            System.out.print ("2 + 3 = ");
            System.out.println (objetoRemoto.suma(2,3));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Cliente();
    }
    
}
