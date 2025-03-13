public class ForDemo
{
	public static void main(String [] args)
	{
		//loop #1
		int x = Integer.parseInt(args[0]);
		long f = 1;
		for(int i = 1; i <= x; i++)
		{
			f = f * i;
		}
		System.out.println("f = " + f);
		//System.out.println("i = " + i);

		//loop #2
		for(int k = 1; k <= 100; k++)
		{
			if(k % 7 == 0)
			{
				System.out.println(k);
			}
		}

		//loop #3
		for(int a = 1, b = 100; a < b; a = a + 2, b = b - 4)
		{
			System.out.println("a = " + a + " and b = " + b);
		}
	}
}