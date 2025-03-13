 
public class puenteSeguro {

	private int pesoEnPuente = 0;
	private int nVehiculos   = 0;
	private int nAmbulanciasEsperando = 0;
	private static final int pesoMaximo = 15000;
	private static final int nVehiculosMaximo = 10;
	private static final int pesoAmbulancia = 1500;
	
	public synchronized void entrarPuente(int Peso) throws InterruptedException {

		boolean esAmbulancia = false; 
	    
		if (Peso == pesoAmbulancia) {
			nAmbulanciasEsperando ++;
			esAmbulancia = true;    
		}
	    
		while((Peso + pesoEnPuente > pesoMaximo ||
				nVehiculos + 1 > nVehiculosMaximo) || 
				(nAmbulanciasEsperando > 0 && !esAmbulancia)) wait();

		if (esAmbulancia) nAmbulanciasEsperando --;
		pesoEnPuente = pesoEnPuente + Peso;
		nVehiculos++;       
	    
	}

	    
	public synchronized void salirPuente(int Peso) throws InterruptedException {

		pesoEnPuente = pesoEnPuente - Peso;
		nVehiculos--;
		notifyAll();	    
	}
}
