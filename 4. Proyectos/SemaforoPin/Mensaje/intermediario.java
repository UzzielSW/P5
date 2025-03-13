
public class intermediario {

	private mensajeDecodificado 	mensajeD; 
	private claseMensaje claseMD;            
	private int nProcesosNecesarios  = 0; 
	private boolean mensajePendiente = false; 
	
	public synchronized void entregarMD (mensajeDecodificado mensajeD,
                                         claseMensaje claseMD)
			throws InterruptedException {

		while (mensajePendiente) wait();
		
		this.mensajeD = mensajeD;
		this.claseMD  = claseMD;
		this.mensajePendiente = true;
		
		switch (claseMD) {
			case clase1 : {
				nProcesosNecesarios = 1;
				break;
			}
			case clase2 : {
				nProcesosNecesarios = 2;
				break;
			}
			case clase3 : {
				nProcesosNecesarios = 3;
				break;
			}
		}
		notifyAll();
	}

	public synchronized mensajeDecodificado recogerMD ()
           throws InterruptedException {
		
		while (!mensajePendiente) wait();
		
		nProcesosNecesarios --;
		if (nProcesosNecesarios == 0) {
			mensajePendiente = false;
			notifyAll();
		}		
		return mensajeD;
	}
	
}
