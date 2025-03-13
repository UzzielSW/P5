public class Employee
{
	/* Beneficios del polimofismo
	 *1- se puede usar una referencia de la clase padre a un objeto hijo.
	 *2- Se puede crear parametros polimorfos y retornar valores.
	 *3- Se pueden crear colecciones heterogeneas de objetos, en la que no todos 
	 *los elementos son de la misma tipo. 
	 
	 */
	private String name;
	private String address;
	private int number;

	public Employee(String name, String address, int number)
	{
		System.out.println("Constructing an Employee");
		this.name = name;
		this.address = address;
		this.number = number;
	}

	public void mailCheck()
	{
		System.out.println("Mailing a check to " + this.name + " " + this.address);
	}

	public String toString()
	{
		return name + " " + address + " " + number;
	}

	public String getName()
	{
		return name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String newAddress)
	{
		address = newAddress;
	}

	public int getNumber()
	{
		return number;
	}
}
