/*
 *
 * @author: Prof. Alvaro Pino N.
 * @date: 21/12/2010
 *
 **/

public class Persona extends Thread
{
	private Caja caja;
	private int id;

    public Persona(Caja caja, int id)
    {
 		this.caja = caja;
 		this.id = id;
    }

    public void run()
   	{
  		int tiempo = 0;


  	   	while(true)
       	{
			synchronized(caja)
  		  	{
  		     	while(!caja.isNoTengo())
  				{
  			   		try
			   		{
System.out.println("Persona: " +id+ " is waiting...");
	  					caja.wait(1000);
   		   	   		}catch(InterruptedException e){}
  			   		break;
  				}
       	  	}
	     	//Produce the paper
	   if (caja.getCantCaja() != 3)
         {
	  		try
	  	   	{
	//	System.out.println("Persona: " + id+ " Busca papel");
				tiempo = (int) (Math.random()* 100 + 1);
				Thread.sleep(tiempo);
	  		}catch(InterruptedException e){}

		if(caja.getCantPapel() < 5 && caja.getCantCaja() != 3 )
			{
				caja.setNoTengo(false);
		  		synchronized(caja)
		  		{
		  			addPapel();
System.out.println("Id: "+ id + " Puso papel: "+ caja.getCantPapel());
					caja.notifyAll();
				}
			}
 	} else{
 				//pelota.notify();
 				break;
 			}
 		} //fin del while
 		return;
   	}

  public synchronized void addPapel()
    {
       caja.agregarPapel();
    }

 }
