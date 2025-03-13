
public class oficina {

	private int nEsperaV1 = 0;
 	private int nEsperaV2 = 0;
	private boolean permisoV1      = false;
	private boolean permisoV2      = false;
	
/////////////////////////////////////////////////////	
	
	public synchronized void EsperarVentanill1()
	  throws InterruptedException{

		if ((nEsperaV1 == 0) && (nEsperaV2 == 0)) notifyAll();

		nEsperaV1 ++;		
		while (!permisoV1){
			wait();}  
		nEsperaV1 --;
		permisoV1 = false;
	}
	
/////////////////////////////////////////////////////

	public synchronized void EsperarVentanill2()
	  throws InterruptedException{

		if ((nEsperaV1 == 0) && (nEsperaV2 == 0)) notifyAll();
		
		nEsperaV2 ++;
		while (!permisoV2){	
			wait();}
		nEsperaV2 --;
		permisoV2 = false;
	}
	
/////////////////////////////////////////////////////	

	public synchronized void atenderCiudadano()
	  throws InterruptedException{
		
		while (nEsperaV1 == 0 && nEsperaV2 == 0){
			wait();
		}
		
		permisoV1 = (nEsperaV1 >= nEsperaV2);
		permisoV2 = (nEsperaV2 > nEsperaV1);
        notifyAll();
		
	}
}
