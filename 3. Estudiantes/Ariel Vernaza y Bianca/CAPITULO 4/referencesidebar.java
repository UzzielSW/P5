public class ReferenceSidebar
{
	public static void main(String [] args)
	{
		Employee e1, e2;
		String s;

		e1 = new Employee();
		s = e1;
		s = (Employee) e1;
	}
}