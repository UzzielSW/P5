public class Boss
{
	/*palabra cable instaceof*/
	public void payEmployee(Employee e)
	{
		double pay = 0.0;

		if(e instanceof Salary)
		{
			pay = ((Salary) e).computePay();
		}
		else if(e instanceof Hourly)
		{
			pay = ((Hourly) e).computePay();
		}
		System.out.println("Pay = " + pay);
		e.mailCheck();
	}	
}
