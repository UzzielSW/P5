public class GestorEstadistico {

	static final int NMAX = 3;
	private float[] datos = new float[NMAX];
	private int nEntregados = 0;
	private float valorEstadistico = 0;
    private boolean varianzaCalculada = false;
	
	private float calcularEstadistico (float[] arrayDatos) {
		
		//Calcula la media
		
		float suma = 0;
		for (int i=0; i < arrayDatos.length; i++) {
			suma = suma + arrayDatos[i];
		}
		
		return suma / arrayDatos.length;
	}
	
	public float entregarDato(float dato)
		   throws InterruptedException {

		while (varianzaCalculada) { wait(); }
		
		datos[nEntregados] = dato;
		nEntregados ++;
		while (nEntregados < NMAX) { wait(); }
        if (nEntregados == NMAX) {
        	varianzaCalculada = true;
        	valorEstadistico = calcularEstadistico(datos);
        	nEntregados --;
        	notifyAll();
        } else {
        	nEntregados --;
        	if (nEntregados == 0) {
        		varianzaCalculada = false;
        		notifyAll();
        	}
        }
	 return valorEstadistico;
	}
	
}
