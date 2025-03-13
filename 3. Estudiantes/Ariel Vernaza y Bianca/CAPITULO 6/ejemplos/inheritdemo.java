public class InheritDemo
{
	public static void main(String [] args)
	{
		System.out.println("Instantiating an Employee");
		Employee e = new Employee();
		e.name = "Robert Smith";
		e.address = "111 Java Street";
		e.SSN = 999001111;
		e.number = 1;

		System.out.println("Instantiating a Salary");
		Salary s = new Salary();
		s.name = "Jane Smith";
		s.address = "222 Oak Drive";
		s.SSN = 111009999;
		s.number = 2;
		s.salary = 100000.00F;


		System.out.println("Instantiating an Hourly");
		Hourly h = new Hourly();
		h.name = "George Washington";
		h.address = "333 Espresso Lane";
		h.SSN = 111990000;
		h.number = 3;
		h.hourlyRate = 10.00F;
		h.hoursWorked = 50;

		System.out.println("Paying employees");
		//e.computePay();	//does not compile!
		System.out.println(s.number + " " + s.computePay());
		System.out.println(h.number + " " + h.computePay());

		System.out.println("Mailing checks");
		e.mailCheck();
		s.mailCheck();
		h.mailCheck();
	}
}