public class AlternateStop extends Object implements Runnable {
	private volatile boolean stopRequested;
	private Thread runThread;
	
	public void run() {
		runThread = Thread.currentThread();
		stopRequested = false;
		
		int count = 0;
		
		while( true ) {
		   System.out.println("Running ... count =" + count);
		   count++;
		   
		   try{
			   Thread.sleep(300);
		   }catch(InterruptedException x ) {
		       Thread.currentThread().interrupt(); //reassert
		   }
		}
	  }
     
	  public void stopRequest() {
		  stopRequested = true;
		  
		  if( runThread != null ) {
			  runThread.interrupt();
		  }
	  }
	  
	  	  
	  public static void main(String[] args ) {
		  AlternateStop as = new AlternateStop();
		  Thread t = new Thread(as);
		  t.start();
		  
		  try{
		      Thread.sleep(2000);
		  }catch( InterruptedException x ) {
			  // ignore
		  }
		  
		  // Abruptetly stop the other thread in its tracks!
		  as.stopRequest();
	  }
      }
		  
