public class PayDemo2
{
	public static void main(String [] args)
	{
		SmartBoss boss = new SmartBoss();

		Salary s = new Salary("Thomas Jefferson", "Monticello, VA", 3, 2600.00);
		Hourly h = new Hourly("John Adams", "Boston, MA", 2, 2.50);
		h.setHoursWorked(40);
		Employee e = new Employee("George W.", "Houston, TX", 43);

		System.out.println("** Paying Salary object **");
		boss.payEmployee(s);

		System.out.println("\n** Paying Hourly object **");
		boss.payEmployee(h);

		System.out.println("\n** Paying Employee object **");
		boss.payEmployee(e);
	}
}
