public class Salary extends Employee
{
	public float salary;	//annual salary

	public float computePay()
	{
		System.out.println("Computing salary pay for " + name);
		return salary/52;
	}
}