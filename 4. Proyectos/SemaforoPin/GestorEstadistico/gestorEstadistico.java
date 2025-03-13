
public class gestorEstad’stico {

	private float[] datos = new float[3];
	private int nEntregados = 0;
	private float valorEstadístico;
	private boolean estadísticoCalculado  = false;
	
	public synchronized float entregarDato (float datoEntrada)
	    throws InterruptedException {
	
	    while (estadísticoCalculado) wait(); 
		
	    datos[nEntregados] = datoEntrada;
	    nEntregados ++;
    
	    if (nEntregados == 3) {
		valorEstadístico = calcularEstad’stico
		    (datos[0], datos[1], datos[2]);
		
		estadísticoCalculado = true;
		nEntregados = nEntregados - 1;
		notifyAll();
	    }
		else {
		    while (!estadísticoCalculado) wait();
		    nEntregados --;
		    if (nEntregados == 0) {
			    estadísticoCalculado = false;
			    notifyAll();
			}
		}
		 
		return valorEstadístico;
			
	}
	
	protected float calcularEstadístico (float d0, float d1, float d2) {
		
		return (d0 + d1 + d2) / 3;
	}
}