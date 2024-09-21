public class PrintNumbers implements Runnable {
	public boolean keepGoing;

	public PrintNumbers() {
		keepGoing = true;
	}

	public void stopPrinting() {
		keepGoing = false;
	}

	public void run() {
		int numPrint = 1;
		while (keepGoing) {
			System.out.println(numPrint++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
