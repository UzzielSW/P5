import java.util.Vector;

public class VectorDemo2
{
	public static void main(String [] args)
	{
		Vector employees = new Vector(10);	//initial capacity of 10

		System.out.println("Add some Employee objects to the vector...");

		int numSalary = 0;
		for(int i = 1; i <= 10; i++)
		{
			Employee e = null;
			int random = (int) (Math.random() * 3);
			if(random == 0)
			{
				e = new Salary("Salary " + i, "Palo Alto, CA", i, 100000.00);
				employees.add(0, e);
				numSalary++;
			}
			else if(random == 1)
			{
				e = new Hourly("Hourly " + i, "Cupertino, CA", i, 100.00);
				employees.insertElementAt(e, numSalary);
			}
			else
			{
				e = new Contractor("Contractor " + i, "Milpitas, CA", i, 1000.00);
				employees.add(e);
			}
		}

		System.out.println("The size of the vector is " + employees.size());
		System.out.println("The capacity of the vector is " + employees.capacity());

		Salary s = new Salary("","",4, 0.0);
		if(employees.remove(s))
		{
			System.out.println("Just removed employee number 4");
		}

		employees.remove(7);
		System.out.println("Just removed employee number 7");

		int size = employees.size();
		System.out.println("The size is now " + size);
		System.out.println("The capacity is now " + employees.capacity());


		for(int i = 0; i < size; i++)
		{
			Employee current = (Employee) employees.elementAt(i);
			if(current instanceof Hourly)
			{
				((Hourly) current).setHoursWorked(40);
			}
			else if(current instanceof Contractor)
			{
				((Contractor) current).setDaysWorked(5);
			}

			current.computePay();
			current.mailCheck();
		}
	}
}
