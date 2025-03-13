/*
 *
 * @author: Prof. Alvaro Pino N.
 * @date: 24/11/2015
 * @date: 26/11/2015
 * @version: 3
 *
 **/

import java.util.concurrent.*;


public class Supervisor extends Thread
{
	private Caja caja;
	private int id;
    private int i=0;
    private final Semaphore s;
    
    public Supervisor(Semaphore s,Caja caja, int id)
    {
    	this.s=s;
 		this.caja = caja;
        this.id=id;
    }

    public void run()
   	{
  	 int tiempo = 0;
  	 while(true)
      {
      	try
       		{ 
       		
       	s.acquire();
	  /* synchronized(caja)
  		 { */
  		   while(caja.isNoTengo())
  		    {
	  if (caja.getCantCajaActual() != caja.getMaxCantCajas())
		 {
  		   try
			   {
			   	
	   		System.out.println("Supervisor: " +id+
	   					" is waiting..."); 
	   		     
	  		    //Thread.sleep(2000);
	  		    caja.wait(50);
	  		    
   		   	   	}catch(InterruptedException e){
   		   	   	}finally{
   		   	   			s.release();
   		   	   	}
		  }
  	     break;
  		    }
  		}catch(Exception ex){
  			
  				} finally{
   		   	   			s.release();
   		   	   	} 
      // } // end synchronized
	    //Consumer try to take  the box
	  try
	  {
// System.out.println("Supervisor Verify if the box full");
		tiempo = (int) (Math.random()* 1 + 1);
		Thread.sleep(tiempo);
	  }catch(InterruptedException e){}

	if( caja.getCantPapelActual() == caja.getCantMaxPapel())
		{
		 caja.setNoTengo(false);
		 
		/* synchronized(caja)
		  {
		  	*/
		  	
		  	
		   if (caja.getCantCajaActual() != caja.getMaxCantCajas())
		  	 {
		  	 
		  	 try
	   	    {
	   	    
	   	      s.acquire();	
		  	  quitarCaja();
			  System.out.println("Supervisor: " + id+
			  " Quita la Cajeta:" + caja.getCantCajaActual());
		  		
		  	}catch(Exception ex){	
		  		}finally {
		  			
  				    s.release();
  				    caja.setNoTengo(true);	
  				}
  				
		  //	caja.notifyAll();
		//	caja.setNoTengo(true);
			}else{
				  s.release();
				  //caja.notifyAll();
				  break;
				  }
			   //}
 		  }
 		}
   	}

public synchronized void quitarCaja()
    {
       caja.setCantPapelActual(0);
       caja.setCantCajaActual(++i);
    }
 }
