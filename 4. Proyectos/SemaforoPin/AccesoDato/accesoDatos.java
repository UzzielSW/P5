
public class accesoDatos {

	private int nMaxEscritoresEsperando = 5;
	private int nEscritoresEsperando    = 0;
	private int nLectoresEsperando      = 0;
	private int nLectores               = 0;
	private boolean hayLectoresAccediendo   = false;
	private boolean hayEscritoresAccediendo = false;


	public synchronized void inicioLectura  () 
	    throws InterruptedException {

        nLectoresEsperando ++;

        while ((nEscritoresEsperando >= nMaxEscritoresEsperando)
                || (hayEscritoresAccediendo)) 
            wait();

        nLectoresEsperando --;

        if (nLectores == 0)  hayLectoresAccediendo = true;
        nLectores++;
        
        if (nLectoresEsperando > 0) notifyAll();
    }

	public synchronized void inicioEscritura () 
    	throws InterruptedException {

		nEscritoresEsperando ++;
        while (   hayLectoresAccediendo 
               || hayEscritoresAccediendo
               || (nLectoresEsperando > 0 && (nEscritoresEsperando < nMaxEscritoresEsperando)))
               wait();

        nEscritoresEsperando --;
        hayEscritoresAccediendo = true;
        
   }
	
	public synchronized void finLectura () {
		nLectores --;		
        if (nLectores == 0) {
           hayLectoresAccediendo = false;
            notifyAll();
        }
	}

	public synchronized void finEscritura () {
		hayEscritoresAccediendo = false;	
		notifyAll();	
	}	
	
}
