
public class lectorTemperatura implements Runnable{
	
	private int periodoMuestreo;
	private gestorDatos unGestor;
	private int valor = 0; 
	private Thread lectorT = new Thread (this);
	
	public lectorTemperatura(int periodoMuestreo,
			                 gestorDatos unGestor){
		this.periodoMuestreo = periodoMuestreo;
		this.unGestor        = unGestor;
		this.lectorT.start();
		
	}

	public void run(){
		
		System.out.println(",,,, Se crea el lector de Presi—n ");

		try{
		    Thread.sleep(periodoMuestreo/2);					
		} catch (InterruptedException ie) {};
		
		while(!unGestor.condici—nFin()){
			try{
			    Thread.sleep(periodoMuestreo);					
			} catch (InterruptedException ie) {};
		    unGestor.notificarTemperatura(valor);
		    valor++;
		}
	}
	
	
	
}
