public class DeprecatedStop extends Object implements Runnable {
	
	public void run() {
		int count = 0;
		
		while( true ) {
		   System.out.println("Running ... count =" + count);
		   count++;
		   
		   try{
			   Thread.sleep(300);
		   }catch(InterruptedException x ) {
			   // Ignore
		   }
		}
	  }
     
	  public static void main(String[] args ) {
		  DeprecatedStop ds = new DeprecatedStop();
		  Thread t = new Thread(ds);
		  t.start();
		  
		  try{
		      Thread.sleep(2000);
		  }catch( InterruptedException x ) {
			  // ignore
		  }
		  
		  // Abruptetly stop the other thread in its tracks!
		  t.stop();
	  }
      }
		  
