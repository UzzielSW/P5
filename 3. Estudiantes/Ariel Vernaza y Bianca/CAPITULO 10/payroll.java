public class Payroll
{
	public void payEmployee(Payable p)
	{
		p.computePay(40);
		p.mailCheck();
	}

	public void printPaycheck(Payable p)
	{
		System.out.println("Printing check for $" + p.getWeeklyPay());
	}
}
