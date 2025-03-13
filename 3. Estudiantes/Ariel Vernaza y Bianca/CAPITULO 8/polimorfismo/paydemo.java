public class PayDemo
{
	//Los parametros polimorfos son aquellos que permiten pasar al padre de un objet
	//las funciones polimorficas son aquellas que se comportan segun sea el metodo del hijo
	//asignado...
	public static void main(String [] args)
	{
		Boss boss = new Boss();

		Hourly h = new Hourly("Abe Lincoln", "Springfield, IL", 16, 8.00);
		Salary s = new Salary("George Washington", "Valley Forge, DE", 1, 5000.00);
		Employee x = new Salary("Rich Raposa", "Rapid City, SD", 47, 250000.00);
		Employee y = new Employee("George W.", "Houston, TX", 43);

		System.out.println("** Paying Abe Lincoln **");
		boss.payEmployee(h);
		System.out.println("\n** Paying George Washington **");
		boss.payEmployee(s);
		System.out.println("\n** Paying Rich Raposa **");
		boss.payEmployee(x);
		System.out.println("\n** Paying George W. **");
		boss.payEmployee(y);
	}
}
