public class BreakDemo
{
	public static void main(String [] args)
	{
		int k = 1;
		while(k <= 10)
		{
			System.out.println(k);
			if(k == 6)
			{
				break;
			}
			k++;
		}

		System.out.println("The final value of k is " + k);
	}
}
