public class GestorHebras {
	
    private static final int POSICION_VACIA = -1;
    private int nMaxHebras;
    private int[] colaHebras;
    private int nHebrasTrabajadoras = 0;
    private int posicionMasPrioritaria  = POSICION_VACIA;
    private int nHebrasCliente = 0;
    private Actividad actividadSiguiente = null;
	
    public GestorHebras(int nMaxHebras) {
	this.nMaxHebras = nMaxHebras;
	colaHebras = new int[nMaxHebras];
	for (int i = 0; i < nMaxHebras; i ++) {
	    colaHebras[i] = POSICION_VACIA;
	}
    }
    //////////////////////////////////////////////////////////	
    private int obtenerPosicionMax(int[] colaHebras) {
        int posicion = 0;
	int maxPrioridad = -1;
        
	for (int i = 0; i < nMaxHebras; i ++) {
	    if (colaHebras[i] > maxPrioridad) {
		posicion = i;
		maxPrioridad = colaHebras[i]; 
	    }
	}	
	return posicion;
    }
    ////////////////////////////////////////////////////////////	
    private int incluirHebra(int prioridad, int[] colaHebras){
		
	for (int i = 0; i < nMaxHebras; i ++) {
	    if (colaHebras[i] == POSICION_VACIA) {
		colaHebras[i] = prioridad; 
		return i;
	    }
	}
	// Nunca se llega aqu'i pues s'olo se llama a este m'etodo si
	// hay hebras en la cola
	return 0;
    }
    //////////////////////////////////////////////////////////////	
    public synchronized Actividad solicitarActividad(int prioridad) 
	throws InterruptedException {
	int posicionEnCola;
		
	if (nHebrasTrabajadoras == nMaxHebras) return null;
		
	posicionEnCola = incluirHebra(prioridad, colaHebras);
	if (nHebrasCliente > 0 && nHebrasTrabajadoras == 0) notifyAll();
	nHebrasTrabajadoras++;

	while (posicionMasPrioritaria != posicionEnCola) wait(); 

	nHebrasTrabajadoras--;
	colaHebras[posicionMasPrioritaria] = POSICION_VACIA;
	posicionMasPrioritaria = POSICION_VACIA;
	notifyAll(); // Objetivo: despertar a hebras cliente dormidas
	return actividadSiguiente;
    }	
    ////////////////////////////////////////////////////////////////	
    public synchronized void proporcionarTrabajo(Actividad actividad) 
	throws InterruptedException {		
	nHebrasCliente++;

        while (posicionMasPrioritaria != POSICION_VACIA || 
               nHebrasTrabajadoras == 0) wait();

	posicionMasPrioritaria = obtenerPosicionMax(colaHebras);
	nHebrasCliente--;
	actividadSiguiente = actividad;		
	notifyAll(); // Objetivo: que una hebra trabajadora coja trabajo
    }
}
