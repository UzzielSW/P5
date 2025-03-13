public class ContinueDemo
{
	public static void main(String [] args)
	{
		System.out.println("The for loop");
		for(int i = 10; i > 0; i--)
		{
			if(i % 2 == 0)
			{
				continue;
			}
			System.out.println(i);
		}

		System.out.println("The while loop");
		int j = 20;
		do
		{
			if(j % 3 != 0)
			{
				continue;
			}
			System.out.println(j);
		}while(j-- > 0);
	}
}
