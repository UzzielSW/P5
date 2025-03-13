
public class claseError {

	private boolean  hayError;
	private procesos elProceso;
	
	public claseError(boolean error, procesos elProceso) {
		this.elProceso = elProceso;
		this.hayError  = error;
	}
	
	public boolean hayError (claseError estadoError) {
		return hayError;
	}
	
	public procesos procesoErroneo (claseError estadoError) {
		return elProceso;
	}
	
}
