
public class Sincronizar {
	// Quiero que el primer proceso sea de tipo A
	 private int numOrden = 0; 
	   
	 public synchronized void accederTipoA()
	 	throws InterruptedException {
		 
		 while ((numOrden % 3) != 0) {wait();}
		 numOrden++;
		 notifyAll();
	     
	 }

	 public synchronized void accederTipoB()
	 	throws InterruptedException {
		
		 while ((numOrden % 3) == 0) {wait();}
		 numOrden ++;
		 notifyAll();
	     
      }

}
