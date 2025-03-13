
public class cocheSur extends Thread{
	private int idCoche;
	private gestorAparcamiento unGestor;
	private long retardoInicial;
	
	public cocheSur (gestorAparcamiento unGestor, int idCoche, long retardoInicial) {
		this.idCoche  = idCoche;
		this.unGestor = unGestor;
		this.retardoInicial = retardoInicial;
		this.start();
	}

	public void run(){
	
		try {
			Thread.sleep(retardoInicial);
			unGestor.entrarAparcamientoSur(idCoche);
			Thread.sleep(3000);
			unGestor.salirAparcamiento(idCoche);
		} catch (InterruptedException e) {}
		
	}
	
}
