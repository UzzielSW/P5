
public class lectorPresion implements Runnable{
		
	private int periodoMuestreo;
	private gestorDatos unGestor;
	private int valor = 0;
	private Thread lectorP = new Thread(this);
		
	public lectorPresion(int periodoMuestreo,
			             gestorDatos unGestor){
		
			this.periodoMuestreo = periodoMuestreo;
			this.unGestor        = unGestor;
			this.lectorP.start();
	}

	public void run(){
			
		System.out.println(",,,, Se crea el lector de Presi—n ");
		
		while(!unGestor.condici—nFin()){
			try{
			    Thread.sleep(periodoMuestreo);					
			} catch (InterruptedException ie) {};
		    unGestor.notificarPresi—n(valor);
		    valor++;
		    }
	}
}
