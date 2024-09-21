public class Print {
	public static void main(String[] args) {
		PrintNumbers printNumbers = new PrintNumbers();

		Thread hilo = new Thread(printNumbers);
		hilo.start();

		int segundos = Integer.parseInt(args[0]);

		try {
			Thread.sleep(segundos);
		} catch (InterruptedException m) {
		}

		printNumbers.stopPrinting();

		System.out.println("main() is ending");
	}
}
