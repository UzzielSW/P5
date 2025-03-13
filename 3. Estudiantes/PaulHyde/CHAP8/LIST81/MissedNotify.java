public class MissedNotify extends Object {
      private Object proceedLock;
      
      public MissedNotify() {
	      print("in MissedNotify()");
	      proceedLock = new Object();
      }
      
      public void waitToProceed() throws InterruptedException {
	      print("in waitToProceed() - entered");
	      
	      synchronized ( proceedLock ) {
		      print("in waitToProceed()  - about to wait()");
		      proceedLock.wait();
		      print("in  waitToProceed() -back from wait()");
	      }
      
	      print("in waitTOProceed() - leaving");
      }
      
      public void proceed() {
	      print("in proceed() - entered");
	      
	      synchronized ( proceedLock ) {
		      print("in proceed()  - about to notifyAll()");
		      proceedLock.notifyAll();
		      print("in  proceed() - back from notifyAll()");
	      }
      
	      print("in proceed() - leaving");
      }
      
      public static void print(String msg) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": " + msg);
	}
	
	public static void main(String[] args) {
		final MissedNotify  mn = new MissedNotify();
				
		Runnable runA = new Runnable() {
			public void run() {
				try{ Thread.sleep(1000); 
				mn.waitToProceed();
	                        }catch( InterruptedException x ) {
				x.printStackTrace();
				}
			}
		};
		
	
	Thread threadA = new Thread(runA, "threadA");
	threadA.start();
	
	Runnable runB = new Runnable() {
		public void run() {
		try{
		        Thread.sleep(1000); 
			mn.proceed();
	        }catch( InterruptedException x ) {
				x.printStackTrace();
			}
		}
	};
		
	Thread threadB = new Thread(runB, "threadB");
	threadB.start();
		
	try{
	    Thread.sleep(1000); 
	}catch( InterruptedException x ) {
	}

	print("about to interrupt() threadA");
	threadA.interrupt();
      }
   }
	
      
	      
