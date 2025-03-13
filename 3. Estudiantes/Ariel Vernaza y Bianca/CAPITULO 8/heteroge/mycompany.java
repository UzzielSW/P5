public class MyCompany
{
	public static void main(String [] args)
	{
		Employee [] company = new Employee[200];

		System.out.println("Randomly fill the array with employees");
		for(int i = 0; i < company.length; i++)
		{
			int random = (int) (Math.random() * 3);
			if(random == 0)
			{
				company[i] = new Salary("Salary " + i, "New York, NY", i, 50000.00);
			}
			else if(random == 1)
			{
				company[i] = new Hourly("Hourly " + i, "Chicago, IL", i, 10.00);
				((Hourly) company[i]).setHoursWorked(40);
			}
			else
			{
				company[i] = new Contractor("Contractor " + i, "Denver, CO", i, 200.00);
				((Contractor) company[i]).setDaysWorked(5);
			}
		}

		SmartBoss boss = new SmartBoss();

		System.out.println("Paying each employee");
		for(int i = 0; i < company.length; i++)
		{
			boss.payEmployee(company[i]);
		}
	}
}
