public class GestorDespegue {
   
	private boolean pistaOcupada = true;
	private int     nVIPEsperando   = 0;
	private int     nEsperando      = 0;
	private final int  tiempoAvion  = 3;
	private boolean      anteriorVIP = false; 
	private Temporizador unTemporizador = new Temporizador(this);
		
 	public synchronized void despegarAvion() throws InterruptedException {
 
 		nEsperando ++;
 		while (pistaOcupada || (nVIPEsperando > 0 && !anteriorVIP)) wait();
        nEsperando --;
 	    anteriorVIP = false;
   	    unTemporizador.armarTemporizador(tiempoAvion);
 	    pistaOcupada = true;
 	}

 	public synchronized void  despegarAvionVIP() throws InterruptedException {
 		nVIPEsperando++;
 	    while (pistaOcupada || (nEsperando > 0 && anteriorVIP)) wait();
 		nVIPEsperando--;
 	    anteriorVIP = true;
   	    unTemporizador.armarTemporizador(tiempoAvion);
 	    pistaOcupada = true; 		
 	}
 	
 	public synchronized void  finTemporizador() throws InterruptedException {
 		pistaOcupada = false;
 		notifyAll();
 	}	
}