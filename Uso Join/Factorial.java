// La función join() se utiliza para esperar a que un hilo específico termine su ejecución. 

public class Factorial extends Thread {
	int n;
	int result;

	public Factorial(int n) {
		this.n = n;
	}

	public void run() {
		if ((n == 0) || (n == 1))
			result = 1;
		else {
			Factorial f1 = new Factorial(n - 1);

			f1.start();

			try {
				f1.join();
			} catch (InterruptedException e) {
			}
			;

			// El código aquí se ejecutará solo después de que el hilo f1 haya terminado
			result = n * f1.getResult();
		}
	}

	public int getResult() {
		return result;
	}

	public static void main(String[] args) {
		Factorial f1 = new Factorial(Integer.parseInt("4"));
		f1.start();
		try {
			f1.join();
		} catch (InterruptedException e) {
		}
		;

		// El código aquí se ejecutará solo después de que el hilo f1 haya terminado
		System.out.println("Answer is " + f1.getResult());
	}
}
