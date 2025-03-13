/**Auhor: Eric Chen 
 *Modificado por
 * Prof. Alvaro Pino N.
 *fecha 5/10/2018
**/
 

import java.util.LinkedList;
import java.util.Random;
public class Busqueda{
public static void main (String [] args){
    
    LinkedList <Integer> vec;
    
    int rand;
    int i;
    System.out.println("Inicio - Main");
    
     Random generador=new Random();
              
     vec=new LinkedList<Integer>();
     
     for( i=0;i<20;i++)
      {
        rand=generador.nextInt(9)+1;
        Integer j = new Integer(rand);
        vec.add(j);
      }
        
Integer inicio = vec.get(0); //1ra posicion de la lista
Integer fin= vec.get(19); //ultima posicion de la lista

System.out.print("[");

for( i =1; i < 9; i++)
  System.out.print( i+", ");
 System.out.print(i+",");

  
  for( i =10; i < 20; i++)
  System.out.print( i+",");
 System.out.print(i+"]");

  
System.out.println("\n"+vec);//imprimo lista

Thread run_buscador1 = new Thread(new HiloBuscadorinicio(8,vec,inicio));
Thread run_buscador2=new Thread(new HiloBuscadorfin(8,vec,fin));
   
    run_buscador1.start();
    run_buscador2.start();
    
        try{
    	     	
    	     	Thread.sleep(10000);
                
        }catch(InterruptedException e){}
    
    System.out.println( "Fin - Main   ");
    
  }
}