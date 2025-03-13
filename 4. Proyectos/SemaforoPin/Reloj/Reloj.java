
public class Reloj extends Tiempo{ 

	public synchronized void otro_segundo() { // Sucede un nuevo segundo 

		segundo = (segundo + 1) % 60;
		if (segundo == 0) {
			minuto = (minuto + 1) % 60;
			if (minuto == 0) {
				hora = (hora + 1) %  24;
				notifyAll();
			}
		}
	}

	public synchronized Tiempo lee() {     // Lee el reloj 

		Tiempo elTiempo = new Tiempo();
		
		elTiempo.hora = hora;       
		elTiempo.minuto = minuto;      
		elTiempo.segundo = segundo;
		
		return elTiempo;
	}

	public synchronized void espera_hora() // Espera el siguiente cambio de hora 
	     throws InterruptedException{
		wait();
	}

	public synchronized void espera_horas(int n) // Espera el n-simo cambio de hora 
	     throws InterruptedException{
		
		while (n>0) {
			wait();
			n--;
		}	
	}
}
