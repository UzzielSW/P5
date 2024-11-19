
public class Fabrica extends Thread {
	public static void main(String[] args) {
		int cantCajas = 10;
		int cantPapel = 20;
		boolean done = false;


		Caja caja = new Caja(cantCajas, cantPapel);

		ThreadGroup g1 = new ThreadGroup("t");

		Thread[] thread = new Thread[3];

		Persona persona[] = new Persona[3];

		try {

			for (int i = 0; i < 3; i++) {
				persona[i] = new Persona(caja, i + 1);

				thread[i] = new Thread(g1, persona[i], "t");
				thread[i].start();
				thread[i].join(200);
			}

		} catch (InterruptedException e) {
		}

		Supervisor consumer = new Supervisor(caja, 4);

		Thread consumer2 = new Thread(g1, consumer, "t");
		consumer2.setDaemon(true);
		consumer2.start();

		try {
			sleep(1000 * Math.max(cantPapel, cantCajas));
		} catch (InterruptedException e) {
		}

		System.out.println("Caja Actual tiene:  " + caja.getCantPapelActual());
		System.out.println("Cantidad de cajas llenas:  " + caja.getCantCajaActual());
		System.out.println("Cantidad Maxima de cajas:  " + caja.getMaxCantCajas());

		while (!done) {
			if (g1.activeGroupCount() == 0)
				done = true;
		}

	}

	public static void valida(int cant) throws MenorQueCeroException {
		if (cant <= 0)
			throw new MenorQueCeroException(cant);
	}
}

class MenorQueCeroException extends Exception {
	private int cant;

	MenorQueCeroException(int cant) {
		this.cant = cant;
		System.out.println("La cantidad es incorrecta! ");
		System.out.println("Ingrese una cantidad mayor que cero");
		System.exit(0);
	}
}