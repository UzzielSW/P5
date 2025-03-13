package infocustomer;

public class Customer {

	private String name;

	private String id;

	private String direccion;

	private Account account;

	public Customer(String name, String id, String direccion, Account account) {

		this.name = name;
		this.id = id;
		this.direccion = direccion;
		this.account = account;

	}

	public String getDireccion() {

		return direccion;
	}

	public String getName() {

		return name;
	}

	public Account getAccount() {

		return account;
	}

	public String getId() {

		return id;
	}

	public void setAccount(Account acct) {

		account = acct;
	}
}