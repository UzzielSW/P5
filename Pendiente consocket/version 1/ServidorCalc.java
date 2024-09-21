/**
 * @(#)ServidorCalc
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

import java.rmi.registry.*;

public class ServidorCalc {
    
 public static void main(String args [])
 {
 	 	
 	try{
 		
 	ImplCalcRemote  objcalc = 
 	new ImplCalcRemote();	
 	
 Naming.rebind("//127.0.0.1/ObjetoCalculadora", objcalc);
 	
 System.out.println("Objeto Calculadora GUI registrado");
 	
 		
     	}catch(Exception e)
     	{
     	System.out.println("ERROR: " + e.getMessage());
 		
 		e.printStackTrace();	
     	//	System.out.println(e);
     	}
 }
}