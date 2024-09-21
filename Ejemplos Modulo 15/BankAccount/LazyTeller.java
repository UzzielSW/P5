public class LazyTeller extends Thread {
	private ThreadSafeBankAccount source, dest;

	public LazyTeller(ThreadSafeBankAccount a, ThreadSafeBankAccount b) {
		source = a;
		dest = b;
	}

	public void run() {
		transfer(250.00);
	}

	public void transfer(double amount) {
		System.out.println("Transferring from " + source.getNumber() + " to " + dest.getNumber());
		synchronized (source) {

			// Thread.yield();

			/* Dead Lock */
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}

			synchronized (dest) {
				System.out.println("Balance from " + source.getNumber() + "is: " + source.getBalance());
				System.out.println("Withdrawing from " + source.getNumber());
				source.withdraw(amount);
				System.out.println("Balance from " + source.getNumber() + "is: " + source.getBalance());
				System.out.println("Balance from " + dest.getNumber() + "is: " + dest.getBalance());
				System.out.println("Depositing into " + dest.getNumber());
				dest.deposit(amount);
				System.out.println("Balance from " + dest.getNumber() + "is: " + dest.getBalance());
			}
		}
	}
}
