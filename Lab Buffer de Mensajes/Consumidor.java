public class Consumidor extends Thread {

	private Buffer buffer;
	private int num;

	public Consumidor(Buffer b, int n) {
		buffer = b;
		this.num = n;
	}

	public void run() {

		for (int i = 1; i <= 25; i++) {

			int val = buffer.lee();
			System.out.println(" - Consumidor " + this.num + " toma: " + val);

			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				System.out.println("Interrupcion del hilo...");
			}
		}
	}
}
