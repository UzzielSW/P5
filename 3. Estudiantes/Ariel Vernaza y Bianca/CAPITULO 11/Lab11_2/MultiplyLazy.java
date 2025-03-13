public class MultiplyLazy
{
	public static void main(String [] args)
	{
		int x = 0, y = 0;
		try
		{
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
		}catch(RuntimeException r)
		{
			System.out.println("Error processing command line arguments");
			r.printStackTrace();
			return;
		}

		System.out.println(x + " x " + y + " = " + (x * y));
	}
}