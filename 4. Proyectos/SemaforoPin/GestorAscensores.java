
public class GestorAscensores {

	private boolean ascensorLibre[] = new boolean[] {false, false, false, false};
	private int  posicionAscensor[] = new int[] {0, 0, 0, 0};
	private int nAscensoresLibres   = 0;
	private int ascensorMasCercano  = -1;
	private int idPlanta = 0;
	private boolean ascensorSolicitado = false; 

	private int ascensorMasCercano(int idPlantaPersona) {
		int ascensorMasCercano = -1;
		int distanciaMinima = 9999;
		int distancia;

		for (int i = 0; i < ascensorLibre.length; i++ ) {
			if ( ascensorLibre[i]) {
				distancia = Math.abs(idPlantaPersona - posicionAscensor [i]);
				if (distancia < distanciaMinima) {
					ascensorMasCercano = i;
					distanciaMinima    = distancia;
				}
			}
		}
		return ascensorMasCercano;
	}


	public synchronized void solicitarAscensor(int idPlantaPersona) 
			throws InterruptedException {

		while (nAscensoresLibres == 0 || ascensorSolicitado) wait();

		// Esta variable impide desbloquear una solicitud hasta que la 
		// anterior se haya tratado por completo
		ascensorSolicitado = true;
		ascensorMasCercano = ascensorMasCercano(idPlantaPersona);

		this.idPlanta = idPlantaPersona;
		notifyAll();
	}

	public synchronized int notificarAscensorLibre(int idAscensor, int idPlantaAscensor) 
			throws InterruptedException {

		ascensorLibre[idAscensor] = true;
		nAscensoresLibres ++;
		posicionAscensor[idAscensor] = idPlantaAscensor;
		notifyAll();
		while (ascensorMasCercano != idAscensor) wait();
		ascensorLibre[idAscensor] = false;
                nAscensoresLibres--;
		ascensorMasCercano = -1;
		ascensorSolicitado = false;
        // Puede que haya personas esperando y ascensores libres
		notifyAll();
		return this.idPlanta;
	}

}
