import java.util.Random;
public class hebraRecurso extends Thread{

	int id = 0;
	static final int n  = 5;
	monitorOrden unMonitorOrden; //= new monitorOrden();
	Random generador = new java.util.Random(System.currentTimeMillis());
	
	public hebraRecurso (int unId, monitorOrden unMonitorOrden){
		id = unId;
		this.unMonitorOrden = unMonitorOrden;
	}
	
	public void run () {
		int i = 0;
		long turno = 0;
		long maxRetardo = 4000; //milisegundos
        long retardo = 0;
		
		for (i=0; i < n; i++ ){
			
			turno = unMonitorOrden.solicitarTurno();
			System.out.println(">Hebra " + id + " obtiene nœmero " + turno);
			try {
				unMonitorOrden.accederRecurso(turno);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("<Hebra " + id + " accede al recurso. Turno " + turno);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			unMonitorOrden.liberarRecurso();
			retardo = (long)(maxRetardo * generador.nextFloat());
			try {
				Thread.sleep (retardo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
