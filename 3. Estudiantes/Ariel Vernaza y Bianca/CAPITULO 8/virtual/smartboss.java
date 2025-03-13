//en java por default los metodos son virtuales

public class SmartBoss
{
	public void payEmployee(Employee e)
	{
		double pay = e.computePay();
		System.out.println("Just paid " + e.getName() + " $" + pay);
		e.mailCheck();
	}
}
