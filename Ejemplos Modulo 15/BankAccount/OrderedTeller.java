public class OrderedTeller extends Thread {
	private ThreadSafeBankAccount source, dest;

	public OrderedTeller(ThreadSafeBankAccount a, ThreadSafeBankAccount b) {
		source = a;
		dest = b;

	}

	public void run() {
		transfer(250.00);
	}

	public void transfer(double amount) {
		System.out.println("Transferring from " + source.getNumber() + " to " + dest.getNumber());

		ThreadSafeBankAccount first, second;

		if (source.getNumber() < dest.getNumber()) {
			first = source;
			second = dest;
		} else {
			first = dest;
			second = source;
		}

		synchronized (first) {
			Thread.yield();
			synchronized (second) {
				System.out.println("Balance from " + source.getNumber() + "is: " + source.getBalance());
				System.out.println("Withdrawing from " + source.getNumber());
				source.withdraw(amount);
				System.out.println("Balance from " + source.getNumber() + "  is: " + source.getBalance());

				System.out.println("Balance from " + dest.getNumber() + "  is: " + dest.getBalance());
				System.out.println("Depositing into " + dest.getNumber());
				dest.deposit(amount);
				System.out.println("Balance from " + dest.getNumber() + "is: " + dest.getBalance());
			}

		}
	}
}
