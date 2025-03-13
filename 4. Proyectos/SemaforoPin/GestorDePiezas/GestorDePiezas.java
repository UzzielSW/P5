
public class GestorDePiezas {

	final static private int NMaxRojas  = 50;
	final static private int NMaxAzules = 50;
	
	private int NRojas  = 0;
	private int NAzules = 0;
	
	private boolean PedidoEnCurso = false;
	
	public synchronized void A–adirRoja()
	throws InterruptedException {
		NRojas = NRojas ++;
		notifyAll();
		while (NRojas == NMaxRojas) wait();
	}
		
	public synchronized void A–adirAzul()
	throws InterruptedException {
		NAzules = NAzules ++;
		notifyAll();
		while (NAzules == NMaxAzules) wait();
	}
	
	public synchronized void SolicitarPedido(int SolRojas, int SolAzules)
	throws InterruptedException {

		while (PedidoEnCurso) wait();
		
		PedidoEnCurso = true;
		
		while (SolRojas > NRojas || SolAzules > NAzules) wait();
		
		NRojas  = NRojas  - SolRojas;
		NAzules = NAzules - SolAzules;
		PedidoEnCurso = false;
		notifyAll();
	}
	
}
