public class Hourly extends Employee
{
	public float hourlyRate;	//pay rate
	public float hoursWorked;	//weekly hours worked

	public float computePay()
	{
		System.out.println("Computing hourly pay for " + name);

		float pay = 0.0F;
		if(hoursWorked <= 40)
		{
			pay = hourlyRate * hoursWorked;
		}
		else	//need to compute overtime
		{
			pay = (hourlyRate * 40) + (hourlyRate * (hoursWorked - 40) * 1.5F);
		}

		return pay;
	}
}