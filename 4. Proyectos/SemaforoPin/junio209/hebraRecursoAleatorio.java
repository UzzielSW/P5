import java.util.Random;
public class hebraRecursoAleatorio extends Thread{

	int id = 0;
	static final int n  = 5;
	nonitorOrdenAleatorio unMonitorOrden; //= new monitorOrden();
	Random generador = new java.util.Random(System.currentTimeMillis());
	
	public hebraRecursoAleatorio (int unId, nonitorOrdenAleatorio unMonitorOrden){
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
				unMonitorOrden.accederRecurso(turno, id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("<Hebra " + id + " accede al recurso. Turno " + turno);
			try {			
				retardo = (long)(maxRetardo * generador.nextFloat());
				System.out.println("Retardo: " + retardo);
				Thread.sleep(retardo * 5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			unMonitorOrden.liberarRecurso();
			try {
				Thread.sleep (1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
