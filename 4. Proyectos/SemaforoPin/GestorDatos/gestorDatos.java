
public class gestorDatos {
	
	private muestraSensores muestraActual = new muestraSensores();
	private boolean hayValorTemperatura   = false;
	private boolean hayValorPresi—n       = false;
	private int nLecturasMax;
	private int nLecturas                 = 0;
	
	public gestorDatos(int nLecturasMax) {		
		this.nLecturasMax = nLecturasMax;
	}
	
	public synchronized void notificarTemperatura(float temperatura){

		System.out.println("++++ El lector de Temperatura escribe: " + 
		           temperatura);
		
		muestraActual.muestraTemperatura = temperatura;

		if (hayValorTemperatura && hayValorPresi—n) { 
			hayValorPresi—n = false;
			}	 
		else {
			hayValorTemperatura = true;
			if (hayValorPresi—n) {
				notify();
			}
			}
	}
	

	public synchronized void notificarPresi—n(float presi—n){

		System.out.println("**** El lector de Presi—n escribe: " + 
		           presi—n);
		
		muestraActual.muestraPresi—n = presi—n;

		if (hayValorTemperatura && hayValorPresi—n) { 
			hayValorTemperatura = false;
			}	 
		else {
			hayValorPresi—n = true;
			if (hayValorTemperatura){
				notify();
				}
			}
	}

	
	public synchronized muestraSensores obtenerValorSensores (){
		
		// En este problema no es necesario poner la condici—n de espera
		// en un while. Ser’a suficiente un if. Esto es debido a que 
		// solo hay un proceso que lee los valores y Žste es el œnico
		// que se puede quedar bloqueado en el monitor. Sin embargo,
		// se ha mantenido el while, como norma de buen uso.
		//
		// Por esta raz—n, no es necesario incluir un notifyAll apra
		// despertar al proceso que procesa los datos de los sensores.
		
		if (!(hayValorTemperatura && hayValorPresi—n)) {
			System.out.println("!!!! El Procesador se bloquea");
		}
		
		try{
			while (!(hayValorTemperatura && hayValorPresi—n)){wait();}
		} catch (InterruptedException ie) {}
		
	    hayValorTemperatura = false;
	    hayValorPresi—n = false;
	    nLecturas ++;
	    return new muestraSensores(muestraActual.muestraTemperatura, 
	    		                   muestraActual.muestraPresi—n);		
	}
	
	public synchronized boolean condici—nFin () {
		return nLecturas == nLecturasMax;
	}
	
}

