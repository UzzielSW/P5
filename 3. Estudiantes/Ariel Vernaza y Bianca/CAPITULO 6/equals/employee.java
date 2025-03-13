public class Employee
{
	public String name;
	public String address;
	public int SSN;
	public int number;

	public void mailCheck()
	{
		System.out.println("Mailing a check to " + name + " " + address);
	}

	public boolean equals(Object x)
	{
		if(x == null)
			return false;

		Employee other = (Employee) x;
		if(this.number == other.number)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int hashcode()
	{
		return this.number;
	}
}