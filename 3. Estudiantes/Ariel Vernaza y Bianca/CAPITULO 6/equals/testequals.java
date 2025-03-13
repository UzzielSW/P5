public class TestEquals
{
	
	public static void main(String[]  args)
	{
		
		Employee e1  = new Employee();
		
		Employee e2  = new Employee();
		
		e1.number = 101;
		
		e2.number = 102;
		
		if ( e1.equals(e2))
		  System.out.println("This will not print.");
		
		
		e2.number = 101;
		
		if( e2.equals(e1) )
		   System.out.println("This will print");
		
		if( e1 == e2)
		
		System.out.println("This will not print either");
		
	}
}
		
	
