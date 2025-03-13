public class IfDemo
{
	public static void main(String [] args)
	{
		int x = Integer.parseInt(args[0]);
		double half = 0.0;

		if(x != 0)
		{
			half = x/2.0;
			System.out.println(x + "/2 = " + half);
		}

		if(x == 0)
		{
			System.out.println("The value of x is 0");
		}

		int y = x * 5;
		char grade = 'F';

		if(y >= 85)
		{
			grade = 'A';
		}

		if(y >= 70 && y < 85)
			grade = 'C';

		System.out.println("y = " + y + " and grade = " + grade);
	}
}
