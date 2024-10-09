import java.util.LinkedList;

public class MultiplicaMatricesConHilos {
	public static void main(String[] args) {

		// Dos matrices para multiplicar
		double[][] m1 = new double[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		double[][] m2 = new double[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		// Se multiplican
		double[][] resultado = new MultiplicaMatricesConHilos().multiplica(m1, m2);

		// Se saca por pantalla el resultado.
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++)
				System.out.print(resultado[i][j] + " ");
			System.out.println(" ");
		}
	}

	/**
	 * Realiza la multiplicación de las dos matrices y devuelve el resultado
	 * 
	 * @param m1 primer operando
	 * @param m2 segundo operando
	 * @return resultado de multiplicar m1xm2
	 */
	public double[][] multiplica(double[][] m1, double[][] m2) {
		// condiciones que deben cumplirse y que se suponen ciertas
		// con los parámetros de entrada
		assert m1 != null;
		assert m2 != null;
		assert m1.length > 0;
		assert m1[0].length > 0;
		assert m2.length > 0;
		assert m2[0].length > 0;
		assert m1.length == m2[0].length;

		// Calculo de las dimensiones de la matriz resultado y
		// reserva de espacio para ella
		int filas = m1.length;
		int columnas = m2[0].length;
		double[][] resultado = new double[filas][columnas];

		// Lista con todos los hilos lanzados.
		LinkedList<Thread> hilos = new LinkedList<Thread>();

		// Para cada elemento de la matriz resultado, se lanza el hilo
		// correspondiente.
		for (int fila = 0; fila < filas; fila++)
			for (int columna = 0; columna < columnas; columna++) {
				Thread hilo = new Thread(new HiloMultiplicador(m1, m2, resultado, fila, columna));
				hilos.add(hilo);
				hilo.start();
			}

		// Se espera que terminen todos los hilos
		for (Thread hilo : hilos)
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		return resultado;
	}
}

// Calcula uno de los elementos de la matriz resultado
class HiloMultiplicador implements Runnable {
	private double[][] m1;
	private double[][] m2;
	private double[][] resultado;
	private int fila;
	private int columna;

	/**
	 * Guarda los parámetros que se le pasan
	 * 
	 * @param m1        primer operando
	 * @param m2        segundo operando
	 * @param resultado matriz donde dejar el resultado
	 * @param fila      fila que debe calcular
	 * @param columna   columna que debe calcular
	 */
	public HiloMultiplicador(double[][] m1, double[][] m2, double[][] resultado, int fila, int columna) {
		this.m1 = m1;
		this.m2 = m2;
		this.resultado = resultado;
		this.fila = fila;
		this.columna = columna;
	}

	 // Calcula el elemento fila,columna de la matriz resultado
	public void run() {
		resultado[fila][columna] = 0.0;
		for (int i = 0; i < m2.length; i++)
			resultado[fila][columna] += m1[fila][i] * m2[i][columna];
	}
}
