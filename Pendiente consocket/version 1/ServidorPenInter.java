/**
 * @(#)ServidorPenInter con socket
 *
 *
 * @author por Prof. Alvaro Pino N.
 * @version 1.00 2018/11/19
 *               2018/11/21
 *        
 * Programa Servidor que genera el objeto remoto y 
 * lo ofrece a traves de socket.
 *
 */
import java.rmi.*;

import java.rmi.registry.*;

public class ServidorPenInter {
    
 public static void main(String args [])
 {
 	 	
 	try{
 		
 	ImplPendInterRemota  objimplpend = new ImplPendInterRemota();	
 	
 Naming.rebind("//127.0.0.1/ImplObjeRemoto", objimplpend);
 	
 System.out.println("Objeto   registrado");
 	
 		
     	}catch(Exception e)
     	{
     	System.out.println("ERROR: " + e.getMessage());
 		
 		e.printStackTrace();	
     	//	System.out.println(e);
     	}
 }
}