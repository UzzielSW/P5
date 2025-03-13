public class Contractor extends Employee
{
	private double dailyRate;
	private int daysWorked;

	public Contractor(String name, String address, int number, double dailyRate)
	{
		super(name, address, number);
		setDailyRate(dailyRate);
	}

	public double computePay()
	{
		System.out.println("Computing contractor pay for " + getName());
		return dailyRate * daysWorked;
	}

	public void setDailyRate(double newRate)
	{
		if(newRate >= 0.0 && newRate <= 2000.00)
		{
			dailyRate = newRate;
		}
	}

	public double getDailyRate()
	{
		return dailyRate;
	}

	public void setDaysWorked(int daysWorked)
	{
		if(daysWorked >= 0)
		{
			this.daysWorked = daysWorked;
		}
	}

}
