public class gestorRecursosServicios { 

	private boolean [] recursoOcupado = new boolean[] 
	                                {false, false, false};
	
	public synchronized void liberarRecurso (recursos Recurso){
		
		switch (Recurso) {
		
		case r1: {
			recursoOcupado [0] = false; 
			break;
		}
		
		case r2: {
			recursoOcupado [1] = false; 
			break;
		}
		case r3: {
			recursoOcupado [2] = false; 
			break;
		}

		}

		notifyAll();
		
	}
	
	
	public synchronized void solicitarServicio (servicios Servicio) 
		throws InterruptedException {
		
		switch (Servicio) {
		
		case s1: {
			while (recursoOcupado [0] || recursoOcupado [1]) wait();
            recursoOcupado [0] = true;
            recursoOcupado [1] = true;
			break;
		}

		case s2: {
			while (recursoOcupado [1] || recursoOcupado [2]) wait();
            recursoOcupado [1] = true;
            recursoOcupado [2] = true;
			break;
		}
		case s3: {
			while (recursoOcupado [0] || recursoOcupado [2]) wait();
            recursoOcupado [0] = true;
            recursoOcupado [1] = true;
			break;
		}

		}

		
	}
	
}

