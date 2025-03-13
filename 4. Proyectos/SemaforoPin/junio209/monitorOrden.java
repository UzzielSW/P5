
public class monitorOrden {

    numerosOrden numeroOrden = new numerosOrden();
	long numeroActual = 1;
    
	public synchronized long solicitarTurno() {
		return numeroOrden.numeroSiguiente();
	}

	
	public synchronized void accederRecurso(long numeroOrden) 
	    throws InterruptedException {
		while (numeroOrden > numeroActual) wait();
	}

	public synchronized void liberarRecurso() {
		numeroActual ++;
		notifyAll();
	}

}
