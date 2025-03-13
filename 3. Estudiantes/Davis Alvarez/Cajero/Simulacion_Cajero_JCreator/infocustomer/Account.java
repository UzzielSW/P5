package infocustomer;

import view.*;

public class Account {

	private double balance;
	private int numeroDeCuenta;

	ViewTransaction viewTransaction;

	public Account(double init_balance, int numeroDeCuenta, ViewTransaction viewTransaction) {

		this.numeroDeCuenta = numeroDeCuenta;
		this.viewTransaction = viewTransaction;
		balance = init_balance;
	}

	public int getNumeroDeCuenta() {

		return numeroDeCuenta;
	}

	public double getBalance() {

		return balance;
	}

	public synchronized void deposit(double dep) {

		balance += dep;
		viewTransaction.setText("El " + Thread.currentThread().getName() + " esta haciendo deposito de  :" + dep
				+ "\n" + "Nuevo balance es :" + getBalance());

	}

	public synchronized boolean withdraw(double withdraw) {

		if (withdraw > balance) {

			viewTransaction.setText("El " + Thread.currentThread().getName() + " no puede hacer el retiro " +
					"\n" + "El balance es :" + getBalance());
			return (true);

		}

		else {

			balance -= withdraw;
			viewTransaction.setText("El " + Thread.currentThread().getName() + " esta haciendo retiro de :" + withdraw
					+ "\n" + "Nuevo balance es :" + getBalance());
			return (false);
		}

	}
}