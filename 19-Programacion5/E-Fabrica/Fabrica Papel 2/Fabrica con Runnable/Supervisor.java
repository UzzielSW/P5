public class Supervisor implements Runnable
{
	private Caja caja;
	private int id;
    private int i=0;

    public Supervisor(Caja caja, int id)
    {
 		this.caja = caja;
        this.id=id;
    }

    public void run()
   	{	
  		int tiempo = 0;
  	   	while(true)
       	{
			synchronized(caja)
  		  	{
  		     	while(caja.isNoTengo())
  				{
  					
		  		  if (caja.getCantCaja() != 3)
		  		    {	
  			   		try
			   		{
	   				System.out.println("Supervisor: " +id+" is waiting...");
	  					caja.wait(100);
   		   	   		}catch(InterruptedException e)
  			   		{}
		  		    }
  			   		break;
  				} 
       	  	}

	     	//Consumer try to take off the box
	  		try
	  	   	{
			   // System.out.println("Supervisor Verify if the box full");
				tiempo = (int) (Math.random()* 1 + 1);
				Thread.sleep(tiempo);
	  		}catch(InterruptedException e)
	 		{}
	 				 
			if( caja.getCantPapel() == 5)
			{			
				caja.setNoTengo(false);
		  		synchronized(caja)
		  		{	  		  
		  		    if (caja.getCantCaja() != 3)
		  		     {	
		  			quitarCaja();
			System.out.println("Supervisor: " + id+ " Quita la Cajeta:" + caja.getCantCaja());
		  		  
					caja.notifyAll();
					caja.setNoTengo(true);
				    }else
				    {
				    	caja.notifyAll();
				    	break;
				    }	    	
			   }
 		  }
 		}
   	}
   	
   	
   	
public synchronized void quitarCaja()
    {
    	
       caja.setCantPapel(0);
       caja.setCantCaja(++i);
    }

 }
