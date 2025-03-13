
public class pruebaMonitorOrden {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	int n = 10;
    hebraRecurso unaHebra; //= hebraRecurso();
	monitorOrden unMonitorOrden = new monitorOrden();
    
    for (int i=0; i < n; i++){
    	unaHebra = new hebraRecurso(i, unMonitorOrden);
    	unaHebra.start();
    }

	}

}
