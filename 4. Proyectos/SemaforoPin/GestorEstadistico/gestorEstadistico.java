
public class gestorEstad�stico {

	private float[] datos = new float[3];
	private int nEntregados = 0;
	private float valorEstad�stico;
	private boolean estad�sticoCalculado  = false;
	
	public synchronized float entregarDato (float datoEntrada)
	    throws InterruptedException {
	
	    while (estad�sticoCalculado) wait(); 
		
	    datos[nEntregados] = datoEntrada;
	    nEntregados ++;
    
	    if (nEntregados == 3) {
		valorEstad�stico = calcularEstad�stico
		    (datos[0], datos[1], datos[2]);
		
		estad�sticoCalculado = true;
		nEntregados = nEntregados - 1;
		notifyAll();
	    }
		else {
		    while (!estad�sticoCalculado) wait();
		    nEntregados --;
		    if (nEntregados == 0) {
			    estad�sticoCalculado = false;
			    notifyAll();
			}
		}
		 
		return valorEstad�stico;
			
	}
	
	protected float calcularEstad�stico (float d0, float d1, float d2) {
		
		return (d0 + d1 + d2) / 3;
	}
}