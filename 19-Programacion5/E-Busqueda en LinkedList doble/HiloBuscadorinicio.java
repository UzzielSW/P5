/**Auhor: Eric Chen 
 *Modificado por
 * Prof. Alvaro Pino N.
 *fecha 5/10/2018
**/
 

import java.util.LinkedList;

class HiloBuscadorinicio extends Thread {
	
LinkedList<Integer> datos;
public Integer dato_buscado;
public Integer inicio;
public boolean noEsta = true;

public HiloBuscadorinicio(int dato, LinkedList<Integer> datos,Integer ini){ 
    
    super("P");
    
    dato_buscado = new Integer(dato); 
    this.datos = datos;
    inicio=ini;
}
public void run(){ 

int i;
try
  {

System.out.println("Inicio Hilo - " + getName()); 

Integer primero = (Integer)datos.getFirst();

//System.out.println("Primero = " + primero.intValue()); 
    
if(inicio== primero)
 {
  
  for(i=0;i < datos.size();i++)
   {
   	 Integer k = (Integer)datos.get(i);
   	 
    if (k.intValue() == dato_buscado.intValue())
     {
     System.out.println("Fin Hilo: "+getName()+ " "+dato_buscado.intValue() + " Encontrado en "+(i+1));
     
     return;
    }else{
        System.out.println((i+1) + " "+ getName() +" =  "+datos.get(i));
    }
  }
  Thread.sleep(1000);
    	
    
  }
  
  }catch(InterruptedException e) {}
  
  if( noEsta == true)
  {
  	
  System.out.println("OJO: Fin Hilo - "+ getName()+" " + dato_buscado.intValue()+"  No fue Encontrado en la Lista");
  
  }
  
  
 }
}