
public class gestorOperaciones {

	private boolean bloqueoEscritor = false;
	private boolean bloqueoLector   = false;
	private int  nLectores = 0;

	public synchronized void permisoLeer(int idLector) 
	   throws InterruptedException { 
		while (bloqueoEscritor) {wait();}
		bloqueoLector = true;
		nLectores ++;
	}
	
	public synchronized void permisoEscribir(int idEscritor) 
	   throws InterruptedException{
		while (bloqueoEscritor || bloqueoLector){wait();}
		bloqueoEscritor = true;
	}

	public synchronized void finLeer(int idLector){
	      nLectores --;
	      if (nLectores == 0) {
	    	  bloqueoLector = false;
	    	  notifyAll();
	      }
	}
	
	public synchronized void finEscribir(int idEscritor) {
		bloqueoEscritor = false;
		notifyAll();
	}
}
