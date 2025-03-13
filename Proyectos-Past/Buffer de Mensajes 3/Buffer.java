import java.util.Arrays;

class Buffer {
	private final int capacidad = 10;
	private final int pila[] = new int[capacidad];
	private int puntero = -1;
	private boolean estaLleno = false;
	private boolean estaVacio = true;

	/**
	 * Metodo que se encarga de leer un numero desde la pila. Si la pila esta
	 * vacia, se bloquea hasta que el productor añada un elemento.
	 * Extrae el numero de la pila, decrementa el puntero, y notifica al hilo
	 * que esta esperando. Marca la pila como vacia si el puntero es -1 y
	 * como no llena tras la lectura.
	 * 
	 * @return num el numero extraido de la pila
	 */
	public synchronized int lee() {
		System.out.print("\n | LEE | puntero: " + puntero + " | vacio: " + estaVacio);

		while (estaVacio) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupcion del hilo...");
			}
		}

		int num = pila[puntero];
		pila[puntero--] = 0;
		// puntero--;

		if (puntero == -1)
			estaVacio = true;

		estaLleno = false;

		System.out.print(" - Pila: " + Arrays.toString(pila));

		notify();

		return num;
	}

	/**
	 * Metodo que se encarga de escribir un numero en la pila. Si la pila esta
	 * llena, se bloquea hasta que el consumidor libere espacio en la pila.
	 * Almacena el numero en la pila y notifica al hilo que esta esperando.
	 * 
	 * @param num numero a escribir en la pila
	 */
	public synchronized void escribe(int num) {
		System.out.print("\n | ESCRIBE | puntero: " + puntero + " | lleno: " + estaLleno);

		while (estaLleno) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupcion del hilo...");
			}
		}

		// puntero++;
		pila[++puntero] = num;

		if (puntero == capacidad - 1)
			estaLleno = true;

		estaVacio = false;

		System.out.print(" - Pila: " + Arrays.toString(pila));

		notify();
	}
}
