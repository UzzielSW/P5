public class Fabrica2 extends Thread
{
	boolean  done;
	
		Caja cajita;
		Thread [] thread;
		Persona persona [];
		ThreadGroup g1;
		Supervisor supervisor;
		Thread consumer2;
		
		public Fabrica2()
		{
		 cajita = new Caja();
		 g1 = new ThreadGroup("t");	
		thread = new Thread[3];	
		persona  = new  Persona[3];
		supervisor = new Supervisor(cajita, 4);
		
		 consumer2 = new Thread(g1,supervisor ,"t");
		
        consumer2.setDaemon(true);
		
		consumer2.start();
		}
		
		public void run()
		{
				
		try{
       	
            for (int i= 0; i < 3; i++)
              {
               persona[i] = new  Persona(cajita,i + 1);
        
		       thread[i] = new Thread (g1,persona[i],"t");
		       thread[i].start();
		       thread[i].join(20);
              }
	
		}catch(InterruptedException e){}
		
       	
		}
		
	public static void main(String [] args)
	{
	  
       Fabrica2 fabr = new Fabrica2(); 	
	
       fabr.start();
       
       
       	try{

			sleep(5000);
		    fabr.join();
		}catch(InterruptedException e){}
       
       //	System.out.println("Caja Actual tiene:  "+ fabr.cajita.getCantPapel());
       	System.out.println("Cantidad de cajas llenas:  "+ fabr.cajita.getCantCaja());

	 while (!fabr.done )
       {
       	if (fabr.g1.activeGroupCount() == 0)
       		fabr.done = true;
       }    
	    
	}
}