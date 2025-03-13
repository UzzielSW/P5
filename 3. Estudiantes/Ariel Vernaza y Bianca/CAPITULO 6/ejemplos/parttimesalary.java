public class PartTimeSalary extends Salary
{
	public int hoursWorked;

	public int getHoursWorked()
	{
		System.out.println("Getting hours for " + this.name + " earning " + salary);
		return hoursWorked;
	}
}