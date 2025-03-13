public class WhileDemo
{
	public static void main(String [] args)
	{
		//loop #1
		int i = 10;
		while(i > 0)
		{
			System.out.print(i + " ");
			i--;
		}
		System.out.println();

		//loop #2
		int x = Integer.parseInt(args[0]);
		long sum = 0;
		i = 0;
		while(i <= x)
		{
			sum += i;
			i++;
		}
		System.out.println("sum = " + sum);

		//loop #3
		long f = 1;
		while(x >= 1)
			f *= x--;
		System.out.println("f = " + f + " and x = " + x);
	}
}
