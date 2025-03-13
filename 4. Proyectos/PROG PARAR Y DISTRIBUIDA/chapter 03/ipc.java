class WaitNotifyTest implements Runnable  {
WaitNotifyTest () { 
	Thread th = new Thread (this); 
	th.start(); } 
synchronized void notifyThat () 	{ 
	System.out.println ("Notify the threads waiting"); 
	this.notify();
	} 
synchronized public void run() { 
	try { 
		System.out.println("Thead is waiting...."); 
		this.wait (); } 
	catch (InterruptedException e){} 
		System.out.println ("Waiting thread notified"); 
	} 
} 
class runWaightNotify { 
	public static void main (String args[]) 	{ 
		WaitNotifyTest wait_not = new WaitNotifyTest(); 
		Thread.yield (); 
		wait_not.notifyThat(); 
	}
} 
