
public class gestorEvento {
	
	private estadoEvento estado = estadoEvento.Inactivo;
	private boolean cambioProcesado = true;
	private int     nHebras = 0;
	private int     nHebrasPendientes = 0;
	
	public synchronized void cambiarAActivo()
		throws InterruptedException {

		while (!cambioProcesado) wait();
		  
		if (estado == estadoEvento.Inactivo && nHebras > 0){
			cambioProcesado = false;	
			nHebrasPendientes = nHebras;
			estado = estadoEvento.Activo;
			notifyAll();
		}
	  }

	public synchronized void cambiarInactivo()
		throws InterruptedException {
		
		while (!cambioProcesado) wait();

		estado = estadoEvento.Inactivo;  
	}
	
	public synchronized void esperar(int numOcurrencias)
		throws InterruptedException {
	 
		while (!cambioProcesado) wait();
		
		nHebras++;
		
		while (numOcurrencias > 0) {
			
			wait();
			
			if (!cambioProcesado)
			{
				numOcurrencias--;	
				nHebrasPendientes --;
				if (nHebrasPendientes == 0) 
				{
					cambioProcesado = true;
					notifyAll();
				}
			}
		}
		
		nHebras --;
	}
}
