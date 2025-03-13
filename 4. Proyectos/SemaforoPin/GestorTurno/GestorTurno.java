public class GestorTurno {

    private int ultimaHebra    = 0;
    private int siguienteHebra = 0;
    private Temporizador temp  = new Temporizador (this);
    private int nHebrasEspera  = 0;
    private long valorArmadoTemporizador  = 5000; 
    
	public synchronized int solicitarTurno() {		
		ultimaHebra ++;
		return ultimaHebra;
	}

	public synchronized void accederRecurso(int miTurno) 
	     throws InterruptedException {
		
   	        if (miTurno < siguienteHebra) {return;} 
		//NOTA: Esta soluci'on presenta alg'un problema potencial, 
                //pero es la m'as coherente con el enunciado. Otras alternativas
                //para tratar hebras a las que se le ha pasado el turno, 
                //como retornar "false" o lanzar una excepci'on, tambi'en
                //se consideran correctas
		
		if (miTurno > siguienteHebra && nHebrasEspera == 0 ) {
			temp.armarTemporizador(valorArmadoTemporizador);
		}
		nHebrasEspera ++;
		while (miTurno > siguienteHebra) wait();
		temp.cancelarTemporizador();
	}
	
	public synchronized void liberarRecurso() {
		nHebrasEspera --;
		siguienteHebra ++;
		if (nHebrasEspera > 0) {
			temp.armarTemporizador(valorArmadoTemporizador);
		}
		notifyAll();
	}
	
	public synchronized void notificarExpiracion() {
		siguienteHebra ++;
		if (nHebrasEspera > 0) {
			temp.armarTemporizador(valorArmadoTemporizador);
		}
                notifyAll();
	}

}
