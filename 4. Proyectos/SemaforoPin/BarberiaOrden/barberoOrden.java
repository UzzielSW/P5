
public class barberoOrden extends Thread{

	private barberiaOrden laBarberia;
	
	public barberoOrden(barberiaOrden laBarberia) {
		this.laBarberia = laBarberia;
	}
	
	public void run(){
		
	while (true) {
		
		try {
			laBarberia.esperarCliente();
			//Cortar pelo
			Thread.sleep(5000);
			laBarberia.acabarCorte();
			//Decansa un poco
			Thread.sleep(1000);
		} catch (InterruptedException e){};
	}

	}

}
