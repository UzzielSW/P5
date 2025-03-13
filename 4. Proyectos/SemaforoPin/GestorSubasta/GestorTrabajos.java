
public class GestorTrabajos implements Runnable {

		Runnable[] llamadasPendientes;
		int numPendientes=0;
		int siguienteSalidaPendientes=0;
		int siguienteEntradaPendientes=0;
		
		public GestorTrabajos(int cantidad) {
			llamadasPendientes=new Runnable[cantidad];
			for (int i=0; i < cantidad; i++) {
				Thread unaHebra = new Thread(this);
				unaHebra.start();
			}
		}
		
		public synchronized void ponerTrabajo(Runnable trabajo) {
			try {
				while (numPendientes == llamadasPendientes.length) wait();
				llamadasPendientes[siguienteEntradaPendientes]= trabajo;
				siguienteEntradaPendientes=(siguienteEntradaPendientes+1)%llamadasPendientes.length;
				numPendientes++;
				notifyAll();
			} catch (InterruptedException e) {
				ponerTrabajo(trabajo);
			}
		}

		public void run() {
			Runnable trabajo;
			while (true) {
				trabajo = tomarTrabajo();
				trabajo.run();
			}
		}

		private synchronized Runnable tomarTrabajo() {
			try {
				while (numPendientes == 0) wait();
				Runnable siguiente=llamadasPendientes[siguienteSalidaPendientes];
				siguienteSalidaPendientes=(siguienteSalidaPendientes+1)%llamadasPendientes.length;
				numPendientes--;
				notifyAll();
				return siguiente;	
			} catch (InterruptedException e) {
				return tomarTrabajo();
			}
		}
	}
