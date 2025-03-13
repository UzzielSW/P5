
public class procesadorDatos implements Runnable{

	java.util.Random generador = new java.util.Random(System.currentTimeMillis());
	private int periodoMuestreo;
	private gestorDatos unGestor;
	private muestraSensores valorSensores;
	private Thread procesador = new Thread(this);
	
	public procesadorDatos(int periodoMuestreo, 
  			               gestorDatos unGestor){
		
			this.periodoMuestreo = periodoMuestreo;
			this.unGestor        = unGestor;
			this.procesador.start();
	}

	public void run(){
			
		while(!unGestor.condici—nFin()){
			try{
			    Thread.sleep((long)(periodoMuestreo * generador.nextFloat()));					
			} catch (InterruptedException ie) {};
			valorSensores = unGestor.obtenerValorSensores();
			System.out.println("---- El procesador lee T: " + 
					           valorSensores.muestraTemperatura + 
					           " P: " +
					           valorSensores.muestraPresi—n);
		    }
	}
}
