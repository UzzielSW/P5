
public class pruebaMonitorOrdenAleatorio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	int n = 10;
    hebraRecursoAleatorio unaHebra; //= hebraRecurso();
    nonitorOrdenAleatorio unMonitorOrden = new nonitorOrdenAleatorio();
    
    for (int i=0; i < n; i++){
    	unaHebra = new hebraRecursoAleatorio(i, unMonitorOrden);
    	unaHebra.start();
    }

	}

}
