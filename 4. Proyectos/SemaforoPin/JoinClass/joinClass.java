
public class joinClass {

	private int nProcesosMax;
	private int nProcesos = 0;
	private boolean saliendoProcesos = false;
	
	public joinClass(int nProcesos) {
		this.nProcesosMax = nProcesos;
	}
	
	public synchronized void join ()
	   throws InterruptedException {
		
		while (saliendoProcesos) wait();
		
		if (nProcesos == nProcesosMax - 1) {
			saliendoProcesos = true;
			notifyAll();
		}
		else {
			nProcesos ++;
			while (!saliendoProcesos) wait();
			nProcesos --;
			if (nProcesos == 0) {
				saliendoProcesos = false;
				notifyAll();
			}
		}
	}
}
