/*
 *
 * @author: Prof. Alvaro Pino N.
 * @date: 24/11/2015
 * @version: 3
 **/
import java.util.concurrent.*;

public class Persona extends Thread
{
	private Caja caja;
	private int id;
    private final Semaphore s;
    
    public Persona(Semaphore s,Caja caja, int id)
    {  
        this.s=s;
 		this.caja = caja;
 		this.id = id;
    }

    public void run()
   	{
  		int tiempo = 0;
  		
  	   	while(true)
       	{
       	/*	try
       		{ */
       		
       		
		/*	synchronized(caja)
  		  	{
  		  		
  		 */
  		 try
			   		{
			   		s.acquire();
  		     	while(!caja.isNoTengo())
  				{
  			   		
			   	 try
			   		{	
	   	System.out.println("Persona: " +id+
	   					 " is waiting..."); 
	   				//	 Thread.sleep(1000);
	  				caja.wait(50);
   		   	   		}catch(InterruptedException e){
   		   	   		}
   		   	   		
  			   		break;
  				}
  		}catch(Exception ex){
  			
  				}
  				 finally{
   		   	   			s.release();
   		   	   		} 
  				 
       	  //	}
	     	//Produce the paper
	 if (caja.getCantCajaActual() != caja.getMaxCantCajas())
       {
	  	try
	  	  {
			System.out.println("Persona: " + id+ " Busca papel");
		tiempo = (int) (Math.random()* 100 + 1);
		Thread.sleep(tiempo);
	  	}catch(InterruptedException e){}

  if(caja.getCantPapelActual() < caja.getCantMaxPapel() && caja.getCantCajaActual() != caja.getMaxCantCajas())
	{
	  
	 /* synchronized(caja)
	   {
	   	*/
	   	    try
	   	    {
	   	    
	   	    s.acquire();
	   	    caja.setNoTengo(false);
  			addPapel();
		  	System.out.println("Id: "+ id + " Puso papel: "+
		  		               caja.getCantPapelActual());
		//	caja.notifyAll();
		    s.release();
		    }catch(Exception ex){
  			
  				}
  				finally {
  				    s.release();	
  				} 
		    
		//}
	}
} else{	break;
      }
} //fin del while
 return;
}

  public synchronized void addPapel()
    {
       caja.agregarPapel();
    }
}
