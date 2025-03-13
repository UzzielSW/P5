public class SmartBoss
{
	public void payEmployee(Employee e)
	{
		double pay = e.computePay();
		System.out.println("Just paid " + e.getName() + " $" + pay);
		e.mailCheck();
	}
}
