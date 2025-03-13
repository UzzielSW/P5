public class Fabrica
{
	
	
	public static void main(String [] args)
	{
		boolean done = false;
		Caja caja = new Caja();
		
        ThreadGroup g1 = new ThreadGroup("t");
        Thread [] thread = new Thread[3];
        
        Persona persona [] = new  Persona[3];
       
       try{
       	
        for (int i= 0; i < 3; i++)
        {
        persona[i] = new  Persona(caja,i + 1);
        
		thread[i] = new Thread (g1,persona[i],"t");
		thread[i].start();
		thread[i].join(200);
        }
	
		}catch(InterruptedException e){}
		
		Supervisor consumer = new Supervisor(caja, 4);
		
		Thread consumer2 = new Thread(g1,consumer ,"t");
		
        consumer2.setDaemon(true);
		
		consumer2.start();
     
       
       	try{

			Thread.sleep(1000);
			
		}catch(InterruptedException e){}
       
     //  	System.out.println("Caja Actual tiene:  "+ caja.getCantPapel());
       	System.out.println("Cantidad de cajas llenas:  "+ caja.getCantCaja());

	 while (!done )
       {
       	if (g1.activeGroupCount() == 0)
       		done = true;
       }    
	    
	}
}