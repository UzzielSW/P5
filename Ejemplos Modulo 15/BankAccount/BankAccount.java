public class BankAccount {
	private double balance;
	private int number;

	public BankAccount(int number, double initialBalance) {
		this.number = number;
		balance = initialBalance;
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}

		balance += amount;
	}

	public void withdraw(double amount) {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
		if (amount <= balance)
			balance -= amount;
		else
			System.out.println("balance insuficiente");
	}
}
