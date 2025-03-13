
public class usuarioRecurso implements Runnable{
	
	Prioridad prioridad;
	GestorRecursoPrioridad gestorRecurso;
	int id;
	
	public usuarioRecurso (int id,
				           Prioridad prioridad, 
			               GestorRecursoPrioridad gestorRecurso) {
		this.prioridad     = prioridad;
		this.gestorRecurso = gestorRecurso;
		this.id            = id;
	}
	
	public void run(){
		while (true) {
			
			try{
				Thread.sleep(5000);
			}catch(InterruptedException ie){}
			
			switch (prioridad) {
			case alta  : { 
				gestorRecurso.solicitarAlta();
				System.out.println("Hebra " + id + " usa el recurso con prioridad Alta");
				break;
			}

			case media : { 
				gestorRecurso.solicitarMedia();
				System.out.println("Hebra " + id + " usa el recurso con prioridad Media");
				break;
			}
			
			case baja  : { 
				gestorRecurso.solicitarBaja();
				System.out.println("Hebra " + id + " usa el recurso con prioridad Baja");
				break;
			}
			}
			
			try{
				Thread.sleep(500);
			}catch(InterruptedException ie){}
			
			gestorRecurso.liberar();
			System.out.println("Hebra " + id + " libera el recurso");
			}
		}
	}
	
