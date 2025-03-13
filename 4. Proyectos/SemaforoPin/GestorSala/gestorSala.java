
public class gestorSala {
    
    private int nPersonas = 0;
    private int nMaxPersonasNormalT = 50;
    private int nMaxPersonasAltaT   = 35;
    private int nMaxPersonas = nMaxPersonasNormalT;
    private boolean tAlta = false;
    private int tUmbral = 30;
	
    public synchronized void entrarSala ()
	throws InterruptedException 
    {
        // Activar sólo una vez la tarea de control
	if (sensorT.valorTemperatura > tUmbral && !tAlta)
	    {
		tAlta = true;
		nMaxPersonas = nMaxPersonasAltaT;	
		// Para despertar a la hebra de control
		notifyAll();
	    }

	while (nPersonas >= nMaxPersonas)
	    {
		// Espero si no pueden entrar m‡s personas
		wait();
	    }
	nPersonas++;
    }
    
    public synchronized void salirSala ()
	throws InterruptedException 
    {
	nPersonas--;       
	if (nPersonas < nMaxPersonas) notifyAll();    	   
    }
	
    public synchronized void esperarARefrigerar ()
	throws InterruptedException 
    {
	while (!tAlta) wait();
    }
    
    public synchronized void finRefrigerar ()
	throws InterruptedException 
    {
	nMaxPersonas = nMaxPersonasNormalT;
	tAlta = false;
	if (nPersonas < nMaxPersonas) notifyAll();    	   
    }
}
