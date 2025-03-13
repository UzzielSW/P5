
public class nonitorOrdenAleatorio {

    private numerosOrden numeroOrden = new numerosOrden();
	private long numeroActual = 0;
	private long enteroMuyGrande = 10000000;
	private long numeroMinimo  = enteroMuyGrande;
	private int  numeroHebras = 0;
	private boolean recursoOcupado = false;
	private int numeroHebrasOp = 0;
    
	public synchronized long solicitarTurno() {
		return numeroOrden.numeroSiguiente();
	}

	
	public synchronized void accederRecurso(long numeroOrden, int id) 
	    throws InterruptedException {

//		while (!recursoOcupado && numeroHebras > 0) wait();
			
		numeroHebras ++;		
		while (!(!recursoOcupado && (numeroOrden == numeroActual || numeroHebras == 1) )) {
			wait();
				if (numeroOrden < numeroMinimo) {
					numeroMinimo = numeroOrden;
					System.out.println("NumeroMinimo parcial: " + numeroMinimo + " id: " + id);
				}
				numeroHebrasOp ++;
				if (numeroHebrasOp == numeroHebras) {
					numeroActual = numeroMinimo;
					System.out.println("NumeroMinimo: " + numeroMinimo + " nHebras: " + numeroHebras );
				//	if (numeroActual < numeroOrden) {
						notifyAll();
				//	}
						
				}
				else wait();
			}
	
		numeroMinimo   = enteroMuyGrande;
		numeroHebrasOp = 0;
		recursoOcupado = true;		
		numeroHebras --;
	}

	public synchronized void liberarRecurso() {

		recursoOcupado = false;
		notifyAll();
	}

}
