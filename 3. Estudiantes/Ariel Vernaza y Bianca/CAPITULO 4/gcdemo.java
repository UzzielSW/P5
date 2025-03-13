public class GCDemo
{
	public static void main(String [] args)
	{
		Employee e1, e2, e3;
		e1 = new Employee();	//employee #1
		e2 = new Employee();	//employee #2
		e3 = new Employee();	//employee #3

		e2 = e1;
		e3 = null;
		e1 = null;
	}
}