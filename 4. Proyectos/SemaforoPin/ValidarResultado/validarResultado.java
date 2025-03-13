public class validarResultado {

	private int nHebrasIniciales = 3;
	private int nHebrasActivas = nHebrasIniciales;
	private int [] valores = new int[nHebrasIniciales];
	private int valoresDisponibles = 0;
	private boolean est‡nTodas = false;
	private int valorPromedio  = 0;
	
	private int calcularPromedio (int[] losValores) {
        int suma = 0;
        
        for (int i = 0; i < nHebrasActivas; i++) suma = suma + losValores[i];
        return suma / nHebrasActivas;
	}
	
	public synchronized boolean esResultadoErroneo (int id, int valor) 
	    throws InterruptedException {
		
		boolean esErroneo = false;
		
		while (est‡nTodas) wait();
		
		valores[valoresDisponibles] = valor;
		valoresDisponibles ++;
		
		if (valoresDisponibles== nHebrasActivas) {
			valorPromedio = calcularPromedio (valores);
			est‡nTodas = true;
			notifyAll();
		} 
		else {
			while ( !est‡nTodas) wait();
		}

		valoresDisponibles --;
		if (valor > 1.1 * valorPromedio || valor < 0.9 * valorPromedio) 
		  { 
			esErroneo = true;
		    nHebrasActivas --;
		  }
		
		if (valoresDisponibles == 0) {
			est‡nTodas = false;
			notifyAll();
		}
		
		return esErroneo;
	}
	
	
}
