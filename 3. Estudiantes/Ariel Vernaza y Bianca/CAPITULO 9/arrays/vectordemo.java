import java.util.Vector;

public class VectorDemo
{
	public static void main(String [] args)
	{
		Vector employees = new Vector(50, 10);

		System.out.println("Add some Employee objects to the vector...");
		int numSalary = 0;
		for(int i = 1; i <= 51; i++)
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
	}
}
